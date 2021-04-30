package chapter10.section01

import java.io.BufferedReader
import java.io.FileOutputStream
import java.io.FileReader
import java.io.PrintWriter

/*
    코틀린 표준 라이브러리(6) - use()

        - 보통 특정 객체가 사용된 후 닫아야 하는 경우가 생기는데 이때 use()를 사용하면
          객체를 사용한 후 close() 등을 자동적으로 호출해 닫아 줄 수 있습니다.

        - 표준 함수의 정의
            public inline fun <T : Closeable?, R> T.use(block: (T) -> R): R
            public inline fun <T : AutoCloseable?, R> T.use(block: (T) -> R): R (JAVA 7 이후)

 */

fun main() {
    PrintWriter(FileOutputStream("d:\\test\\output.txt")).use {
        it.println("hello")
    }

}

private fun readFirstLine(): String {
    BufferedReader(FileReader("test.file")).use { return it.readLine() }
}