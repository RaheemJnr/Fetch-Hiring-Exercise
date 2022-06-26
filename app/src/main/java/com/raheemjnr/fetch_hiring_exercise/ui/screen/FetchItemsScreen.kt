package com.raheemjnr.fetch_hiring_exercise.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.raheemjnr.fetch_hiring_exercise.data.model.FetchItems
import com.raheemjnr.fetch_hiring_exercise.data.repo.FetchRepoImpl
import com.raheemjnr.fetch_hiring_exercise.ui.FetchVM
import com.raheemjnr.fetch_hiring_exercise.ui.FetchVmFactory
import com.raheemjnr.fetch_hiring_exercise.ui.components.ExerciseItem

/**
 * Screen that contain data from [FetchItems]
 * */
@Composable
fun FetchExerciseScreen() {

    //viewModel
    val viewModel: FetchVM = viewModel(
        factory = FetchVmFactory(FetchRepoImpl())
    )
    /***
     *  holds [LazyPagingItems<FetchItems]
     *  to be displayed to users */
    val pagingItems = viewModel.getExerciseList().collectAsLazyPagingItems()
    //paging state
    val lazyListState = rememberLazyListState()

    //lazy column
    LazyColumn(state = lazyListState) {
        items(items = pagingItems,
            key = { listItem ->
                listItem.id.toString()
            }
        ) { item ->
            item?.let {
                Column {
                    ExerciseItem(item = it)
                }
            }
        }
        //check the current state during paging and apply desired effect
        pagingItems.apply {
            when {
                //refresh list
                loadState.refresh is LoadState.Loading -> item {
                    CircularProgressIndicator()
                }
                //add to the already available list
                loadState.append is LoadState.Loading -> item {
                    CircularProgressIndicator()
                }
                loadState.refresh is LoadState.Error -> item {
                    CircularProgressIndicator()
                }
            }
        }
    }
}