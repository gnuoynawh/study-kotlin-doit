package chapter08.section01.reified

/*
    - reifeid
        - '구체화된' 이라는 뜻
        - inline 함수에서만 사용가능
    -
        - T 자료형은 실행시간에 삭제되기 때문에 T 자체에 그대로 접근할 수 없음..
        - 함수의 매개변수를 넣어 c:Class<T> 처럼 지정해야만 접근가능..
        - reified T 자료형은 컴파일러가 복사해 넣을때 실제 자료형을 알수 있으므로 실행시간에도 사용가능.

 */

// 일반인 제네릭 함수
fun <T> myGenericFunc(c: Class<T>) {}

// reified 사용 예제
inline fun <reified T> myGenericFun() {}
