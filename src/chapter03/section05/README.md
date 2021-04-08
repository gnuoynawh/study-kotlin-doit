### Section 05

<br>

#### AnonymousFunc.kt (익명함수)
- 익명함수란 ? 일반 함수이지만이름이 없는 것 

- 예제
    ~~~ kotlin
    fun main() {
    
        // 선언부 포함
        val add: (Int, Int) -> Int = fun(x, y) = x + y
        val result = add(10, 2)
        println(result)
    
        // 선언부 생략
        val add1 = fun(x:Int, y:Int) = x + y
        val result1 = add1(10, 2)
        println(result1)
    
        // 람다식함수
        val add2 = {x:Int, y:Int -> x + y}
        val result2 = add2(10, 2)
        println(result2)
    }
    ~~~
- 결과
    ~~~
    12
    12
    12
    ~~~
  
#### InlinFunc.kt (인라인 함수)

- 인라인 함수란 ? 이 함수가 호출되는 곳에 함수 본문의 내용을 모두 복사해 넣어  
  함수의 분기없이 처리되기 때문에 코드의 성능을 높일 수 있습니다.
- 코드가 복사해서 들어가기 때문에 짧게 작성한다.
- 람다식 매개변수를 가지고 있는 함수에서 동작한다.

- 예제
    ~~~ kotlin
    fun main() {
      // 인라인 함수 shortFunc 의 내용이 [out] 부분으로 들어감
      shortFunc(3) { println("First call: $it") }
      shortFunc(5) { println("Second call: $it") }
    }
    
    inline fun shortFunc(a: Int, out: (Int) -> Unit) {
      println("Before calling out()")
      out(a)
      println("After calling out()")
    }
    ~~~
- 결과
    ~~~
    Before calling out()
    First call: 3
    After calling out()
    Before calling out()
    Second call: 5
    After calling out()
    ~~~
  

#### InlineBlockFunc.kt (인라인 함수 제한하기)

- 인라인 함수를 제한하려면 noinline 을 붙인다.
    - 인라인 함수와 동일한 결과를 보인다.
    - 코드가 복사되지않고 일반함수처럼 처리된다.
    
- 예제
    ~~~ kotlin
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
    ~~~
- 결과
    ~~~
    Before calling out()
    First call: 3
    After calling out()
    Before calling out()
    Second call: 5
    After calling out()
    ~~~

#### ExtensionFunc.kt (확장함수)

- 확장함수란 ? 기존 멤버 메서드는 아니지만 기존의 클래스에 내가 원하는 함수를 추가할 수 있는 개념을 제공한다.

    ~~~ kotlin
    fun 확장 대상.함수 이름(매개변수, ...): 반환값 {
        ...
        return 값
    }
    ~~~
  
- 예제
    ~~~ kotlin
    fun main() {
        // String을 확장해서 getLongString 함수를 추가
        val source = "Hello World"
        val target = "Kotlin"
        println(source.getLongString(target))
        println("Hello World".getLongString("Kotlin"))
    }
    
    // 확장함수
    fun String.getLongString(target: String): String =
            if(this.length > target.length) this else target
    ~~~
- 결과
    ~~~
    Hello World
    Hello World
    ~~~

#### InfixFunc.kt (중위함수)

- 중위 함수란 ? 클래스의 멤버를 호출할 때 사용하는 점(.)을 생략하고  
  함수이름 뒤에 소괄호를 붙이지 않아 직관적인 이름을 사용할 수 있는 표현법이다.
  
- 중위 함수의 조건
    - 멤버 메서드 또는 확장함수여야 한다
    - 하나의 매개변수를 가져야 한다
    - infix 키워드를 사용하여 정의하여야 한다

- 예제
    ~~~ kotlin
    fun main() {
        // 일반적인 표현
        val multi1 = 3.multiply(10)
        println("multi 1 : $multi1")
    
        // 중위 표현법
        val multi2 = 3 multiply 10
        println("multi 2 : $multi2")
    }
    
    // 중위함수
    infix fun Int.multiply(x: Int): Int {
        return this * x
    }
    ~~~
- 결과
    ~~~
    multi 1 : 30
    multi 2 : 30
    ~~~

#### TailRecFunc.kt (재귀함수)

- 재귀란 ? 
    - 자기 자신을 다시 참조하는 방법 (반복해서 어떠한 작업을 할 경우)
    - 지속적으로 참조하면 무한하게 대상을 생성할 수 있음
    
- 재귀 함수의 조건
    - 무한 호출에 빠지지 않도록 탈출 조건을 만들어준다
    - 스택 영역을 이용하므로 호출횟수를 무리하게 많이 지정해 연산하지 않는다
    - 코드를 복잡하지 않게 한다

- 예제
    ~~~ kotlin
    
    fun main() {
    
        // 1. 팩토리얼
        val num1 = 4
        val result: Long
        result = factorial(num1)
        println("factorial : $num1 -> $result")
    
        // 2. 팩토리얼 꼬리재귀
        val num2 = 5
        println("tail factorial : $num2 -> ${tailFactorial(num2)}")
    
        // 3. 피보나치
        val n1 = 100
        val first1: Long = 0
        val second1: Long = 1
        println("fibonacci : ${fibonacci(n1, first1, second1)}")
    
        // 4. 피보나치 꼬리재귀
        val n2 = 100
        val first2 = BigInteger("0")
        val second2 = BigInteger("1")
        println("tail fibonacci : ${tailFibonacci(n2, first2, second2)}")
    
    }
    
    // 일반적인 팩토리얼 함수
    fun factorial(n: Int): Long {
        return if(n == 1) n.toLong() else n * factorial(n - 1)
    }
    
    // 꼬리재귀를 사용한 팩토리얼 함수
    tailrec fun tailFactorial(n: Int, run: Int = 1): Long {
        return if(n == 1) n.toLong() else tailFactorial(n - 1, run * n)
    }
    
    // 일반적인 피보나치 수열 함수
    fun fibonacci(n: Int, a: Long, b: Long): Long {
        return if(n == 0) b else fibonacci(n - 1, a + b, a)
    }
    
    // 꼬리재귀를 사용한 피보나치 수열 함수
    tailrec fun tailFibonacci(n: Int, a: BigInteger, b: BigInteger): BigInteger {
        return if(n == 0) a else tailFibonacci(n - 1, b, a + b)
    }
    ~~~
- 결과
    ~~~
    factorial : 4 -> 24
    tail factorial : 5 -> 1
    fibonacci : -2437933049959450366
    tail fibonacci : 354224848179261915075
    ~~~