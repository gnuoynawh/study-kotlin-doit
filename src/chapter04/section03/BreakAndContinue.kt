package chapter04.section03

fun main() {
    // break
    for (i in 1..5) {
        if(i == 3) break
        print(i)
    }
    println()

    // continue
    for(i in 1..5) {
        if(i == 3) continue
        print(i)
    }
    println()
}