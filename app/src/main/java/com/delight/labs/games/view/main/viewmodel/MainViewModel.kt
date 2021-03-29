package com.delight.labs.games.view.main.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.delight.labs.games.helper.extens.get
import com.delight.labs.games.helper.extens.init
import com.delight.labs.games.helper.extens.set
import com.delight.labs.games.helper.extens.toFlowable
import com.delight.labs.games.viewmodel.BaseViewModel

/**
 * 页面描述：MainViewModel
 *
 * Created by ditclear on 2018/12/11.
 */
class MainViewModel constructor():BaseViewModel(){

    val text = MutableLiveData<String>().init("click me ")
    val doubleBindText = MutableLiveData<String>().apply {
        set("")
    }

    init {
        doubleBindText.toFlowable()
            .doOnNext {
                println("MainViewModel------》$it")
            }.subscribe()
    }


    val loading = MutableLiveData<Boolean>().apply { set(false) }

    fun testView() {
        text.set("${text.get() ?: ""}111")
    }
}