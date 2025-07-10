package text_analyzer

import kotlin.String

fun cleanText(text: String): String{
    val regex = Regex("[^\\w\\s]")
    return regex.replace(text, "").lowercase()
}

fun isValidEmail(email: String): Boolean {
    val pattern = Regex("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")
    return pattern.matches(email)
}

fun main(){
    val REPORT_HEADER: String = "--- Analisis Text ---"
    println(REPORT_HEADER)

    println("Masukkan teks yang ingin di analisis (akhiri dengan baris kosong)")
    val inputText = readLine() ?: ""
    val cleanedText = cleanText(inputText)
//    println(cleanedText)
    val words: List<String> = cleanedText
        .split(" ")
        .filter { it.isNotBlank() }
    val uniqueWords: Set<String> = words.toSet()

    println(formatAnalysisResult(
        analysisType = "Jumlah Kata",
        value = words.size,
        includeTimestamp = true
    ))

    println(formatAnalysisResult(
        analysisType = "Jumlah Kata Unik",
        value = uniqueWords.size
    ))

    val(shortest,longest) = words.getShortestAndLongestWords()
    println("Kata Terpendek: $shortest")
    println("Kata Terpanjang: $longest")
    println(concatenateWords("raditya","rahmadhani","ssssss","lalalalaa"))

    val sentence = "Saya suka Kotlin dan Java"
    val keywords = listOf("Kotlin","Python")
    println("Mengandung kata penting? ${sentence containsAny keywords}")

    val (filename, ext) = parseFileName("laporan_akhir_2025.pdf")
    println("Nama file: $filename, Ekstensi: $ext")

    println("Jumlah karakter (tanpa spasi): ${inputText.totalCharacters}")
    println("Apakah input adalah palindrom? ${inputText.isPalindrome()}")

    println(performComplexAnalysis("Rad%^&555itya Rahmadhani arek guanteng"))
    println(isValidEmail("edo@gmai.com"))
}