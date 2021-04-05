package chapter02.section04

fun main() {

    // 비트연산자
    var x = 4
    var y = 0b0000_1010
    var z = 0x0F

    println("x shl 2 -> ${x shl 2}")
    println("x.inv() -> ${x.inv()}")
    println("y shr 2 -> ${y/4}, ${y shr 2}")
    println("x shl 4 -> ${x+16}, ${x shl 4}")
    println("z shl 4 -> ${z+16}, ${z shl 4}")

    x = 64
    println("x shr 2 -> ${x/4}, ${x shr 2}")

    // ushr
    val number1 = 5
    val number2 = -5

    println(number1 shr 1)
    println(number1 ushr 1) // 변화 없음
    println(number2 shr 1)  // 부호비트가 1로 유지
    println(number2 ushr 1) // 부호비트가 0이 되면서 변경

    // 비트 논리 연산
    val number3 = 12
    val number4 = 25

    println(number3 or number4)     // result = number3.or(number4) 와 동일
    println(number3 and number4)    // result = number3.and(number4) 와 동일
    println(number3 xor number4)    // result = number3.xor(number4) 와 동일
}