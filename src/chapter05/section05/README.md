### Section 05 정보 은닉 캡슐화

<br>

#### UsePrivate.kt ()

- 가시성 지시자
    - private : 외부에서 접근 불가
    - public : 어디서든 접근 가능 (기본)
    - protected : 외부에서 접근할 수 없음, 하위 상속요소에서 가능
    - internal : 같은 정의의 모듈 내부에서는 접근이 가능
    
- 예제
    ~~~ kotlin
    fun main() {
        val pc = PrivateClass() // 생성 가능
        // 접근 불가
        //pc.i
    
        // 접근 불가
        //pc.privateFunc()
    }
    
    private class PrivateClass {
        private var i = 1
        private fun privateFunc() {
            i += 1 // 접근 허용
        }
        fun access() {
            privateFunc() // 접근 허용
        }
    }
    
    class OtherClass {
    
        // 불가 - 프로퍼티 opc는 private이 되야 함
        //val opc = PrivateClass()
        fun test() {
            val pc = PrivateClass() // 생성 가능
        }
    }
    
    fun TopFunction() {
        val tpc = PrivateClass() // 객체 생성 가능
    }
    ~~~

<br>

#### UseProtected.kt ()

- 최상위 클래스에는 protected 를 사용할 수 없음.
- 상속된 하위 클래스에서만 접근 가능.
- 외부 클래스나 객체 생성 후 점`.` 표기를 통해 접근을 허용하지않음.

- 예제
~~~ kotlin
open class Base1 {
    // 이 클래스에서는 a, b, c, d, e 접근 가능
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4  // 가시성 지시자 기본값은 public

    protected class Nested {
        // 이 클래스에서는 a, b, c, d, e, f 접근 가능
        public val e: Int = 5 // public 생략 가능
        private val f: Int = 6
    }
}

class Derived : Base1() {
    // 이 클래스에서는 b, c, d, e 접근 가능
    // a 는 접근 불가
    override val b = 5   // Base의 'b' 는 오버라이딩됨 - 상위와 같은 protected 지시자
}

class Other(base: Base1) {
    // base.a, base.b는 접근 불가
    // base.c와 base.d는 접근 가능(같은 모듈 안에 있으므로)
    // Base.Nested는 접근 불가, Nested::e 역시 접근 불가
}
~~~

<br>

#### UseInternal.kt 

- `internal`은 프로젝트 단위의 모듈을 가리키기도 한다.
- 자바에서는 `패키지` 내부에서 접근가능 했으나,  
  코틀린에서는 `모듈` 단위로 접근가능
  
- 예제
~~~ kotlin
internal class InternalClass {
    internal var i = 1
    internal fun icFunc() {
        i += 1 // 접근 허용
    }
    fun access() {
        icFunc() // 접근 허용
    }
}

class Other {
    internal val ic = InternalClass() // 프로퍼티 지정시 internal로 맞춰야 한다.
    fun test() {
        ic.i  // 접근 허용
        ic.icFunc() // 접근 허용
    }
}

fun main() {
    val mic = InternalClass() // 생성 가능
    mic.i // 접근 허용
    mic.icFunc() // 접근 허용
}
~~~