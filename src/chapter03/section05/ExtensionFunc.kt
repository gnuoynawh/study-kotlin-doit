package chapter03.section05

fun main() {
    val source = "Hello World"
    val target = "Kotlin"
    println(source.getLongString(target))
    println("Hello World".getLongString("Kotlin"))
}

// 확장함수
fun String.getLongString(target: String): String =
        if(this.length > target.length) this else target
