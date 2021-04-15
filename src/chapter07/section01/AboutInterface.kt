package chapter07.section01

/*
    인터페이스
        - 현실 세계의 계약서
            계약서에는 무엇 무엇을 하라는 추상적인 활동들이 적혀 있다.
            이것을 어떤 '작업자'가 받아들였다면 계약서에 있는 활동에 구체적인 내용을 반드시 실행해야 함
            계약서 자체로는 실행될 수 없음
        - 추상 클래스와 다른점
            클래스가 아니므로 다양한 인터페이스로부터 클래스 구현 가능 (다중 상속)
            추상 클래스와는 다르게 강한 연관을 가지지 않는
 */
open class Animal(val name: String)

interface Pet {
    var category: String // abstract 키워드가 없어도 기본은 추상 프로퍼티
    val msgTags: String  // val 선언 시 게터의 구현이 가능
        get() = "I'm your lovely pet!"

    var species: String // 종을 위한 프로퍼티
    fun feeding() // 마찬가지로 추상 메서드
    fun patting() { // 비-추상 메서드: 구현부를 포함하면 비-추상이 되며 기본 구현이 된다.
        println("Keep patting!") // 구현부
    }
}

class Cat(name: String, override var category: String) : Pet, Animal(name) {

    override var species: String = "cat" // 프로퍼티를 오버라이딩해 종을 특정한다.

    override fun feeding() {
        println("Feed the cat a tuna can!")
    }
}

fun main() {
    val obj = Cat("Bill", "small")
    println("Pet Category: ${obj.category}")
    println("Pet Message Tags: ${obj.msgTags}")
    obj.feeding() // 구현된 메서드
    obj.patting() // 기본 메서드
}