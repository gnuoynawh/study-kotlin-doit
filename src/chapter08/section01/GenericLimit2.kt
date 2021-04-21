package chapter08.section01

// 다수 조건 !!
// 형식 매개변수의 자료형 제한하기


// test Interface
interface InterfaceA
interface InterfaceB
interface InterfaceC

// test Class
class HandlerA: InterfaceA, InterfaceB
class HandlerB: InterfaceA
class HandlerC: InterfaceA, InterfaceC

// ClassA 는 2개의 인터페이스(InterfaceA 와 InterfaceB)를 구현하는 클래스로 제한
class ClassA<T> where T: InterfaceA, T: InterfaceB

fun main() {
    val obj = ClassA<HandlerA>()
    // val obj2 = ClassA<HandlerB>() // 오류!
    // val obj3 = ClassA<HandlerC>() // 오류!

}

