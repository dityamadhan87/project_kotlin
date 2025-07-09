package hotel_reservation

fun tampilkanDaftarKamar(daftarKamar: List<Kamar>){
    println("=== Daftar .hotel_reservation.Kamar Tersedia ===")
    for (kamar in daftarKamar){
        println(".hotel_reservation.Kamar ${kamar.nomorKamar} ${kamar.tipeKamar}: Rp${kamar.hargaPerMalam}/malam")
    }
}

fun cetakDetailApapun(objek: Any){
    when(objek){
        is Pemesanan -> println("Detail .hotel_reservation.Pemesanan: ID = ${objek.idBlooking}, nama tamu = ${objek.namaTamu} ,.hotel_reservation.Kamar dipesan = ${objek.kamarDipesan}, Total = Rp${objek.totalHarga}")
        else -> println("Objek tidak dikenal")
    }
}