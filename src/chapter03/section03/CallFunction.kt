package chapter03.section03

fun main() {
    // 1. 인자와 반환값이 있는 함수
    val res1 = funcParam(3, 2, ::funcSum)
    println(res1)

    // 2. 인자가 없는 함수
    hello(::funcText)   // 반환값이 없음

    // 3. 일반 변수에 값처럼 할당
    val likeLamda = ::funcSum
    println(likeLamda(6,6))
}

fun funcSum(a: Int, b: Int) = a + b

fun funcText(a: String, b: String) = "Hi! $a $b"

fun funcParam(a: Int, b: Int, c: (Int, Int) -> Int): Int {
    return c(a,b)
}

fun hello(body: (String, String) -> String): Unit {
    println(body("Hello", "World"))
}