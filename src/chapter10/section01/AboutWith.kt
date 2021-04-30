package chapter10.section01


/*
    코틀린 표준 라이브러리(5) - with()

        - 인자로 받는 객체를 이어지는 block의 receiver로 전달하며 결과값을 반환합니다.
        - run()함수와 기능이 거의 동일한데, run의 경우 receiver가 없지만 with()에서는 receiver로 전달할 객체를 처리합니다
        - with는 세이프 콜(?.)은 지원하지 않기 때문에 다음과 같이 let과 같이 사용되기도 합니다.
        - 표준 함수의 정의
            public inline fun <T, R> with(receiver: T, block: T.() -> R): R  = receiver.block()

ex)
    supportActionBar?.let {
        with(it) {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_clear_white)
        }
    }

    supportActionBar?.run {
        setDisplayHomeAsUpEnabled(true)
        setHomeAsUpIndicator(R.drawable.ic_clear_white)
    }값
 */

fun main() {

    data class User(var name: String, var skills: String, var email: String? = null)
    val user = User("killdong", "default")

    // run 하고 비슷하지만
    // 객체 넘겨받는 위치가 다름..
    // 파라미터로 받은 user 를 내부에서 this 로 받는다.
    var result = with(user) {
        this.skills = "kotlin"
        email = "killdong@example.com"  // this 생략
        "success"       // 반환
    }

    println(user)
    println("result = $result")

}