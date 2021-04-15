package chapter07.section02


/*
    실드 클래스
        - 봉인된 이라는 의미로 무언가 안전하게 보관하기 위해 묶어 두는 것
        - sealed 키워드를 class 와 함께 사용
        - 추상클래스와 같기 때문에 객체를 만들 수 없다
        - 생성자도 기본적으로 private
        - 실드 클래스는 같은 파일 안에서는 상속이 가능 (다른 파일에서는 불가)
        - 블록 안에서 선언되는 클래스는 상속이 필요한 경우 open 키워드로 선언
 */

// 실드 클래스 생성 1
sealed class Result {
    open class Success(val message: String): Result()
    class Error(val code: Int, val message: String): Result()
}
class Status : Result() // 실드 클래스 상속은 같은 파일내에서만 가능
class Inside : Result.Success("Status") // 내부 클래스 상속

/*
    // 실드 클래스 생성 2
    sealed class Result
    open class Success(val message: String): Result()
    class Error(val code: Int, val message: String): Result()

    class Status : Result()
    class Inside : Success("Status")
 */

fun main() {
    val result = Result.Success("Good!")
    val msg = eval(result)
    println(msg)

    val result1 = Result.Error(10, "No disk")
    println(eval(result1))
}

fun eval(result : Result) : String = when(result) {
    is Status -> "in progress"
    is Result.Success -> result.message
    is Result.Error -> result.message
}