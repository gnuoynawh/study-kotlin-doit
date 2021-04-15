package chapter07.section02

/*
    DTO(Data Transfer Object)
        - java 에서는 POJO 라고도 불리움
        - 구현로직을 가지고 있지않은 순수 데이터 객체
        - 데이터를 접근하기 위한 게터/세터
        - toString, equals와 같은 데이터 표현, 비교 메서드 포함

        - 조건
            주 생성자는 최소한 하나의 매개변수를 가져야 한다.
            주 생성자의 모든 매개변수는 val, var로 지정된 프로퍼티여야 한다.
            데이터 클래스는 abstract, open, sealed, inner 키워드를 사용할 수 없다.

    객체 디스트럭처 (Destruct)
        - 객체가 가지고 있는 프로퍼티를 개별 변수로 분해하는 것
 */

// 기본
data class Customer(var name: String, var email: String)

// 생성자, init 초기화
data class Customer1(var name: String, var email: String) {
    var job: String = "Unknown"
    constructor(name: String, email: String, _job: String): this(name, email) {
        job = _job
    }

    init {
        // 간단한 로직은 여기
    }
}

fun main() {
    val cus1 = Customer("Sean", "sean@mail.com")
    val cus2 = Customer("Sean", "sean@mail.com")

    println(cus1 == cus2)
    println(cus1.equals(cus2))
    println("${cus1.hashCode()}, ${cus2.hashCode()}")


    // 객체 디스트럭쳐 1
    val (name, email) = cus1
    println("name : $name, email : $email")

    // 객체 디스트럭쳐 2 - 첫번째 프로퍼티 제외
    val (_, email1) = cus1
    println("email : $email1")


}