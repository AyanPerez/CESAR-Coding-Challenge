fun replaceAllSpaces(str: String, until : Int) =
    str.take(until).map {
        if (it == ' ') "&32" else it
    }.joinToString("")
   
fun main(){
    println(replaceAllSpaces("User is not allowed  ",19)) // User&32is&32not&32allowed
}