package com.example.myapplication

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // array initialization
        val array = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        // size of array
        val n = array.size
        val result = sum(array, 0) // normal function call
        Log.i("RESCUSIVE", "result : $result")

        val results = sumOfGenerate(generateData(), generateData().size)
        Log.i("RESCUSIVE", "generate : $results")

        val res = sumOfGenerateString(generateData())
        Log.i("DATA", "res : ${Gson().toJson(res)}")

        val sumof = sum(5, 10)
        Log.i("RESCUSIVE", "sumof : $sumof")

        val sumOfGenerate = sum(generateData(), 0)
        Log.i("RESCUSIVE", "last : $sumOfGenerate")

        val factorialRecursive = factorialRecursive(generateData(), 0)
        Log.i("RECURSIVE", "factorial : $factorialRecursive")
    }

    fun factorialRecursive(args: ArrayList<ParentModel>,index : Int): Int{
        /*Log.i("RECURSIVE", "loop : ${Gson().toJson(args)} \n index : $index")
        return if (index >= 5) args.size
        else (factorialRecursive(args, index + 1) + args[index + 1])*/
        return 0
    }
    fun sum(args: Array<Int>, index: Int): Int {
        Log.i("RESCUSIVE", "sumof args : ${args.toList()} \n index : $index")
        return if (index >= 4) 5
        else (sum(args, index + 1) + args[index + 1]) // recursive function call
    }

    fun sumOfGenerate(args: ArrayList<ParentModel>, index: Int): Int {
        Log.i("RESCUSIVE", "generate : ${args.toList()} \n index : $index")

        return if (index <= 0) 0
        else (sumOfGenerate(args, index - 1) + args.size - 1)
    }

    /*fun rescursiveGenerateString(args: ArrayList<ParentModel>, index: Int): ArrayList<String>{

    }*/

    fun sum(start: Int, end: Int): Int {
        Log.i("RESCUSIVE", "start : ${start} \n end : $end")

        return if (end > start) {
            end + sum(start, end - 1)
        } else {
            end
        }
    }

    fun sum(args: ArrayList<ParentModel>, index: Int): ArrayList<String> {
        return if (index <= 5) {
            if (args[index].label.isNotEmpty()) {
                Log.i("RESCUSIVE", "last : ${args[index].label.isNotEmpty()} \n size ${args.size}")
//                arrayListOf(TextUtils.join(",", )
//                (args[index].options.map { it } + sum(args, index + 1))
                val textUtils = TextUtils.join(",", args[index].options)
                Log.i("RESUSIVE", "textUtils : $textUtils")
                args[index].options.toArray()
                sum(args, index + 1)
            } else
                arrayListOf()
        } else arrayListOf()
    }

    fun sumOfGenerateString(args: ArrayList<ParentModel>): ArrayList<String> {
        val listsString = arrayListOf<String>()
        if (args.isNotEmpty()) {
            args[0].options.forEach { p1 ->
                if (args.size > 1) {
                    args[1].options.forEach { p2 ->
                        if (args.size > 2) {
                            args[2].options.forEach { p3 ->
                                listsString.add("$p1,$p2,$p3")
                            }
                        } else {
                            listsString.add("$p1,$p2")
                        }
                    }
                } else {
                    listsString.add("$p1")
                }
            }
        }
        return listsString
    }

    fun generateData(): ArrayList<ParentModel> = arrayListOf<ParentModel>().apply {
        this.add(
            ParentModel(
                "warna",
                arrayListOf(
                    "merah",
                    "kuning",
                    "hijau",
                    "ungu",
                    "jingga",
                    "merah muda",
                    "putih",
                    "biru",
                    "kuning",
                    "coklat",
                    "abu-abu"
                )
            )
        )
        this.add(
            ParentModel("ukuran", arrayListOf("besar", "kecil", "sedang", "super besar", "biasa"))
        )
        this.add(
            ParentModel("material", arrayListOf("22 x 3", "18 x 5"))
        )
    }
}