package com.gustavorueda.facebook.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    postText: String = "Porfin termine la pantalla de Login Compose",
    imageUrl: String = "https://picsum.photos/600/400",
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        PostHeader()

        Text(
            text = postText,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Imagen remota cargada con la librería Coil
        AsyncImage(
            model = imageUrl,
            contentDescription = "https://mi-dominio.com/foto.jpg",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
        )

        PostStats()

        PostActions()
    }
}

@Preview(showBackground = true)
@Composable
fun PostCardPreview() {
    PostCard()
}
