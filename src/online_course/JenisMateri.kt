package online_course

sealed class JenisMateri {
    data class Teks(val jumlahHalaman: Int) : JenisMateri()
    data class Video(val durasiMenit: Int) : JenisMateri()
    data class Kuis(val jumlahSoal: Int) : JenisMateri()
}