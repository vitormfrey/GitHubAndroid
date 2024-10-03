package com.bit.githubperfil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bit.githubperfil.components.UserCard
import com.bit.githubperfil.framework.viewmodel.GitViewModel
import com.bit.githubperfil.framework.viewmodel.UiState
import com.bit.githubperfil.ui.theme.GitHubPerfilTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GitHubPerfilTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
    viewmodel: GitViewModel = koinViewModel()
) {
    val uiState = viewmodel.uiState.collectAsState()

    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        when (val state = uiState.value) {
            is UiState.Loading -> {
                CircularProgressIndicator()
            }
            is UiState.Success -> {
                UserCard(user = state.data)
            }
            is UiState.Error -> {
                Text(text = state.message)
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewmodel.fetchData() }) {
            Text(text = "Get Data")
            
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GitHubPerfilTheme {
        //Greeting("Android")
    }
}