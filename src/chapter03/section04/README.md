### Section 03

#### ReentrantLock.kt (동기화를 위한 코드구현)

- 공유자원에 함수가 접근할 때 동기화를 위함... 

    - 예시
    
        ~~~ kotlin
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
        ~~~
    - 결과
    
        ~~~ 
        4
        ~~~

<br>
