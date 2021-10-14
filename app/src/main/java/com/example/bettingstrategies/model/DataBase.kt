package com.example.bettingstrategies.model

import android.content.Context
import com.example.bettingstrategies.R

@Suppress("UNCHECKED_CAST")
class DataBase(private val context: Context) {
    private val fileManager = FileManager(context)
    private val filename = "Strategies"

    var strategyList: ArrayList<Strategy>

    val favoritesList: ArrayList<Strategy>
    get() {
        val list = ArrayList<Strategy>()
        for (strategy in strategyList) {
            if (strategy.isFavorite)
                list.add(strategy)
        }
        return list
    }

    init {
        strategyList = if (fileManager.readFile(filename) == null)
                            createNewStrategiesList()
                       else
                            fileManager.readFile(filename) as ArrayList<Strategy>
    }

    private fun write(list: ArrayList<Strategy>) {
        fileManager.writeFile(filename, list)
    }

    fun upDate(strategy: Strategy) {
        strategyList[strategyList.indexOf(strategy)] = strategy
        write(strategyList)
    }

    private fun createNewStrategiesList(): ArrayList<Strategy> {
        val list = ArrayList<Strategy>()
        list.add(Strategy(R.string.title_strategy_1,
            R.string.strategy_1,
            R.mipmap.img_strategy_1, false))
        list.add(Strategy(R.string.title_strategy_2,
            R.string.strategy_2,
            R.mipmap.img_strategy_2, false))
        list.add(Strategy(R.string.title_strategy_3,
            R.string.strategy_3,
            R.mipmap.img_strategy_3, false))
        list.add(Strategy(R.string.title_strategy_4,
            R.string.strategy_4,
            R.mipmap.img_strategy_4, false))
        list.add(Strategy(R.string.title_strategy_5,
            R.string.strategy_5,
            R.mipmap.img_strategy_5, false))
        list.add(Strategy(R.string.title_strategy_6,
            R.string.strategy_6,
            R.mipmap.img_strategy_6, false))
        fileManager.writeFile(filename, list)
        return list
    }
}