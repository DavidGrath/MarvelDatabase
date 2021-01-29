package com.example.marveldatabase.presenter.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.marveldatabase.R
import com.example.marveldatabase.domain.entities.ui.*
import com.example.marveldatabase.utils.Constants

class MarvelCharacterAdapter(var items: List<MarvelUIEntity>, val context: Context) :
    BaseAdapter() {
    interface ItemClickListener {
        fun onItemClicked(entity: MarvelUIEntity, position: Int)
    }

    var itemClickListener: ItemClickListener? = null

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val v: View
        val item = items[position]
        var itemCast: MarvelUIEntity
        when (item.getType()) {
            Constants.MARVEL_ENTITY_CHARACTER -> {
                itemCast = item as MarvelCharacterUI
                v = convertView ?: LayoutInflater.from(context)
                    .inflate(R.layout.recyclerview_marvelcharacter, parent, false)
                v.findViewById<TextView>(R.id.textview_marvelcharacter_name).text = itemCast.name
                v.findViewById<TextView>(R.id.textview_marvelcharacter_description).text =
                    if (!itemCast.description.isNullOrBlank()) itemCast.description else "No description available"
            }
            Constants.MARVEL_ENTITY_COMIC -> {
                itemCast = item as MarvelComicUI
                v = convertView ?: LayoutInflater.from(context)
                    .inflate(R.layout.recyclerview_marvelcomic, parent, false)
                v.findViewById<TextView>(R.id.textview_marvelcomic_title).text = itemCast.title
                v.findViewById<TextView>(R.id.textview_marvelcomic_description).text =
                    if (!itemCast.description.isNullOrBlank()) itemCast.description else "No description available"
            }
            Constants.MARVEL_ENTITY_CREATOR -> {
                itemCast = item as MarvelCreatorUI
                v = convertView ?: LayoutInflater.from(context)
                    .inflate(R.layout.recyclerview_marvelcreator, parent, false)
                v.findViewById<TextView>(R.id.textview_marvelcreator_fullname).text =
                    itemCast.fullName
            }
            Constants.MARVEL_ENTITY_EVENT -> {
                itemCast = item as MarvelEventUI
                v = convertView ?: LayoutInflater.from(context)
                    .inflate(R.layout.recyclerview_marvelevent, parent, false)
                v.findViewById<TextView>(R.id.textview_marvelevent_title).text = itemCast.title
                v.findViewById<TextView>(R.id.textview_marvelevent_description).text =
                    if (!itemCast.description.isNullOrBlank()) itemCast.description else "No description available"
                v.findViewById<TextView>(R.id.textview_marvelevent_startdate).text =
                    itemCast.start.toString()
            }
            Constants.MARVEL_ENTITY_STORY -> {
                itemCast = item as MarvelStoryUI
                v = convertView ?: LayoutInflater.from(context)
                    .inflate(R.layout.recyclerview_marvelcharacter, parent, false)
                v.findViewById<TextView>(R.id.textview_marvelstory_title).text = itemCast.title
                v.findViewById<TextView>(R.id.textview_marvelstory_description).text =
                    if (!itemCast.description.isNullOrBlank()) itemCast.description else "No description available"
            }
            Constants.MARVEL_ENTITY_SERIES -> {
                itemCast = item as MarvelSeriesUI
                v = convertView ?: LayoutInflater.from(context)
                    .inflate(R.layout.recyclerview_marvelcharacter, parent, false)
                v.findViewById<TextView>(R.id.textview_marvelseries_title).text = itemCast.title
                v.findViewById<TextView>(R.id.textview_marvelseries_description).text =
                    if (!itemCast.description.isNullOrBlank()) itemCast.description else "No description available"
                v.findViewById<TextView>(R.id.textview_marvelseries_startyear).text =
                    itemCast.startDate.toString()
            }
            else -> {
                itemCast = item as MarvelCharacterUI
                v = convertView ?: LayoutInflater.from(context)
                    .inflate(R.layout.recyclerview_marvelcharacter, parent, false)
            }
        }
        v.setOnClickListener { view ->
            itemClickListener?.onItemClicked(item, position)
        }
        return v
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }

}