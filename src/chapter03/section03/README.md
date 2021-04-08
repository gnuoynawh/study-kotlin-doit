### Section 03

#### HighFunctions.kt (고차 함수)

- 다른 함수를 인자로 사용하거나 함수를 결괏값으로 반환하는 함수  

- 인자에 일반함수 사용해보기

    - 예시
    
        ~~~ kotlin
        fun main() {
            val res1 = sum(3,2)          // 일반 인자
            val res2 = mul(sum(3,3), 3)  // 인자에 함수를 사용
            println("res1 : $res1, res2 : $res2")
        }
        
        fun sum(a: Int, b:Int) = a + b
        fun mul(a: Int, b:Int) = a * b
        ~~~
    - 결과
    
        ~~~ kotlin
        res1 : 5, res2 : 18
        ~~~

<br>

- 반환값에 일반함수 사용해보기

    - 예시
    
        ~~~ kotlin
        fun main() {
            println("funcFunc : ${funcFunc()}")
        }
        
        fun sum(a: Int, b:Int) = a + b
        
        fun funcFunc(): Int {   // 함수의 반환값으로 함수를 사용
            return sum(2,2)
        }
        ~~~
    - 결과
    
        ~~~ kotlin
        funcFunc : 4
        ~~~

<br>

- 변수에 할당하는 람다식 함수 작성하기

    - 예시
    
        ~~~ kotlin
        fun main() {
            var result: Int
            val multi = {x: Int, y:Int -> x * y}    // 일반 변수에 람다식 할당
            result = multi(10, 20)  // 람다식이 할당된 변수는 함수처럼 사용 가능
            println(result)
        }
        ~~~
    - 결과
    
        ~~~ kotlin
        200
        ~~~

<br>

#### Lamda.kt (람다식)

- 생략되지 않는 전체 표현

    ~~~ kotlin
    val multi: (Int, Int) -> Int = {x: Int, y: Int -> x * y}
    ~~~
  
- 선언 자료형 생략

    ~~~ kotlin
    val multi1 = {x: Int, y: Int -> x * y}
    ~~~
  
- 람다식 매개변수 자료형 생략

    ~~~ kotlin
    val multi2: (Int, Int) -> Int = {x, y -> x * y}
    ~~~
  
- 선언자료형과 람다 내 자료형 둘다 생략하면 자료형 추론이 안되므로 오류

    ~~~ kotlin
    val multi3 = {x, y -> x * y}
    ~~~
  
- 반환형 자료형이 없을때

    ~~~ kotlin
    var greet: ( ) -> Unit = { println("Hello World!")}
    ~~~
  
- 매개변수가 하나만 있을때

    ~~~ kotlin
    val square: (Int) -> Int = {x -> x * x}
    val square1 = {x : Int -> x * x}    
    ~~~
  
- 매개변수에 람다식 함수를 이용한 고차함수

    - 예제 
    ~~~ kotlin
    val result = highOrder({ x, y -> x + y }, 15, 25)
    println(result)
    ~~~
  
    - 결과 
    ~~~ kotlin
    40
    ~~~
  
<br>

#### CallByValue.kt

- 아래 예제에 대한 실행순서
    - lamda() 실행
    - "lamda function !" 출력
    - 람다식 결과값 반환
    - callByValue 실행
    - "call By Value function !" 출력
    - 매개변수로 넘어온 결과값 반환
    - 넘어온 결과값 출력
    
- 예제 
    ~~~ kotlin
    fun main() {
        val result = callByValue(lamda()) // 람다식 호출
        println(result)
    }
    
    fun callByValue(b: Boolean): Boolean { // 일반 변수 자료형으로 선언된 매개변수
        println("callByValue function")
        return b
    }
    
    val lamda: ( ) -> Boolean = {   // 람다표현식이 2줄
        println("lamda function")
        true // 마지막 표현식 문장의 결과가 반
    }
    ~~~

- 결과 
    ~~~ kotlin
    lamda function
    callByValue function
    true
    ~~~


<br>

#### CallByName.kt

- 아래 예제에 대한 실행순서
    - callByName() 실행
    - "call By Name function !" 출력
    - 매개변수로 넘어온 람다식 otherLamda 실행
    - "other Lamda function !" 출력
    - 람다식 결과값 반환
    - 실행한 람다식의 결과값 반환
    - 넘어온 결과값 출력
    
- 예제 
    ~~~ kotlin
    fun main() {
        val result = callByName(otherLamda) // 람다식 이름으로 호출
        println(result)
    }
    
    fun callByName(b: ( ) -> Boolean): Boolean {    // 람다식 자료형으로 선언된 매개변수
        println("callByName function")
        return b()
    }
    
    val otherLamda: ( ) -> Boolean = {
        println("otherLamda function")
        true
    }
    ~~~

