package chapter09.section04

fun main() {

    /*
        요소의 처리와 집계
            - 반복, 순환 : forEach, forEachIndexed, onEach
            - 개수 : count
            - 최대, 최소 : max, min, maxBy, minBy (it에 대한 식의 결과)
            - ford : 초깃값과 정해진 식에 따라 처음요소부터 끝 요소에 적용해서 값을 반환
            - foldRight : fold와 같고 마지막 요소에서 처음요소로 반대로 적용
            - reduce : ford 와 동일하지만 초깃값이 없음
            - sumBy : 식에 대한 전체합
     */

    val list = listOf(1, 2, 3, 4, 5, 6)
    val listPair = listOf(Pair("A", 300), Pair("B", 200), Pair("C", 100))
    val listMixed = listOf(1, "Hello", 3, "World", 5, 'A')
    val listWithNull = listOf(1, null, 3, null, 5, 6)
    val listRepeated = listOf(2, 2, 3, 4, 5, 5, 6)
    val map = mapOf(11 to "Java", 22 to "Kotlin", 33 to "C++")

    // forEach
    list.forEach { print("$it ") }
    println()
    list.forEachIndexed { index, value -> println("index[$index]: $value") }

    // onEach
    val returnedMap = map.onEach { println("key: ${it.key}, value: ${it.value}") }
    println("returnedMap = $returnedMap")


    // count
    println(list.count { it % 2 == 0 }) // 3


    // max / min
    println(list.max()) // 6
    println(list.min()) // 1
    println("maxBy: " + map.maxBy { it.key }) // 키를 기준으로 최댓값
    println("minBy: " + map.minBy { it.key }) // 키를 기준으로 최솟값


    // fold
    println(list.fold(4) { total, next -> total + next }) // 4+ 1 + ... 6 = 25
    println(list.fold(1) { total, next -> total * next }) // 1 * 1 * 2 *... 6 = 720
    println(list.foldRight(4) { total, next -> total + next })
    println(list.foldRight(1) { total, next -> total * next })


    // reduce
    println(list.reduce { total, next -> total + next })
    println(list.reduceRight { total, next -> total + next })


    // sumBy
    println(listPair.sumBy { it.second })
}