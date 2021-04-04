package chapter01.section03

fun main() {

    // 세이프콜 - 값이 null 일 경우 length 는 실행되지 않고 NPE 를 발생한다.
    // 이때 ? 를 붙여서 세이프콜을 하면 NPE가 발생하지 않고 null 을 return
    val str1: String? = null
    println("str1 = $str1, str1.lengh = ${str1?.length}")

    // 단정기호 !!
    // null 이 아님을 단정하므로 컴파일러가 null 검사 없이 무시한다.
    // null 일지라도 컴파일이 진행되며 실행중 NPE 가 발생한다.
    // null 이 아님이 보장될 때만 사용
    val str2: String? = "Hello Kotlin"
    println("str2 = $str2, str2.lengh = ${str2!!.length}")

    // 엘비스 연산자 ?:
    // null 일 경우 리턴할 값 지정을 위해 사용
    // null 일 경우 ?: 뒤에 지정한 값을 리턴
    var str3: String? = "Hello Kotlin"
    println("str3 = $str3, str3.lengh = ${str3?.length ?: -1}")

    var str4 : String?
    str4 = null
    println("str4 = $str4, str4.length: ${str4?.length ?: -1}")
}