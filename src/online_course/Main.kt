package online_course

fun main(){
    val kursus = Kursus.buatKursusPopuler("Pemrograman Kotlin")
    val kursus2 = Kursus.buatKursusPopuler("ssssss")
    println(kursus.getDetailKursus())
    println(kursus2.getDetailKursus())

    // Tambah materi
    val materi1 = MateriTeks("Dasar Kotlin", "Belajar variabel dan fungsi")
    val materi2 = MateriKuis("Uji Pemahaman", 5)

    kursus.materi.add(materi1)
    kursus.materi.add(materi2)

    // Daftarkan siswa
    val siswa = Siswa("Budi", "budi@example.com")
    kursus.daftarSiswa(siswa)

    // Gunakan object expression
    var totalPendaftaran = 0
    val listener = object : ListenerPendaftaran {
        override fun saatSiswaTerdaftar(siswa: Siswa) {
            totalPendaftaran++
            println("Siswa ${siswa.nama} telah mendaftar. Total: $totalPendaftaran")
        }
    }
    listener.saatSiswaTerdaftar(siswa)

    // Panggil inner class
    val notif = kursus.PemberitahuanSiswa("Materi baru telah ditambahkan.")
    println(notif.tampilkan())

    // Coba sealed class dengan when expression
    val jenis: JenisMateri = JenisMateri.Video(90)
    val deskripsi = when (jenis) {
        is JenisMateri.Teks -> "Materi teks dengan ${jenis.jumlahHalaman} halaman."
        is JenisMateri.Video -> "Materi video dengan durasi ${jenis.durasiMenit} menit."
        is JenisMateri.Kuis -> "Kuis dengan ${jenis.jumlahSoal} soal."
    }
    println(deskripsi)

    // Sertifikat dan metode data class
    val sertifikat1 = Sertifikat("Budi", "Kotlin", "2025-07-09")
    val sertifikat2 = sertifikat1.copy(namaKursus = "Kotlin Advanced")
    println(sertifikat1)
    println(sertifikat1 == sertifikat2) // false

    // Delegasi
    val log = LogAktivitas()
    log.catatAktivitas("Siswa mendaftar.")
    log.catatAktivitas("Materi ditambahkan.")
    log.catatAktivitas(pesan = "ssss")
    println("Jumlah log: ${log.jumlahLog}")
    println(log.joinToString("\n"))

    // Otorisasi
    val penggunaAdmin = Pengguna("Admin1", "admin")
    val penggunaBiasa = Pengguna("User1", "user")
    println("Admin bisa edit: ${SistemOtorisasi.cekIzin(penggunaAdmin, "edit")}")
    println("User bisa edit: ${SistemOtorisasi.cekIzin(penggunaBiasa, "edit")}")
}