package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapters by lazy { MainAdapter(lists()) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val callback: ItemTouchHelper.Callback = ItemMoveCallback(adapters)
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(binding.recyclerView)

        binding.recyclerView.adapter = adapters
    }

    private fun lists(): ArrayList<String>{
        val lists = arrayListOf<String>()
        for (i in 0 .. 30)
            lists.add("items $i")

        return lists
    }
}