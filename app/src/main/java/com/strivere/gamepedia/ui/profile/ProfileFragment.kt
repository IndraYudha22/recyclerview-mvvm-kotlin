package com.strivere.gamepedia.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.strivere.gamepedia.R
import com.strivere.gamepedia.databinding.FragmentProfileBinding
import com.strivere.gamepedia.ui.mainmenu.MainFragment

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    companion object {
        fun newInstance() = ProfileFragment().apply {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        val btn_back = binding.btnBack
        btn_back.setOnClickListener {
           back()
        }
        return binding.root
    }

    fun back(){
        val mainFragment: Fragment = MainFragment.newInstance()
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment3, mainFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}
