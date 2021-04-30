package chapter09.section04

fun main() {

    val list1: List<String> = listOf("one", "two", "three")
    val list2: List<Int> = listOf(1, 3, 4)
    val map1 = mapOf("hi" to 1, "hello" to 2, "Goodbye" to 3)

    // + 연산자를 사용한 문자열 요소 추가
    println(list1 + "four")

    // + 연산자를 사용한 정수형 요소 추가
    println(list2 + 1)

    // 두 List의 병합
    println(list2 + listOf(5, 6, 7))

    // 요소의 제거
    println(list2 - 1)

    // 일치하는 요소의 제거
    println(list2 - listOf(3, 4, 5))

    // Pair()를 사용한 map의 추가
    println(map1 + Pair("Bye", 4))

    // 일치하는 값의 제거
    println(map1 - "hello")

    // map의 병합
    println(map1 + mapOf("Apple" to 4, "Orange" to 5))

    // List에 일치하는 값을 map에서 제거
    println(map1 - listOf("hi", "hello"))
}