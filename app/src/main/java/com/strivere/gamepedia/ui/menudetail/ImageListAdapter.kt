package com.strivere.gamepedia.ui.menudetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.strivere.gamepedia.R
import com.strivere.gamepedia.data.models.DataContentItem
import com.strivere.gamepedia.data.models.Game
import com.strivere.gamepedia.databinding.RecyclerviewImageBinding
import com.strivere.gamepedia.ui.RecyclerViewClickListener
import kotlinx.android.extensions.LayoutContainer

class ImageListAdapter(private val content: List<String>, private val listener: RecyclerViewClickListener)
    : RecyclerView.Adapter<ImageListAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ImageViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_image,
                parent,
                false
            )
        )

    override fun getItemCount(): Int {
        return content.size
    }

    override fun onBindViewHolder(holder: ImageListAdapter.ImageViewHolder, position: Int) {
        holder.bindItem(content[position])
    }

    inner class ImageViewHolder (val recyclerviewImageBinding: RecyclerviewImageBinding)
        : RecyclerView.ViewHolder(recyclerviewImageBinding.root), LayoutContainer {
        override val containerView: View?
            get() = itemView
        fun bindItem(item: String){
            containerView?.context.let {
                recyclerviewImageBinding.gamepedia = item
                recyclerviewImageBinding.executePendingBindings()
            }
        }
    }
}