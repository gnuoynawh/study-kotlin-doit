package chapter03.section05

import java.math.BigInteger

fun main() {

    // 1. 팩토리얼
    val num1 = 4
    val result: Long
    result = factorial(num1)
    println("factorial : $num1 -> $result")

    // 2. 팩토리얼 꼬리재귀
    val num2 = 5
    println("tail factorial : $num2 -> ${tailFactorial(num2)}")

    // 3. 피보나치
    val n1 = 100
    val first1: Long = 0
    val second1: Long = 1
    println("fibonacci : ${fibonacci(n1, first1, second1)}")

    // 4. 피보나치 꼬리재귀
    val n2 = 100
    val first2 = BigInteger("0")
    val second2 = BigInteger("1")
    println("tail fibonacci : ${tailFibonacci(n2, first2, second2)}")

}

// 일반적인 팩토리얼 함수
fun factorial(n: Int): Long {
    return if(n == 1) n.toLong() else n * factorial(n - 1)
}

// 꼬리재귀를 사용한 팩토리얼 함수
tailrec fun tailFactorial(n: Int, run: Int = 1): Long {
    return if(n == 1) n.toLong() else tailFactorial(n - 1, run * n)
}

// 일반적인 피보나치 수열 함수
fun fibonacci(n: Int, a: Long, b: Long): Long {
    return if(n == 0) b else fibonacci(n - 1, a + b, a)
}

// 꼬리재귀를 사용한 피보나치 수열 함수
tailrec fun tailFibonacci(n: Int, a: BigInteger, b: BigInteger): BigInteger {
    return if(n == 0) a else tailFibonacci(n - 1, b, a + b)
}
