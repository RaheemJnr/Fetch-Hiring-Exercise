package com.raheemjnr.fetch_hiring_exercise.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raheemjnr.fetch_hiring_exercise.data.model.FetchItems

@Composable
fun ExerciseItem(item: FetchItems) {

    //annotated text
    val listId = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)) {
            append("ListId: ")
        }
        append("${item.listId}")
    }
    val id = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)) {
            append("Id: ")
        }
        append("${item.id}")
    }
    val name = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)) {
            append("Name: ")
        }
        append("${item.name}")
    }

    //list item layout
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = listId
            )
            Row {
                Text(
                    text =id
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = name
                )
            }
        }
    }


}
