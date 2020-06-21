package dev.ayan.searchlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.ayan.searchlist.ui.main.WordFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment, WordFragment())
                .commit()
        }
    }