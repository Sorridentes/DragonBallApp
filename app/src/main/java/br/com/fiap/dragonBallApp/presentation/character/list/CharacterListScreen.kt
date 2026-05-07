package br.com.fiap.dragonBallApp.presentation.character.list


import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import br.com.fiap.dragonBallApp.presentation.common.UiState
import coil3.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 13)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterListScreen(
    onCharacterClick: (number: Int) -> Unit,
    viewModel: CharacterListViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getCharacters()
    }

    Scaffold(topBar = {
        TopAppBar(
            title = { Text("Personagens") }
        )
    }) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            when (val state = uiState) {
                UiState.Initial -> Unit

                UiState.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.padding(16.dp)
                    )
                }

                is UiState.Error -> {
                    Text(
                        text = state.message,
                        modifier = Modifier.padding(16.dp)
                    )
                }

                is UiState.Success -> {
                    LazyRow {
                        items(state.data) { character ->
                            Card(
                                modifier = Modifier
                                    .width(200.dp)
                                    .clickable { onCharacterClick(character.id) },
                                colors = CardColors(
                                    containerColor = Color.Black,
                                    contentColor = Color.White,
                                    disabledContainerColor = Color.Black,
                                    disabledContentColor = Color.White
                                ),
                                border = BorderStroke(width = 1.dp, color = Color.White),
                            ) {
                                AsyncImage(
                                    model = character.image,
                                    contentDescription = character.name,
                                    modifier = Modifier.size(100.dp),
                                    contentScale = ContentScale.Fit
                                )

                                Spacer(modifier = Modifier.width(8.dp))

                                Text(text = character.name.replaceFirstChar { it.uppercase() },
                                    style = MaterialTheme.typography.headlineMedium)
                            }
                        }
                    }
                }
            }
        }
    }
}