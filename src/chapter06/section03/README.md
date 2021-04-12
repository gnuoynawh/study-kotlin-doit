### Section 03 정적 변수와 컴패니언 객체
    
<br>

#### CompanionObject.kt (companion)

- 정적변수 (companion)
    - 컴패니언 객체는 실제 객체의 싱글톤(singleton)으로 정의됩니다.
    - 싱글톤이란 전역 변수를 사용하지 않고 객체를 하나만 생성하도록 하며,
    - 생성된 객체를 어디에서든지 참조할 수 있도록 하는 디자인 패턴의 하나입니다.

- @JvmStatic
    - 어노테이션으로 자바에서 접근가능

- 최상위 함수
    - @file:JvmName("PKLevel")
    - 객체 생성 없이도 어디에서든 실행 가능
    - 패지키 레벨함수(package-level function) 라고도 한다
    - 자바에서 static final 로 선언된 함수라고 생각하면 됨

- 예제
    ~~~ kotlin
    
    class Person3 {
        var id: Int = 0
        var name: String = "Youngdeok"
        companion object {
            var language: String = "Korean"
            fun work() {
                println("working...")
            }
        }
    }
    
    class KCustomer {
        companion object {
            const val LEVEL = "INTERMEDIATE"
            @JvmStatic fun login() = println("Login...")
        }
    }
    
    fun main() {
        println(Person3.language)       // 객체 생성 안하고 호출
        Person3.language = "English"    // 기본값 변경가능
        println(Person3.language)       // 변경된 내용 출력
        //println(Person3.name)           // companion 이 아니기 때문에 에러
    
        val p3 = Person3()
        println(p3.name)        // companion 이 아니므로 객체 생성 후 호출
    }
    ~~~
- 결과
    ~~~
    Korean
    English
    Youngdeok
    ~~~

<br>

#### ObjectExpression.kt (object, 싱글톤)

- 정적변수 (object, 싱글톤)
    - object 로 선언된 클래스는 멤버 프로퍼티와 메서드를 객체 생성없이 이름의 점 표기법으로 바로 사용가능
    - 단일 인스턴스를 생성해 처리하기 때문에 싱글톤 패턴에 이용
    - 자바에서 object 로 생성된 인스턴스에 접근하려면 INSTANCE 를 사용
    
- 예제
    ~~~ kotlin
    class Hobby(val name: String)
    
    fun main() {
        OCustomer.greeting()
        OCustomer.name = "Dooly"
        println("name = ${OCustomer.name}")
        println(OCustomer.HOBBY.name)
    
        CCustomer.greeting()
        println("name = ${CCustomer.name}, Hello = ${CCustomer.HELLO}")
        println(CCustomer.HOBBY.name)
    }
    
    // (1) object 키워드를 사용한 방식
    object OCustomer {
        var name = "Kildong"
        fun greeting() = println("Hello World!")
        val HOBBY = Hobby("Basketball")
        init {
            println("Init!")
        }
    }
    
    // (2) companion object를 사용한 방식
    class CCustomer {
        companion object {
            const val HELLO = "hello"  // 상수 표현
            var name = "Joosol"
            @JvmField val HOBBY = Hobby("Football")
            @JvmStatic fun greeting() = println("Hello World!")
        }
    }
    ~~~
- 결과
    ~~~
    Init!
    Hello World!
    name = Dooly
    Basketball
    Hello World!
    name = Joosol, Hello = hello
    Football
    ~~~

<br>
