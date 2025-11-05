package id.antasari.uts_mp_230104040126.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen(onNext: (String, String, String) -> Unit) {
    var nama by remember { mutableStateOf("") }
    var kelas by remember { mutableStateOf("") }
    var hobi by remember { mutableStateOf("") }

    // 🎨 Warna tema (dark modern elegan)
    val backgroundColor = Color(0xFF121212)
    val cardColor = Color(0xFF1E1E1E)
    val textColor = Color(0xFFE0E0E0)
    val accentColor = Color(0xFF03DAC6)

    // 🅿️ Font bawaan modern (tanpa .ttf)
    val modernFont = FontFamily.SansSerif

    Scaffold(
        containerColor = backgroundColor,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Form Profil",
                        fontFamily = modernFont,
                        fontSize = 20.sp,
                        color = textColor,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = cardColor
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(20.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                colors = CardDefaults.cardColors(containerColor = cardColor),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
            ) {
                Column(Modifier.padding(16.dp)) {

                    OutlinedTextField(
                        value = nama,
                        onValueChange = { nama = it },
                        label = { Text("Nama Lengkap", color = textColor) },
                        textStyle = TextStyle(
                            fontFamily = modernFont,
                            color = textColor
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = accentColor,
                            unfocusedIndicatorColor = Color.Gray,
                            focusedLabelColor = accentColor,
                            cursorColor = accentColor,
                            focusedContainerColor = cardColor,
                            unfocusedContainerColor = cardColor,
                            focusedTextColor = textColor,
                            unfocusedTextColor = textColor
                        )
                    )

                    Spacer(Modifier.height(12.dp))

                    OutlinedTextField(
                        value = kelas,
                        onValueChange = { kelas = it },
                        label = { Text("Kelas", color = textColor) },
                        textStyle = TextStyle(
                            fontFamily = modernFont,
                            color = textColor
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = accentColor,
                            unfocusedIndicatorColor = Color.Gray,
                            focusedLabelColor = accentColor,
                            cursorColor = accentColor,
                            focusedContainerColor = cardColor,
                            unfocusedContainerColor = cardColor,
                            focusedTextColor = textColor,
                            unfocusedTextColor = textColor
                        )
                    )

                    Spacer(Modifier.height(12.dp))

                    OutlinedTextField(
                        value = hobi,
                        onValueChange = { hobi = it },
                        label = { Text("Hobi", color = textColor) },
                        textStyle = TextStyle(
                            fontFamily = modernFont,
                            color = textColor
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = accentColor,
                            unfocusedIndicatorColor = Color.Gray,
                            focusedLabelColor = accentColor,
                            cursorColor = accentColor,
                            focusedContainerColor = cardColor,
                            unfocusedContainerColor = cardColor,
                            focusedTextColor = textColor,
                            unfocusedTextColor = textColor
                        )
                    )
                }
            }

            Button(
                onClick = { onNext(nama, kelas, hobi) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = accentColor,
                    contentColor = Color.Black
                ),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    "Simpan & Lanjut",
                    fontFamily = modernFont,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}
