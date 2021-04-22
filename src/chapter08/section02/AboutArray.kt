package chapter08.section02

import java.util.*

fun main() {

    /*
        기본 배열형식
     */
    // 정수형으로 초기화된 배열
    val numbers = arrayOf(4, 5, 7, 3)

    // 문자열형으로 초기화된 배열
    val animals = arrayOf("Cat", "Dog", "Lion")

    // 정수형으로 초기화된 배열 출력하기
    for (element in numbers) {
        println(element)
    }


    /*
        2차원 배열 - 1
     */
    val arr1 = arrayOf(1,2,3)
    val arr2 = arrayOf(4,5,6)
    val arr3 = arrayOf(7,8,9)
    var arr2d = arrayOf(arr1, arr2, arr3)


    /*
        2차원 배열 - 2
     */
    val arr2dd = arrayOf(
            arrayOf(1,2,3),
            arrayOf(4,5,6),
            arrayOf(7,8,9)
    )


    /*
        배열에 대한 접근
     */
    arr1.get(2)    //arr1[2]
    arr1.set(2, 3) //arr1[2] = 3
    arr2d[1][1]


    /*
        많은 양의 배열생성
     */

    // 1000개의 null 로 채워진 정수배열
    val a = arrayOfNulls<Int>(1000)

    // 0 으로 채워진 배열
    val b = Array(1000) { 0 }


    /*
        추가, 잘라내기
     */
    val arr4 = intArrayOf(1,2,3,4,5)

    // 기존 배열에 요소 추가
    val arr5 = arr4.plus(6)
    println("arr5 : ${Arrays.toString(arr5)}")

    // 잘라내기 - 인자에 잘라낼 인덱스의 범위를 지정
    val arr6 = arr4.sliceArray(0..2)
    println("arr6 : ${Arrays.toString(arr6)}")


    /*
        기타
     */
    // 첫번째와 마지막 요소 확인
    println(arr1.first())
    println(arr1.last())

    // 값이 3인 배열의 인덱스값 반환
    println("indexOf(3) : ${arr1.indexOf(3)}")

    // 배열의 평균값
    println("average : ${arr1.average()}")

    // count 에 의한 요소의 개수
    println("count : ${arr1.count()}")
    println("size : ${arr1.size}")

    // 존재여부 확인
    println("arr1.contains(4) : ${arr1.contains(4)}")
    println("4 in arr1 : ${4 in arr1}")
}