package chapter06.section02

class Person1 {
    lateinit var name: String // ① 늦은 초기화를 위한 선언

    fun test() {
        if(!::name.isInitialized) { // ② 프로퍼티의 초기화 여부 판단
            println("not initialized")
        } else {
            println("initialized")
        }
    }
}

fun main() {
    val kildong = Person1()
    kildong.test()
    kildong.name = "Kildong" // ③ 이 시점에서 초기화됨(지연 초기화)
    kildong.test()
    println("name = ${kildong.name}")
}