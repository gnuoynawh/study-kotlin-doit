package chapter05.section03

// 상속 가능한 클래스를 위해 open 사용
open class Bird1(var name: String, var wing: Int, var beak: String, var color: String) {

    // 메서드
    fun fly() = println("Fly wing: $wing")

    // 오버라이딩 가능한 메서드
    open fun sing(vol: Int) = println("Sing vol: $vol")
}

open class Lark1(name: String, wing: Int, beak: String, color: String) : Bird1(name, wing, beak, color) {

    // final 키워드로 하위 클래스에서 재정의를 막음
    final override fun sing(vol: Int) {
        // 구현부 새롭게 정의
    }
}

class Parrot1(name: String,
              wing: Int = 2,
              beak: String,
              color: String, // 마지막 인자만 var로 선언되어 프로퍼티가 추가되었음을 알 수 있다.
              var language: String = "natural") : Bird1(name, wing, beak, color) {

    // Parrot에 추가된 메서드
    fun speak() = println("Speak! $language")

    // 오버라이딩된 메서드
    override fun sing(vol: Int) {
        println("I'm a parrot! The volume level is  $vol")

        // 달라진 내용!
        speak()
    }
}

fun main() {
    val parrot = Parrot1(name = "myparrot", beak = "short", color = "multiple")
    parrot.language = "English"

    println("Parrot: ${parrot.name}, ${parrot.wing}, ${parrot.beak}, ${parrot.color}, ${parrot.language}")
    parrot.sing(5) // 달라진 메서드 실행 가능

    val calc = Calc()
    println(calc.add(3, 2))
    println(calc.add(3.2, 1.3))
    println(calc.add(3, 3, 2))
}

class Calc {
    fun add(x: Int, y: Int): Int {
        return x + y
    }

    fun add(x: Double, y: Double): Double {
        return x + y
    }

    fun add(x: Int, y: Int, z: Int): Int {
        return x + y + z
    }
}