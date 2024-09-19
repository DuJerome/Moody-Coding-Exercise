package com.dushanesmith.moodycodingexercise

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.paging.compose.collectAsLazyPagingItems
import com.dushanesmith.moodycodingexercise.ui.theme.MoodyCodingExerciseTheme
import com.dushanesmith.moodycodingexercise.ui.theme.Post
import com.dushanesmith.moodycodingexercise.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoodyCodingExerciseTheme {
                PostList(mainViewModel, context = applicationContext)
            }
        }
    }
}

@Composable
fun PostList(mainViewModel: MainViewModel, context: Context) {
    val postListData = mainViewModel.getCardData().collectAsLazyPagingItems()
    val postList = remember { postListData }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        items(postList.itemCount) {
            Post(postList[it], context = context)
        }
    }
}