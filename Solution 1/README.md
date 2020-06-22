
# 1. Replacing characters in place:
Given an array of characters, write a method to replace all the spaces with “&32”.
You may assume that the array has sufficient slots at the end to hold the additional
characters, and that you are given the “true” length of the array. (Please perform this
operation in place with no other auxiliary structure).

Example:
```
Input: “User is not allowed      “, 19
Output: “User&32is&32not&32allowed”
```

## Solution
``` kotlin
fun replaceAllSpaces(str: String, until : Int) =
    str.take(until).map {
        if (it == ' ') "&32" else it
    }.joinToString("")
   
fun main(){
    println(replaceAllSpaces("User is not allowed  ",19)) // User&32is&32not&32allowed
}
```

## Output
```
User&32is&32not&32allowed
```

## Run Online
```
https://pl.kotl.in/cnOJwg2ej
```

## Explanation
The proposed solution has a algorithm that checks all N items of array to compare if the item is space or not, the complexity is O (n) where N is the length given.