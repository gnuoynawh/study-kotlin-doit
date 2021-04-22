package chapter08.section01.variance

/*
    공변성에 따른 자료형 제한하기
        - 상위 클래스와 하위 클래스를 만들고, 공변성에 따라 자료형을 제한
 */

// 상위
open class Animal(val size: Int) {
    fun feed() = println("Feeding...")
}


// 하위
class Cat(val jump: Int): Animal(50)
class Spider(val position: Boolean): Animal(1)


// 형식 매개변수를 Animal로 제한, 주 생성자에는 val 만 사용
class Box4<out T: Animal>(val element: T) {

    // out 은 반환 자료형에만 사용할 수 있음
    fun getAnimal(): T = element

//    // 오류! T는 in 위치에 사용할 수 없음
//    fun set(new: T) {
//        element = new
//    }
}

fun main() {
    // 일반적인 객체 선언
    val c1: Cat = Cat(10)
    val s1: Spider = Spider(true)

    // 클래스의 상위 자료형으로 변환하는 것은 아무런 문제가 없음
    var a1: Animal = c1

    // a1은 Spider 의 객체가 됨
    a1 = s1
    println("a1.size = ${a1.size}")

    // 공변성 - Cat은 Animal 의 하위 자료형
    val c2: Box4<Animal> = Box4<Cat>(Cat(10))
    println("c2.element.size = ${c2.element.size}")

    // 오류 - 반대의 경우는 인스턴스화 되지 않음
    //val c3: Box4<Cat> = Box4<Animal>(10)

    // 오류 - 자료형을 제한하여 Animal 과 하위 클래스 이외에는 사용할 수 없음
    //val c4: Box4<Any> = Box4<Int>(10)
}