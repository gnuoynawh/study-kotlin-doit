### Section 03 상속과 다형석

<br>

#### OpenClass.kt (상속)

- 상속
   
    - 최상위 클래스는 `Any` 이다.
    - 묵시적으로 `Any`부터 상속한다.
    - 부모클래스의 앞에 `open` 키워드를 붙인다.
    - 상속 기본형식  
        ~~~
        class 자식(파생)클래스: 부모(기반)클래스() {
            ...
        } 
        ~~~

- 예제
    ~~~ kotlin
    // 묵시적으로 any 부터 상속, open 키워드로 상속/파생 가능
    open class Bird(var name: String, var wing: Int, var beak: String, var color: String) {
        fun fly() = println("Fly wing : $wing")
        fun sing(vol: Int) = println("Sing vol : $vol")
    }
    
    // 기반 클래스를 상속함, 최종 클래스로 상속/파생 불가
    // 주 생성자를 사용하는 상속
    class Lark(name: String, wing: Int, beak: String, color: String) : Bird(name, wing, beak, color) {
    
        // 새로 추가한 메서드
        fun singHitone() = println("Happy Song!")
    }
    
    // 부 생성자를 사용하는 상속
    class Parrot: Bird {
        val language: String
    
        // 부생성자
        constructor(name: String, wing: Int, beak: String, color: String, language: String) : super(name, wing, beak, color) {
            this.language = language
        }
    
        fun speak() = println("Speak! $language")
    }
    
    fun main() {
    
        val coco = Bird("mybird", 2, "short", "blue")
        val lark = Lark("mylark", 2, "long", "brown")
        val parrot = Parrot("myparrot", 2, "short", "multiple", "korean")
    
        println("coco : ${coco.toString()}")
        println("lark : ${lark.toString()}")
        println("parrot : ${parrot.toString()}")
    
        lark.singHitone()
        parrot.speak()
        lark.fly()
    
    }
    ~~~
- 결과
    ~~~
    coco : chapter05.section03.Bird@355da254
    lark : chapter05.section03.Lark@4dc63996
    parrot : chapter05.section03.Parrot@d716361
    Happy Song!
    Speak! korean
    Fly wing : 2
    ~~~
  
<br>

#### OpenClass.kt (다형성)

- 다형성
    - 오버라이딩 (overriding) - 기능을 완전히 다르게 바꾸어 재설계
    - 오버로딩 (overloading) - 기능은 같지만 인자를 다르게 하여 여러 경우를 처리
    - 키워드
        - open : 클래스/함수를 상속, 파생할 수 있음을 지정
        - override : open 함수를 오버라이딩
        - final : 하위클래스에서 재정의 불가

- 예제
    ~~~ kotlin
    // 상속 가능한 클래스를 위해 open 사용
    open class Bird1(var name: String, var wing: Int, var beak: String, var color: String) {
    
        // 메서드
        fun fly() = println("Fly wing: $wing")
    
        // 오버라이딩 가능한 메서드
        open fun sing(vol: Int) = println("Sing vol: $vol")
    }
    
    open class Lark1(name: String, wing: Int, beak: String, color: String) : Bird1(name, wing, beak, color) {
    
        // final 키워드로 하위 클래스에서 재정의를 막음
        final override fun sing(vol: Int) {
            // 구현부 새롭게 정의
        }
    }
    
    class Parrot1(name: String,
                  wing: Int = 2,
                  beak: String,
                  color: String, // 마지막 인자만 var로 선언되어 프로퍼티가 추가되었음을 알 수 있다.
                  var language: String = "natural") : Bird1(name, wing, beak, color) {
    
        // Parrot에 추가된 메서드
        fun speak() = println("Speak! $language")
    
        // 오버라이딩된 메서드
        override fun sing(vol: Int) {
            println("I'm a parrot! The volume level is  $vol")
    
            // 달라진 내용!
            speak()
        }
    }
    
    fun main() {
        val parrot = Parrot1(name = "myparrot", beak = "short", color = "multiple")
        parrot.language = "English"
    
        println("Parrot: ${parrot.name}, ${parrot.wing}, ${parrot.beak}, ${parrot.color}, ${parrot.language}")
        parrot.sing(5) // 달라진 메서드 실행 가능
    
        val calc = Calc()
        println(calc.add(3, 2))
        println(calc.add(3.2, 1.3))
        println(calc.add(3, 3, 2))
    }
    
    class Calc {
        fun add(x: Int, y: Int): Int {
            return x + y
        }
    
        fun add(x: Double, y: Double): Double {
            return x + y
        }
    
        fun add(x: Int, y: Int, z: Int): Int {
            return x + y + z
        }
    }
    ~~~
- 결과
    ~~~
    Parrot: myparrot, 2, short, multiple, English
    I'm a parrot! The volume level is  5
    Speak! English
    5
    4.5
    8
    ~~~