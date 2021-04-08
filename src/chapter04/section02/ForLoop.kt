package chapter04.section02

fun main() {

    // 1. 기본
    for(x in 1..5)
        print(x)
    print("\n")

    // 2. 덧셈
    var sum = 0
    for(x in 1..10)
        sum += x
    println("sum: $sum")

    // 3. 하행반복
    for(i in 5 downTo 1)
        print(i)
    print("\n")

    // 4. 2씩 증가
    for (i in 1..10 step 2)
        print(i)
    print("\n")

    // 5. 1-100 홀수의 합
    var total = 0
    for (i in 1..100 step 2)
        total += i
    println("total: $total")

    // 6. 삼각형 출력
    print("Enter the lines: ")
    var n = readLine()!!.toInt()
    for(line in 1..n) {
        for (space in 1..(n - line)) print(" ")
        for (star in 1..(2 * line - 1)) print("*")
        println()
    }
}