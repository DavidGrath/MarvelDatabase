package com.example.marveldatabase.presenter.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.marveldatabase.R
import com.example.marveldatabase.utils.Constants
import com.example.marveldatabase.utils.Constants.Companion.MARVEL_ENTITY_CHARACTER
import com.example.marveldatabase.utils.Constants.Companion.MARVEL_ENTITY_SERIES
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar_main)

        button_open_search.setOnClickListener(this)
        button.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        v?.let {
            when (it) {
                button_open_search -> {
                    with(Intent(this, SearchActivity::class.java)) {
                        putExtra("ENTITY_CODE", MARVEL_ENTITY_CHARACTER)
                        startActivity(this)
                    }
                }
                button -> {
                    with(Intent(this, SearchActivity::class.java)) {
                        putExtra("ENTITY_CODE", Constants.MARVEL_ENTITY_COMIC)
                        startActivity(this)
                    }
                }
                button2 -> {
                    with(Intent(this, SearchActivity::class.java)) {
                        putExtra("ENTITY_CODE", Constants.MARVEL_ENTITY_CREATOR)
                        startActivity(this)
                    }
                }
                button3 -> {
                    with(Intent(this, SearchActivity::class.java)) {
                        putExtra("ENTITY_CODE", Constants.MARVEL_ENTITY_EVENT)
                        startActivity(this)
                    }
                }
                button4 -> {
                    with(Intent(this, SearchActivity::class.java)) {
                        putExtra("ENTITY_CODE", MARVEL_ENTITY_SERIES)
                        startActivity(this)
                    }
                }

                else -> {

                }
            }
        }
    }
}
