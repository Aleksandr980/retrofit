package com.example.m14_retrofit.retrofit


import com.example.m14_retrofit.utils.Constants.Companion.API_KEY
import com.example.m14_retrofit.utils.Constants.Companion.BASE_URL
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET



object RetrofitServices {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiSearchUser: ApiSearchUser = retrofit.create(ApiSearchUser::class.java)
}

interface ApiSearchUser {
    @GET(API_KEY)
 suspend fun  getUser() : Response<UserModel>
 }


