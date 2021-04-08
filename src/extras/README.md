### Person.kt

#### 클래스 생성 방법

- 기본 클래스 생성

    ~~~ kotlin
    class Person    // 기본
    
    class Person {  // 변수
        var name
        var age
    }
    
    class Person {  // 변수 + 기본값
        var name = "홍길동"
        var age = 34
    }
    ~~~

- 기본 클래스 생성 + 생성자
    ~~~ kotlin
    // 생성자
    class Person (val name: String, val age: Int)
    
    // 생성자 + 기본값
    class Person(val name: String = "홍길동", val age: Int = 34)
    ~~~

<br>
<br>
