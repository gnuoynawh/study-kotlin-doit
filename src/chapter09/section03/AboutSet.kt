package chapter09.section03

import java.util.*
import kotlin.collections.HashSet

fun main() {

    /*
        set 불변형 : setOf
     */
    val mixedTypesSet = setOf("Hello", 5, "world", 3.14, 'c') // 자료형 혼합 초기화
    var intSet: Set<Int> = setOf<Int>(1, 5, 5)  // 정수형만 초기화

    println(mixedTypesSet)
    println(intSet)


    /*
        set 가변형 : mutableSetOf
     */
    val animals = mutableSetOf("Lion", "Dog", "Cat", "Python", "Hippo")
    println(animals)

    // 추가, 제거
    animals.add("Dog") // 이미 존재하므로 변화 없음
    animals.remove("Python")
    println(animals)


    /*
        HashSet
     */
    val intsHashSet: HashSet<Int> = hashSetOf(6, 3, 4, 7)
    intsHashSet.add(5)
    intsHashSet.remove(6)
    println(intsHashSet)


    /*
        linkedSetOf
     */
    val intsLinkedHashSet: java.util.LinkedHashSet<Int> = linkedSetOf(35, 21, 76, 26, 75)
    intsLinkedHashSet.add(4)
    intsLinkedHashSet.remove(21)
    println("intsLinkedHashSet $intsLinkedHashSet")

    intsLinkedHashSet.clear()
    println(intsLinkedHashSet)


    /*
        sortedSetOf
     */
    val intsSortedSet: TreeSet<Int> = sortedSetOf(4, 1, 7, 2)
    intsSortedSet.add(6)
    intsSortedSet.remove(1)
    println("intsSortedSet = ${intsSortedSet}")

    intsSortedSet.clear()  // 모든 요소 삭제
    println("intsSortedSet = ${intsSortedSet}")
}