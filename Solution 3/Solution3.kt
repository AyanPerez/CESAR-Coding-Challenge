fun largeBetween(str1: String, str2: String) : String {
    if (str1.length >= str2.length) return str1
    return str2
}

fun smallBetween(str1: String, str2: String) : String {
    if (str1.length < str2.length) return str1
    return str2
}

fun checkTypo(word1: String, word2: String) : Boolean {
    val valid = arrayOf(
        (word1.length == word2.length - 1),
        (word1.length - 1 == word2.length),
        (word1.length == word2.length)
    )
    if (true in valid){
        val large = largeBetween(word2, word1)
        val small = smallBetween(word2, word1)
        var total = 0
        var replace = 0
        for (i in small.indices) {
            total += if (large[i] == small[total]) 1 else 0
            replace += if (large[i] == small[i]) 1 else 0
        }
        return (
            (replace >= large.length - 1) ||
            ((total + 1) == small.length) ||
            ((total - 1) == large.length)
        )
    }
    return false
}

fun main() { 
    
    println(checkTypo("pale", "ple")) // true
    println(checkTypo("pales", "pale")) // true
    println(checkTypo("pale", "bale")) // true
    println(checkTypo("pale", "bake")) // false
    
}