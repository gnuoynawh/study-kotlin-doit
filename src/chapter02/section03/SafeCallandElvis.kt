package chapter02.section03

fun main() {

    // 세이프콜 ?
    val str1: String? = null
    println("str1 = $str1, str1.lengh = ${str1?.length}")

    // 단정기호 !!
    val str2: String? = "Hello Kotlin"
    println("str2 = $str2, str2.lengh = ${str2!!.length}")

    // 엘비스 연산자 ?:
    var str3: String? = "Hello Kotlin"
    println("str3 = $str3, str3.lengh = ${str3?.length ?: -1}")

    var str4 : String?
    str4 = null
    println("str4 = $str4, str4.length: ${str4?.length ?: -1}")
}