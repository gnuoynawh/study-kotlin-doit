package chapter04.section03

fun main() {
    add(4, 5)
    hello("홍길동")
    hello1("홍길동")
    hello2("홍길동")
}

// 1. return 기본형태
fun add(a: Int, b: Int): Int {
    return a + b
}

// 2. return 으로 Unit 반환
fun hello(name: String): Unit {
    println(name)
    return Unit
}

// 3. Unit 생략
fun hello1(name: String) {
    println(name)
    return
}

// 4. return 생략
fun hello2(name: String) {
    println(name)
}
