package chapter09.section05

fun main() {

    /*
        피보나치 수열
     */

    val fibonacci = generateSequence(1 to 1) {it.second to it.first + it.second}
            .map {it.first}
    println(fibonacci.take(10).toList())


}