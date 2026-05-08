package br.com.fiap.dragonBallApp.presentation.character.list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import br.com.fiap.dragonBallApp.domain.model.CharacterItem
import coil3.compose.AsyncImage

@Composable
fun CharacterCard(character: CharacterItem, onCharacterClick: () -> Unit) {
    Card(
        modifier = Modifier
            .clickable { onCharacterClick() },
        colors = CardColors(
            containerColor = Color.Black,
            contentColor = Color.White,
            disabledContainerColor = Color.Black,
            disabledContentColor = Color.White
        ),
        border = BorderStroke(width = 1.dp, color = Color.White),
    ) {
        Column(
            modifier = Modifier
                .width(350.dp)
                .height(450.dp)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = character.image,
                contentDescription = character.name,
                modifier = Modifier.size(350.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = character.name.replaceFirstChar { it.uppercase() },
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}