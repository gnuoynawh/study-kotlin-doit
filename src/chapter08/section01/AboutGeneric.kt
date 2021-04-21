package chapter08.section01

/*
    제네릭
        - 클래스 내부에서 사용할 자료형을 나중에 인스턴스를 생성할 때 확정
        - 객체의 자료형을 컴파일할대 체크하기 때문에 객체 자료형의 안정성을 높이고 형 변환의 번거로움이 줄어듬
        - 형식 매개변수 종류
            E   : 요소 element
            K   : 키 key
            N   : 숫자 number
            T   : 형식 type
            V   : 값 value
            S, U, V etc. : 두번째, 세번째, 네번째 형식

        - 제네릭의 형식 매개변수는 기본적으로 null 을 허용
            null 을 사용하고 싶지 않다면 <T: Any> 로 작성
 */

class Box<T>(t: T) {    // 형식 매개변수로 받은 인자를 name 에 저장
    var name = t
}

fun main() {
    val box1: Box<Int> = Box(1)
    val box2: Box<String> = Box("Hello")
    println(box1.name)
    println(box2.name)
}