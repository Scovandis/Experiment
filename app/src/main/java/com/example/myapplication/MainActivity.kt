package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.core.view.isVisible
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = mutableListOf<Data>()
    private val listDetail = mutableListOf<Data.DataDetail>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addData()

    }

    private fun addData() {
        var number = 0L
        for (i in 0..3) {
            val detail = Data.DataDetail(
                id = number++,
                itemName = "Suhendra ${i}"
            )
            listDetail.add(detail)
        }

        number = 0L
        for (i in 0..1) {
            val data = Data(
                id = number++,
                name = "Parent ${number++}"
            )
            list.add(data)
        }

        Log.i("DATA", "parent ${Gson().toJson(list)}")
        Log.i("DATA", "child ${Gson().toJson(listDetail)}")


        val resultJson = mutableListOf<Data>()
//        for (u in 0..listDetail.size) {
//            list.forEach { data ->
//                val detailList = mutableListOf<Data.DataDetail>()
//                listDetail.forEach { detail ->
//                    if (detail.id == data.id) {
//                        detailList.add(detail)
//                    }else if(list.size > u && detail.id != data.id){
//                        detailList.add(listDetail[u])
//                    }
//                }
//                if (list.size < u) {
//                    resultJson.add(Data(id = data.id, name = data.name, detailList))
//                }else{
//                    resultJson.add(Data(id = u.toLong(), name = "", detailList))
//                }
//            }
//        }

        Log.i("DATA", "jsonResult ${Gson().toJson(resultJson)}")
        val result = String.format("$resultJson")
        binding.parent.text = result
    }

}