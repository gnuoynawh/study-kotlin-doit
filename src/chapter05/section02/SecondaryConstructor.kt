package chapter05.section02

// 1. 부생성자
class Bird1 {
    var name: String
    var wing: Int
    var beak: String
    var color: String

    // 부생성자
    /*constructor(name: String, wing: Int, beak: String, color: String) {
        this.name = name
        this.wing = wing
        this.beak = beak
        this.color = color
    }*/

    // 부생성자 이름이 다른 스타일
    constructor(_name: String, _wing: Int, _beak: String, _color: String) {
        name = _name
        wing = _wing
        beak = _beak
        color = _color
    }

    fun fly() = println("fly wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}

// 주 생성자가 없고 여러개의 보조 생성자를 가진 클래스
class Bird2 {
    // 프로퍼티들
    var name: String
    var wing: Int
    var beak: String
    var color: String

    // 부 생성자 1
    constructor(_name: String, _wing: Int, _beak: String, _color: String) {
        name = _name
        wing = _wing
        beak = _beak
        color = _color
    }

    // 부 생성자 2
    constructor(_name: String, _beak: String) {
        name = _name
        wing = 2
        beak = _beak
        color = "grey"
    }

    // 메서드들
    fun fly() = println("Fly wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}
