package com.siyu.doordashlite.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.siyu.doordashlite.R
import com.siyu.doordashlite.viewmodel.GifListViewModel

class GifListFragment : Fragment() {

    companion object {
        fun newInstance() = GifListFragment()
    }

    private lateinit var viewModel: GifListViewModel
    private lateinit var gifAdapter: RestaurantsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(GifListViewModel::class.java)
        viewModel.restaurantsLiveData.observe(this, Observer { gifList->
            gifAdapter.setData(gifList)
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gifAdapter = RestaurantsAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_restaurants)
        recyclerView?.adapter = gifAdapter
        recyclerView?.layoutManager = GridLayoutManager(activity, 1)
    }
}
