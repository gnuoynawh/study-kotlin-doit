package chapter04.section01


fun main() {

    print("Enter the score : ")
    val score = readLine()!!.toDouble()
    var grade: Char = 'F'

    // with 범위지정자
    when(score) {
        in 90.0 .. 100.0 -> grade = 'A'
        in 80.0 .. 89.9 -> grade = 'B'
        in 70.0 .. 79.9 -> grade = 'C'
        in 0.0 .. 69.9 -> grade = 'F'
    }
    println("Score: $score, Grade: $grade")

    // 인자가 없음
    when {
        score >= 90.0 -> grade = 'A'
        score in 80.0 .. 89.9 -> grade = 'B'
        score in 70.0 .. 79.9 -> grade = 'C'
        score < 70.0 -> grade = 'F'
    }
    println("Score: $score, Grade: $grade")

    // 다양한 인자
    cases("Hello")
    cases(1)
    cases(1234L)
    cases(MyClass())

}

class MyClass

fun cases(obj: Any) {
    when(obj) {
        1 -> println("Int: $obj")
        "Hello" -> println("String: $obj")
        is Long -> println("Long: $obj")
        !is String -> println("Not a String")
        else -> println("Unknown")
    }
}