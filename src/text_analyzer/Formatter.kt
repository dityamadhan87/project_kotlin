package text_analyzer

fun formatAnalysisResult(
    analysisType: String,
    value: Any,
    unit: String = "",
    includeTimestamp: Boolean = false
): String{
    val timestamp = if (includeTimestamp) "[${java.time.LocalDateTime.now()}]" else ""
    return "$timestamp $analysisType: $value $unit"
}