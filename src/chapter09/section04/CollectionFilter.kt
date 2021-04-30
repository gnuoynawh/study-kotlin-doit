package chapter09.section04

fun main() {

    /*
        요소의 필터와 추출
            - filter : 식에 따른 특정요소 골라내기
                - filterNot : 식 이외에 요소
                - filterNotNull : 식 이외에 요소 + null 제외
                - filterIndexed : 인덱스와 함께 추출
                - filterIndexedTo : 추출 후 가변형 컬렉션으로 변환
                - filterKeys : / filterValues : Map 의 키, 값에 따라 추출
                - filterIsInstance : 여러 자료형의 요소 중 원하는 자료형을 골라냄
            - slice : 특정 인덱스의 요소들을 잘라서 반환
            - take : 관련 연산을 사용하면 n 개의 요소를 가진 list 를 반환
            - drop : 처음부터 n 개의 요소를 제외하고 반환
                - dropWhile : 람다식에 따른 요소를 제외하고 반환
                - dropLastWhile : 람다식에 따른 요소를 제외하고 반환
            - componentN : N 에 인덱스가 아니라 1부터 시작하는 요소의 순서 번호
            - distinct : 합집합, 중복요소는 하나로 취급해서 반환
            - intersect : 교집합, 교집합 요소만 골라냄

    */

    val list = listOf(1, 2, 3, 4, 5, 6)
    val listMixed = listOf(1, "Hello", 3, "World", 5, 'A')
    val listWithNull = listOf(1, null, 3, null, 5, 6)
    val listRepeated = listOf(2, 2, 3, 4, 5, 5, 6)
    val map = mapOf(11 to "Java", 22 to "Kotlin", 33 to "C++")


    // filter
    println(list.filter { it % 2 == 0 })
    println(list.filterNot { it % 2 == 0 })
    println(listWithNull.filterNotNull())
    println("filterIndexed: " + list.filterIndexed { idx, value -> idx != 1 && value % 2 == 0 })
    val mutList = list.filterIndexedTo(mutableListOf()) { idx, value -> idx != 1 && value % 2 == 0 }
    println("filterIndexedTo: $mutList")

    println("filterKeys: " + map.filterKeys { it != 11 })
    println("filterValues: " + map.filterValues { it == "Java" })

    println("filterIsInstance: " + listMixed.filterIsInstance<String>())


    // slice
    println("slice: " + list.slice(listOf(0, 1, 2)))


    // take
    println("take: " + list.take(2))
    println("takeLast: " + list.takeLast(2))
    println("takeWhile: " + list.takeWhile { it < 3 })


    // drop
    println("drop: " + list.drop(3))
    println("dropWhile: " + list.dropWhile { it < 3 })
    println("dropLastWhile: " + list.dropLastWhile { it > 3 })


    // componentN
    println("component1(): " + list.component1())


    // distinct
    println("distinct: " + listRepeated.distinct())


    // intersect
    println("intersect: " + list.intersect(listOf(5, 6, 7, 8)))
}