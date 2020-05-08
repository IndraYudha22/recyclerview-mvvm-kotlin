package com.strivere.gamepedia.ui.mainmenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.ShapeAppearanceModel
import com.strivere.gamepedia.R
import com.strivere.gamepedia.data.models.Game
import com.strivere.gamepedia.data.network.GamepediaApi
import com.strivere.gamepedia.data.repositories.GamepediaRepository
import com.strivere.gamepedia.ui.RecyclerViewClickListener
import com.strivere.gamepedia.ui.menudetail.DetailFragment
import com.strivere.gamepedia.utils.Communicator
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.recyclerview_menu.*


class MainFragment : Fragment(),
    RecyclerViewClickListener {

    private lateinit var id:String


    private lateinit var viewModel: MainViewModel
    private lateinit var factory: GamepediaViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.main_fragment, container, false)

        return rootView
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = GamepediaApi()
        val repository =
            GamepediaRepository(api)
        factory = GamepediaViewModelFactory(
            repository
        )
        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
        viewModel.getContent()
        viewModel.content.observe(viewLifecycleOwner, Observer { content ->
            if  (content != null){
                rv_view_main_content.also {
                    it.layoutManager = LinearLayoutManager(requireContext())
                    it.setHasFixedSize(true)
                    it.adapter = MainAdapter(content,this)
                }
            }
        })
    }

    override fun onRecyclerViewItemClick(view: View, game: Game, id: String){
        when(view.id){
            R.id.layout_all -> {
                Toast.makeText(requireContext(), "id : "+id, Toast.LENGTH_LONG).show()
                ShowFragmentDetail(id)
            }
        }
    }

    fun ShowFragmentDetail(idContent: String) {
        val someFragment: Fragment = DetailFragment.newInstance(idContent)
        val transaction = requireFragmentManager().beginTransaction()
        transaction.replace(R.id.fragment3, someFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }




}
