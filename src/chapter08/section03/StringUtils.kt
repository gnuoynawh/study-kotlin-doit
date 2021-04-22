package chapter08.section03

fun main() {

    val title = "  Welcome to Kotlin Programming!"

    println(title)
    println(title + "\nChapter1")
    println(title[1])
    println(title.toLowerCase())
    println(title.toUpperCase())
    println(title.trim())

    val deli = "Welcome to Kotlin"
    val sp = deli.split(" ")
    println(sp)

}