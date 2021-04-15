package chapter07.section03

/*
    연산자 오버로딩
        - 연산자에 다른 의미의 동작을 부여
        - 코틀린에서는 특정 연산자의 역할을 함수로 정의
        - operator 키워드를 사용해서 정의


        // + operator for basic types
        operator fun plus(other: Byte): Int
        operator fun plus(other: Short): Int
        operator fun plus(other: Int): Int
        operator fun plus(other: Long): Long
        operator fun plus(other: Float): Float
        operator fun plus(other: Double): Double

        // for string concatenation
        operator fun String?.plus(other: Any?): String
 */

class Point(var x: Int = 0, var y: Int = 10) {
    operator fun plus(p: Point) : Point {
        return Point(x + p.x, y + p.y)
    }
}

fun main() {
    val p1 = Point(3, -8)
    val p2 = Point(2, 9)

    var point = Point()
    point = p1 + p2
    println("point = (${point.x}, ${point.y})")
}