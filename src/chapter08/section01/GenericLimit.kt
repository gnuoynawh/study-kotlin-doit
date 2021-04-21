package chapter08.section01

// 형식 매개변수의 자료형 제한하기

// T 를 Number 형으로 제한
class Calc<T: Number> {
    fun plus(arg1: T, arg2: T): Double {
        return arg1.toDouble() + arg2.toDouble()
    }
}

fun main() {
    val calc = Calc<Int>()
    println(calc.plus(10, 20))

    val calc1 = Calc<Double>()
    val calc2 = Calc<Long>()
    // val calc3 = Calc<String>()  // Number 형이 아니므로 오류발생

    println(calc1.plus(2.5, 3.5))
    println(calc2.plus(5L, 10L))
}