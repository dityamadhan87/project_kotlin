package hotel_reservation

class Pemesanan(
    val idBlooking: String,
    val kamarDipesan: Kamar,
    val namaTamu: String,
    val jumlahMalam: Int
){

    val totalHarga: Double
        get() {
            return kamarDipesan.hargaPerMalam * jumlahMalam
        }
}