package com.example.marveldatabase.presenter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.marveldatabase.R
import com.example.marveldatabase.domain.entities.ui.*
import com.example.marveldatabase.presenter.adapters.MarvelEntitySummaryAdapter
import com.example.marveldatabase.presenter.viewmodels.DetailSingleton
import com.example.marveldatabase.presenter.viewmodels.DetailsViewModel
import com.example.marveldatabase.presenter.viewmodels.factories.DetailsViewModelFactory
import com.example.marveldatabase.utils.Constants
import kotlinx.android.synthetic.main.fragment_marvel_story.*

class MarvelStoryFragment : Fragment() {

    lateinit var story: MarvelStoryUI
    lateinit var viewModel: DetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(
            requireActivity(),
            DetailsViewModelFactory(DetailSingleton.detailsUseCase)
        ).get(DetailsViewModel::class.java)
        story = viewModel.nextUIEntity as MarvelStoryUI
        return inflater.inflate(R.layout.fragment_marvel_story, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().setTitle(story.title)

        story.thumbnail?.let {
            val path = it.path + "/" + Constants.IMAGESIZE_STANDARD_XLARGE + "." + it.extension
            Glide.with(this)
                .load(path)
                .centerCrop()
                .into(imageview_storyfrag_thumbnail)
        }
        textview_storyfrag_description.text = story.description ?: "No description available"
        textview_storyfrag_type.text = story.type ?: "No Type Information"
        textview_storyfrag_originalissue.text = story.originalIssue?.name ?: "No Original Issue"
        textview_storyfrag_originalissue.setOnClickListener {
            if (story.originalIssue?.resourceURI != null) {
                viewModel.getStoryFromUrl(story.originalIssue?.resourceURI!!)
            }
        }
        val allSummaries = ArrayList<MarvelUISummary>().also {
            if (story.comics?.items != null) it.addAll(story.comics?.items!!)
            if (story.events?.items != null) it.addAll(story.events?.items!!)
            if (story.series?.items != null) it.addAll(story.series?.items!!)
            if (story.characters?.items != null) it.addAll(story.characters?.items!!)
            if (story.creators?.items != null) it.addAll(story.creators?.items!!)
        }
        val adapter = MarvelEntitySummaryAdapter(allSummaries)
        adapter.summaryClickListener = object : MarvelEntitySummaryAdapter.SummaryClickListener {
            override fun onSummaryClicked(data: MarvelUISummary, position: Int) {
                when (data.getType()) {
                    Constants.MARVEL_ENTITY_CHARACTER -> {
                        if ((data as MarvelCharacterUISummary).resourceURI != null) {
                            viewModel.getCharacterFromUrl(data.resourceURI!!)
                        }
                    }
                    Constants.MARVEL_ENTITY_CREATOR -> {
                        if ((data as MarvelCreatorUISummary).resourceURI != null) {
                            viewModel.getCreatorFromUrl(data.resourceURI!!)
                        }
                    }
                    Constants.MARVEL_ENTITY_COMIC -> {
                        if ((data as MarvelComicUISummary).resourceURI != null) {
                            viewModel.getComicFromUrl(data.resourceURI!!)
                        }
                    }
                    Constants.MARVEL_ENTITY_EVENT -> {
                        if ((data as MarvelEventUISummary).resourceURI != null) {
                            viewModel.getEventFromUrl(data.resourceURI!!)
                        }
                    }
                    Constants.MARVEL_ENTITY_SERIES -> {
                        if ((data as MarvelSeriesUISummary).resourceURI != null) {
                            viewModel.getStoryFromUrl(data.resourceURI!!)
                        }
                    }
                }
            }
        }

        recyclerview_storyfrag_references.layoutManager = LinearLayoutManager(requireContext())
        recyclerview_storyfrag_references.adapter = adapter
    }
}