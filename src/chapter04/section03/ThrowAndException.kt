package chapter04.section03

import java.lang.ArithmeticException
import java.lang.Exception

fun main() {
    val a = 6
    val b = 0
    val c: Int

    try {
        c = a / b
    } catch (e : ArithmeticException) {
        println("Exception is handled. ${e.message}")   // 특정 예외처리
    } catch (e : Exception) {
        e.printStackTrace()     // 스택 추적
        println(e.message)      // 메시지 출력
    } finally {
        println("finally 블록은 반드시 항상 실행됨")
    }

    /*
        사용자 예외처리 클래스
     */
    val name: String = "test1234"
    try {
        validateName(name)
    }catch (e : InvalidNameException) {
        println(e.message)
    }finally {
        println("finally 사용자 예외 클래스 끝")
    }
}

// 사용자 예외 클래스 만들어보기
class InvalidNameException(message: String) : Exception(message)

fun validateName(name: String) {
    if(name.matches(Regex(".*\\d+."))) { // 이름에 숫자가 포함되어있는지 확인
        throw InvalidNameException("Your Name : $name : contains numerals.")
    }
}