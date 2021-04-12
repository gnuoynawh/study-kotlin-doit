package chapter06.section02


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