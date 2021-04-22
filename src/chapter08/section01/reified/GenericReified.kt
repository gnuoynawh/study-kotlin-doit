package chapter08.section01.reified

fun main() {
    val result = getType<Float>(10)
    println("type test <Float> result = $result")

    val result1 = getType<String>(11111)
    println("type test <String> result1 = $result1")
}

inline fun <reified T> getType(value: Int): T {

    // 실행 시간에 삭제되지 않고 사용 가능
    println(T::class)       // kotlin
    println(T::class.java)  // java

    // 받아들인 제네릭 자료형에 따라 반환
    return when (T::class) {
        Float::class -> value.toFloat() as T
        Int::class -> value as T
        else -> throw IllegalStateException("${T::class} is not supported!")
    }
}
