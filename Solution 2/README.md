# 2. Check words with jumbled letters :
Our brain can read texts even if letters are jumbled, like the following sentence:  “Yuo
cna porbalby raed tihs esaliy desptie teh msispeillgns.” Given two strings, write a
method to decide if one is a partial­permutation of the other. Consider a
partial­permutation only if:
­ The first letter hasn’t changed place
­ If word has more than 3 letters, up to 2/3 of the letters have changed place

Examples:
```
you, yuo ­> true
probably, porbalby ­> true
despite, desptie ­> true
moon, nmoo ­> false
misspellings, mpeissngslli ­> false
```

## Solution
``` kotlin
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
```

## Output
```
true
true
true
false
false
```

## Run Online
```
https://pl.kotl.in/ZnZ30xFzC
```

## Explanation
The proposed algorithm verifies all N items of array to check how many letters has not been changed of position. Then, as the worse case is checked all items, the complexity is O(n).
