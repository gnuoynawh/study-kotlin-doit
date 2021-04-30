package chapter09.section04

fun main() {

    /*
        - 요소의 처리와 검색
            - elementAt : 인덱스에 해당하는 요소 반환
                - elementAtOrElse : 인덱스를 벗어나면 식에 따라 반환
                - elementAtOrNull : 인덱스를 벗어나는 경우 null 반환

           - first / firstOrNull : 식에 일치하는 첫 요소 반환, 식과 일치하지 않는 경우 nul
            - last / lastOrNull : 식에 일치하는 마지막 요소 반환, 식과 일치하지 않는 경우 nul

            - indexOf : 주어진 요소에 일치하는 첫 인덱스 반환
                - lastIndexOf : 주어진 요소에 일치하는 마지막 인덱스 반환
                - indexOfFirst : 식에 일치하는 첫 인덱스 반환, 없으면 -1
                - indexOfLast : 식에 일치하는 마지막 요소의 반환, 없으면 -1

            - single / singleOrNull : 람다식에 일치하는 요소 하나 반환, 없으면 null
            - binarySearch : 요소에 대해 이진 탐색 후 인덱스 반환
            - find : 조건식을 만족하는 첫번째 검색요소 반환, 없으면 null
     */


    val list = listOf(1, 2, 3, 4, 5, 6)
    val listPair = listOf(Pair("A", 300), Pair("B", 200), Pair("C", 100), Pair("D", 200))
    val listRepeated = listOf(2, 2, 3, 4, 5, 5, 6)

    // elementAt
    println("elementAt: " + list.elementAt(1))
    println("elementAtOrElse: " + list.elementAtOrElse(10, { 2 * it }))
    println("elementAtOrNull: " + list.elementAtOrNull(10))

    // first / last
    println("first: " + listPair.first { it.second == 200 })
    println("last: " + listPair.last { it.second == 200 })
    println("firstOrNull: " + listPair.firstOrNull { it.first == "E" })
    println("lastOrNull: " + listPair.lastOrNull { it.first == "E" })

    // indexOf
    println("indexOf:" + list.indexOf(4))
    println("indexOfFirst:" + list.indexOfFirst { it % 2 == 0 })
    println("lastIndexOf:" + listRepeated.lastIndexOf(5))
    println("indexOfLast:" + list.indexOfLast { it % 2 == 0 })

    // single
    println("single: " + listPair.single { it.second == 100 })
    println("singleOrNull: " + listPair.singleOrNull { it.second == 500 })

    // binarySearch
    println("binarySearch: " + list.binarySearch(3))

    // find
    println("find: " + list.find { it > 3 })
}