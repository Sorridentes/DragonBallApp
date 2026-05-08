package br.com.fiap.dragonBallApp.presentation.character.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.dragonBallApp.presentation.common.UiState
import br.com.fiap.dragonBallApp.ui.theme.DragonBallAppTheme
import coil3.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetailScreen(
    characterNumber: Int,
    onBackClick: () -> Unit,
    viewModel: CharacterDetailViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(characterNumber) {
        viewModel.getCharacterDetailByNumber(characterNumber)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalhe do Personagem") },
                navigationIcon = {
                    IconButton(onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                }
            )
        }
    ) { paddingInner ->
        Box(
            modifier = Modifier
                .padding(paddingInner)
                .padding(16.dp)
                .fillMaxSize(),
        ) {
            when (val state = uiState) {
                UiState.Initial -> Unit

                UiState.Loading -> {
                    CircularProgressIndicator()
                }

                is UiState.Error -> {
                    Text(state.message)
                }

                is UiState.Success -> {
                    val character = state.data

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        AsyncImage(
                            model = character.detail.image,
                            contentDescription = character.detail.name,
                            modifier = Modifier.size(160.dp),
                            contentScale = ContentScale.Fit
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = character.detail.name,
                            style = MaterialTheme.typography.headlineMedium,
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text("Número: ${character.detail.id}")

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(character.detail.description)

                        Spacer(modifier = Modifier.height(25.dp))

                        TransformationItems(character.transformations)
                    }

                }
            }
        }
    }
}

