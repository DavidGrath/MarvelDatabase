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
import kotlinx.android.synthetic.main.fragment_marvel_series.*

class MarvelSeriesFragment : Fragment() {
    lateinit var viewModel: DetailsViewModel
    lateinit var series: MarvelSeriesUI
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(
            requireActivity(),
            DetailsViewModelFactory(DetailSingleton.detailsUseCase)
        ).get(DetailsViewModel::class.java)
        series = viewModel.nextUIEntity as MarvelSeriesUI

        return inflater.inflate(R.layout.fragment_marvel_series, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().setTitle(series.title)

        series.thumbnail?.let {
            val path = it.path + "/" + Constants.IMAGESIZE_STANDARD_XLARGE + "." + it.extension
            Glide.with(this)
                .load(path)
                .centerCrop()
                .into(imageview_seriesfrag_thumbnail)
        }
        textview_seriesfrag_description.text = series.description ?: "No description available"
        textview_seriesfrag_startyear.text = series.startDate.toString()
        textview_seriesfrag_endyear.text = series.endDate.toString()
        textview_seriesfrag_prev.text = series.previous?.name ?: "No Previous Series"
        textview_seriesfrag_prev.setOnClickListener {
            if (series.previous?.resourceURI != null) {
                viewModel.getStoryFromUrl(series.previous?.resourceURI!!)
            }
        }
        textview_seriesfrag_next.text = series.next?.name ?: "No Next Series"
        textview_seriesfrag_prev.setOnClickListener {
            if (series.next?.resourceURI != null) {
                viewModel.getStoryFromUrl(series.next?.resourceURI!!)
            }
        }

        val allSummaries = ArrayList<MarvelUISummary>().also {
            if (series.comics?.items != null) it.addAll(series.comics?.items!!)
            if (series.stories?.items != null) it.addAll(series.stories?.items!!)
            if (series.events?.items != null) it.addAll(series.events?.items!!)
            if (series.characters?.items != null) it.addAll(series.characters?.items!!)
            if (series.creators?.items != null) it.addAll(series.creators?.items!!)
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
                }
            }
        }

        recyclerview_seriesfrag_references.layoutManager = LinearLayoutManager(requireContext())
        recyclerview_seriesfrag_references.adapter = adapter
    }
}