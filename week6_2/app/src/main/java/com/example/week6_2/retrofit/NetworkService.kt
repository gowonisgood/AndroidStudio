package com.example.week6_2.retrofit

import com.example.week6_2.model.PageListModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//Retrofit Query 구현
interface NetworkService {
    @GET("/v2/everything")
    fun getList(
        @Query("q") q: String?,
        @Query("apiKey") apiKey: String?,
        @Query("page") page: Long,
        @Query("pageSize") pageSize: Int
    ): Call<PageListModel>
}

