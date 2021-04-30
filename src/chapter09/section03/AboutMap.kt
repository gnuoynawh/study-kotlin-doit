package chapter09.section03

import java.util.*

fun main() {

    /*
        Map 불변형 : mapOf
     */

    // 생성
    val langMap: Map<Int, String> = mapOf(11 to "Java", 22 to "Kotlin", 33 to "C++")
    for ((key, value) in langMap) { // 키와 값의 쌍을 출력
        println("key=$key, value=$value")
    }

    println("langMap[22] = ${langMap[22]}") // 키 22에 대한 요소 출력
    println("langMap.get(22) = ${langMap.get(22)}") // 위와 동일한 표현
    println("langMap.keys = ${langMap.keys}") // 맵의 모든 키 출력

    /*
        Map 가변형 : mutableMapOf
     */

    // 생성
    val capitalCityMap: MutableMap<String, String> // 선언 시 키와 값의 자료형을 명시할 수 있음
            = mutableMapOf("Korea" to "Seoul", "China" to "Beijing", "Japan" to "Tokyo")
    println(capitalCityMap.values)
    println(capitalCityMap.keys)

    // 추가, 제거
    capitalCityMap.put("UK", "London")
    capitalCityMap.remove("China")
    println(capitalCityMap)

    // putAll()을 사용한 맵의 추가
    val addData = mutableMapOf("USA" to "Washington")
    capitalCityMap.putAll(addData)
    println(capitalCityMap)


    /*
        hashMapOf
     */
    val hashMap: HashMap<Int, String> = hashMapOf(1 to "Hello", 2 to "World")
    println("hashMap = $hashMap")


    /*
        sortedMapOf
     */
    val sortedMap: SortedMap<Int, String> = sortedMapOf(1 to "Apple", 2 to "Banana")
    println("sortedMap = $sortedMap")


    /*
        linkedMapOf
     */
    val linkedHash: LinkedHashMap<Int, String> = linkedMapOf(1 to "Computer", 2 to "Mouse")
    println("linkedHash = $linkedHash")
}