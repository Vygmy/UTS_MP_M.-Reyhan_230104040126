package id.antasari.uts_mp_230104040126.data

import android.content.Context
import android.content.SharedPreferences

class PrefManager(context: Context) {
    private val pref: SharedPreferences = context.getSharedPreferences("profile_data", Context.MODE_PRIVATE)

    fun saveProfile(nama: String, kelas: String, hobi: String, darkMode: Boolean) {
        pref.edit()
            .putString("nama", nama)
            .putString("kelas", kelas)
            .putString("hobi", hobi)
            .putBoolean("darkMode", darkMode)
            .apply()
    }

    fun getNama() = pref.getString("nama", "")
    fun getKelas() = pref.getString("kelas", "")
    fun getHobi() = pref.getString("hobi", "")
    fun getDarkMode() = pref.getBoolean("darkMode", false)

    fun hasData() = getNama()?.isNotEmpty() == true
}
