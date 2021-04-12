package chapter06.section02

import kotlin.properties.Delegates

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