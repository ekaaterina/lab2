package com.example.test.network

import android.util.Log
import com.example.test.ItemRowModel
import com.squareup.moshi.Json
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.net.UnknownHostException

data class Result(
    @field:Json(name = "data") val data: Data?
)

data class Data(
    @field:Json(name = "results") val results: List<MarvelCharacter>
)

data class MarvelCharacter(
    @field:Json(name = "id") val id: Int?,
    @field:Json(name = "name") val name: String?,
    @field:Json(name = "description") val description: String?,
    @field:Json(name = "thumbnail") val thumbnail: Thumbnail?
)

data class Thumbnail(
    @field:Json(name = "path") val path: String?,
    @field:Json(name = "extension") val extension: String?
)


fun getMarvel(): List<ItemRowModel>{
    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(ApiMarvel.API_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val service = retrofit.create(ApiMarvel::class.java)
    val list: MutableList<ItemRowModel> = mutableListOf()
    try {
        val res = service.getAllCharacters().execute().body()!!.data!!.results
        var i = 0
        res.forEach { item ->
            if (item.thumbnail!!.path.toString() != "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available") {
                list.add(
                    ItemRowModel(
                        i,
                        item.name!!,
                        item.description!!,
                        item.thumbnail.path?.replace("http", "https") + "/portrait_incredible." + item.thumbnail.extension
                    )
                )
                i++
            }
        }
        Log.i("MyLog", list.toString())
    } catch (e: UnknownHostException) {
        list.add(ItemRowModel(0, "error","", ""))
    }

    return list
}
