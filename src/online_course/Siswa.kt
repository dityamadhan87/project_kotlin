package online_course

open class Siswa(val nama: String, emailInput: String){
    val email: String
    init {
        require(emailInput.contains("@")) { "Email tidak valid." }
        email = emailInput.lowercase()
    }
}