package br.com.fiap.dragonBallApp.presentation.character.detail


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.dragonBallApp.domain.model.Transformation
import br.com.fiap.dragonBallApp.ui.theme.DragonBallAppTheme
import coil3.compose.AsyncImage

@Composable
fun TransformationCard(transformation: Transformation = Transformation(1, "", "")) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .padding(20.dp),
        colors = CardColors(
            containerColor = Color.Yellow,
            contentColor = Color.White,
            disabledContainerColor = Color.Yellow,
            disabledContentColor = Color.White,
        )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = transformation.image,
                contentDescription = transformation.name,
                modifier = Modifier.size(160.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = transformation.name.uppercase(),
                style = MaterialTheme.typography.headlineMedium
            )
        }


    }

}

@Preview(showBackground = true)
@Composable
private fun TransformationCardPreview() {
    DragonBallAppTheme {
        TransformationCard()
    }
}