### Section 02

#### AboutNull.kt (Null)

- NULL
    - 코틀린은 기본적으로 null 허용하지 않음. NPE 발생함
    - null 을 허용하지 위해서는 ? 를 붙인다.
    - 변수의 함수를 사용할때
    
    <br>
            
- 예제1
~~~ kotlin
// null 허용하지 않으므로 NPE
var str1: String = "Hello Kotlin"
str1 = null
println("str1 = $str1")

// null 허용하지 않으므로 NPE
val str2: String = null
println("str2 = $str2, str2.lengh = ${str2.length}")
~~~
- 결과1
~~~ kotlin
Kotlin: Null can not be a value of a non-null type String
~~~

<br>

#### SafeCallandElvis.kt (Null 을 막기위한 코드) 

- 세이프콜 `?`
    - 변수뒤에 ? 를 붙이면 NPE 가 발생하지 않고 null 을 리턴  
    
- 단정기호 `!!`
    - null 이 아님을 단정하므로 컴파일러가 null 검사 없이 무시한다.
    - null 일지라도 컴파일이 진행되며 실행중 NPE 가 발생한다.
    - **`null 이 아님이 보장될 때만 사용`**  
    
- 엘비스 연산자 `?:`
    - null 일 경우 리턴할 값 지정을 위해 사용
    - null 일 경우 ?: 뒤에 지정한 값을 리턴
    
    
- 예제
~~~ kotlin
// 세이프콜
val str1: String? = null
println("str1 = $str1, str1.lengh = ${str1?.length}")

// 단정기호
val str2: String? = "Hello Kotlin"
println("str2 = $str2, str2.lengh = ${str2!!.length}")

// 엘비스 연산자 ?:
var str3: String? = "Hello Kotlin"
println("str3 = $str3, str3.lengh = ${str3?.length ?: -1}")

var str4 : String?
str4 = null
println("str4 = $str4, str4.length: ${str4?.length ?: -1}")
~~~
- 결과
~~~ kotlin
str1 = null, str1.lengh = null
str2 = Hello Kotlin, str2.lengh = 12
str3 = Hello Kotlin, str3.lengh = 12
str4 = null, str4.length: -1
~~~



<br>

#### CheckDataType.kt (자료형 검사) 
- 자료형 검사
    - is 키워드를 사용
    - 왼쪽 항의 변수가 오른쪽 항의 자료형과 같으면 true
    - 왼쪽 항의 변수가 오른쪽 항의 자료형과 다르면 false  
    
- 예제
~~~ kotlin
val num = 256

if (num is Int) { // num이 Int형 일때
    print(num)
} else if (num !is Int) { // num이 Int형이 아닐 때, !(num is Int) 와 동일
    print("Not a Int")
}
~~~
- 결과
~~~ kotlin
256
~~~

<br>

#### ChangeDataType.kt (자료형 형변환) 
- 스마트 캐스트
    - Number 형과 같이 여러개의 자료형을 가지는 자료형에 사용
    - Number 형은 정수형, 실수형 등을 가질 수 있다
    - 저장된 값의 자료형에 따라 형태가 정해짐
    
- 예제1
~~~ kotlin
// 12.2에 의해 test는 Float형으로 스마트 캐스트
var test: Number = 12.2
println("$test, type = ${test.javaClass}" )

// Int 형으로 스마트 캐스트
test = 12
println("$test, type = ${test.javaClass}" )

// Long 형으로 스마트 캐스트
test = 120L
println("$test, type = ${test.javaClass}" )

// Float 형으로 스마트 캐스트
test = 12.0f
println("$test, type = ${test.javaClass}" )
~~~

- 결과1
~~~ kotlin
12.2, type = class java.lang.Double
12, type = int
120, type = long
12.0, type = float
~~~

- as 를 이용한 스마트캐스트
    - 형변환이 가능하지 않을 경우 오류를 발생
    - null 일 경우 세이프콜을 사용한다

- 예제2
~~~ kotlin
val a = 123
val b = null

// 형변환 오류
val x: String = a as String
println("cast x = $x")

// null 오류
val y: String = b as String
println("cast y = $y")

// null 을 표현할때 
val z: String? = b as? String
println("cast z = $z")
~~~

- 결과2
~~~ kotlin
Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
Exception in thread "main" java.lang.NullPointerException: null cannot be cast to non-null type kotlin.String
cast z = null
~~~

<br>

#### AboutAny.kt (Any) 

- Any 
    - Any 형은 자료형의 최상위 클래스
    - 모든 자료형을 가질 수 있음
    - 저장되는 값에 따라 묵시적 형변환이 발생함
    
- 예제1
~~~ kotlin
// Any 형 e 는 초기화 될 때 Int 형이 됨
var e: Any = 1
println("1. e: $e type: ${e.javaClass}")

// Int 형이였던 e는 변경된 값 20L에 의해 Long 형이 됨
e = 20L
// e의 자바 기본형을 출력하면 long이 나옴
println("2. e: $e type: ${e.javaClass}")
~~~
- 결과1
~~~ kotlin
1. e: 1 type: class java.lang.Integer
2. e: 20 type: long
~~~


- 예제2
~~~ kotlin
fun main() {
    var x:Any
    x = "Hello"
    if(x is Int) {
        println("Int = $x")
    }else if(x is String) {
        println("String = $x")
    }

    checkArgs(10)
    checkArgs("Hello Kotlin")
    checkArgs(12.2f)
}

fun checkArgs(x: Any) {
    if(x is Int) {
        println("x is Int = $x")
    }else if(x is String) {
        println("x is String = $x")
    }else if(x is Float) {
        println("x is Float = $x")
    }
}
~~~

- 결과2
~~~ kotlin
String = Hello
x is Int = 10
x is String = Hello Kotlin
x is Float = 12.2
~~~