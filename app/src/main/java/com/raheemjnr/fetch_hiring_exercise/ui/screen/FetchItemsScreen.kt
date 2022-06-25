package com.raheemjnr.fetch_hiring_exercise.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.raheemjnr.fetch_hiring_exercise.data.model.FetchItems
import com.raheemjnr.fetch_hiring_exercise.data.repo.FetchRepoImpl
import com.raheemjnr.fetch_hiring_exercise.ui.FetchVM
import com.raheemjnr.fetch_hiring_exercise.ui.FetchVmFactory

/**
 * Screen that contain data from [FetchItems]
 * */
@Composable
fun FetchExerciseScreen() {

    //viewModel
    val viewModel: FetchVM = viewModel(
        factory = FetchVmFactory(FetchRepoImpl())
    )

    val pagingItems = viewModel.getExerciseList().collectAsLazyPagingItems()
    val lazyListState = rememberLazyListState()

    LazyColumn(state = lazyListState) {
        items(items = pagingItems,
            key = { listItem ->
                listItem.id.toString()
            }
        ) { item ->
            item?.let {
                Column {
                    Text(text = "$it")
                }
            }
        }
        pagingItems.apply {
            when {
                //refresh list
                loadState.refresh is LoadState.Loading -> item {
                    Dialog(
                        onDismissRequest = {},
                        DialogProperties(
                            dismissOnBackPress = false,
                            dismissOnClickOutside = false
                        )
                    ) {
                        Box(
                            modifier = Modifier
                                .size(55.dp)
                                .background(
                                    Color.Transparent,
                                    shape = RoundedCornerShape(8.dp)
                                )
                        ) {

                        }
                    }
                }
                //add to the already available list
                loadState.append is LoadState.Loading -> item {

                }
                loadState.refresh is LoadState.Error -> item {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.BottomCenter,

                        ) {

                    }
                }
            }
        }
    }
}