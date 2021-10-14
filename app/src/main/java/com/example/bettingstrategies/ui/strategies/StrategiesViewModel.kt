package com.example.bettingstrategies.ui.strategies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bettingstrategies.model.DataBase
import com.example.bettingstrategies.model.Strategy

class StrategiesViewModel(application: Application) : AndroidViewModel(application) {
    private val dataBase = DataBase(application.baseContext)

    private val _strategyList = MutableLiveData<ArrayList<Strategy>>().apply {
        value = dataBase.strategyList
    }
    val strategyList: LiveData<ArrayList<Strategy>> = _strategyList

    fun upDate(strategy: Strategy) {
        dataBase.upDate(strategy)
        _strategyList.value = dataBase.strategyList
    }

}