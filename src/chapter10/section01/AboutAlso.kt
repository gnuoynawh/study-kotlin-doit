package chapter10.section01

/*
    코틀린 표준 라이브러리(2) - also()

        - 함수를 호출하는 객체 T를 이어지는 block에 전달하고 객체 T 자체를 반환합니다.
        - let 과 유사하지만 반환값이 다름
        - let은 마지막 수행된 코드 블록의 결과를 반환하고
          also는 블록 안의 코드 수행 결과와 상관없이 T인 바로 객체 this를 반환
        - 표준 함수의 정의
            public inline fun <T> T.also(block: (T) -> Unit): T { block(this); return this }
 */

fun main() {
    var m = 1

    // also 함수는 블록안의 결과가 어쨌든 간에 원본 값을 반환한다.
    m = m.also { it + 3 }
    println(m) // 원본 값 1
}