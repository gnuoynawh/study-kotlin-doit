package chapter03.section01

fun main() {

    // 1. 기본함수
    println(sum(3, 2))
    println(sum(6, 7))
}

// 기본함수1
fun sum(a: Int, b: Int): Int {
    return a + b
}

// 기본함수2
//fun sum(a: Int, b: Int): Int = a + b

// 기본함수3
//fun sum(a: Int, b: Int) = a + b
