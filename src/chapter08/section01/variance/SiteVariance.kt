package chapter08.section01.variance

/*
    - 자료형 프로젝션
        - 가변성의 2가지 사용방법
            - 선언 지점 변성 (declaration-site variance)
                : 클래스를 선언하면서 클래스 자체에 가변성을 지정
            - 사용 지점 변성 (use-site variance)
                : 메서드 매개변수에서 또는 제네릭 클래스를 생성할 때와 같이 사용위치에서 가변성을 지정

        - 스타 프로젝션
            - 자료형에 * 를 지정하는 방법을 스타프로젝션이라고 한다.
            - Box<Any?> 가 되면 모든 자료형의 요소를 담을 수 있음을 의미
            - Box<*> 은 어떤 자료형이라도 들어올 수 있으나 구체적으로 자료형이 결정되면 그 자료형과 하위 자료형의 요소만 담을 수 있도록 제한
 */

open class Animal1(val size: Int) {
    fun feed() = println("Feeding...")
}

// 선언지점
class Boxx1<T: Animal1>(var item: T)


// 사용지점
class Boxx2<T>(var item: T)

fun <T> printObj(box: Boxx2<out Animal>) {
    val obj: Animal = box.item
    println(obj)
}


// 스타 프로젝션
class InOutTest<in T, out U>(t: T, u: U) {
    // val propT: T = t // T 는 in 위치이기 때문에 사용불가. 오류!
    val propU: U = u

    // fun func1(u: U) // U 는 out 위치이기 때문에 사용불가. 오류!
    fun func2(t: T) {
        print(t)
    }
}

// in 으로 정의된 형식 매개변수를 *로 받으면 in Nothing 으로 간주
// out 으로 정의된 형식 매개변수를 *로 받으면 out Any? 으로 간주
fun startTestFunc(v: InOutTest<*,*>) {
    // v.func2(1)  // Nothing 으로 인자를 처리하여 오류!
    print(v.propU)
}