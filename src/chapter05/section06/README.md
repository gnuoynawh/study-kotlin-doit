### Section 06 클래스와 클래스의 관계
    
<br>

#### AssociationTest.kt (연관관계)

- 연관관계
    - 2개의 서로 분리된 클래스가 연결을 가지는 것
    - 단방향, 양방향

- 예제
    ~~~ kotlin  
    // 연관관계
    class Patient1(val name: String) {
    
        fun doctorList(d: Doctor1) {  // 인자로 참조
            println("Patient: $name, Doctor: ${d.name}")
        }
    }
    
    class Doctor1(val name: String) {
        fun patientList(p: Patient1) { // 인자로 참조
            println("Doctor: $name, Patient: ${p.name}")
        }
    }
    
    fun main() {
        val doc1 = Doctor1("KimSabu")
        val patient1 = Patient1("Kildong")
        doc1.patientList(patient1)
        patient1.doctorList(doc1)
    }
    ~~~
- 결과
    ~~~
    Doctor: KimSabu, Patient: Kildong
    Patient: Kildong, Doctor: KimSabu
    ~~~
<br>

#### DependencyTest.kt (의존관계)

- 의존관계
    - 한 클래스가 다른 클래스에 의존되어 있어 영향을 주는 경우

- 예제
    ~~~ kotlin
    // 의존관계
    class Patient(val name: String, var id: Int) {
        fun doctorList(d: Doctor) {
            println("Patient: $name, Doctor: ${d.name}")
        }
    }
    
    class Doctor(val name: String, val p: Patient) {
        val customerId: Int = p.id
    
        fun patientList() {
            println("Doctor: $name, Patient: ${p.name}")
            println("Patient Id: $customerId")
        }
    }
    
    fun main() {
        val patient1 = Patient("Kildong", 1234)
        val doc1 = Doctor("KimSabu", patient1)
        doc1.patientList()
    }
    ~~~
- 결과
    ~~~
    Doctor: KimSabu, Patient: Kildong
    Patient Id: 1234
    ~~~
    
<br>

#### AggregationTest.kt (집합관계)

- 집합관계
    - 연관 관계와 거의 동일하지만 특정 객체를 소유한다는 개념이 추가

- 예제
    ~~~ kotlin
    // 집합관계
    // 여럿의 오리를 위한 List 매개변수
    class Pond(_name: String, _members: MutableList<Duck>) {
        val name: String = _name
        val members: MutableList<Duck> = _members
        constructor(_name: String): this(_name, mutableListOf<Duck>())
    }
    
    class Duck(val name: String)
    
    fun main() {
    
        // 두 개체는 서로 생명주기에 영향을 주지 않는다.
        val pond = Pond("myFavorite")
        val duck1 = Duck("Duck1")
        val duck2 = Duck("Duck2")
    
        // 연못에 오리를 추가 - 연못에 오리가 집합한다
        pond.members.add(duck1)
        pond.members.add(duck2)
    
    
        // 연못에 있는 오리들
        for (duck in pond.members) {
            println(duck.name)
        }
    }
    ~~~
- 결과
    ~~~
    Duck1
    Duck2
    ~~~

<br>

#### CompositionTest.kt (구성관계)

- 구성관계
    - 집합 관계와 거의 동일 하지만 특정 클래스가 어느 한 클래스의 부분이 되는 것
    - 생명주기가 소유 클래스에 의존되어 있어, 소유 클래스가 삭제되면 구성 클래스도 삭제된다.

- 예제
    ~~~ kotlin
    // 구성 관계
    class Car(val name: String, val power: String) {
    
        private var engine = Engine(power) // Engine클래스 객체는 Car에 의존적이다
    
        fun startEngine() = engine.start()
        fun stopEngine() = engine.stop()
    }
    
    class Engine(power: String) {
        fun start() = println("Engine has been started.")
        fun stop() = println("Engine has been stopped.")
    }
    
    fun main() {
        val car = Car("tico", "100hp")
        car.startEngine()
        car.stopEngine()
    }
    ~~~
- 결과
    ~~~
    Engine has been started.
    Engine has been stopped.
    ~~~ 