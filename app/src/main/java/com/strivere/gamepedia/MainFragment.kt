package com.strivere.gamepedia

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var factory: GamepediaViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = GamepediaApi()
        val repository = GamepediaRepository(api)
        factory = GamepediaViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
    }
}
