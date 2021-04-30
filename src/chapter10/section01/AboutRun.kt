package chapter10.section01

/*
    코틀린 표준 라이브러리(4) - run()

        - 인자가 없는 익명 함수처럼 동작하는 형태로 단독 사용하거나 확장 함수 형태로 호출하는 형태 두 가지로 사용할 수 있습니다.
        - 독립적으로 사용할 때는 block에 처리할 내용을 넣어주며 마지막 식이 반환됩니다.
        - 표준 함수의 정의
            public inline fun <R> run(block: () -> R): R  = return block()
            public inline fun <T, R> T.run(block: T.() -> R): R = return block()
        - 할당 없이 사용할 때는 체이닝을 사용해 특정 결과에 대한 메서드를 실행할 수 있습니다.
            run {
                if (firstTimeView) introView else normalView
            }.show()
        - 확장 함수형태로 사용할 때 어떤 요소가 null인경우 다음과 같이 세이프콜을 사용할 수 있습니다.
            obj?.run {
                ...
            }
 */

fun main() {
    val a = 10

    // 마지막 식 반환
    val skills = run {
        val level = "Kotlin Level:" + a
        level // 마지막 표현식이 반환됨
    }
    println(skills)

}