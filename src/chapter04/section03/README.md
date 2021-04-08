### Section 03 흐름의 중단과 반환

<br>
 
#### UsingReturn.kt (return 문)

- 예제
    ~~~ kotlin
    fun main() {
        add(4, 5)
        hello("홍길동")
        hello1("홍길동")
        hello2("홍길동")
    }
    
    // 1. return 기본형태
    fun add(a: Int, b: Int): Int {
        return a + b
    }
    
    // 2. return 으로 Unit 반환
    fun hello(name: String): Unit {
        println(name)
        return Unit
    }
    
    // 3. Unit 생략
    fun hello1(name: String) {
        println(name)
        return
    }
    
    // 4. return 생략
    fun hello2(name: String) {
        println(name)
    }
    ~~~
- 결과
    ~~~
    홍길동
    홍길동
    홍길동
    ~~~

<br>

#### UsingReturnInLamda.kt (람다식에서 return)

- 예제
    ~~~ kotlin
    fun main() {
        retFunc()
        retFunc1()
        retFunc2()
        retFunc3()
    }
    
    // 1. 람다에서 return 사용하기
    fun retFunc() {
        println("start retFunc()")          // (1)
        inlineLamda(10, 3) { a, b ->  // (2) a+b 는 10보다 크다
            val result = a + b
            if (result > 10) return         // (3) 10 보다 크면 이 함수를 빠져나감
            println("result: $result")      // (4) 10 보다 크면 이 문장에 도달하지 못함
        }
        println("end retFunc()")            // (5)
    }
    
    // 2. 람다식에서 label 과 함께 return 사용하기 : return 에 라벨을 사용하면 해당 라벨에 지정된 {} 를 나간다
    fun retFunc1() {
        println("start retFunc1()")
        inlineLamda(10, 3) lit@ {   // (1) 람다식 블록의 시작부분에 라벨을 지정
            a, b ->
            val result = a + b
            if (result > 10) return@lit   // (2) 라벨을 사용한 블록의 끝부분으로 반환
            println("result: $result")    // (3) 라벨에서 {} 을 빠져나가므로 아래부분은 미실행
        }
        println("end retFunc1()")         // (4) 이 부분 실행됨
    }
    
    // 3. 람다식에서 label 과 함께 return 사용하기 : 암묵적 라벨 (람다식 명칭을 그대로 라벨처럼 사용)
    fun retFunc2() {
        println("start retFunc2()")
        inlineLamda(10, 3, fun(a, b) {
            val result = a + b
            if (result > 10) return@inlineLamda
            println("result: $result")
        })
        println("end retFunc2()")
    }
    
    // 4. 익명함수에서 람다식과 함께 return
    fun retFunc3() {
        getMessage = lamda@ { num: Int ->
            if(num !in 1..100)
                return@lamda "Error"
            "Success"
        }
        println(getMessage(100))
    }
    
    inline fun inlineLamda(a: Int, b: Int, out: (Int, Int) -> Unit) {
        out(a, b)
    }
    
    var getMessage = fun(num: Int): String {
        if(num !in 1..100)
            return "Error"
        return "Success"
    }
    ~~~
- 결과
    ~~~
    start retFunc()
    start retFunc1()
    end retFunc1()
    start retFunc2()
    end retFunc2()
    Success
    ~~~
  
<br>

#### BreakAndContinue.kt (break 문, continue 문)
- 예제
    ~~~ kotlin
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
    ~~~
- 결과
    ~~~
    12
    1245
    ~~~

<br>

#### ThrowAndException.kt (try/catch 문, exception) 
- 예제
    ~~~ kotlin
    fun main() {
        val a = 6
        val b = 0
        val c: Int
    
        try {
            c = a / b
        } catch (e : ArithmeticException) {
            println("Exception is handled. ${e.message}")   // 특정 예외처리
        } catch (e : Exception) {
            e.printStackTrace()     // 스택 추적
            println(e.message)      // 메시지 출력
        } finally {
            println("finally 블록은 반드시 항상 실행됨")
        }
    
        /*
            사용자 예외처리 클래스
         */
        val name: String = "test1234"
  
        try {
            validateName(name)
        } catch (e : InvalidNameException) {
            println(e.message)
        } finally {
            println("finally 사용자 예외 클래스 끝")
        }
    }
    
    // 사용자 예외 클래스 만들어보기
    class InvalidNameException(message: String) : Exception(message)
    
    fun validateName(name: String) {
        if(name.matches(Regex(".*\\d+."))) { // 이름에 숫자가 포함되어있는지 확인
            throw InvalidNameException("Your Name : $name : contains numerals.")
        }
    }
    ~~~
- 결과
    ~~~
    Exception is handled. / by zero
    finally 블록은 반드시 항상 실행됨
    Your Name : test1234 : contains numerals.
    finally 사용자 예외 클래스 끝
    ~~~
