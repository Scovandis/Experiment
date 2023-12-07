package com.example.myapplication

import android.R.attr.data
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplication.databinding.ListItemsBinding
import java.util.Collections


class MainAdapter(private val list: ArrayList<String>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>(), ItemTouchHelperContract {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemsBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = with(holder.binding) {
        textData.text = list[position]
    }

    class ViewHolder(val binding: ListItemsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onRowMoved(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Log.i("MOVED", "until\nfromPos : $fromPosition\ntoPos : $toPosition")
                Collections.swap(list, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Log.i("MOVED", "toDown\nfromPos : $fromPosition\ntoPos : $toPosition")
                Collections.swap(list, i, i - 1)
            }
        }
//        Collections.swap(list, fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onRowSelected(viewHolder: RecyclerView.ViewHolder) {
//        with(viewHolder.binding)
    }

    override fun onRowClear(viewHolder: RecyclerView.ViewHolder) {
    }

}