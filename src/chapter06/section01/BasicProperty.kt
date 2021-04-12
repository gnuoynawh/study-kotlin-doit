package chapter06.section01

class User(val id: Int, var name: String, var age: Int)

fun main() {
    val user = User(1, "Sean", 30)

    // 게터에 의한 값 획득
    val name = user.name

    // 세터에 의한 값 지정
    user.age = 41

    println("name: $name, ${user.age}")
}