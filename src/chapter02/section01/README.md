### Section 01

#### UsingSameNameClass.kt <br> (동일한 이름의 클래스가 있을 경우)  
1. 하나의 클래스 아래 동일한 이름의 클래스가 사용되었을 경우  
`import 된 클래스`가 우선적으로 적용된다.  
    - 예제
        ~~~ kotlin
        import extras.Person
        
        fun main() {
            val a = Person()
            println("a 의 이름은 ${a.name}, 나이는 ${a.age} 입니다.")
        }
        
        class Person(val name: String = "심청이", val age: Int = 30)
        ~~~  
    - 결과
        ~~~ kotlin
        a 의 이름은 김철수, 나이는 34 입니다.
        ~~~  
  
2. 위와 같은 상황에 클래스를 구분하기 위해  
import 된 클래스에 `as` 키워드를 사용하여 별칭을 적용한다.  
    
    - 예제
        ~~~ kotlin
        import extras.Person as User
        
        fun main() {
            val a = Person()
            println("a 의 이름은 ${a.name}, 나이는 ${a.age} 입니다.")
        }
        
        class Person(val name: String = "심청이", val age: Int = 30)
        ~~~  
    - 결과
        ~~~ kotlin
        a 의 이름은 심청이, 나이는 30 입니다.
        ~~~

