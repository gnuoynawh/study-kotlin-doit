### Section 01 프로퍼티의 접근
    
<br>

#### BasicProperty.kt (프로퍼티에 접근)
- 프로퍼티에 접근
    - getter, setter
    - val 일때는 setter 는 없음 (불변, 읽기전용)

- 예제
    ~~~ kotlin
    class User(val id: Int, var name: String, var age: Int)
    
    fun main() {
        val user = User(1, "Sean", 30)
    
        // 게터에 의한 값 획득
        val name = user.name
    
        // 세터에 의한 값 지정
        user.age = 41
    
        println("name: $name, ${user.age}")
    }
    ~~~
- 결과
    ~~~
    name: Sean, 41
    ~~~

<br>

#### GetterAndSetter.kt 

- 프로퍼티에 접근
    - 기본형식 (기본 게터와 세터 직접 지정)
    
    ~~~ kotlin
    var 프로퍼티이름[: 프로퍼티자료형] [= 프로퍼티 초기화]
      [get() { 게터 본문 } ]
      [set(value) {세터 본문}]
  
    val 프로퍼티이름[: 프로퍼티자료형] [= 프로퍼티 초기화]
      [get() { 게터 본문 } ]
    ~~~
  
- 예제
    ~~~ kotlin
    // 직접 구성한 기본 게터와 세터
    class User1(_id: Int, _name: String, _age: Int) {
        // 프로퍼티
        val id: Int = _id
            get() = field
    
        var name: String = _name
            get() = field
            set(value) {
                field = value
            }
    
        var age: Int = _age
            get() = field
            set(value) {
                field = value
            }
    }
    
    // 프로퍼티 override
    open class First {
        open val x: Int = 0 // 오버라이드 가능
            get() {
                println("First x")
                return field
            }
    
        val y: Int = 0
    }
    
    class Second : First() {
        override val x: Int = 0
            get() {
                println("Second x")
                return field + 3
            }
    
    }
    
    fun main() {
        val user1 = User1(1, "Kildong", 30)
        // user1.id = 2  // val 프로퍼티는 값 변경 불가
        user1.age = 35 // 세터
        println("user1.age = ${user1.age}") // 게터
    
    
        // 프로퍼티 오버라이드
        val second = Second()
        println(second.x)
        println(second.y)
    }
    ~~~
- 결과
    ~~~
    user1.age = 35
    Second x
    3
    0
    ~~~