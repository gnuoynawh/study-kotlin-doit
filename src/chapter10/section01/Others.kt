package chapter10.section01

import kotlin.random.Random
import kotlin.system.measureTimeMillis


/*
    코틀린 표준 라이브러리(7) - 기타함수

    1. takeIf / takeUnless
        - takeIf()함수는 람다식이 true 이면 결과를 반환
        - takeUnless()함수는 람다식이 false 이면 결과를 반환합니다.
        - 표준 함수의 정의
            public inline fun <T> T.takeIf(predicate: (T) -> Boolean): T?
              = if (predicate(this)) this else null

    2. measureTimeMillis(), measureNanoTime()
        - 시간 측정 함수
        - 표준 함수의 정의
            // measureTimeMillis()
            public inline fun measureTimeMillis(block: () -> Unit): Long {
                val start = System.currentTimeMillis()
                block()
                return System.currentTimeMillis() - start
            }

            // measureNanoTime()
            public inline fun measureNanoTime(block: () -> Unit): Long {
                val start = System.nanoTime()
                block()
                return System.nanoTime() - start
            }

    3. Random
        - 난수 생성
 */

fun main() {

    // 1. takeIf / takeUnless
    val input = "kotlin"
    val keyword = "in"
    input.indexOf(keyword).takeIf { it >= 0 } ?: error("keyword not found")
    input.indexOf(keyword).takeUnless { it < 0 } ?: error("keyword not found")

    // 2. measureTimeMillis
    val executionTime = measureTimeMillis {
        // 측정할 작업 코드
        makeRandom()
    }
    println("Execution time : $executionTime ms")

}

// 3. Random
fun makeRandom() {
    val number = Random.nextInt(1000) // 숫자는 난수 발생 범위
    println(number)
}