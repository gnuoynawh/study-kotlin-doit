### Section 02 지연 초기화와 위임
    
<br>

#### LateinitTest.kt (지연 초기화)

- 지연 초기화
    - 기본 자료형들은 생성자에서 반드시 초기화 되어야 하지만  
      의존성이 있는 경우.. 매번 초기화하기 힘듦
    - 임시 프로퍼티를 사용하는 경우 등
    - `lateinit` 키워드를 사용한다.
    
- lateinit 의 제한
    - var 로 선언된 프로퍼티만 가능하다.
    - 프로퍼티에 대한 게터와 세터를 사용할 수 없다.
    
- 예제
    ~~~ kotlin
    class Person1 {
        lateinit var name: String // ① 늦은 초기화를 위한 선언
    
        fun test() {
            if(!::name.isInitialized) { // ② 프로퍼티의 초기화 여부 판단
                println("not initialized")
            } else {
                println("initialized")
            }
        }
    }
    
    fun main() {
        val kildong = Person1()
        kildong.test()
        kildong.name = "Kildong" // ③ 이 시점에서 초기화됨(지연 초기화)
        kildong.test()
        println("name = ${kildong.name}")
    }
    ~~~
- 결과
    ~~~
    not initialized
    initialized
    name = Kildong
    ~~~

<br>

#### ByLazyTest.kt (lazy 로 지연초기)

- by lazy
    - 호출 시점에 `by lazy {...}` 정의에 의해 블록 부분의 초기화를 진행한다.
    - 불변의 변수 선언인 `val` 에서만 사용 가능하다.(읽기 전용)
    - `val` 이므로 값을 다시 변경할 수 없다.

- lazy 모드
    - `SYNCHRONIZED` : lock 을 사용해 단일 스레드만이 사용하는 것을 보장한다. (기본)
    - `PUBLICATION` : 여러 군데에서 호출될 수 있으나 처음 초기화된 후 반환값을 사용한다.
    - `NONE` : lock 을 사용하지 않기 때문에 빠르지만 다중 스레드가 접근할 수 있다. (값의 일관성을 보장할 수 없음)

- 예제
    ~~~ kotlin
    class Person2(val name: String, val age: Int)
    
    class LazyTest {
        init {
            println("init block") // ②
        }
    
        val subject by lazy {
            println("lazy initialized") // ⑥
            "Kotlin Programming" // ⑦ lazy 반환값
        }
        fun flow() {
            println("not initialized") //  ④
            println("subject one: $subject") // ⑤ 최초 초기화 시점!
            println("subject two: $subject") // ⑧ 이미 초기화된 값 사용
        }
    }
    
    fun main() {
    
        ///////
        var test = LazyTest()
        test.flow()
    
        ///////
    
        var isPersonInstantiated: Boolean = false  // ① 초기화 확인 용도
    
        val person : Person2 by lazy { // ② lazy를 사용한 person 객체의 지연 초기화
            isPersonInstantiated = true
            Person2("Kim", 23) // ③ 이 부분이 Lazy 객체로 반환 됨
        }
        val personDelegate = lazy { Person2("Hong", 40) }  // ④ 위임 변수를 사용한 초기화
    
        println("person Init: $isPersonInstantiated")
        println("personDelegate Init: ${personDelegate.isInitialized()}")
    
        println("person.name = ${person.name}")  // ⑤ 이 시점에서 초기화
        println("personDelegate.value.name = ${personDelegate.value.name}")  // ⑥ 이 시점에서 초기화
    
        println("person Init: $isPersonInstantiated")
        println("personDelegate Init: ${personDelegate.isInitialized()}")
    }
    ~~~
- 결과
    ~~~
    init block
    not initialized
    lazy initialized
    subject one: Kotlin Programming
    subject two: Kotlin Programming
    person Init: false
    personDelegate Init: false
    person.name = Kim
    personDelegate.value.name = Hong
    person Init: true
    personDelegate Init: true
    ~~~

<br>

#### .kt (위임)

- 위임(delegation)이란 ?
    - 어떤 특정 일을 대신하는 중간자 역할을 말합니다.
    - 키워드 `by` 를 사용한다.
    - 예를 들어 상속 재산을 위해 합의서에 모든 상속자가 서명해야 하지만 특정 상속자가  
      다른 상속자를 대신하여 서명할 수 있게 위임장이라는 것을 쓰면 대신 서명할 수 있게 되는 것입니다.

- 예제
    ~~~ kotlin
    interface Car {
        fun go(): String
    }
    
    class VanImpl(val power: String) : Car {
        override fun go(): String = "은 짐을 적재하며 $power 을 가집니다."
    }
    
    class SportImpl(val power: String) : Car {
        override fun go(): String = "은 경주용에 사용되며 $power 을 가집니다."
    }
    
    class CarModel(val model: String, impl: Car) : Car by impl {
        fun carInfo() {
            println("$model ${go()}")
        }
    }
    
    fun main() {
        val myDamas = CarModel("Damas 2010", VanImpl("100마력"))
        val my350z = CarModel("350Z 2008", SportImpl("350마력"))
    
        myDamas.carInfo()
        my350z.carInfo()
    }
    ~~~
  
- 결과
    ~~~
    Damas 2010 은 짐을 적재하며 100마력 을 가집니다.
    350Z 2008 은 경주용에 사용되며 350마력 을 가집니다.
    ~~~
  
<br>


#### DelegateProperty.kt (프로퍼티 위임)

- observable()
    - `Delegates` 패키지를 임포트 해야한다.  
    - 프로퍼티 값이 변경되는 감시하는 함수
    
- vetoable()
    - `Delegates` 패키지를 임포트 해야한다.
    - 최댓값이라는 조건에 맞지않으면 값 할당을 거부하도록
    
- 예제
    ~~~ kotlin
    // observable 테스트
    class User2 {
        var name: String by Delegates.observable("NONAME") { //프로퍼티 위임
            prop, old, new -> // 람다식 매개변수로 프로퍼티, 기존값, 새로운값 지정
            println("$old -> $new") // 이벤트 발생시에만 실행
        }
    }
    
    fun main() {
        val user = User2()
        user.name = "Kildong"   // 값이 변경되는 시점에서 첫 이벤트
        user.name = "Dooly"     // 값이 변경되는 시점에서 두번째 이벤트
    
    
        // vetoable 테스트
        var max: Int by Delegates.vetoable(0) { // 초기값 0
            prop, old, new ->
            new > old           // 조건에 맞지않으면 거부권 행사
        }
    
        println(max)    // 0
        max = 10
        println(max)    // 10
    
        max = 5         // 입력한 값이 기존 값보다 작아지므로 false, 5로 재할당 하지않고 기존값 유지
        println(max)    // 10
    }
    ~~~

- 결과
    ~~~
    NONAME -> Kildong
    Kildong -> Dooly
    0
    10
    10
    ~~~



