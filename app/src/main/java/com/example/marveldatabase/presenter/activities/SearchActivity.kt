package com.example.marveldatabase.presenter.activities

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.view.Menu
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.marveldatabase.R
import com.example.marveldatabase.domain.entities.ui.MarvelUIEntity
import com.example.marveldatabase.framework.TempService
import com.example.marveldatabase.presenter.adapters.MarvelCharacterAdapter
import com.example.marveldatabase.presenter.viewmodels.DetailSingleton
import com.example.marveldatabase.presenter.viewmodels.SearchViewModel
import com.example.marveldatabase.utils.Constants
import com.example.marveldatabase.utils.ObservableTemp
import com.example.marveldatabase.utils.ResultValue
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    lateinit var viewModel: SearchViewModel
    lateinit var binder: TempService.TempBinder

    val servConn = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            binder = service as TempService.TempBinder
        }

        override fun onServiceDisconnected(name: ComponentName?) {

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        setSupportActionBar(toolbar_search)

        val entityType = intent.getIntExtra("ENTITY_CODE", Constants.MARVEL_ENTITY_CHARACTER)
        viewModel = DetailSingleton.getsSearchViewModel(entityType)
        bindService(Intent(this, TempService::class.java), servConn, Context.BIND_AUTO_CREATE)
        val adapter = MarvelCharacterAdapter(emptyList(), this)
        listview_characters.adapter = adapter
        adapter.itemClickListener = object : MarvelCharacterAdapter.ItemClickListener {
            override fun onItemClicked(entity: MarvelUIEntity, position: Int) {
                binder.entity = entity
                startActivity(Intent(this@SearchActivity, DetailsActivity::class.java))
            }

        }

        viewModel.charactersLiveData.subscribe(object :
            ObservableTemp.ObserverTemp<ResultValue<List<MarvelUIEntity>?>> {
            override fun onChanged(newValue: ResultValue<List<MarvelUIEntity>?>?) {
                Handler(Looper.getMainLooper()).post {
                    when (newValue) {
                        is ResultValue.Success -> {
                            progressbar_search.visibility = View.INVISIBLE
                            listview_characters.visibility = View.VISIBLE
                            adapter.items = newValue.data!!
                            adapter.notifyDataSetChanged()
                        }
                        is ResultValue.Failure -> {
                            listview_characters.visibility = View.INVISIBLE
                            progressbar_search.visibility = View.INVISIBLE
                            Toast.makeText(this@SearchActivity, "Error", Toast.LENGTH_SHORT).show()
                        }
                        is ResultValue.Waiting -> {
                            listview_characters.visibility = View.INVISIBLE
                            progressbar_search.visibility = View.VISIBLE
                        }
                    }
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        with(menu!!.findItem(R.id.searchitem_searchactivity)) {
            (actionView as SearchView).setOnQueryTextListener(object :
                SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    viewModel.search(query ?: "")
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }
            })
        }
        return true
    }

}
