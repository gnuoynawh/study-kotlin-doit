package chapter02.section01

import extras.Person as User

fun main() {

    // 현재 패키지의 Person
    // 기본값
    val a = Person()
    println("a 의 이름은 ${a.name}, 나이는 ${a.age} 입니다.")

    // 지정값 지정
    val b = Person("심봉사", 53)
    println("b 의 이름은 ${b.name}, 나이는 ${b.age} 입니다.")


    // extra 패키지의 Person
    // 기본값
    val c = User()
    println("c 의 이름은 ${c.name}, 나이는 ${c.age} 입니다.")

    // 지정값 지정
    val d = User("이영희", 26)
    println("d 의 이름은 ${d.name}, 나이는 ${d.age} 입니다.")

}

class Person(val name: String = "심청이", val age: Int = 30)