package com.strivere.gamepedia.ui.menudetail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.strivere.gamepedia.R
import kotlinx.android.synthetic.main.detail_fragment.view.*

class DetailFragment : Fragment() {

    private lateinit var idContent: String

    companion object {
        fun newInstance(id: String) = DetailFragment().apply {
            this.idContent = id
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.detail_fragment, container, false)
        rootView.id_content.text = idContent
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}
