package com.example.marveldatabase.presenter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marveldatabase.R
import com.example.marveldatabase.domain.entities.ui.*
import com.example.marveldatabase.utils.Constants
import com.example.marveldatabase.utils.ListViewType

class MarvelEntitySummaryAdapter(val summaries: List<MarvelUISummary>) :
    RecyclerView.Adapter<MarvelEntitySummaryAdapter.SummaryViewHolder>() {
    val rows = ArrayList<ListViewType<String, MarvelUISummary>>()

    init {
        summaries.groupBy { it.getType() }.forEach {
            rows.add(ListViewType.Header(resolveEntityLabel(it.key)))
            rows.addAll(it.value.map { summary ->
                ListViewType.Item<String, MarvelUISummary>(summary)
            })
            return@forEach
        }
    }

    interface SummaryClickListener {
        fun onSummaryClicked(data: MarvelUISummary, position: Int)
    }

    var summaryClickListener: SummaryClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SummaryViewHolder {
        val v: View
        when (viewType) {
            Constants.LISTVIEW_TYPE_HEADER -> {
                v = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_summary_header, parent, false)
                return SummaryHeaderViewHolder(v)
            }
            Constants.LISTVIEW_TYPE_ITEM -> {
                v = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_marvelcharacter_summary, parent, false)
                return SummaryItemViewHolder(v)
            }
            else -> {
                v = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_marvelcharacter_summary, parent, false)
                return SummaryItemViewHolder(v)
            }
        }


    }

    override fun onBindViewHolder(holder: SummaryViewHolder, position: Int) {
        val rowItem = rows[position]
        when (holder) {
            is SummaryHeaderViewHolder -> {
                holder.title.text = (rowItem as ListViewType.Header).data
            }
            is SummaryItemViewHolder -> {
                val data = (rowItem as ListViewType.Item).data
                val rowCast: MarvelUISummary
                holder.item.setOnClickListener {
                    summaryClickListener?.onSummaryClicked(data, position)
                }
                when (data.getType()) {
                    Constants.MARVEL_ENTITY_CHARACTER -> {
                        rowCast = data as MarvelCharacterUISummary
                        holder.label.text = rowCast.name
                    }
                    Constants.MARVEL_ENTITY_COMIC -> {
                        rowCast = data as MarvelComicUISummary
                        holder.label.text = rowCast.name
                    }
                    Constants.MARVEL_ENTITY_CREATOR -> {
                        rowCast = data as MarvelCreatorUISummary
                        holder.label.text = rowCast.name
                    }
                    Constants.MARVEL_ENTITY_EVENT -> {
                        rowCast = data as MarvelEventUISummary
                        holder.label.text = rowCast.name
                    }
                    Constants.MARVEL_ENTITY_SERIES -> {
                        rowCast = data as MarvelSeriesUISummary
                        holder.label.text = rowCast.name
                    }
                    Constants.MARVEL_ENTITY_STORY -> {
                        rowCast = data as MarvelStoryUISummary
                        holder.label.text = rowCast.name
                    }
                    else -> {
                        rowCast = data as MarvelCharacterUISummary
                        holder.label.text = rowCast.name
                    }
                }

            }
        }
    }

    override fun getItemCount(): Int {
        return rows.size
    }

    override fun getItemViewType(position: Int): Int {
        return rows[position].getType()
    }

    fun resolveEntityLabel(entityType: Int): String {
        return when (entityType) {
            Constants.MARVEL_ENTITY_CHARACTER -> {
                "Characters"
            }
            Constants.MARVEL_ENTITY_COMIC -> {
                "Comics"
            }
            Constants.MARVEL_ENTITY_CREATOR -> {
                "Creators"
            }
            Constants.MARVEL_ENTITY_EVENT -> {
                "Events"
            }
            Constants.MARVEL_ENTITY_SERIES -> {
                "Series"
            }
            Constants.MARVEL_ENTITY_STORY -> {
                "Stories"
            }
            else -> {
                ""
            }
        }
    }

    open class SummaryViewHolder(val item: View) : RecyclerView.ViewHolder(item) {

    }

    class SummaryHeaderViewHolder(item: View) : SummaryViewHolder(item) {
        final val title: TextView = item.findViewById<TextView>(R.id.textview_summary_header)
    }

    open class SummaryItemViewHolder(item: View) : SummaryViewHolder(item) {
        final val label: TextView = item.findViewById<TextView>(R.id.textview_charsumm_name)
    }
}