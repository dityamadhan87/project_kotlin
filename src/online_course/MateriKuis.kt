package online_course

class MateriKuis(private val judulKuis: String, val jumlahSoal: Int) : MateriPembelajaran {
    override val judul: String
        get() = "$judulKuis - Kuis"

    override fun baca(): String = "Mengerjakan kuis dengan $jumlahSoal soal"
}