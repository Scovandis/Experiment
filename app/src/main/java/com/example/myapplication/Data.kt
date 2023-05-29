package com.example.myapplication

data class Data(
    var id: Long = 0L,
    var name: String = "",
    var listDetail: List<DataDetail>? = emptyList()
){
    data class DataDetail(
        val id: Long = 0L,
        var itemName: String = ""
    )
}
