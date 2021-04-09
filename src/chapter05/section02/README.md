### Section 02 생성자

<br>

#### SecondaryConstructor.kt (부생성자)

- 예제
    ~~~ kotlin
    // 1. 부생성자
    class Bird1 {
        var name: String
        var wing: Int
        var beak: String
        var color: String
    
        // 부생성자
        /*constructor(name: String, wing: Int, beak: String, color: String) {
            this.name = name
            this.wing = wing
            this.beak = beak
            this.color = color
        }*/
    
        // 부생성자 이름이 다른 스타일
        constructor(_name: String, _wing: Int, _beak: String, _color: String) {
            name = _name
            wing = _wing
            beak = _beak
            color = _color
        }
    
        fun fly() = println("fly wing: $wing")
        fun sing(vol: Int) = println("Sing vol: $vol")
    }
    
    // 주 생성자가 없고 여러개의 보조 생성자를 가진 클래스
    class Bird2 {
        // 프로퍼티들
        var name: String
        var wing: Int
        var beak: String
        var color: String
    
        // 부 생성자 1
        constructor(_name: String, _wing: Int, _beak: String, _color: String) {
            name = _name
            wing = _wing
            beak = _beak
            color = _color
        }
    
        // 부 생성자 2
        constructor(_name: String, _beak: String) {
            name = _name
            wing = 2
            beak = _beak
            color = "grey"
        }
    
        // 메서드들
        fun fly() = println("Fly wing: $wing")
        fun sing(vol: Int) = println("Sing vol: $vol")
    }
    ~~~

<br>

#### PrimaryConstructor.kt (주생성자)

- 예제
    ~~~ kotlin
    // 1. 주 생성자 - constructor 생략가능
    class Bird3 (_name: String, _wing: Int, _beak: String, _color: String) {
        var name: String = _name
        var wing: Int = _wing
        var beak: String = _beak
        var color: String = _color
    
        fun fly() = println("fly wing: $wing")
        fun sing(vol: Int) = println("Sing vol: $vol")
    }
    
    // 2. 주 생성자 생략된 표현법 - 프로퍼티를 매개변수로 이미 선언
    class Bird4 (var name: String, var wing: Int, var beak: String, var color: String) {
        fun fly() = println("fly wing: $wing")
        fun sing(vol: Int) = println("Sing vol: $vol")
    }
    
    // 3. 초기화 블럭, 기본값을 가진 클래스
    class Bird5 (var name: String = "NONAME", var wing: Int = 2, var beak: String, var color: String) {
    
        // 초기화 블럭
        init {
            println("------------ start of init ------------")
            println("The name is $name, The beak is $beak")
            this.sing(3)
            println("------------ end of init ------------")
        }
    
        fun fly() = println("fly wing: $wing")
        fun sing(vol: Int) = println("Sing vol: $vol")
    }
    ~~~
