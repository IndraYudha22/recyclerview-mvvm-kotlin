package com.strivere.gamepedia.ui.mainmenu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.strivere.gamepedia.R
import com.strivere.gamepedia.data.models.Game
import com.strivere.gamepedia.databinding.RecyclerviewMenuBinding

class MainAdapter(private val content: List<Game>) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MainViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_menu,
                parent,
                false
            )
        )

    override fun getItemCount(): Int {
        return content.size
    }

    override fun onBindViewHolder(holder: MainAdapter.MainViewHolder, position: Int) {
        holder.recyclerviewMenuBinding.gamepedia = content[position]
    }

    inner class MainViewHolder(
        val recyclerviewMenuBinding: RecyclerviewMenuBinding
    ) : RecyclerView.ViewHolder(recyclerviewMenuBinding.root)
}