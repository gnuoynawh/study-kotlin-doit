package chapter03.section03

fun main() {

    // 1. 생략되지 않는 전체 표현
    val multi: (Int, Int) -> Int = {x: Int, y: Int -> x * y}

    // 2. 선언 자료형 생략
    val multi1 = {x: Int, y: Int -> x * y}

    // 3. 람다식 매개변수 자료형 생략
    val multi2: (Int, Int) -> Int = {x, y -> x * y}

    // 4. 선언자료형과 람다 내 자료형 둘다 생략하면 자료형 추론이 안되므로 오류
    // val multi3 = {x, y -> x * y}

    // 5. 반환형 자료형이 없을때
    var greet: ( ) -> Unit = { println("Hello World!")}

    // 6. 매개변수가 하나만 있을때
    val square: (Int) -> Int = {x -> x * x}
    val square1 = {x : Int -> x * x}

    // 7. 매개변수에 람다식 함수를 이용한 고차함수
    val result = highOrder({ x, y -> x + y }, 15, 25)
    println(result)
}

// 매개변수 (람다식, Int, Int)
fun highOrder(sum: (Int, Int) -> Int, a: Int, b: Int): Int {
    return sum(a,b)
}