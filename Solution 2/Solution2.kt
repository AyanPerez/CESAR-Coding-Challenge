fun permuted(word1: String, word2: String) : Boolean {
    val errors = arrayOf(
        (word1[0] != word2[0]),
        (word1.length != word2.length)
    )
    if (true in errors) return false
    var total = 0
    for (i in word1.indices) {
        total += if (word1[i] == word2[i]) 1 else 0
    }
    return (total >= (word1.length / 3))
}

fun main() {
    
    println(permuted("you", "yuo")) // true
    println(permuted("probably", "porbalby")) // true
    println(permuted("despite", "desptie"))  // true
    println(permuted("moon", "nmoo")) // false
    println(permuted("misspellings", "mpeissngslli")) // false
    
}