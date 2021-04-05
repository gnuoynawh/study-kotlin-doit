package chapter02.section02

fun main() {

    // 정수형
    val num01 = 127
    val num02 = -32768
    val num03 = 2147483647
    val num04 = 9223372036854775807
    println("num01 = $num01, type = ${num01::class.simpleName}")
    println("num02 = $num02, type = ${num02::class.simpleName}")
    println("num03 = $num03, type = ${num03::class.simpleName}")
    println("num04 = $num04, type = ${num04::class.simpleName}")

    // 실수형
    val num05 = 3.14
    val num06 = 3.14F
    val num07 = 3.14E-2     //왼쪽으로 소수점 자리 이동
    val num08 = 3.14e2f     //오른쪽으로 소수점 자리 이동
    println("num05 = $num05, type = ${num05::class.simpleName}")
    println("num06 = $num06, type = ${num06::class.simpleName}")
    println("num07 = $num07, type = ${num07::class.simpleName}")
    println("num08 = $num08, type = ${num08::class.simpleName}")
}