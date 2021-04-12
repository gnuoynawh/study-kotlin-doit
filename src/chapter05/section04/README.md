### Section 04 super 와 this 의 참조

<br>

#### SuperAndThis.kt (super, this)

- super
    - super.프로퍼티이름 - 상위클래스의 프로퍼티 참조
    - super.메서드이름() - 상위클래스의 메서드 참조
    - super() - 상위클래스 생성자 참조

- this
    - this.프로퍼티이름 - 현재클래스의 프로퍼티 참조
    - this.메서드이름() - 현재클래스의 메서드 참조
    - this() - 현재클래스 생성자 참조
 
- 예제
    ~~~ kotlin
    // 부모 클래스
    open class Person {
        
        constructor(firstName: String) {
            println("[Person] firstName: $firstName")
        }
        
        constructor(firstName: String, age: Int) { // ③
            println("[Person] firstName: $firstName, $age")
        }
    }
    
    // 자식 클래스
    class Developer: Person {
    
        // this 로 다른 부생성자를 실행
        constructor(firstName: String): this(firstName, 10) { // ①
            println("[Developer] $firstName")
        }
        
        // super 로 부모 클래스의 부생성자를 상속받는다. 
        constructor(firstName: String, age: Int): super(firstName, age) { // ②
            println("[Developer] $firstName, $age")
        }
    }
    
    fun main() {
        val sean = Developer("Sean")
    }
    ~~~
- 결과 
    ~~~
    [Person] firstName: Sean, 10
    [Developer] Sean, 10
    [Developer] Sean
    ~~~
  
<br>

#### InnerClass.kt (이너클래스)
- 이너클래스 : 클래스 안에 다시 클래스를 선언하는 것
- 바깥클래스의 상위 클래스를 호출할 경우 `super` 키워드와   
  `@` 기호옆에 바깥 클래스 이름을 작성
  
- 예제
    ~~~ kotlin
    fun main() {
        val c1 = Child()
        c1.Inside().test()
    }
    
    open class Base {
        open val x: Int = 1
        open fun f() = println("Base Class f()")
    }
    
    class Child : Base() {
        override val x: Int = super.x + 1
        override fun f() = println("Child Class f()")
    
        inner class Inside {
            fun f() = println("Inside Class f()")
            fun test() {
                f() // Inside 클래스의 f() 접근
                Child().f() // Child 클래스의 f() 접근
                super@Child.f() // Child 의 상위클래스인 Base 클래스의 f() 접근
                println("[Inside] super@Child.x : ${super@Child.x}")
            }
        }
    }
    ~~~
- 결과
    ~~~
    Inside Class f()
    Child Class f()
    Base Class f()
    [Inside] super@Child.x : 1
    ~~~
  
<br>

#### Interface.kt (인터페이스)
- 인터페이스는 일종의 `구현 약속`으로 클래스는   
  인터페이스가 가진 내용을 구현해야한다 라는 가이드를 제시
- 코틀린은 자바와 같이 2개 이상의 상속을 받는 `다중상속이 불가`하다.
- 프로퍼티나 메서드의 이름이 동일할 경우 `<>` 에 클래스이름을 추가해서 구분해준다.

- 예제
    ~~~ kotlin
    fun main() {
        val c = C()
        c.test()
    }
    
    open class A {
        open fun f() = println("A class f()")
        fun a() = println("A class a()")
    }
    
    interface B {
        fun f() = println("B interface f()")
        fun b() = println("B interface b()")
    }
    
    // , 를 사용해서 클래스와 인터페이스를 지정
    class C : A() , B {
    
        // 컴파일 되려면 f() 가 오버라이딩 되어야 함
        override fun f() = println("C class f()")
    
        fun test() {
            f() // 현재 클래스의 f()
            b() // 인터페이스 B의 b()
            super<A>.f()    // A 의 f()
            super<B>.f()    // B 의 f()
        }
    }
    ~~~
- 결과
    ~~~
    C class f()
    B interface b()
    A class f()
    B interface f()
    ~~~