package com.example.marveldatabase.presenter.activities

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.marveldatabase.R
import com.example.marveldatabase.domain.entities.ui.MarvelUIEntity
import com.example.marveldatabase.framework.TempService
import com.example.marveldatabase.presenter.fragments.*
import com.example.marveldatabase.presenter.viewmodels.DetailSingleton
import com.example.marveldatabase.presenter.viewmodels.DetailsViewModel
import com.example.marveldatabase.presenter.viewmodels.factories.DetailsViewModelFactory
import com.example.marveldatabase.utils.Constants.Companion.MARVEL_ENTITY_CHARACTER
import com.example.marveldatabase.utils.Constants.Companion.MARVEL_ENTITY_COMIC
import com.example.marveldatabase.utils.Constants.Companion.MARVEL_ENTITY_CREATOR
import com.example.marveldatabase.utils.Constants.Companion.MARVEL_ENTITY_EVENT
import com.example.marveldatabase.utils.Constants.Companion.MARVEL_ENTITY_SERIES
import com.example.marveldatabase.utils.Constants.Companion.MARVEL_ENTITY_STORY
import com.example.marveldatabase.utils.ObservableTemp
import com.example.marveldatabase.utils.ResultValue
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    lateinit var viewModel: DetailsViewModel
    val servConn = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = (service as TempService.TempBinder)
            val entity = binder.entity!!
            viewModel.nextUIEntity = entity
            val frag = fragmentFromEntityType(entity)
            supportFragmentManager.beginTransaction()
                .add(R.id.framelayout_entity_detail, frag)
                .commit()

            viewModel.nextEntityLiveData.subscribe(object :
                ObservableTemp.ObserverTemp<ResultValue<MarvelUIEntity>> {
                override fun onChanged(newValue: ResultValue<MarvelUIEntity>?) {
                    Handler(Looper.getMainLooper()).post {
                        when (newValue) {
                            is ResultValue.Success -> {
                                viewModel.nextUIEntity = newValue.data!!
                                val fragment: Fragment = fragmentFromEntityType(newValue.data!!)
                                newFragment(fragment)
                            }
                            is ResultValue.Failure -> {
                                Toast.makeText(
                                    this@DetailsActivity,
                                    "Error Getting Entity!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            is ResultValue.Waiting -> {
                                //Do Nothing
                            }
                        }
                    }
                }
            })
        }

        override fun onServiceDisconnected(name: ComponentName?) {

        }

    }

    fun newFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.framelayout_entity_detail, fragment)
            .addToBackStack(null)
            .commit()
    }

    fun fragmentFromEntityType(entity: MarvelUIEntity): Fragment {
        return when (entity.getType()) {
            MARVEL_ENTITY_CHARACTER -> {
                MarvelCharacterFragment()
            }
            MARVEL_ENTITY_COMIC -> {
                MarvelComicFragment()
            }
            MARVEL_ENTITY_CREATOR -> {
                MarvelCreatorFragment()
            }
            MARVEL_ENTITY_EVENT -> {
                MarvelEventFragment()
            }
            MARVEL_ENTITY_SERIES -> {
                MarvelSeriesFragment()
            }
            MARVEL_ENTITY_STORY -> {
                MarvelStoryFragment()
            }
            else -> {
                MarvelCharacterFragment()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        setSupportActionBar(toolbar_details)
        bindService(Intent(this, TempService::class.java), servConn, Context.BIND_AUTO_CREATE)
        viewModel =
            ViewModelProvider(this, DetailsViewModelFactory(DetailSingleton.detailsUseCase)).get(
                DetailsViewModel::class.java
            )
    }
}
