package chapter01.section03

/*
NULL
        : 코틀린은 기본적으로 null 허용하지 않음. NPE 발생함
        : null 을 허용하지 위해서는 ? 를 붙인다.
        : 변수의 함수를 사용할때
 */

fun main() {

    // 오류! null 을 허용하지 않는다.
/*
    // NPE 발생
    var str1: String = "Hello Kotlin"
    str1 = null
    println("str1 = $str1")

    // NPE 발생
    val str2: String = null
    println("str2 = $str2, str2.lengh = ${str2.length}")
*/

    // Null 허용
    var str1: String? = "Hello Kotlin"
    str1 = null
    println("str1 = $str1")

}