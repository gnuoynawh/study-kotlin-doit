package chapter05.section04

// 인터페이스에서 참조
fun main() {
    val c = C()
    c.test()
}

open class A {
    open fun f() = println("A class f()")
    fun a() = println("A class a()")
}

interface B {
    fun f() = println("B interface f()")
    fun b() = println("B interface b()")
}

// , 를 사용해서 클래스와 인터페이스를 지정
class C : A() , B {

    // 컴파일 되려면 f() 가 오버라이딩 되어야 함
    override fun f() = println("C class f()")

    fun test() {
        f() // 현재 클래스의 f()
        b() // 인터페이스 B의 b()
        super<A>.f()    // A 의 f()
        super<B>.f()    // B 의 f()
    }
}