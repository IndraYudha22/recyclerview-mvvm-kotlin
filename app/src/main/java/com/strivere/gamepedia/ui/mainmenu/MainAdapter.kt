package com.strivere.gamepedia.ui.mainmenu

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.strivere.gamepedia.R
import com.strivere.gamepedia.data.models.Game
import com.strivere.gamepedia.databinding.RecyclerviewMenuBinding
import com.strivere.gamepedia.ui.RecyclerViewClickListener

class MainAdapter(private val content: List<Game>, private val listener: RecyclerViewClickListener)
    : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    var id : String = ""

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
        holder.recyclerviewMenuBinding.layoutImage.setOnClickListener {  }
        holder.recyclerviewMenuBinding.layoutAll.setOnClickListener {
            listener.onRecyclerViewItemClick(holder.recyclerviewMenuBinding.layoutAll, content[position], content[holder.adapterPosition].id)
        }
    }

    inner class MainViewHolder(
        val recyclerviewMenuBinding: RecyclerviewMenuBinding
    ) : RecyclerView.ViewHolder(recyclerviewMenuBinding.root)
}