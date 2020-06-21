package com.strivere.gamepedia.ui.menudetail

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.strivere.gamepedia.data.network.GamepediaApi
import com.strivere.gamepedia.data.repositories.GamepediaRepository
import com.strivere.gamepedia.databinding.FragmentAboutBinding
import com.strivere.gamepedia.ui.mainmenu.GamepediaViewModelFactory


class AboutFragment : Fragment() {

    private lateinit var idContent: String
    private lateinit var viewModel: DetailViewModel
    private lateinit var factory: GamepediaViewModelFactory
    private lateinit var binding: FragmentAboutBinding

    companion object {
        fun newInstance(id: String) = AboutFragment().apply {
            this.idContent = id
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = GamepediaApi()
        val repository = GamepediaRepository(api)
        factory = GamepediaViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(DetailViewModel::class.java)
        viewModel.getContentId(idContent)
        viewModel.content.observe(viewLifecycleOwner, Observer { content ->
            if (content != null){
                binding.apply {
                    binding.gamepedia = content[0]
                }
            } else {
                Toast.makeText(requireContext(), "Internet error or Api Error \nclose Apps and run again", Toast.LENGTH_LONG).show()
            }
        })
    }

}
