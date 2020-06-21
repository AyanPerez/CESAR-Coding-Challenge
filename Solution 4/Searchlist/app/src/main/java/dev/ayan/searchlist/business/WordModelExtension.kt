package dev.ayan.searchlist.business

fun String.isValid(word : String) : Boolean {
    return (this.permuted(word) || this.checkTypo(word))
}

fun String.permuted(word: String) : Boolean {
    val errors = arrayOf(
        (word[0] != this[0]),
        (word.length != this.length)
    )
    if (true in errors) return false
    var total = 0
    for (i in word.indices) {
        total += if (word[i] == this[i]) 1 else 0
    }
    return (total >= (word.length / 3))
}

fun String.checkTypo(word: String) : Boolean {
    val valid = arrayOf(
        (word.length == this.length - 1),
        (word.length - 1 == this.length),
        (word.length == this.length)
    )
    if (true in valid){
        val large = largeBetween(this, word)
        val small = smallBetween(this, word)
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

fun largeBetween(str1: String, str2: String) : String {
    if (str1.length >= str2.length) return str1
    return str2
}

fun smallBetween(str1: String, str2: String) : String {
    if (str1.length < str2.length) return str1
    return str2
}