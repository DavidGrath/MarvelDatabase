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
import kotlinx.android.synthetic.main.fragment_marvel_character.*

class MarvelCharacterFragment : Fragment() {
    lateinit var viewModel: DetailsViewModel
    lateinit var character: MarvelCharacterUI


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(
            requireActivity(),
            DetailsViewModelFactory(DetailSingleton.detailsUseCase)
        ).get(DetailsViewModel::class.java)
        character = viewModel.nextUIEntity as MarvelCharacterUI
        return inflater.inflate(R.layout.fragment_marvel_character, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = character.name ?: "No name available"
        //Load Glide here
        character.thumbnail?.let {
            val path = it.path + "/" + Constants.IMAGESIZE_STANDARD_XLARGE + "." + it.extension
            Glide.with(this)
                .load(path)
                .centerCrop()
                .into(imageview_charfrag_charthumbnail)
        }
        textview_charfrag_chardescription.text = character.description ?: "No description available"
        val allSummaries = ArrayList<MarvelUISummary>().also {
            if (character.comics?.items != null) it.addAll(character.comics?.items!!)
            if (character.events?.items != null) it.addAll(character.events?.items!!)
            if (character.series?.items != null) it.addAll(character.series?.items!!)
            if (character.stories?.items != null) it.addAll(character.stories?.items!!)
        }
        val adapter = MarvelEntitySummaryAdapter(allSummaries)
        adapter.summaryClickListener = object : MarvelEntitySummaryAdapter.SummaryClickListener {
            override fun onSummaryClicked(data: MarvelUISummary, position: Int) {
                when (data.getType()) {
                    Constants.MARVEL_ENTITY_COMIC -> {
                        if ((data as MarvelComicUISummary).resourceURI != null) {
                            viewModel.getComicFromUrl(data.resourceURI!!)
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
                    Constants.MARVEL_ENTITY_SERIES -> {
                        if ((data as MarvelSeriesUISummary).resourceURI != null) {
                            viewModel.getSeriesSingularFromUrl(data.resourceURI!!)
                        }
                    }
                }
            }
        }

        recyclerview_charfrag_references.layoutManager = LinearLayoutManager(requireContext())
        recyclerview_charfrag_references.adapter = adapter
    }
}