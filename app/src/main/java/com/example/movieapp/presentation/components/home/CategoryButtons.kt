package com.example.movieapp.presentation.components.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.R
import com.example.movieapp.presentation.home.HomeViewModel
import com.example.movieapp.util.Genre

@Composable
fun CategoryButtons(
    categories: List<String>,
    viewModel: HomeViewModel,
    genreMap: Map<String, Genre>,
    selectedButtonIndex: MutableState<Int>
) {
    LazyRow {
        items(
            count = categories.size,
            itemContent = {
                val ctgry = categories[it]
                Card(
                    modifier = Modifier.padding(start = 10.dp, top = 20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = colorResource(id = R.color.background)
                    )
                ) {
                    ElevatedButton(
                        onClick = {
                            viewModel.loadGetGenreMovie(genreMap[ctgry]?.id.toString())
                            selectedButtonIndex.value = it
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (selectedButtonIndex.value == it) colorResource(
                                id = R.color.search
                            ) else colorResource(id = R.color.background)
                        )
                    ) {
                        Text(
                            text = ctgry,
                            fontSize = 12.sp,
                            color = if (selectedButtonIndex.value == it) colorResource(id = R.color.primary_blue) else Color.White
                        )
                    }
                }
            }
        )
    }
}