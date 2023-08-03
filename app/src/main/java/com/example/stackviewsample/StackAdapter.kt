package com.example.stackviewsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.stackviewsample.databinding.ItemStackViewBinding

class StackAdapter(private val items: List<ItemData>) : BaseAdapter() {

    private var selectedItemPosition = -1

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Any = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val item = getItem(position) as ItemData
        val binding = if (convertView == null) {
            val inflater = LayoutInflater.from(parent?.context)
            ItemStackViewBinding.inflate(inflater, parent, false)
        } else {
            ItemStackViewBinding.bind(convertView)
        }

        binding.itemLabel.text = item.label
        binding.itemText.text = item.text
        return binding.root
    }

    fun setSelectedItem(position: Int) {
        selectedItemPosition = position
        notifyDataSetChanged()
    }
}

