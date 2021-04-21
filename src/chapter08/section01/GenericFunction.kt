package chapter08.section01

/*
    제네릭 함수/메서드
        - 사용
            fun <형식매개변수[...]> 함수 이름(매개변수 : <매개변수자료형>[,...]) : <반환자료형>
 */

// 사용예시 1
// 매개변수와 반환 자료형에 형식 매개변수 T가 사용됨
fun <T> genericFunc(arg: T): T? { return null }

// 사용예시 2
// 형식 매개변수가 여러 개인 경우
fun <K, V> put(key: K, value: V): Unit { }

// 제네릭 함수
fun <T> find(a: Array<T>, Target: T) : Int {
    for(i in a.indices) {
        if(a[i] == Target) return i
    }
    return -1
}

fun main() {

    val arr1: Array<String> = arrayOf("Apple", "Banana", "Cherry", "Durian")
    val arr2: Array<Int> = arrayOf(1, 2, 3, 4)

    println("arr.indices ${arr1.indices}")          // indices 는 배열의 유효범위 반환
    println(find<String>(arr1, "Cherry"))   // 요소 C 의 인덱스 찾아내기
    println(find(arr2, 2))                  // 요소 2 이 인덱스 찾아내

}