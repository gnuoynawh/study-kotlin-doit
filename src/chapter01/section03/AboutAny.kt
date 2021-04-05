package chapter01.section03

fun main() {

    // Any 형 test 는 초기화 될 때 Int 형이 됨
    var e: Any = 1
    println("1. e: $e type: ${e.javaClass}")

    // Int 형이였던 e는 변경된 값 20L에 의해 Long 형이 됨
    e = 20L
    // e의 자바 기본형을 출력하면 long이 나옴
    println("2. e: $e type: ${e.javaClass}")


    // Any 자료형은 코틀린의 최상위 클래스
    var x:Any
    x = "Hello"
    if(x is Int) {
        println("Int = $x")
    }else if(x is String) {
        println("String = $x")
    }

    checkArgs(10)
    checkArgs("Hello Kotlin")
    checkArgs(12.2f)
}

fun checkArgs(x: Any) {
    if(x is Int) {
        println("x is Int = $x")
    }else if(x is String) {
        println("x is String = $x")
    }else if(x is Float) {
        println("x is Float = $x")
    }
}