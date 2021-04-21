

- 예제
~~~ kotlin
class Box<T>(t: T) {    // 형식 매개변수로 받은 인자를 name 에 저장
    var name = t
}

fun main() {
    val box1: Box<Int> = Box(1)
    val box2: Box<String> = Box("Hello")
    println(box1.name)
    println(box2.name)
}
~~~

- 결과
~~~
1
Hello
~~~