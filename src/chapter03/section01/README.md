### Section 01

#### function.kt (함수의 기본형태)

- 함수의 기본형태, []는 생략가능

    ~~~ kotlin
    fun 함수이름( [변수명: 자료형, 변수명: 자료형 ...] ): [반환값의 자료형] {
        표현식...
        [return 반환값]
    }
  
    ex)
    fun sum(a: Int, b: Int): Int {
        var sum = a + b
        return sum
    }
    ~~~

- 함수 간략하게 만들기

    ~~~ kotlin
    // 1. 기본형태
    fun sum(a: Int, b: Int): Int {
        return a+b
    }
    
    // 2. {} 안의 코드가 한 줄일때 중괄호와 return 문 생략가능
    fun sum(a: Int, b: Int): Int = a + b
    
    // 3. 매개변수값이 Int 이고, 반환형도 같은 Int 이므로 반환자료형도 생략 가능
    fun sum(a: Int, b: Int) = a + b
    ~~~
  
- 예제

    ~~~ kotlin
    fun main() {
    
      // 1. 기본함수
      println(sum(3, 2))
      println(sum(6, 7))
    }
    
    // 기본함수1
    fun sum(a: Int, b: Int): Int {
      return a + b
    }
    
    // 기본함수2
    fun sum(a: Int, b: Int): Int = a + b
    
    // 기본함수3
    fun sum(a: Int, b: Int) = a + b
    ~~~
  
- 결과

    ~~~ kotlin
    5
    13
    ~~~
  
<br>
  
#### NoReturn.kt (반환값이 없는 함수)

- 반환값이 없는 함수
    ~~~ kotlin
    //반환값을 Unit 으로 지정하거나 생략
    fun printSum(a: Int, b: Int): Unit {
        println("sum of $a and $b is ${a + b}")
    }
    ~~~
  
- 예제

    ~~~ kotlin
    fun main() {
        printSum(30, 20)
    }
    
    // 반환값이 없는 함수
    fun printSum(a: Int, b: Int) {
        println("sum of $a and $b is ${a + b}")
    }
    ~~~
  
- 결과

    ~~~ kotlin
    sum of 30 and 20 is 50
    ~~~
  
<br>
  
#### WithParams.kt (기본값이 있는 매개변수)

- 예제

    ~~~ kotlin
    fun main() {
        val name = "홍길동"
        val email = "hong@example.kr"
    
        add(name)
        add(name, email)
        add("둘리", "dooly@example.kr")
        defaultArgs()        // 100 + 200
        defaultArgs(200)  // 200 + 200
    }
    
    fun add(name: String, email: String = "default") {
        val output = "${name}님의 이메일은 ${email}입니다."
        println(output)
    }
    
    fun defaultArgs(x: Int = 100, y: Int = 200) {
        println(x + y)
    }
    ~~~
  
- 결과

    ~~~ kotlin
    홍길동님의 이메일은 default입니다.
    홍길동님의 이메일은 hong@example.kr입니다.
    둘리님의 이메일은 dooly@example.kr입니다.
    300
    400
    ~~~
  
<br>
  
#### WithNamedParams.kt (매개변수 이름과 함께 호출하기)

- 예제

    ~~~ kotlin
    fun main() {
        // y는 기본값
        namedParam(x = 200, z = 100)
  
        // Error - z에 기본값도 없고 인자도 없으므로.
        namedParam(x = 300)
  
        // Ok - x와 y는 기본값으로 지정됨  
        namedParam(z = 150)
    }
    
    fun namedParam(x: Int = 100, y: Int = 200, z: Int) {
        println(x + y + z)
    }
    ~~~
  
- 결과

    ~~~ kotlin
    500
    Kotlin: No value passed for parameter 'z'
    450
    ~~~