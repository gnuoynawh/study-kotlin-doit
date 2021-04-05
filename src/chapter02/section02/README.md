### Section 02

#### variable.kt (변수)
  
- 변수
    - 변수 선언시 변수 선언시 val, var 을 사용한다.
    - val 은 불편형
    - var 은 가변형
    - 변수명은 카멜표기법에 따라서 선언  
    
    <br>
    
    ~~~ kotlin
    var a = "mutable"           // a 변수는 가변형, 자료형은 String 으로 추
    val b: String = "immutable" // b 변수는 불변형, 자료형은 String 
    
    // var 변수는 수정가능
    a = "change"
    
    // a 변수는 가변형이라서 수정 가능하지만
    // 최초 String 으로 참조되어서 Int 형을 넣으면 오류
    a = 1
    ~~~
<br>
    
#### DataType.kt (자료형)

- 자료형
    - 보통 프로그래밍 언어의 자료형은 기본형 자료형과 참조형 자료형으로 구분
    - 코틀린은 참조형 자료형을 사용한다.
    - 기본형? 말 그대로 가공되지 않은 순수한 자료형을 말하며 프로그래밍 언어에 내장
    - 참조형? 객체를 생성하고 동적 공간에 데이터를 둔 다음 이것을 참조하는 자료형.
    - 자바에서는 int, long, float, double 등 기본형과 String, Date와 같은 참조형을 모두 사용
    - 코틀린에서는 참조형만 사용하며, 이것은 다시 코틀린의 성능 최적화에 따라 JVM에 실행하기 위해 컴파일러에서 기본형으로 대체
        - 정수 자료형 (Byte, Short, Int, Long)
            - 양수, 음수, 0 을 나타냄. 숫자의 크기에 상관없이 기본은 모두 Int 형으로 추론
        - 실수형 (Float, Double)
            - 자료형을 명시하지 않으면 Double 형으로 추론
            - 간략하게 식별자 F 를 붙이는 방법도 가능
            - 실수를 표현할때는 부동소수점 (floating-point) 방식을 사용. 부동소수점 방식은 실수를 가수, 지수로 나누어 표현하는 방식

- 예제
    ~~~ kotlin
    // 정수형
    val num01 = 127
    val num02 = -32768
    val num03 = 2147483647
    val num04 = 9223372036854775807
    println("num01 = $num01, type = ${num01::class.simpleName}")
    println("num02 = $num02, type = ${num02::class.simpleName}")
    println("num03 = $num03, type = ${num03::class.simpleName}")
    println("num04 = $num04, type = ${num04::class.simpleName}")
    
    // 실수형
    val num05 = 3.14
    val num06 = 3.14F
    val num07 = 3.14E-2     //왼쪽으로 소수점 자리 이동
    val num08 = 3.14e2f     //오른쪽으로 소수점 자리 이동
    println("num05 = $num05, type = ${num05::class.simpleName}")
    println("num06 = $num06, type = ${num06::class.simpleName}")
    println("num07 = $num07, type = ${num07::class.simpleName}")
    println("num08 = $num08, type = ${num08::class.simpleName}")
    ~~~
- 결과
    ~~~ kotlin
    num01 = 127, type = Int
    num02 = -32768, type = Int
    num03 = 2147483647, type = Int
    num04 = 9223372036854775807, type = Long
    num05 = 3.14, type = Double
    num06 = 3.14, type = Float
    num07 = 0.0314, type = Double
    num08 = 314.0, type = Float
    ~~~
<br>

#### StringFormat.kt (문자열)

- 문자열 표기
    - `$a` 는 변수의 값을 표기
    - `${a}` 는 함수, 계산식 등 사용가
    - 특수문자 표현
        - 특수문자 앞에 \ 역슬래시
        - `${''}` 내부에 작성
    - `"""` 로 감싼 문자열은 모든 내용이 그대로 출력
    
- 예제
    ~~~ kotlin
    // 문자열 표기
    val c = 1
    val str1 = "c = $c"
    val str2 = "c = ${c + 2}"
    val str3 = "c = ${c.toByte()}"
    println("str1 = \"$str1\", str2 = \"$str2\", str3 = \"$str3\"")
    
    // 특수문자 표현
    println("특수문자 표현하기 => ${'"'}${'$'}9.99${'"'}")
    
    // 입력 내용 그대로 출력
    val num = 10
    val formatter =
    """
       var a = 6
       var b = "Kotlin"
       println(a + num)     //num 값은 $num
    """
    println(formatter)
    ~~~
- 결과
    ~~~ kotlin
    str1 = "c = 1", str2 = "c = 3", str3 = "c = 1"
    특수문자 표현하기 => "$9.99"
    
           var a = 6
           var b = "Kotlin"
           println(a + num)     //num 값은 10
       
    ~~~
<br>

- 예제2
    ~~~ kotlin
    // 문자열 참조관련
    var str1: String = "Hello"
    var str2 = "World"
    var str3 = "Hello"
    
    //값 비교
    println("str1 == str2 : ${str1 == str2}")
    println("str1 == str3 : ${str1 == str3}")
    
    //참조 비교
    println("str1 === str2 : ${str1 === str2}")
    println("str1 === str3 : ${str1 === str3}") // StringPool 이라는 공간에 문자열을 저장해두고 str1, str3이 같이 참조하도록 생성
    
    val a: Int = 128
    val b = a
    val c: Int? = a
    val d: Int? = a
    val e: Int? = c
    
    println(a === b)    // a 를 b 에다가 넣기 때문 true
    println(c == d)     // 값의 내용만 비교하는 경우 동일하므로 true
    println(c === d)    // 값의 내용은 같지만 참조 주소를 참조하자면 다른 객체이므로 false
    println(c === e)    // 값의 내용도 같고, 참조 주소도 같으므로 true
    ~~~
- 결과2
    ~~~ kotlin
    str1 == str2 : false
    str1 == str3 : true
    str1 === str2 : false
    str1 === str3 : true
    true
    true
    false
    true
    ~~~