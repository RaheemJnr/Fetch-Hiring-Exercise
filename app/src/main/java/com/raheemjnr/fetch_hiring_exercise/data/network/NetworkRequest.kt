package com.raheemjnr.fetch_hiring_exercise.data.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.raheemjnr.fetch_hiring_exercise.data.model.FetchItemsDto
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//base url
const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Main entry point for network access.
 * a singleton class that fetch all data from API and use [Moshi] to convert them into use able objects
 */
object FetchExerciseApiCall {
    // Configure retrofit to parse JSON and use coroutines
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    //
    val FETCH_SERVICE: FetchExerciseService by lazy {
        retrofit.create(FetchExerciseService::class.java)
    }
}

// interface used to model data on server and return it in a specified format
interface FetchExerciseService {
    @GET("hiring.json")
    suspend fun getExerciseList(
        @Query("page") page: Int = 1,
        @Query("per_page") pageSize: Int = 20
    ): Response<List<FetchItemsDto>>

}



