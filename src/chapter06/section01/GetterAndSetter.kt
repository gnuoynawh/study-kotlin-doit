package chapter06.section01

// 직접 구성한 기본 게터와 세터
class User1(_id: Int, _name: String, _age: Int) {
    // 프로퍼티
    val id: Int = _id
        get() = field

    var name: String = _name
        get() = field
        set(value) {
            field = value
        }

    var age: Int = _age
        get() = field
        set(value) {
            field = value
        }
}

// 프로퍼티 override
open class First {
    open val x: Int = 0 // 오버라이드 가능
        get() {
            println("First x")
            return field
        }

    val y: Int = 0
}

class Second : First() {
    override val x: Int = 0
        get() {
            println("Second x")
            return field + 3
        }

}

fun main() {
    val user1 = User1(1, "Kildong", 30)
    // user1.id = 2  // val 프로퍼티는 값 변경 불가
    user1.age = 35 // 세터
    println("user1.age = ${user1.age}") // 게터


    // 프로퍼티 오버라이드
    val second = Second()
    println(second.x)
    println(second.y)
}
