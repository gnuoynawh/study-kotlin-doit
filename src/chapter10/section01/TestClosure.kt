package chapter10.section01


fun main() {

    /*
        closure
            - 람다식으로 표현된 내부 함수에서 외부 범위에 선언된 변수에 접근할 수 있는 개념
            - 이때 외부 변수는 람다식이 '포획Capture' 한 변수라고 한다.
     */

    val calc = Calc()

    // 외부의 변수
    var result = 0

    // 클로저
    // addNum 이 파라미터로 받게되는 아래 람다식(add) 는 반환값이 없지만,
    // 포획한 result 에 x + y 의 결과값이 있으므로 해당 값이 result 로 유지되여 5가 출력됨.
    calc.addNum(2,3) { x, y -> result = x + y }
    println(result)
}

class Calc {

    // addNum 에는 반환값이 없음
    fun addNum(a: Int, b: Int, add: (Int, Int) -> Unit) {
        add(a, b)
    }
}
