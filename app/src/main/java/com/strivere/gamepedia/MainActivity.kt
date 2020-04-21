package com.strivere.gamepedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = GamepediaRepository(GamepediaApi())

        GlobalScope.launch(Dispatchers.Main) {
            val gamepedia = repository.getContent()
            Toast.makeText(this@MainActivity, gamepedia.toString(), Toast.LENGTH_LONG).show()
        }
    }
}
