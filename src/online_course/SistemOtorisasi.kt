package online_course

object SistemOtorisasi {
    fun cekIzin(pengguna: Pengguna, aksi: String): Boolean {
        return pengguna.role == "admin" || aksi == "baca"
    }
}