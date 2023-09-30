package ru.potemkin.move4goodapp.domain.entities

data class ActivityItem(
    val name:String,
    val count:Int,
    val goal:Int,
    var id:Int = UNDEFINED_ID
) {
    companion object{
        const val UNDEFINED_ID = 0
    }
}