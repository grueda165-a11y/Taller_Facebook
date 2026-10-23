package com.gustavorueda.facebook.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Composable sin estado (stateless) para mostrar las estadísticas de una publicación (reacciones y comentarios).
 *
 * @param modifier Modificador para personalizar el diseño.
 * @param likesCount Cantidad de likes/reacciones en formato texto.
 * @param commentsCount Texto con la cantidad de comentarios.
 */
@Composable
fun PostStats(
    modifier: Modifier = Modifier,
    likesCount: String = "24",
    commentsCount: String = "3 comentarios",
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // Lado izquierdo: Ícono de me gusta/reacción y contador de likes
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "👍",
                fontSize = 14.sp,
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = likesCount,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }

        // Lado derecho: Contador de comentarios
        Text(
            text = commentsCount,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PostStatsPreview() {
    PostStats()
}
