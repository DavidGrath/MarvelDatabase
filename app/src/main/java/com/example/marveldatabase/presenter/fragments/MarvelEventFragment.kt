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
import kotlinx.android.synthetic.main.fragment_marvel_event.*
import java.text.SimpleDateFormat

class MarvelEventFragment : Fragment() {

    lateinit var viewModel: DetailsViewModel
    lateinit var event: MarvelEventUI

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(
            requireActivity(),
            DetailsViewModelFactory(DetailSingleton.detailsUseCase)
        ).get(DetailsViewModel::class.java)
        event = viewModel.nextUIEntity as MarvelEventUI
        return inflater.inflate(R.layout.fragment_marvel_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = event.title
        //Load Glide here
        event.thumbnail?.let {
            val path = it.path + "/" + Constants.IMAGESIZE_STANDARD_XLARGE + "." + it.extension
            Glide.with(this)
                .load(path)
                .centerCrop()
                .into(imageview_eventfrag_eventthumbnail)
        }
        textview_eventfrag_description.text = event.description ?: "No description available"
        val sdf = SimpleDateFormat.getDateInstance(SimpleDateFormat.LONG)
        textview_eventfrag_startdate.text = sdf.format(event.start)
        textview_eventfrag_enddate.text = sdf.format(event.end)
        textview_eventfrag_prev.text = event.next?.name
        textview_eventfrag_prev.setOnClickListener {
            if (event.previous?.resourceURI != null) {
                viewModel.getStoryFromUrl(event.previous?.resourceURI!!)
            }
        }
        textview_eventfrag_next.text = event.next?.name
        textview_eventfrag_next.setOnClickListener {
            if (event.next?.resourceURI != null) {
                viewModel.getStoryFromUrl(event.next?.resourceURI!!)
            }
        }
        val allSummaries = ArrayList<MarvelUISummary>().also {
            if (event.stories?.items != null) it.addAll(event.stories?.items!!)
            if (event.series?.items != null) it.addAll(event.series?.items!!)
            if (event.characters?.items != null) it.addAll(event.characters?.items!!)
            if (event.creators?.items != null) it.addAll(event.creators?.items!!)
        }
        val adapter = MarvelEntitySummaryAdapter(allSummaries)
        adapter.summaryClickListener = object : MarvelEntitySummaryAdapter.SummaryClickListener {
            override fun onSummaryClicked(data: MarvelUISummary, position: Int) {
                when (data.getType()) {
                    Constants.MARVEL_ENTITY_STORY -> {
                        if ((data as MarvelStoryUISummary).resourceURI != null) {
                            viewModel.getStoryFromUrl(data.resourceURI!!)
                        }
                    }
                    Constants.MARVEL_ENTITY_SERIES -> {
                        if ((data as MarvelSeriesUISummary).resourceURI != null) {
                            viewModel.getSeriesSingularFromUrl(data.resourceURI!!)
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

        recyclerview_eventfrag_references.layoutManager = LinearLayoutManager(requireContext())
        recyclerview_eventfrag_references.adapter = adapter
    }
}