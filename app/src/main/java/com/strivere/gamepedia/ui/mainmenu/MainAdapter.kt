package com.strivere.gamepedia.ui.mainmenu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.strivere.gamepedia.R
import com.strivere.gamepedia.data.models.DataContentItem
import com.strivere.gamepedia.data.models.Game
import com.strivere.gamepedia.databinding.RecyclerviewMenuBinding
import com.strivere.gamepedia.ui.RecyclerViewClickListener
import kotlinx.android.extensions.LayoutContainer

class MainAdapter(private val content: List<DataContentItem>, private val listener: RecyclerViewClickListener)
    : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

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
            listener.onRecyclerViewItemClick(holder.recyclerviewMenuBinding.layoutAll, content[position].data, content[holder.adapterPosition].data.id)
        }
        holder.bindItem(content[position])
    }

    inner class MainViewHolder(
        val recyclerviewMenuBinding: RecyclerviewMenuBinding
    ) : RecyclerView.ViewHolder(recyclerviewMenuBinding.root), LayoutContainer{
        override val containerView: View?
            get() = itemView

        fun bindItem(item: DataContentItem){
            containerView?.context.let {
                recyclerviewMenuBinding.gamepedia = item
                recyclerviewMenuBinding.executePendingBindings()
            }
        }

    }

}