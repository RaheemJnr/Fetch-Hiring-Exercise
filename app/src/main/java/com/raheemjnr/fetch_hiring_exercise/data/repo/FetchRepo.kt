package com.raheemjnr.fetch_hiring_exercise.data.repo

import androidx.paging.PagingData
import com.raheemjnr.fetch_hiring_exercise.data.model.FetchItems
import kotlinx.coroutines.flow.Flow


/**
 * interface to get our data
 */
interface FetchRepo {
    //list
    suspend fun getItemsList( page: Int, pageSize: Int): List<FetchItems>
}