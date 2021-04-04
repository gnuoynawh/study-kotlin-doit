package chapter01.section02

fun main() {

    var str1: String = "Hello"
    var str2 = "World"
    var str3 = "Hello"

    //값 비교
    println("str1 == str2 : ${str1 == str2}")
    println("str1 == str3 : ${str1 == str3}")

    //참조 비교
    println("str1 === str2 : ${str1 === str2}")
    println("str1 === str3 : ${str1 === str3}") // StringPool 이라는 공간에 문자열을 저장해두고 str1, str3이 같이 참조하도록 생성


    val a: Int = 128
    val b = a
    val c: Int? = a
    val d: Int? = a
    val e: Int? = c

    // a 를 b 에다가 넣기 때문 true
    println(a === b)

    // 값의 내용만 비교하는 경우 동일하므로 true
    println(c == d)

    // 값의 내용은 같지만 참조 주소를 참조하자면 다른 객체이므로 false
    println(c === d)

    // 값의 내용도 같고, 참조 주소도 같으므로 true
    println(c === e)
}