package chapter05.section02

// 1. 주 생성자 - constructor 생략가능
class Bird3 (_name: String, _wing: Int, _beak: String, _color: String) {
    var name: String = _name
    var wing: Int = _wing
    var beak: String = _beak
    var color: String = _color

    fun fly() = println("fly wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}

// 2. 주 생성자 생략된 표현법 - 프로퍼티를 매개변수로 이미 선언
class Bird4 (var name: String, var wing: Int, var beak: String, var color: String) {
    fun fly() = println("fly wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}

// 3. 초기화 블럭, 기본값을 가진 클래스
class Bird5 (var name: String = "NONAME", var wing: Int = 2, var beak: String, var color: String) {

    // 초기화 블럭
    init {
        println("------------ start of init ------------")
        println("The name is $name, The beak is $beak")
        this.sing(3)
        println("------------ end of init ------------")
    }

    fun fly() = println("fly wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}

fun main() {
    val coco1 = Bird1("mybird", 2, "short", "blue")
    coco1.color = "yellow"
    println("coco1.color: ${coco1.color}")
    coco1.fly()
    coco1.sing(3)
}