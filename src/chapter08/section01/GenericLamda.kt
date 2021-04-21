package chapter08.section01


// 람다식에서 사용해보기

/*
// a+b 는 두 변수의 자료형이 특정되지 않음으로 오류
fun <T> add(a: T, b: T) : T {
    return a + b
}
*/

fun <T> add(a: T, b: T, op: (T, T) -> T) : T {
    return op(a, b)
}

fun main() {
    val result = add(2, 3, {a, b -> a + b}) // (1)
    val result1 = add(2, 3) {a, b -> a + b} // (2) 마지막 파라미터가 람다식일경우 () 밖으로 뺄수있다.
    println(result)
    println(result1)
}