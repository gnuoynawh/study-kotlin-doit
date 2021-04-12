package chapter05.section04

// 부모 클래스
open class Person {

    constructor(firstName: String) {
        println("[Person] firstName: $firstName")
    }

    constructor(firstName: String, age: Int) { // ③
        println("[Person] firstName: $firstName, $age")
    }
}

// 자식 클래스
class Developer: Person {

    // this 로 다른 부생성자를 실행
    constructor(firstName: String): this(firstName, 10) { // ①
        println("[Developer] $firstName")
    }

    // super 로 부모 클래스의 부생성자를 상속받는다.
    constructor(firstName: String, age: Int): super(firstName, age) { // ②
        println("[Developer] $firstName, $age")
    }
}

fun main() {
    val sean = Developer("Sean")
}