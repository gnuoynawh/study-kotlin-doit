### Section 01 조건문

<br>

#### UsingIf.kt (if 문, if/else 문)
- 다른 언어의 일반적인 if문, if/else문 하고 동일하다.
- `{}` 안에 내부에서 가장 마지막 식이 반환 된다.
-  범위연산자로 조건식 생략가능 `변수 이름 in 시작값..마지막값`
    ~~~ kotlin
    } else if (score >= 80 && score <= 89.9) {
    
    >>
    
    } else if (score in 80.0..89.9) {
    ~~~

- 예제
    ~~~ kotlin
    fun main() {
        // 1. if / else
        val a = 12
        val b = 7
    
        val max = if (a > b) {
            println("choose a")
            a
        }else {
            println("choose b")
            b
        }
        println(max)
    
        // 2. 논리합
        print("Enter the score : ")
        val score = readLine()!!.toDouble()
        var grade: Char = 'F'
    
        if(score >= 90.0)
            grade = 'A'
        else if(score >= 80.0 && score <= 89.9)
            grade = 'B'
        else if(score >= 70.0 && score <= 79.9)
            grade = 'C'
    
    
        // 범위지정자
        else if(score in 60.0 .. 69.9)
            grade = 'D'
        else if(score in 50.0 .. 59.9)
            grade = 'E'
    
        println("Score: $score, Grade: $grade")
    }
    ~~~
- 결과
    ~~~
    choose a
    12
    Enter the score : 70
    Score: 70.0, Grade: C
    ~~~

<br>

#### UsingWhen.kt (When 문)
- 인자를 사용하는 When 문 
    - switch/case 문과 비슷하지만 break 필요하지 않음
    - 블록 사용 또는 생략이 가능
    - 범위지정자 사용가능
    
    ~~~ kotlin
    when (인자) {
        인자에 일치하는 값 혹은 표현식 -> 수행할 문장
        인자에 일치하는 범위 -> 수행할 문장
        ..
        else -> 수행할 문장
    }
    ~~~
  
- 인자가 없는 When 문
    - 특정 인자에 제한하지 않고 다양한 조건을 구상할 수 있다.
    - 조건이나 표현식을 직접 만들 수 있다.
    
    ~~~ kotlin
    when {
        조건 [혹은 표현식] -> 수행할 문장
        ..
    }
    ~~~
  
- 다양한 인자 (Any)
    - 인자로 Any 형을 사용하게 되면 다양한 자료형의 인자를 받을 수 있다.
     
- 예제
    ~~~ kotlin
    fun main() {
        
        print("Enter the score : ")
        val score = readLine()!!.toDouble()
        var grade: Char = 'F'
    
        // with 범위지정자
        when(score) {
            in 90.0 .. 100.0 -> grade = 'A'
            in 80.0 .. 89.9 -> grade = 'B'
            in 70.0 .. 79.9 -> grade = 'C'
            in 0.0 .. 69.9 -> grade = 'F'
        }
        println("Score: $score, Grade: $grade")
    
        // 인자가 없음
        when {
            score >= 90.0 -> grade = 'A'
            score in 80.0 .. 89.9 -> grade = 'B'
            score in 70.0 .. 79.9 -> grade = 'C'
            score < 70.0 -> grade = 'F'
        }
        println("Score: $score, Grade: $grade")
    
        // 다양한 인자
        cases("Hello")
        cases(1)
        cases(1234L)
        cases(MyClass())
    
    }
    
    class MyClass
    
    fun cases(obj: Any) {
        when(obj) {
            1 -> println("Int: $obj")
            "Hello" -> println("String: $obj")
            is Long -> println("Long: $obj")
            !is String -> println("Not a String")
            else -> println("Unknown")
        }
    }
    ~~~
- 결과
    ~~~
    Enter the score : 70
    Score: 70.0, Grade: C
    Score: 70.0, Grade: C
    String: Hello
    Int: 1
    Long: 1234
    Not a String
    ~~~
