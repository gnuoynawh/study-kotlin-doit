package chapter09.section02

fun main() {

    val fruits = listOf("apple", "banana", "kiwi")

    // 요소로 반복
    for (item in fruits) {
        println(item)
    }

    // 인덱스로 반복
    for (index in fruits.indices) {
        println("fruits[$index] = ${fruits[index]}")
    }

    // 사이즈로 while 반복
    var index = 0
    while (index < fruits.size) {
        println("fruits[$index] = ${fruits[index]}")
        index++
    }

}