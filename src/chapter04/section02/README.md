### Section 02 반복문

<br>
 
#### ForLoop.kt (for 문)
- 기본 형식 : `for(요소 변수 in 컬렉션 또는 범위) { 반복할 본문 }`
- in 연산자 사용 : `for(x in 1..5)`
- 하행 반복 : `for(x in 5 downTo 1)` 
- 계수 증가 : `for(x in 1..10 step 2)`

- 예제
    ~~~ kotlin
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
    ~~~
- 결과
    ~~~
    12345
    sum: 55
    54321
    13579
    total: 2500
    Enter the lines: 5
        *
       ***
      *****
     *******
    *********
    ~~~

<br>

#### WhileLoop.kt (while 문)
- 기본형식 : `while (조건식) { 반복할 본문 } // 조건식이 true 일때 반복`

- 예제
    ~~~ kotlin
    var i = 1
    while (i <= 5) {
        print("$i")
        ++i
    }
    ~~~
- 결과
    ~~~
    12345
    ~~~

<br>

#### DoWhileLoop.kt (do-while 문) 
- 기본형식 : `do { 반복할 본문 } while (조건식) // 1 회 실행 후 조건식이 true 일때 반복`

- 예제
    ~~~ kotlin
    fun main() {
        do {
            print("Enter an integer: ")
            val input = readLine()!!.toInt()
    
            for(i in 0..(input - 1)) {
                for(j in 0..(input -1))
                    print((i + j) % input + 1)
                println()
            }
        } while (input != 0)
    }
    ~~~
- 결과
    ~~~
    Enter an integer: 5
    12345
    23451
    34512
    45123
    51234
    Enter an integer: 0
    ~~~
