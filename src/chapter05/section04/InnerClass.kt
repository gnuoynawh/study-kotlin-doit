package chapter05.section04

// Inner 클래스에서 바깥 클래스 접근
fun main() {
    val c1 = Child()
    c1.Inside().test()
}

open class Base {
    open val x: Int = 1
    open fun f() = println("Base Class f()")
}

class Child : Base() {
    override val x: Int = super.x + 1
    override fun f() = println("Child Class f()")

    inner class Inside {
        fun f() = println("Inside Class f()")
        fun test() {
            f() // Inside 클래스의 f() 접근
            Child().f() // Child 클래스의 f() 접근
            super@Child.f() // Child 의 상위클래스인 Base 클래스의 f() 접근
            println("[Inside] super@Child.x : ${super@Child.x}")
        }
    }
}