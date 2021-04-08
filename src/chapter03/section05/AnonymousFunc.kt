package chapter03.section05

fun main() {

    // 선언부 포함
    val add: (Int, Int) -> Int = fun(x, y) = x + y
    val result = add(10, 2)
    println(result)

    // 선언부 생략
    val add1 = fun(x:Int, y:Int) = x + y
    val result1 = add1(10, 2)
    println(result1)

    // 람다식함수
    val add2 = {x:Int, y:Int -> x + y}
    val result2 = add2(10, 2)
    println(result2)
}
