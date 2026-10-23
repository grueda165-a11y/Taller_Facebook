package com.gustavorueda.facebook.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack

private val FacebookTextGray = Color(0xFF606770)
private val FacebookDarkText = Color(0xFF1C1E21)
private val FacebookBorderGray = Color(0xFFCCD0D5)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FacebookForgotPasswordScreen(
    onClickBack: () -> Unit,
    onClickSearch: (String) -> Unit
) {
    var emailOrPhone by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Recuperar cuenta",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = FacebookDarkText
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onClickBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver",
                            tint = FacebookDarkText
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        },
        containerColor = Color.White
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Encuentra tu cuenta",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = FacebookDarkText,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Ingresa tu correo electrónico o número de teléfono celular para buscar tu cuenta.",
                fontSize = 14.sp,
                color = FacebookTextGray,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = emailOrPhone,
                onValueChange = { emailOrPhone = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "Correo electrónico o teléfono",
                        color = FacebookTextGray,
                        fontSize = 16.sp
                    )
                },
                singleLine = true,
                shape = RoundedCornerShape(6.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = FacebookBlue,
                    unfocusedBorderColor = FacebookBorderGray,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    cursorColor = FacebookBlue
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { onClickSearch(emailOrPhone) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = FacebookBlue),
                shape = RoundedCornerShape(6.dp),
                enabled = emailOrPhone.isNotBlank()
            ) {
                Text(
                    text = "Buscar cuenta",
                    color = Color.White,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Meta © 2024",
                modifier = Modifier.padding(bottom = 24.dp),
                color = FacebookTextGray,
                fontSize = 12.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}