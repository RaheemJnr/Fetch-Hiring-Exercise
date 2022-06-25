package com.raheemjnr.fetch_hiring_exercise.data.repo

import android.util.Log
import androidx.paging.PagingData
import com.raheemjnr.fetch_hiring_exercise.data.model.FetchItems
import com.raheemjnr.fetch_hiring_exercise.data.model.toDomainList
import com.raheemjnr.fetch_hiring_exercise.data.network.FetchExerciseApiCall
import kotlinx.coroutines.flow.Flow


/**
 * interface to get our data
 */
interface FetchRepo {
    /***
    a coroutine function that return list of [FetchItems]]
    */
    suspend fun getItemsList( page: Int, pageSize: Int): List<FetchItems>
}

//repo implementation
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