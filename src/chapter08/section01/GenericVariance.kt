package chapter08.section01


/*
    - 가변성 variance
        - 가변성이란? 형식 매개변수가 클래스 계층에 영향을 주는 것..
        - 형식 A 의 값이 필요한 모든 클래스에 형식 B 의 값을 넣어도 아무 문제가 없다면, B 는 A 의 하위형식 (sub type) 이 된다.
          ex) Int 는 Number 의 하위형식

    - 클래스와 자료형
        - String  : 클래스 o | 자료형 o
        - String? : 클래스 x | 자료형 o
        - List    : 클래스 o | 자료형 o
        - List<String> :  : 클래스 x | 자료형 o

    - 가변성의 유형
        - 공변성
            - T' 가 T 의 하위 자료형이면, C<T'> 는 C<T> 의 하위 자료형이다.
            - 생산자 입장의 out 성질
        - 반공병성
            - T' 가 T 의 하위 자료형이면, C<T> 는 C<T'> 의 하위 자료형이다.
            - 생산자 입장의 in 성질
        - 무병성 :
            - C<T> 와 C<T'> 는 아무 관계가 없다.
            - 생산자 + 소비자

 */

// 무변성
// 형식 매개변수에 in, out 등을 따로 지정하지 않을 경우 무변성으로 제네릭 클래스가 선언된다.
class Box1<T>(val size: Int)

// 공변성
// - 형식 매개변수의 상하 자료형 관계가 성립하고, 그 관계가 인스턴스 자료형으로 이어지는 경우 공변성이라고 한다.
//   ex) Int 가 Any 의 하위 자료형일때, 형식 매개변수 T 는 공변적이라고 한다. 이때 out 키워드 사용
class Box2<out T>(val size: Int)

// 반공변성
// - 공변성과 상하관계가 반대가 되면
//   ex) Int 가 Nothing 의 상위 자료형일때, 형식 매개변수 T 는 반공변적이라고 한다. 이때 in 키워드 사용
class Box3<in T>(val size: Int)

fun main() {

    // 자료형의 상하관계 Nothing < Int < Any

    // 1. 무변성 테스트
    // val anys1: Box1<Any> = Box1<Int>(10) // 자료형 불일치 오류!
    // val nothings1: Box1<Nothing> = Box1<Int>(10) // 자료형 불일치 오류!

    // 2. 공변성 테스트
    val anys2: Box2<Any> = Box2<Int>(10) // 공변성
    // val nothings2: Box2<Nothing> = Box2<Int>(10) // 자료형 불일치 오류!

    // 3. 공변성 테스트
    // val anys3: Box3<Any> = Box3<Int>(10) // 자료형 불일치 오류!
    val nothings3: Box3<Nothing> = Box3<Int>(10) // 반공변성
}


