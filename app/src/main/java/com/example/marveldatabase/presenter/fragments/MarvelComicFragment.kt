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
import kotlinx.android.synthetic.main.fragment_marvel_comic.*

class MarvelComicFragment : Fragment() {

    lateinit var viewModel: DetailsViewModel
    lateinit var comic: MarvelComicUI

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(
            requireActivity(),
            DetailsViewModelFactory(DetailSingleton.detailsUseCase)
        ).get(DetailsViewModel::class.java)
        comic = viewModel.nextUIEntity as MarvelComicUI
        return inflater.inflate(R.layout.fragment_marvel_comic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = comic.title
        //Load Glide here
        comic.thumbnail?.let {
            val path = it.path + "/" + Constants.IMAGESIZE_STANDARD_XLARGE + "." + it.extension
            Glide.with(this)
                .load(path)
                .centerCrop()
                .into(imageview_comicfrag_comicthumbnail)
        }
        textview_comicfrag_description.text = comic.description ?: "No description available"
        val allSummaries = ArrayList<MarvelUISummary>().also {
            if (comic.creators?.items != null) it.addAll(comic.creators?.items!!)
            if (comic.characters?.items != null) it.addAll(comic.characters?.items!!)
            if (comic.events?.items != null) it.addAll(comic.events?.items!!)
            if (comic.stories?.items != null) it.addAll(comic.stories?.items!!)
        }
        val adapter = MarvelEntitySummaryAdapter(allSummaries)
        adapter.summaryClickListener = object : MarvelEntitySummaryAdapter.SummaryClickListener {
            override fun onSummaryClicked(data: MarvelUISummary, position: Int) {
                when (data.getType()) {
                    Constants.MARVEL_ENTITY_CREATOR -> {
                        if ((data as MarvelCreatorUISummary).resourceURI != null) {
                            viewModel.getCreatorFromUrl(data.resourceURI!!)
                        }
                    }
                    Constants.MARVEL_ENTITY_CHARACTER -> {
                        if ((data as MarvelCharacterUISummary).resourceURI != null) {
                            viewModel.getCharacterFromUrl(data.resourceURI!!)
                        }
                    }
                    Constants.MARVEL_ENTITY_STORY -> {
                        if ((data as MarvelStoryUISummary).resourceURI != null) {
                            viewModel.getStoryFromUrl(data.resourceURI!!)
                        }
                    }
                    Constants.MARVEL_ENTITY_EVENT -> {
                        if ((data as MarvelEventUISummary).resourceURI != null) {
                            viewModel.getEventFromUrl(data.resourceURI!!)
                        }
                    }
                }
            }
        }

        recyclerview_comicfrag_references.layoutManager = LinearLayoutManager(requireContext())
        recyclerview_comicfrag_references.adapter = adapter
    }
}