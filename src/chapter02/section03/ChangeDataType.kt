package chapter02.section03

fun main() {

    // 12.2에 의해 test는 Float형으로 스마트 캐스트
    var test: Number = 12.2
    println("$test, type = ${test.javaClass}" )

    // Int 형으로 스마트 캐스트
    test = 12
    println("$test, type = ${test.javaClass}" )

    // Long 형으로 스마트 캐스트
    test = 120L
    println("$test, type = ${test.javaClass}" )

    // Float 형으로 스마트 캐스트
    test = 12.0f
    println("$test, type = ${test.javaClass}" )


    // 2. as 를 이용한 스마트캐스트
    val a = 123
    val b = null

    // java.lang.Integer cannot be cast to java.lang.String
//    val x: String = a as String
//    println("cast x = $x")

    // null cannot be cast to non-null type kotlin.String
//    val y: String = b as String
//    println("cast y = $y")

    // null cast
    val z: String? = b as? String
    println("cast z = $z")


}