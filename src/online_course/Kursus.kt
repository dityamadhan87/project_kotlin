package online_course

open class Kursus(
    val judul: String,
    val id: IDKursus
)
{
    private val daftarSiswaInternal = mutableListOf<Siswa>()
    val materi = mutableListOf<MateriPembelajaran>()

    var jumlahRating = 0
        private set
    var totalRating = 0
        private set

    open fun getDetailKursus(): String {
        return "Kursus: $judul"
    }

    var jumlahPendaftar: Int = 0
        private set

    fun daftarSiswa(siswa: Siswa) {
        daftarSiswaInternal.add(siswa)
        jumlahPendaftar++
    }

    inner class PemberitahuanSiswa(val pesan: String){
        fun tampilkan() = "Notifikasi untuk kursus '${this@Kursus.judul}': $pesan"
    }

    companion object Factory : KursusFactory {
        override fun buatKursusPopuler(judul: String): Kursus {
            val kursus = Kursus(judul, IDKursus("pop-${judul.hashCode()}"))
            kursus.totalRating = 500
            kursus.jumlahRating = 100
            return kursus
        }
    }
}

interface KursusFactory {
    fun buatKursusPopuler(judul: String): Kursus
}