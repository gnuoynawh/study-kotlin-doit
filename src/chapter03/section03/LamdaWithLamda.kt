package chapter03.section03

fun main() {

    twoLamda({a, b -> "Fisrt $a, $b"}, {"Second $it"})

    // 위와 동일
    twoLamda({a, b -> "Fisrt $a, $b"}) {"Second $it"}
}

fun twoLamda(first: (String, String) -> String, second: (String) -> String) {
    println(first("OneParam", "TwoParam"))
    println(second("OenParam"))
}