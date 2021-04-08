package chapter03.section05

fun main() {
    // 일반적인 표현
    val multi1 = 3.multiply(10)
    println("multi 1 : $multi1")

    // 중위 표현법
    val multi2 = 3 multiply 10
    println("multi 2 : $multi2")
}

// 중위함수
infix fun Int.multiply(x: Int): Int {
    return this * x
}