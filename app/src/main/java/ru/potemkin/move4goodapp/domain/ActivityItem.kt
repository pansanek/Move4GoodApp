package ru.potemkin.move4goodapp.domain

data class ActivityItem(
    val name:String,
    val count:Int,
    var id:Int = UNDEFINED_ID,
    val goal:Int
) {
    companion object{
        const val UNDEFINED_ID = 0
    }
}