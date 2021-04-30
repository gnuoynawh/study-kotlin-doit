package chapter09.section05

fun main() {

    /*
        시퀀스
            - 순차적인 컬렉션
            - 요소의 크기를 특정하지 않음
            - 처리 중 계산이 아니고, toList(), count() 에서 연된다.산

        generateSequence() : 특정값을 생성, Seed 인수에 의해 시작요소의 값이 결정

     */

    // 1. 시드와 식에 의해 정의
    val nums: Sequence<Int> = generateSequence(1) { it + 1 }

    // take()를 사용해 원하는 요소 개수만큼 획득하고
    // toList()를 사용해 List 컬렉션으로 반환
    println(nums.take(10).toList())


    // 2.
    val squares = generateSequence(1) {it + 1}.map {it * it}
    println(squares.take(10).toList())


    // 3.
    val oddSquares = squares.filter {it % 2 != 0}
    println(oddSquares.take(5).toList())

}