package chapter03.section03

fun main() {

    // 인자에 일반함수 사용해보기
    val res1 = sum(3,2)             // 일반 인자
    val res2 = mul(sum(3,3), 3)  // 인자에 함수를 사용
    println("res1 : $res1, res2 : $res2")


    // 반환값에 일반함수 사용해보기
    println("funcFunc : ${funcFunc()}")


    // 변수에 할당하는 람다식 함수 작성하기
    var result: Int
    val multi = {x: Int, y:Int -> x * y}    // 일반 변수에 람다식 할당
    result = multi(10, 20)  // 람다식이 할당된 변수는 함수처럼 사용 가능
    println(result)

}

fun sum(a: Int, b:Int) = a + b

fun mul(a: Int, b:Int) = a * b

fun funcFunc(): Int {   // 함수의 반환값으로 함수를 사용
    return sum(2,2)
}
