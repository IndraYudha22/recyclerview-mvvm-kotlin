package com.strivere.gamepedia.ui

import android.view.View
import com.strivere.gamepedia.data.models.Game

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, game: Game, id: String)
}