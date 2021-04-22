package chapter08.section02


/*
    flatten()
    filter()
    체이닝을 통한 필터링
 */
fun main() {


    ///////////////////// flatten()


    val numbers = arrayOf(1,2,3)
    val strs = arrayOf("one", "two", "three")
    val simpleArray = arrayOf(numbers, strs)

    // 2 차원배열 출력
    simpleArray.forEach { println(it) }

    // flatten() 을 이용하여 단일배열로 변환
    val flattenSimpleArray = simpleArray.flatten()
    println(flattenSimpleArray)


    ///////////////////// filter()


    val arr = arrayOf(1, -2, 3, 4, -5, 0)
    arr.filter { e -> e > 0 }.forEach { e -> print("$e ") }
    println()


    ///////////////////// 체이닝을 통한 필터링


    val fruits = arrayOf("banana", "avocado", " apple", "kiwi")
    fruits
            .filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
}