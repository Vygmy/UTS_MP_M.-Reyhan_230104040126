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
import id.antasari.uts_mp_230104040126.data.PrefManager

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SummaryScreen(
    nama: String,
    kelas: String,
    hobi: String,
    prefManager: PrefManager,
    onSave: () -> Unit
) {
    var darkMode by remember { mutableStateOf(false) }

    // 🎨 Warna tema modern abu-abu dark
    val backgroundColor = Color(0xFF121212)
    val cardColor = Color(0xFF1E1E1E)
    val textColor = Color(0xFFE0E0E0)
    val accentColor = Color(0xFF03DAC6)

    Scaffold(
        containerColor = backgroundColor,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Ringkasan Profil",
                        color = textColor,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp
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
                    Text(
                        text = "Nama: $nama",
                        style = TextStyle(
                            color = textColor,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 16.sp
                        )
                    )
                    Text(
                        text = "Kelas: $kelas",
                        style = TextStyle(
                            color = textColor,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 16.sp
                        )
                    )
                    Text(
                        text = "Hobi: $hobi",
                        style = TextStyle(
                            color = textColor,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 16.sp
                        )
                    )

                    Spacer(Modifier.height(12.dp))

                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Aktifkan Mode Gelap",
                            style = TextStyle(
                                color = textColor,
                                fontFamily = FontFamily.SansSerif,
                                fontSize = 16.sp
                            )
                        )
                        Switch(
                            checked = darkMode,
                            onCheckedChange = { darkMode = it },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = accentColor,
                                uncheckedThumbColor = Color.Gray
                            )
                        )
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            Button(
                onClick = {
                    prefManager.saveProfile(nama, kelas, hobi, darkMode)
                    onSave()
                },
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
                    "Simpan ke Perangkat",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}
