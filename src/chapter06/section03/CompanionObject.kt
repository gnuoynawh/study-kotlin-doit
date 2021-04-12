package chapter06.section03

class Person3 {
    var id: Int = 0
    var name: String = "Youngdeok"
    companion object {
        var language: String = "Korean"
        fun work() {
            println("working...")
        }
    }
}

class KCustomer {
    companion object {
        const val LEVEL = "INTERMEDIATE"
        @JvmStatic fun login() = println("Login...")
    }
}

fun main() {
    println(Person3.language)       // 객체 생성 안하고 호출
    Person3.language = "English"    // 기본값 변경가능
    println(Person3.language)       // 변경된 내용 출력
    //println(Person3.name)           // companion 이 아니기 때문에 에러

    val p3 = Person3()
    println(p3.name)        // companion 이 아니므로 객체 생성 후 호출
}