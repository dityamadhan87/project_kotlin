package text_analyzer

fun List<String>.getShortestAndLongestWords(): Pair<String?, String?> {
    if (this.isEmpty()) return Pair(null, null)

    var shortest: String = this[0]
    var longest: String = this[0]

    for (word in this) {
        if (word.length < shortest.length) shortest = word
        if (word.length > longest.length) longest = word
    }
    return Pair(shortest, longest)
}

fun concatenateWords(vararg words: String, separator: String = " ") : String{
    var result = ""
    for(i in words.indices){
        result += words[i]
        if(i < words.size - 1){
            result += separator
        }
    }
    return result
}

infix fun String.containsAny(substrings: List<String>): Boolean {
    for(sub in substrings){
        if (this.contains(sub)){
            return true
        }
    }
    return false
}

fun parseFileName(fullPath: String): Pair<String, String> {
    val dotIndex = fullPath.lastIndexOf('.')
    return if (dotIndex != -1) {
        val name = fullPath.substring(0, dotIndex)
        val ext = fullPath.substring(dotIndex + 1)
        Pair(name, ext)
    } else {
        Pair(fullPath, "")
    }
}

val String.totalCharacters: Int
    get() = this.replace(" ", "").length

fun String.isPalindrome(): Boolean {
    val cleaned = this.replace(" ", "").lowercase()
    return cleaned == cleaned.reversed()
}

fun performComplexAnalysis(text: String){
    val cleaned = cleanText(text)
    val words = cleaned.split(" ").filter { it.isNotBlank() }

    fun validateWord(word: String): Boolean {
        return word.length > 2 && word.all { it.isLetter() }
    }

    var validWords = 0
    for (word in words) {
        println(validateWord(word))
        if (validateWord(word)) validWords++
    }

    println("Valid Words Count: $validWords")
}