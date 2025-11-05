package id.antasari.uts_mp_230104040126

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.navArgument // ✅ ini penting, BUKAN dari compose
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import id.antasari.uts_mp_230104040126.data.PrefManager
import id.antasari.uts_mp_230104040126.screens.*
import id.antasari.uts_mp_230104040126.ui.theme.AppTheme
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()
                val prefManager = remember { PrefManager(this) }

                NavHost(
                    navController = navController,
                    startDestination = "form"
                ) {
                    // 🧩 Screen 1: Form Input
                    composable("form") {
                        FormScreen(onNext = { nama, kelas, hobi ->
                            val encodedNama = URLEncoder.encode(nama, "UTF-8")
                            val encodedKelas = URLEncoder.encode(kelas, "UTF-8")
                            val encodedHobi = URLEncoder.encode(hobi, "UTF-8")
                            navController.navigate("summary/$encodedNama/$encodedKelas/$encodedHobi")
                        })
                    }

                    // 🧩 Screen 2: Ringkasan Profil
                    composable(
                        route = "summary/{nama}/{kelas}/{hobi}",
                        arguments = listOf(
                            navArgument("nama") { type = NavType.StringType },
                            navArgument("kelas") { type = NavType.StringType },
                            navArgument("hobi") { type = NavType.StringType }
                        )
                    ) { backStackEntry ->
                        val nama = URLDecoder.decode(
                            backStackEntry.arguments?.getString("nama") ?: "",
                            StandardCharsets.UTF_8.toString()
                        )
                        val kelas = URLDecoder.decode(
                            backStackEntry.arguments?.getString("kelas") ?: "",
                            StandardCharsets.UTF_8.toString()
                        )
                        val hobi = URLDecoder.decode(
                            backStackEntry.arguments?.getString("hobi") ?: "",
                            StandardCharsets.UTF_8.toString()
                        )

                        SummaryScreen(nama, kelas, hobi, prefManager) {
                            navController.navigate("saved")
                        }
                    }

                    // 🧩 Screen 3: Data Tersimpan
                    composable("saved") {
                        SavedScreen(prefManager) {
                            navController.navigate("form") {
                                popUpTo("form") { inclusive = true }
                            }
                        }
                    }
                }
            }
        }
    }
}
