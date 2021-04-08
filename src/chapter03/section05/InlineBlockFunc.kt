package chapter03.section05

fun main() {
    // 인라인 함수 shortFunc 의 내용이 [out] 부분으로 들어감
    shortBlockFunc(3) { println("First call: $it") }
    shortBlockFunc(5) { println("Second call: $it") }
}

inline fun shortBlockFunc(a: Int, noinline out: (Int) -> Unit) {
    println("Before calling out()")
    out(a)
    println("After calling out()")
}