package chapter02.section02

fun main() {

    // 문자열 표기
    val c = 1
    val str1 = "c = $c"
    val str2 = "c = ${c + 2}"
    val str3 = "c = ${c.toByte()}"
    println("str1 = \"$str1\", str2 = \"$str2\", str3 = \"$str3\"")

    // 특수문자 표현
    println("특수문자 표현하기 => ${'"'}${'$'}9.99${'"'}")

    // 입력 내용 그대로 출력
    val num = 10
    val formatter =
    """
       var a = 6
       var b = "Kotlin"
       println(a + num)     //num 값은 $num
    """
    println(formatter)
}