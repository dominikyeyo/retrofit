package com.diegonunez.retrofitarticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import com.diegonunez.retrofitarticle.ui.theme.RetrofitArticleTheme

class MainActivity : ComponentActivity() {
    private val tmdbViewModel: TmdbViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        //private lateinit var tmdbViewModel: TmdbViewModel


        super.onCreate(savedInstanceState)
        setContent {
            RetrofitArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }

        tmdbViewModel.fetchMovies()

        tmdbViewModel.popularMoviesLiveData.observe(this, Observer {

            //TODO - Your Update UI Logic
        })
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RetrofitArticleTheme {
        Greeting("Android")
    }
}