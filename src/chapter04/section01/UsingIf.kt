package chapter04.section01

fun main() {

    // 1. if / else
    val a = 12
    val b = 7

    val max = if (a > b) {
        println("choose a")
        a
    }else {
        println("choose b")
        b
    }
    println(max)

    // 2. 논리합
    print("Enter the score : ")
    val score = readLine()!!.toDouble()
    var grade: Char = 'F'

    if(score >= 90.0)
        grade = 'A'
    else if(score >= 80.0 && score <= 89.9)
        grade = 'B'
    else if(score >= 70.0 && score <= 79.9)
        grade = 'C'


    // 범위지정자
    else if(score in 60.0 .. 69.9)
        grade = 'D'
    else if(score in 50.0 .. 59.9)
        grade = 'E'

    println("Score: $score, Grade: $grade")
}