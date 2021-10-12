package com.example.linah_alkhurayyif_headsup

import retrofit2.Call
import retrofit2.http.*

interface APIInterface {
    @GET("/celebrities/")
    fun getListUser(): Call<List<CelebritiesDetails.Celebrities>>


    @POST("/celebrities/")
    fun addcelebrities(@Body celebritiesData: CelebritiesDetails.Celebrities): Call<CelebritiesDetails.Celebrities>

    @PUT("/celebrities/{id}")
    fun updatecelebrities(@Path("id") id: Int?, @Body celebritiesData: CelebritiesDetails.Celebrities): Call<CelebritiesDetails.Celebrities>

    @DELETE("/celebrities/{id}")
    fun deletecelebrities(@Path("id") id: Int?): Call<Void>
}