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
import kotlinx.android.synthetic.main.fragment_marvel_creator.*

class MarvelCreatorFragment : Fragment() {

    lateinit var viewModel: DetailsViewModel
    lateinit var creator: MarvelCreatorUI

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(
            requireActivity(),
            DetailsViewModelFactory(DetailSingleton.detailsUseCase)
        ).get(DetailsViewModel::class.java)
        creator = viewModel.nextUIEntity as MarvelCreatorUI
        return inflater.inflate(R.layout.fragment_marvel_creator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = creator.fullName
        //Load Glide here
        creator.thumbnail?.let {
            val path = it.path + "/" + Constants.IMAGESIZE_STANDARD_XLARGE + "." + it.extension
            Glide.with(this)
                .load(path)
                .centerCrop()
                .into(imageview_creatorfrag_creatorthumbnail)
        }
        val allSummaries = ArrayList<MarvelUISummary>().also {
            if (creator.series?.items != null) it.addAll(creator.series?.items!!)
            if (creator.stories?.items != null) it.addAll(creator.stories?.items!!)
            if (creator.comics?.items != null) it.addAll(creator.series?.items!!)
            if (creator.events?.items != null) it.addAll(creator.events?.items!!)
        }
        val adapter = MarvelEntitySummaryAdapter(allSummaries)
        adapter.summaryClickListener = object : MarvelEntitySummaryAdapter.SummaryClickListener {
            override fun onSummaryClicked(data: MarvelUISummary, position: Int) {
                when (data.getType()) {
                    Constants.MARVEL_ENTITY_SERIES -> {
                        if ((data as MarvelSeriesUISummary).resourceURI != null) {
                            viewModel.getSeriesSingularFromUrl(data.resourceURI!!)
                        }
                    }
                    Constants.MARVEL_ENTITY_STORY -> {
                        if ((data as MarvelStoryUISummary).resourceURI != null) {
                            viewModel.getStoryFromUrl(data.resourceURI!!)
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
                }
            }
        }

        recyclerview_creatorfrag_references.layoutManager = LinearLayoutManager(requireContext())
        recyclerview_creatorfrag_references.adapter = adapter
    }

}