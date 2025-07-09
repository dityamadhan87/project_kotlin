package hotel_reservation

fun tentukanHargaDasar(tipe: TipeKamar) : Double = when(tipe){
    TipeKamar.STANDAR -> 500.0
    TipeKamar.DELUXE -> 800.0
    TipeKamar.SUITE -> 1200.0
}