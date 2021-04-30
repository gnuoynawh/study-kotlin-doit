package chapter10.section01

/*
    코틀린 표준 라이브러리(1) - let()

        - 함수를 호출하는 객체 T를 이어지는 block의 인자로 넘기고 block의 결과값 R을 반환
        - 표준 함수의 정의
            public inline fun <T, R> T.let(block: (T) -> R): R { ... return block(this) }
 */

val score: Int? = 32

fun main() {
    checkScoreLet()
}

// let을 사용해 null 검사를 제거
fun checkScoreLet() {

    // 변수 score 에 + 10 을 한 뒤에 print
    score?.let {
        var test = it + 10
        println("Score: $test")
    }

    // 변수 score 값을 string 으로 변환 후 print
    val str = score.let { it.toString() }
    println(str)
}
