package com.raheemjnr.fetch_hiring_exercise.data.repo

import android.util.Log
import com.raheemjnr.fetch_hiring_exercise.data.model.FetchItems
import com.raheemjnr.fetch_hiring_exercise.data.model.toDomainList
import com.raheemjnr.fetch_hiring_exercise.data.network.FetchExerciseApiCall

class FetchRepoImpl() : FetchRepo {

    override suspend fun getItemsList(page: Int, pageSize: Int): List<FetchItems> {
        val response = FetchExerciseApiCall.FETCH_SERVICE.getExerciseList(page)
        return if (response.isSuccessful && !response.body().isNullOrEmpty()) {
            val body = response.body()
            val bodyList = toDomainList(body!!)
            Log.d("Repo","$bodyList")
            bodyList
        } else {
            emptyList()
        }
    }
}