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
fun SavedScreen(prefManager: PrefManager, onBack: () -> Unit) {

    val hasData = prefManager.hasData()

    // 🎨 Warna tema abu-abu elegan + dark mode
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
                        text = "Data Tersimpan",
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
            Modifier
                .padding(padding)
                .padding(20.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (hasData) {
                Card(
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    colors = CardDefaults.cardColors(containerColor = cardColor),
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text(
                            "Nama: ${prefManager.getNama()}",
                            style = TextStyle(
                                color = textColor,
                                fontFamily = FontFamily.SansSerif,
                                fontSize = 16.sp
                            )
                        )
                        Text(
                            "Kelas: ${prefManager.getKelas()}",
                            style = TextStyle(
                                color = textColor,
                                fontFamily = FontFamily.SansSerif,
                                fontSize = 16.sp
                            )
                        )
                        Text(
                            "Hobi: ${prefManager.getHobi()}",
                            style = TextStyle(
                                color = textColor,
                                fontFamily = FontFamily.SansSerif,
                                fontSize = 16.sp
                            )
                        )
                        Text(
                            "Mode Gelap: ${if (prefManager.getDarkMode()) "Ya" else "Tidak"}",
                            style = TextStyle(
                                color = textColor,
                                fontFamily = FontFamily.SansSerif,
                                fontSize = 16.sp
                            )
                        )
                    }
                }
            } else {
                Text(
                    "Belum ada data, silakan isi profil dulu",
                    color = textColor,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 16.sp
                )
            }

            Spacer(Modifier.height(16.dp))

            Button(
                onClick = { onBack() },
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
                    "Kembali ke Form",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}
