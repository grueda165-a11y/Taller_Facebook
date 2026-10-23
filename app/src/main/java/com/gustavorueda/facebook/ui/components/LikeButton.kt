package com.gustavorueda.facebook.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Composable sin estado (stateless) para un botón de "Me gusta" estilo Facebook.
 *
 * @param modifier Modificador para personalizar el diseño.
 * @param isLiked Indica si la publicación tiene "Me gusta" activado.
 * @param text Texto del botón (por defecto "Me gusta").
 * @param onClick Callback que se ejecuta al presionar el botón.
 */
@Composable
fun LikeButton(
    modifier: Modifier = Modifier,
    isLiked: Boolean = false,
    text: String = "Me gusta",
    onClick: () -> Unit = {},
) {
    val icon: ImageVector = if (isLiked) Icons.Filled.ThumbUp else Icons.Outlined.ThumbUp
    val contentColor: Color = if (isLiked) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.onSurfaceVariant
    }

    Row(
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = contentColor,
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = text,
            color = contentColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LikeButtonPreview() {
    LikeButton()
}

@Preview(showBackground = true)
@Composable
fun LikeButtonLikedPreview() {
    LikeButton(isLiked = true)
}
