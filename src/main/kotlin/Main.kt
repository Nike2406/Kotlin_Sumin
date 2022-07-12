fun main() {
    val data = mapOf(
        "january" to listOf(100, 100, 100, 100),
        "february" to listOf(200, 200, -190, 200),
        "march" to listOf(300, 180, 300, 100),
        "april" to listOf(250, -250, 100, 300),
        "may" to listOf(200, 100, 400, 300),
        "june" to listOf(200, 100, 300, 300),
    )
    getInfo(data)
}

fun getInfo(data: Map<String, List<Int>>) {
    val correctMonths = getCorrectMonths(data)

    val averagePerWeek = correctMonths.flatMap { it.value }.average()
    println("Average per week: $averagePerWeek")

    val averagePerMonth = correctMonths.map {
        it.value.reduce { sum, element -> sum + element }
    }.average()
    println("Average per month: $averagePerMonth")

    val maxRevenue = correctMonths.maxOf { it.value.reduce { acc, i -> acc + i } }
    println("Max month revenue: $maxRevenue")

    val listOfSum = correctMonths.map { it.value.sum() }
    val max = listOfSum.maxOf { it }
    val maxMonth = correctMonths.filter { it.value.sum() == max }.keys.toString().trim('[', ']')
    println("Max month: $maxMonth")

    val min = listOfSum.minOf { it }
    println("Min month revenue: $min")
    val minMonth = correctMonths.filter { it.value.sum() == min }.keys.toString().trim('[', ']')
    println("Min month: $minMonth")

    val errorMonths = data.filter { entry -> entry.value.any {it < 0 } }
        .keys.toString().trim('[', ']')
    println("Error months: $errorMonths")
}

fun getCorrectMonths(data: Map<String, List<Int>>): Map<String, List<Int>> =
    data.filter { entry -> entry.value.all { it >= 0 } }


