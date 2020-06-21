package com.strivere.gamepedia.ui.menudetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.strivere.gamepedia.R
import com.strivere.gamepedia.data.network.GamepediaApi
import com.strivere.gamepedia.data.repositories.GamepediaRepository
import com.strivere.gamepedia.databinding.FragmentAboutBinding
import com.strivere.gamepedia.databinding.FragmentSpecBinding
import com.strivere.gamepedia.ui.mainmenu.GamepediaViewModelFactory
import kotlinx.android.synthetic.main.fragment_about.*
import kotlinx.android.synthetic.main.fragment_spec.*

class SpecFragment : Fragment() {

    private lateinit var idContent: String
    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: FragmentSpecBinding
    private lateinit var factory: GamepediaViewModelFactory

    companion object{
        fun newInstance(id: String) = SpecFragment().apply {
            this.idContent = id
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSpecBinding.inflate(inflater, container, false)
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
            }else {
                Toast.makeText(requireContext(), "Internet error or Api Error \nclose Apps and run again", Toast.LENGTH_LONG).show()
            }
        })
    }



}
