package com.example.retrofitmvvmpractice.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitmvvmpractice.R
import com.example.retrofitmvvmpractice.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ListViewModel
    var placeholderAdapter = PlaceholderListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refresh()

        placeholderList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = placeholderAdapter

        }

        observeViewModel()


    }

    fun observeViewModel() {
        viewModel.placeholders.observe(this, Observer { placeholders ->
            placeholders?.let {
                placeholderList.visibility=View.VISIBLE
                placeholderAdapter.updateCountries(it)
            }
        })

        viewModel.placeholderLoadError.observe(this, { isError ->
            isError?.let {
                list_error.visibility = if (it) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
            }
        })

        viewModel.loading.observe(this, Observer { isLoading ->
            isLoading?.let {
                loading_view.visibility = if (it) {
                    View.VISIBLE
                } else {
                    View.GONE
                }

                if (it) {
                    list_error.visibility = View.GONE
                    placeholderList.visibility = View.GONE
                }
            }
        })

    }
}