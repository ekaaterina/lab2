package com.example.test


data class ItemRowModel(
    val image: Int,
    var title: String,
    val url: String,
    val hero: String

)

object Hero {

    val Heroes = listOf(
        ItemRowModel(R.drawable.deadpool, "Deadpool","https://i.ibb.co/LSXGK7r/deadpool.jpg","Ignorance is my middle name"),
        ItemRowModel(R.drawable.ironman, "Iron Man","https://i.ibb.co/PY34rDP/ironman.jpg","The truth is ... I'm an Iron Man."),
        ItemRowModel(R.drawable.capitan, "Capitan America","https://i.ibb.co/98V1RVG/capitan.jpg","I taught you everything I can, friend!"),
        ItemRowModel(R.drawable.spiderman, "Spider Man","https://i.ibb.co/mRrTnQX/spiderman.jpg","Hey guys! Wait a minute... You're not real Avengers!"),
        ItemRowModel(R.drawable.doktor, "Doctor Strange","https://i.ibb.co/4R3LvWv/doktor.jpg","Your sacrifice is greater than your strength"),
        ItemRowModel(R.drawable.thor, "Thor","https://i.ibb.co/Y8Wfykv/Thor.jpg","I make big mistakes all the time. Everything seems to be working out."),
        ItemRowModel(R.drawable.thanos, "Thanos","https://i.ibb.co/8PLV266/thanos.jpg","Some tremble... others run. Fate comes to everyone..."))

}
