package chapter03.section03

fun main() {
    val result = callByName(otherLamda) // 람다식 이름으로 호출
    println(result)
}

fun callByName(b: ( ) -> Boolean): Boolean {    // 람다식 자료형으로 선언된 매개변수
    println("callByName function")
    return b()
}

val otherLamda: ( ) -> Boolean = {
    println("otherLamda function")
    true
}