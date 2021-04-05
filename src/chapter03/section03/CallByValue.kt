package chapter03.section03

fun main() {
    val result = callByValue(lamda()) // 람다식 호출
    println(result)
}

fun callByValue(b: Boolean): Boolean { // 일반 변수 자료형으로 선언된 매개변수
    println("callByValue function")
    return b
}

val lamda: ( ) -> Boolean = {   // 람다표현식이 2줄
    println("lamda function")
    true // 마지막 표현식 문장의 결과가 반
}