package chapter03.section04

import java.util.concurrent.locks.ReentrantLock

fun main() {

    // 공유자원 접근 코드 제어
    val reLock = ReentrantLock()

    // 3가지 전부 동일한 표현식
    lock(reLock, { criticalFunc() })
    lock(reLock) { criticalFunc() }
    lock(reLock, ::criticalFunc)

    println(sharable)

}

// 보호가 필요한 공유자원
var sharable = 1

fun criticalFunc() {
    // 공유자원 접근 코드 사용
    sharable += 1
}

fun <T> lock(reLock: ReentrantLock, body: () -> T): T {
    reLock.lock()   // 공유자원에 접근하는 동안 lock
    try {
        return body()
    }finally {
        reLock.unlock()
    }
}