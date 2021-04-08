package chapter04.section03

fun main() {
    retFunc()
    retFunc1()
    retFunc2()
    retFunc3()
}

// 1. 람다에서 return 사용하기
fun retFunc() {
    println("start retFunc()")          // (1)
    inlineLamda(10, 3) { a, b ->  // (2) a+b 는 10보다 크다
        val result = a + b
        if (result > 10) return         // (3) 10 보다 크면 이 함수를 빠져나감
        println("result: $result")      // (4) 10 보다 크면 이 문장에 도달하지 못함
    }
    println("end retFunc()")            // (5)
}

// 2. 람다식에서 label 과 함께 return 사용하기 : return 에 라벨을 사용하면 해당 라벨에 지정된 {} 를 나간다
fun retFunc1() {
    println("start retFunc1()")
    inlineLamda(10, 3) lit@ {   // (1) 람다식 블록의 시작부분에 라벨을 지정
        a, b ->
        val result = a + b
        if (result > 10) return@lit   // (2) 라벨을 사용한 블록의 끝부분으로 반환
        println("result: $result")    // (3) 라벨에서 {} 을 빠져나가므로 아래부분은 미실행
    }
    println("end retFunc1()")         // (4) 이 부분 실행됨
}

// 3. 람다식에서 label 과 함께 return 사용하기 : 암묵적 라벨 (람다식 명칭을 그대로 라벨처럼 사용)
fun retFunc2() {
    println("start retFunc2()")
    inlineLamda(10, 3, fun(a, b) {
        val result = a + b
        if (result > 10) return@inlineLamda
        println("result: $result")
    })
    println("end retFunc2()")
}

// 4. 익명함수에서 람다식과 함께 return
fun retFunc3() {
    getMessage = lamda@ { num: Int ->
        if(num !in 1..100)
            return@lamda "Error"
        "Success"
    }
    println(getMessage(100))
}

inline fun inlineLamda(a: Int, b: Int, out: (Int, Int) -> Unit) {
    out(a, b)
}

var getMessage = fun(num: Int): String {
    if(num !in 1..100)
        return "Error"
    return "Success"
}
