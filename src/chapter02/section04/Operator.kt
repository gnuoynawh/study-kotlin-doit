package chapter02.section04

fun main() {

    // 1. 기본 연산자
    val num1 = 13.0
    val num2 = 3.0
    println("num1 + num2 = ${num1 + num2}")
    println("num1 - num2 = ${num1 - num2}")
    println("num1 * num2 = ${num1 * num2}")
    println("num1 / num2 = ${num1 / num2}")
    println("num1 % num2 = ${num1 % num2}")


    // 2. 나머지 연산자
    val n = 4
    if ((n % 2) == 1)
        println("n is an Odd")
    if ((n % 2) == 0)
        println("n is an Even")


    // 3. 증감 연산자
    var num3 = 10
    var num4 = 10
    var result1 = ++num3
    var result2 = num4++
    println("result1 : $result1")
    println("result2 : $result2")
    println("num3 : $num3")
    println("num4 : $num4")


    // 4. 논리 연산자
    var check = (5>3) && (5>2)  // 두개의 항이 모두 참일 때 true
    println(check)
    check = (5>3) || (2>5)  // 두개중 하나의 항이 참일 때 true
    println(check)
    check = !(5>3)  // 참인 경우 거짓으로, 거짓인 경우 참으로 변경
    println(check)

}