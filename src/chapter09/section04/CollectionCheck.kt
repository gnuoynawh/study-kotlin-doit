package chapter09.section04

fun main() {

    /*
        요소의 검사
            - all : 람다식에서 모든 요소가 일치하면 true
            - any : 하나 혹은 그 이상이 일치하면 true
            - contains : 요소가 포함되어 있으면 true
            - containsAll : 모든 요소가 포함되어 있으면 true
            - none : 요소가 없으면 ture
            - isEmpty / isNonEmpty : 컬렉션이 비어있는지, 아닌지
     */

    val list = listOf(1, 2, 3, 4, 5, 6)
    val listPair = listOf(Pair("A", 300), Pair("B", 200), Pair("C", 100))
    val map = mapOf(11 to "Java", 22 to "Kotlin", 33 to "C++")

    // all
    println(list.all { it < 10 })  // true
    println(list.all { it % 2 == 0 }) // false


    // any
    println(list.any { it % 2 == 0 }) // true
    println(list.any { it > 10 }) // false


    // contains
    println("contains: " + list.contains(2))  // true
    println(2 in list)  // true
    println(map.contains(11)) // true
    println(11 in map) // true
    println("containsAll: " + list.containsAll(listOf(1, 2, 3)))


    // none
    println("none: " + list.none()) // false
    println("none: " + list.none { it > 6}) // true - 6 이상은 없으므로


    // isEmpty/isNotEmpty: 컬렉션이 비어있는지 검사
    println(list.isEmpty()) // false
    println(list.isNotEmpty()) // true

}