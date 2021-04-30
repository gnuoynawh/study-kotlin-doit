package chapter10.section01

/*
    코틀린 표준 라이브러리(3) - apply()

        - also()함수와 마찬가지로 호출하는 객체 T를 이어지는 block 으로 전달하고 객체 자체인 this 를 반환
        - 표준 함수의 정의
            public inline fun <T> T.apply(block: T.() -> Unit): T { block(); return this }
 */

fun main() {

    data class Person(var name: String, var skills : String)
    val person = Person("Kildong", "Kotlin")

    // 여기서 this 는 변수 person 본인을 가르킨다. this 는 생략가능
    person.apply { this.skills = "Swift" }
    println(person)

    // this 는 생략가능. this 없이 객체의 멤버에 여러 번 접근
    val retrunObj = person.apply {
        name = "Sean"
        skills = "Java"
    }
    println(person)
    println(retrunObj)
}