package chapter09.section04

fun main() {

    /*
        요소의 매핑
            - map : 컬렉션에 주어진 식을 적용해 새로운 컬렉션 반환
            - mapIndexed : 컬렉션에 index 포함, 주어진 식을 적용해 새로운 컬렉션 반환
            - mapNotNull : null 을 제외하고 식을 적용해 새로운 컬렉션 반환
            - flatMap : 각 요소에 식을 적용한 후 다시 합쳐서 새로운 컬렉션 반환
            - groupBy : 주어진 함수의 결과에 따라 그룹화하여 map 으로 반환
     */

    val list = listOf(1, 2, 3, 4, 5, 6)
    val listWithNull = listOf(1, null, 3, null, 5, 6)

    // map
    println(list.map { it * 2 })
    val mapIndexed = list.mapIndexed { index, it -> index * it }
    println(mapIndexed)
    println(listWithNull.mapNotNull { it?.times(2) })

    // flatMap
    println(list.flatMap { listOf(it, 'A') })
    val result = listOf("abc", "12").flatMap { it.toList() }
    println(result)

    // groupBy
    val grpMap = list.groupBy { if (it % 2 == 0) "even" else "odd" }
    println(grpMap)
}