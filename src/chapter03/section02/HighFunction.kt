package chapter03.section02

fun main() {
    println(highFunc({ x, y -> x + y }, 5, 10))
}

// 고차함수
fun highFunc(sum: (Int, Int) -> Int, a: Int, b: Int): Int = sum(a,b)
