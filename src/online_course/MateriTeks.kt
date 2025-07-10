package online_course

class MateriTeks(override val judul: String, val isi: String) : MateriPembelajaran {
    override fun baca(): String = "Membaca teks: $isi"
}