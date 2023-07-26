package com.example.seng31323_myapplication.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var result =MutableLiveData<Double>(0.0)

    fun add(number1:Double,number2: Double){
        // Try var result = number1+number2
        result.value=number1.plus(number2)
        println(result.value)
        Log.d("Add results",result.value.toString())

    }
    fun subs(number1:Double,number2: Double){
        // Try var result = number1+number2
        result.value=number1.minus(number2)
        println(result.value)
        Log.d("subs results",result.value.toString())

    }
    fun prod(number1:Double,number2: Double){
        // Try var result = number1+number2
        result.value=number1.times(number2)
        println(result.value)
        Log.d("prod results",result.value.toString())

    }
    fun div(number1:Double,number2: Double){
        // Try var result = number1+number2
        result.value=number1.div(number2)
        println(result.value)
        Log.d("div results",result.value.toString())

    }
}