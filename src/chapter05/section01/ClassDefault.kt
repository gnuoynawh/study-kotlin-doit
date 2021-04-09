package chapter05.section01

class Bird {    // (1) 클래스 정의

    // (2) 프로퍼티 - 속성
    var name: String = "mybird"
    var wing: Int = 2
    var beak: String = "short"
    var color: String = "blue"

    // (3) 메서드 - 함수
    fun fly() = println("fly wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}


fun main() {

    // (4) 클래스 생성자를 통한 객체생성
    val coco = Bird()

    // (5) 객체의 프로퍼티에 값 쓰기
    coco.color = "red"

    // (6) 객체의 프로퍼티 가져오기
    println("coco.color: ${coco.color}")

    // (7) 객체의 멤버 메서드 사용
    coco.fly()
    coco.sing(5)
}
