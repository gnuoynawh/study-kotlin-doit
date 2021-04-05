package chapter02.section02

fun main() {

    // a 변수는 String 형으로 추론
    var a = "mutable"

    // b 변수는 String 형을 명시적으로 지정
    val b: String = "immutable"

    // var 변수는 수정가능
    a = "change"

    // a 변수는 String 으로 되어서 Int 형을 넣으면 오류
    // a = 1

    println("a = $a, b = $b")

}