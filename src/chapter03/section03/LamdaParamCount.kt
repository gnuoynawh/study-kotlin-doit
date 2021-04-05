package chapter03.section03

fun main() {

    // 1. 매개변수 없는 람다식
    noParam({ "Hello World!" })
    noParam { "Hello World!" }  // 소괄호 생략 가능

    // 2. 매개변수가 하나인 람다식
    oneParam({ a -> "HelloWorld, $a" })
    oneParam { a -> "HelloWorld, $a" }  // 소괄호 생략 가능
    oneParam { "HelloWorld, $it" }      // it으로 대체 가능

    // 3. 매개변수가 두개 있는 람다식, 람다식 이름생략 불가 (특정 매개변수를 사용하고 싶지 않을때 _ 로 대체)
    moreParam { a, b -> "HelloWorld, $a, $b" }
    moreParam { _, b -> "HelloWorld, $b" }      // 첫번째 문자열 생략

    // 4. 인자와 함께 사용하는 람다식
    withArgs("arg1", "arg2", { a, b -> "HelloWorld, $a, $b" })
    withArgs("arg1", "arg2") { a, b -> "HelloWorld, $a, $b" }   // 마지막 인자가 람다식일때 소괄호 바깥으로 분리가능

}

// 매개변수가 없는 람다식을 매개변수로 가짐
fun noParam(out: () -> String) = println(out)

// 매개변수가 한개 있는 람다식을 매개변수로 가짐
fun oneParam(out: (String) -> String) {
    println(out("oneParam"))
}

// 매개변수가 두개 있는 람다식을 매개변수로 가짐
fun moreParam(out: (String, String) -> String) {
    println(out("oneParam", "twoParam"))
}

// 일반 매개변수 2개를 포함, 람다식 함수를 마지막 매개변수로 가짐
fun withArgs(a:String, b:String, out: (String, String) -> String) {
    println(out(a, b))
}
