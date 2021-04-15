package chapter07.section02

/*
    내부 클래스
        - 정적 클래스 : static 키워드를 가지며 외부 클래스를 인스턴스화하지 않고 바로 사용 가능한 내부 클래스 (주로 빌더에 이용)
        - 멤버 클래스 : 인스턴스 클래스로도 불리며 외부 클래스의 필드나 메서드와 연동
        - 지역 클래스 : 초기화 블록이나 메서드 내의 블록에서만 유효한 클래스
        - 익명 클래스 : 이름이 없고 주로 일회용 객체를 인스턴스화하면서 오버라이드 메서드를 구현하는 내부 클래스

 */

/*
    코틀린에서 중첩 클래스는 기본적으로 정적(static) 클래스처럼 다뤄집니다.
    즉, 중첩 클래스는 객체 생성 없이 접근할 수 있다는 것입니다.
 */
class Outer {
    val ov = 5
    class Nested {
        val nv = 10
        fun greeting() = "[Nested] Hello ! $nv" // 외부의 ov에는 접근 불가
    }
    fun outside() {
        val msg = Nested().greeting() // 객체 생성 없이 중첩 클래스의 메서드 접근
        println("[Outer]: $msg, ${Nested().nv}") // 중첩 클래스의 프로퍼티 접근
    }
}

fun main() {
    // 중첩
    // static 처럼 Outer의 객체 생성 없이 Nested객체를 생성 사용할 수 있음
    val output = Outer.Nested().greeting()
    println(output)

    // Outer.outside() // 에러! Outer 객체 생성 필요
    val outer = Outer()
    outer.outside()
}



