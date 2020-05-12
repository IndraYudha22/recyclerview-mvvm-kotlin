package com.strivere.gamepedia.ui.menudetail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.strivere.gamepedia.R
import com.strivere.gamepedia.data.models.Game
import com.strivere.gamepedia.data.network.GamepediaApi
import com.strivere.gamepedia.data.repositories.GamepediaRepository
import com.strivere.gamepedia.databinding.DetailFragmentBinding
import com.strivere.gamepedia.ui.RecyclerViewClickListener
import com.strivere.gamepedia.ui.mainmenu.GamepediaViewModelFactory
import kotlinx.android.synthetic.main.detail_fragment.*
import kotlinx.android.synthetic.main.detail_fragment.view.*
import kotlinx.android.synthetic.main.detail_fragment.view.tabs
import kotlinx.android.synthetic.main.detail_fragment.view.viewPager

class DetailFragment : Fragment(), RecyclerViewClickListener {

    private lateinit var idContent: String
    private lateinit var viewModel: DetailViewModel
    private lateinit var factory: GamepediaViewModelFactory
    private lateinit var binding: DetailFragmentBinding


    companion object {
        fun newInstance(id: String) = DetailFragment().apply {
            this.idContent = id
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val pagerAdapter = ViewPagerAdapter(activity?.supportFragmentManager!!, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        pagerAdapter.addFragment(SpecFragment(), "Spesification")
        pagerAdapter.addFragment(AboutFragment(), "About")
        viewPager.adapter = pagerAdapter
        tabs.setupWithViewPager(viewPager)

        val api = GamepediaApi()
        val repository =
            GamepediaRepository(api)
        factory = GamepediaViewModelFactory(
            repository
        )
        viewModel = ViewModelProvider(this, factory).get(DetailViewModel::class.java)
        viewModel.getContentId(idContent)
        viewModel.content.observe(viewLifecycleOwner, Observer {content ->
            if (content != null){
                binding.apply {
                    binding.gamepedia = content[0]
                }
                rv_all_image.also {
                    it.layoutManager = LinearLayoutManager(requireContext())
                    it.setHasFixedSize(true)
                    it.adapter = ImageListAdapter(content, this)
                }
            }
        })
    }

    override fun onRecyclerViewItemClick(view: View, game: Game, id: String) {

    }

}
