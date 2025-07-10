package online_course

class LogAktivitas : MutableList<String> by mutableListOf() {
    val jumlahLog: Int
        get() = this.size

    fun catatAktivitas(pesan: String) {
        this.add("[LOG] $pesan")
    }
}