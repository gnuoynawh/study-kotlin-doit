package chapter08.section02


/*
    배열의 순환/반복
 */

fun main() {

    //
    val arr = arrayOf(1,2,3,4,5,6,7,8,9)

    // forEach 에 의한 요소순환
    arr.forEach { element -> print("$element") }
    println()

    // forEachIndexed 에 의한 요소순환
    arr.forEachIndexed { idx, e -> println("arr[$idx] = $e") }

    /*
        iterator 의 이용
            next() - 다음 요소를 반환
            remove() - next() 로 읽어온 요소 삭제
     */
    val iter: Iterator<Int> = arr.iterator()
    while (iter.hasNext()) {
        val e = iter.next()
        print("$e ")
    }
}