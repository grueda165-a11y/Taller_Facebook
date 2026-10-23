package com.gustavorueda.facebook.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Composable sin estado (stateless) para simular el PostHeader de una publicación estilo Facebook.
 *
 * @param modifier Modificador para personalizar el diseño externo.
 * @param userName Nombre del usuario o autor de la publicación.
 * @param timeAgo Tiempo transcurrido desde la publicación (ej. "Hace 2 h").
 * @param activationTime Hora o estado de activación (ej. "Activo(a) hace 5 min").
 * @param profileIcon Ícono de perfil / avatar.
 * @param onMoreClick Callback para el botón de opciones (tres puntos).
 */
@Composable
fun PostHeader(
    modifier: Modifier = Modifier,
    userName: String = "Gustavo Rueda",
    timeAgo: String = "Hace 2 h",
    activationTime: String = "Activo(a) hace 5 min",
    profileIcon: ImageVector = Icons.Default.AccountCircle,
    onMoreClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Ícono de perfil en el lado izquierdo
        Icon(
            imageVector = profileIcon,
            contentDescription = "Foto de perfil",
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(10.dp))

        // Columna con Nombre, Hora de publicación y Hora de activación
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = userName,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = timeAgo,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = activationTime,
                fontSize = 11.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
            )
        }

        // Ícono de tres puntos a la derecha
        IconButton(onClick = onMoreClick) {
            Icon(
                imageVector = Icons.Default.MoreHoriz,
                contentDescription = "Opciones de publicación",
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PostHeaderPreview() {
    PostHeader()
}
