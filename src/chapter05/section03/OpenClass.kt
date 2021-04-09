package chapter05.section03

// 묵시적으로 any 부터 상속, open 키워드로 상속/파생 가능
open class Bird(var name: String, var wing: Int, var beak: String, var color: String) {
    fun fly() = println("Fly wing : $wing")
    fun sing(vol: Int) = println("Sing vol : $vol")
}

// 기반 클래스를 상속함, 최종 클래스로 상속/파생 불가
// 주 생성자를 사용하는 상속
class Lark(name: String, wing: Int, beak: String, color: String) : Bird(name, wing, beak, color) {

    // 새로 추가한 메서드
    fun singHitone() = println("Happy Song!")
}

// 부 생성자를 사용하는 상속
class Parrot: Bird {
    val language: String

    // 부생성자
    constructor(name: String, wing: Int, beak: String, color: String, language: String) : super(name, wing, beak, color) {
        this.language = language
    }

    fun speak() = println("Speak! $language")
}

fun main() {

    val coco = Bird("mybird", 2, "short", "blue")
    val lark = Lark("mylark", 2, "long", "brown")
    val parrot = Parrot("myparrot", 2, "short", "multiple", "korean")

    println("coco : ${coco.toString()}")
    println("lark : ${lark.toString()}")
    println("parrot : ${parrot.toString()}")

    lark.singHitone()
    parrot.speak()
    lark.fly()

}
