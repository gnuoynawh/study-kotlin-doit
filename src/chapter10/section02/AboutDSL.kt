package chapter10.section02

data class Person(var name: String? = null, var age: Int? = null, var job: Job? = null)
data class Job(var category: String? = null, var position: String? = null, var extension: Int? = null)

// 1. Person 을 받는 람다식을 매개변수로 받으며, Person 을 반환
fun person1(block: (Person) -> Unit): Person {
    val p = Person()
    block(p)
    return p
}

// 2. Person 의 확장함수를 람다식으로 받으며, Person을 반환
fun person2(block: Person.() -> Unit): Person {
    val p = Person()
    p.block()
    return p
}

// 3. apply 를 통해서 this 를 반환하므로 person 을 반환
fun person3(block: Person.() -> Unit): Person = Person().apply(block)


fun Person.job(block: Job.() -> Unit) {
    job = Job().apply(block)
}

fun main() {

    /*
        DSL
            Domain-Specific Language
            범용언어와 다르게 특정 상황에 특화된 언어
            ex) 데이터베이스에 접근하기 위한 SQL 등...

     */

    // 1 번으로 했을 경우 it 으로 접근가능
    val p1 = person1 {
        it.name = "Kildong"
        it.job {
            category = "IT"
            position = "Android Developer"
            extension = 1234
        }
    }

    // 2 번으로 했을 경우 this 로 접근가능.
    val p2 = person2 {
        this.name = "Kildong"
        job {
            category = "IT"
            position = "Android Developer"
            extension = 1234
        }
    }

    // 3 번으로 했을 경우 this 로 접근가능.
    val p3 = person3 {
        name = "Kildong"
        age = 40
        job {
            category = "IT"
            position = "Android Developer"
            extension = 1234
        }
    }

    println(p3)
}
