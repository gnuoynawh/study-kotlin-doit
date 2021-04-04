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

#### SafeCallandElvis.kt<br>(Null 을 막기위한 코드) 

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

#### CheckDataType.kt<br>(자료형 검사) 

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
