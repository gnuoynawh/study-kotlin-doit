### Section 01 클래스와 객체의 정의

<br>

#### ClassDefault.kt (클래스의 기본 형태)

- 클래스와 객체의 정의
    - 추상화 : 특정 클래스를 만들 때 기본 형식을 규정하는 방법
    - 인스턴스 : 클래스로부터 생성한 객체
    - 상속 : 부모 클래스의 내용을 자식 클래스가 그대로 물려받음
    - 다형성 : 하나의 이름으로 다양한 처리를 제공
    - 캡슐화 : 내용을 숨기고 필요한 부분만 사용
    - 메시지 전송 : 객체간에 주고받는 메시지
    - 연관 : 클래스 간의 관계

- 용어 정리
    - 클래스 Class : 분류, 범주
    - 프로퍼티 Property : 속성(Attribute), 변수(Variable), 필드(Field), 데이터(Data)
    - 메서드 Method : 함수(Function), 동작(Operation), 행동(Behavior)
    - 객체 Object : 인스턴스(Instance)
- 문법
    ~~~ kotlin
    class Bird {    // (1) 클래스 정의
    
        // (2) 프로퍼티 - 속성
        var name: String = "mybird"
        var wing: Int = 2
        var beak: String = "short"
        var color: String = "blue"
    
        // (3) 메서드 - 함수
        fun fly() = println("fly wing: $wing")
        fun sing(vol: Int) = println("Sing vol: $vol")
    }
    
    
    fun main() {
    
        // (4) 클래스 생성자를 통한 객체생성
        val coco = Bird()
    
        // (5) 객체의 프로퍼티에 값 쓰기
        coco.color = "red"
    
        // (6) 객체의 프로퍼티 가져오기
        println("coco.color: ${coco.color}")
    
        // (7) 객체의 멤버 메서드 사용
        coco.fly()
        coco.sing(5)
    }
    ~~~
- 결과
    ~~~
    coco.color: red
    fly wing: 2
    Sing vol: 5
    ~~~