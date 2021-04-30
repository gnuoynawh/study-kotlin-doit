package chapter09.section04

fun main() {

    /*
        순서와 정렬
            - reversed : 뒤집힌 순서로 반환
            - sorted / sortedDescending : 요소를 정렬한 후 반환, desc 는 내림차순
            - sortedBy / sortedByDescending: 비교식에 의해 정렬해서 반환, desc 는 내림차순
     */

    // 뒤집기
    val unsortedList = listOf(3, 2, 7, 5)
    println(unsortedList.reversed())

    // 정렬
    println(unsortedList.sorted())
    println(unsortedList.sortedDescending())

    // 식에 따른 정렬
    println(unsortedList.sortedBy { it % 3 })
    println(unsortedList.sortedByDescending { it % 3 })
}