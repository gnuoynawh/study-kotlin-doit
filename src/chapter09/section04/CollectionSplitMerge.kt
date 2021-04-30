package chapter09.section04

fun main() {

    /*
        - 컬렉션의 분리와 병합
            - union : 두 list 를 합침. 중복요소는 하나만
            - plus : 두 list 를 합침. 중복요소 포함
            - partition : 주어진 식에 따라 2개의 컬렉션으로 분리해서 Pair 로 반환
            - zip : 동일 인덱스끼리 Pair 를 만들어 반환
     */

    val list1 = listOf(1, 2, 3, 4, 5, 6)
    val list2 = listOf(2, 2, 3, 4, 5, 5, 6, 7)
    println(list1.union(list2))
    println(list1.plus(list2))

    // 나누기
    val part =  list1.partition { it % 2 == 0 }
    println(part)

    // 합치기
    val zip = list1.zip(listOf(7, 8))
    println(zip)
}