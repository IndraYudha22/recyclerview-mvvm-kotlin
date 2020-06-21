package com.strivere.gamepedia.ui.menudetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.strivere.gamepedia.data.models.Game
import com.strivere.gamepedia.data.network.GamepediaApi
import com.strivere.gamepedia.data.repositories.GamepediaRepository
import com.strivere.gamepedia.databinding.DetailFragmentBinding
import com.strivere.gamepedia.ui.RecyclerViewClickListener
import com.strivere.gamepedia.ui.mainmenu.GamepediaViewModelFactory
import kotlinx.android.synthetic.main.detail_fragment.*

class DetailFragment : Fragment(), RecyclerViewClickListener {

    private lateinit var idContent: String
    private lateinit var viewModel: DetailViewModel
    private lateinit var factory: GamepediaViewModelFactory
    private lateinit var binding: DetailFragmentBinding
    private lateinit var toolbar: Toolbar

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
        toolbar = binding.toolbarDetail
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val aboutFragment: Fragment = AboutFragment.newInstance(idContent)
        val specFragment: Fragment = SpecFragment.newInstance(idContent)
        val pagerAdapter = ViewPagerAdapter(activity?.supportFragmentManager!!, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        pagerAdapter.addFragment(aboutFragment, "About")
        pagerAdapter.addFragment(specFragment, "Specification")
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
                    it.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                    it.setHasFixedSize(true)
                    it.adapter = ImageListAdapter(content[0].image, this)
                }
            }else {
                Toast.makeText(requireContext(), "Internet error or Api Error \nclose Apps and run again", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onRecyclerViewItemClick(view: View, game: Game, id: String) {

    }


}
