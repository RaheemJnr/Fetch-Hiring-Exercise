package com.raheemjnr.fetch_hiring_exercise.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.raheemjnr.fetch_hiring_exercise.data.repo.FetchRepo
import com.raheemjnr.fetch_hiring_exercise.utilz.PageNumSource

/**
 * [ViewModel] to fetch our data using paging [PageNumSource]
 * **/
class FetchVM(private val repo: FetchRepo) : ViewModel() {


    /**
     * here i used a [Pager] to page data received from [FetchRepo]
     * and according to the requirement remove items that have empty name or is blank
     * **/
    fun getExerciseList(pageSize: Int = 20) =
        Pager(config = PagingConfig(pageSize = pageSize, initialLoadSize = pageSize)) {
            PageNumSource { pageNum, pageSize ->
                repo.getItemsList(pageNum, pageSize).filter { !it.name.isNullOrEmpty() }
                    .sortedBy { it.listId}
            }
        }.flow.cachedIn(viewModelScope)

}


/** viewModel Factory
 * it function is to tell the viewModel how to
 * create the repo object injected as a dependency
 * */
class FetchVmFactory(private val repo: FetchRepo) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FetchVM(repo) as T
    }
}