package chapter09.section05

fun main() {

    /*
        메서드 체이닝
            - filter, map 등을 메서드 체이닝하면 순차적 연산으로 진행
            - asSequence() : 중간연산 상관없이 한번에 연산후 결과를 반환
     */

    // 단순 메서드 체이닝 : 순차적연산
    val list1 = listOf(1, 2, 3, 4, 5)
    val listDefault = list1
            .map { println("map($it) "); it * it } // ①
            .filter { println("filter($it) "); it % 2 == 0 } // ②
    println(listDefault)
    println()


    // asSequence()의 사용
    val listSeq = list1.asSequence()
            .map { print("map($it) "); it * it }  // ①
            .filter { println("filter($it) "); it % 2 == 0 } // ②
            .toList() // ③
    println(listSeq)
}