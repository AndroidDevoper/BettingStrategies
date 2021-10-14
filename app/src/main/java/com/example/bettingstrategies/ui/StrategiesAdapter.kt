package com.example.bettingstrategies.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.bettingstrategies.databinding.ItemStrategiesBinding
import com.example.bettingstrategies.model.Strategy

class StrategiesAdapter(private val inflater: LayoutInflater,
                        private val callback: CallBack
    ): BaseAdapter() {

    private var strategiesList = ArrayList<Strategy>()

    interface CallBack {
        fun upDate(strategy: Strategy)
        fun onClickStrategy(strategy: Strategy)
    }

    fun upDate(list: ArrayList<Strategy>) {
        strategiesList = list
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return strategiesList.size
    }

    override fun getItem(p0: Int): Any {
        return strategiesList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val binding = ItemStrategiesBinding.inflate(inflater)
        val strategy = strategiesList[p0]
        binding.itemStrategiesTvTitle.setText(strategy.title_res)
        binding.itemStrategiesImg.setImageResource(strategy.img_res)
        binding.itemStrategiesChBoxFavorites.isChecked = strategy.isFavorite
        binding.itemStrategiesChBoxFavorites.setOnCheckedChangeListener {view, ch ->
            strategy.isFavorite = ch
            callback.upDate(strategy)
        }
        binding.root.setOnClickListener {
            callback.onClickStrategy(strategy)
        }
        return binding.root
    }

     fun detach() {
         for(i in 0 until strategiesList.size)
             callback.upDate(strategiesList[i])
     }
}