- 결과 
    ~~~ kotlin
    callByName function
    otherLamda function
    true
    ~~~

<br>

#### CallFunction.kt

- 고차함수에서 함수를 인자로 호출
    - 2개의 콜론 `::` 기호를 함수 이름앞에 사용한다.
    
- 예 
    ~~~ kotlin
    fun main() {
        // 1. 인자와 반환값이 있는 함수
        val res1 = funcParam(3, 2, ::funcSum)
        println(res1)
    
        // 2. 인자가 없는 함수
        hello(::funcText)   // 반환값이 없음
    
        // 3. 일반 변수에 값처럼 할당
        val likeLamda = ::funcSum
        println(likeLamda(6,6))
    }
    
    fun funcSum(a: Int, b: Int) = a + b
    
    fun funcText(a: String, b: String) = "Hi! $a $b"
    
    fun funcParam(a: Int, b: Int, c: (Int, Int) -> Int): Int {
        return c(a,b)
    }
    
    fun hello(body: (String, String) -> String): Unit {
        println(body("Hello", "World"))
    }
    ~~~
- 결과 
    ~~~ kotlin
    5
    Hi! Hello World
    12
    ~~~
  
<br>

#### LamdaParamCount.kt

- 매개변수가 없는 람다식

    - 예제
        ~~~ kotlin
        fun main() {
            noParam({ "Hello World!" })
            noParam { "Hello World!" }  // 소괄호 생략 가능
        }
        
        // 매개변수가 없는 람다식을 매개변수로 가짐
        fun noParam(out: () -> String) = println(out)
        ~~~
    
    - 결과
        ~~~ kotlin
        () -> kotlin.String
        () -> kotlin.String
        ~~~
        
- 매개변수가 하나인 람다식

    - 예제
        ~~~ kotlin
        fun main() {
            oneParam({ a -> "HelloWorld, $a" })
            oneParam { a -> "HelloWorld, $a" }  // 소괄호 생략 가능
            oneParam { "HelloWorld, $it" }      // it으로 대체 가능
        }
        
        // 매개변수가 한개 있는 람다식을 매개변수로 가짐
        fun oneParam(out: (String) -> String) {
            println(out("oneParam"))
        }
        ~~~
    
    - 결과
        ~~~ kotlin
        HelloWorld, oneParam
        HelloWorld, oneParam
        HelloWorld, oneParam
        ~~~
  
- 매개변수가 두개 있는 람다식

    - 예제
        ~~~ kotlin
        fun main() {
        람다식 이름생략 불가
            moreParam { a, b -> "HelloWorld, $a, $b" }  // 매개변수명 생략 불가
            moreParam { _, b -> "HelloWorld, $b" }      // 특정 매개변수를 사용하고 싶지 않을때 _ 로 대체
        }
    
        // 매개변수가 두개 있는 람다식을 매개변수로 가짐
        fun moreParam(out: (String, String) -> String) {
            println(out("oneParam", "twoParam"))
        }
        ~~~
    
    - 결과
        ~~~ kotlin
        HelloWorld, oneParam, twoParam
        HelloWorld, twoParam
        ~~~

- 인자와 함께 사용하는 람다식

    - 예제
        ~~~ kotlin
        fun main() {
            withArgs("arg1", "arg2", { a, b -> "HelloWorld, $a, $b" })
            withArgs("arg1", "arg2") { a, b -> "HelloWorld, $a, $b" }   // 마지막 인자가 람다식일때 소괄호 바깥으로 분리가능
        }
        
        // 일반 매개변수 2개를 포함, 람다식 함수를 마지막 매개변수로 가짐
        fun withArgs(a:String, b:String, out: (String, String) -> String) {
            println(out(a, b))
        }
        ~~~
    
    - 결과
        ~~~ kotlin
        HelloWorld, arg1, arg2
        HelloWorld, arg1, arg2
        ~~~

#### LamdaParamCount.kt

- 예제
    ~~~kotlin
    fun main() {
    
        twoLamda({a, b -> "Fisrt $a, $b"}, {"Second $it"})
    
        // 위와 동일
        twoLamda({a, b -> "Fisrt $a, $b"}) {"Second $it"}
    }
    
    fun twoLamda(first: (String, String) -> String, second: (String) -> String) {
        println(first("OneParam", "TwoParam"))
        println(second("OenParam"))
    }
    ~~~
- 결과
    ~~~
    Fisrt OneParam, TwoParam
    Second OenParam
    Fisrt OneParam, TwoParam
    Second OenParam
    ~~~
