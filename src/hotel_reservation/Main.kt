package hotel_reservation

fun main() {
    println("Selamat Datang di Sistem .hotel_reservation.Pemesanan Hotel Kotlin")

    val daftarKamar = listOf(
        Kamar("101", TipeKamar.STANDAR, tentukanHargaDasar(TipeKamar.STANDAR)),
        Kamar("102", TipeKamar.DELUXE, tentukanHargaDasar(TipeKamar.DELUXE)),
        Kamar("103", TipeKamar.SUITE, tentukanHargaDasar(TipeKamar.SUITE))
    )

    val daftarPemesanan = mutableListOf<Pemesanan>();

    while (true){
        println("\n=== Menu Utama ===")
        println("1. Lihat .hotel_reservation.Kamar")
        println("2. Buat .hotel_reservation.Pemesanan")
        println("3. Keluar")
        print("Pilih menu (1-3): ")

        val input = readLine()

        when(input){
            "1" -> tampilkanDaftarKamar(daftarKamar)
            "2" -> {
                tampilkanDaftarKamar(daftarKamar)
                println("Masukkan nomor kamar")
                val nomorKamar = readLine()
                val kamar = daftarKamar.find { it.nomorKamar == nomorKamar }

                println("Masukkan nama anda")
                val namaTamu = readln()

                val jumlahMalam = try {
                    print("Masukkan jumlah malam: ")
                    readln().toInt()
                } catch (e: NumberFormatException){
                    println("Input harus angka")
                    continue
                }

                val pemesanan = Pemesanan(
                    idBlooking = "Book-${System.currentTimeMillis()}",
                    kamarDipesan = kamar!!,
                    namaTamu = namaTamu,
                    jumlahMalam = jumlahMalam
                )
                daftarPemesanan.add(pemesanan)
                println("pemesanan berhasil")
                cetakDetailApapun(pemesanan)
                daftarPemesanan.forEach { println(it.namaTamu) }
            }
            "3" -> {
                println("thanks")
                break
            }
        }
    }
}