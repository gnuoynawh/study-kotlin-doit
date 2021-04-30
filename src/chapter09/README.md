### Chapter 09 컬렉션

1. 컬렉션의 구조와 기본
2. List 활용하기
3. Set 과 Map 활용하기
4. 컬렉션의 확장 함수
5. 시퀀스 활용하기

<br>
<br>

컬렉션의 종류

컬렉션 | 불변형 | 가변형
:---:|:---:|:---|
List | listOf | mutableListOf, arrayListOf 
Set | setOf | mutableSetOf, hashSetOf, linkedSetOf, sortedSetOf
Map | mapOf | mutableMapOf, hashMapOf, linkedMapOf, sortedMapOf

컬렉션의 인터페이스 멤버
size : 컬렉션의 크기를 나타낸다
isEmpty() : 컬렉션이 비어있으면 true
contains(element: E) : 특정 요소가 있다면 true
containsAll(elements: Collection<E>) : 인자로 받아들인 컬렉션이 있다면 true

