### Section 04

#### Operator.kt

- 기본연산자 
    - 덧셈 `+`, 뺄셈 `-`, 곱셈 `*`, 나누기 `/`
    - 나머지 `%`
    
- 대입연산자
    - `=` num = 2 
    - `+=` num = num + 2
    - `-=` num = num - 2
    - `*=` num = num * 2
    - `/=` num = num / 2
    - `%=` num = num % 2
    
- 증감연산자
    - 항의 앞에 붙이냐, 뒤에 붙이냐에 따라 값이 달라짐으로 주의
    - `++` num++ , ++num
    - `--` num-- , --num
    
- 비교연산자
    - 비교결과가 같으면 true, 다르면 false
    - `>` 크다
    - `<` 작다
    - `>=` 크거나 같다
    - `<=` 작거나 같다
    
- 논리연산자
    - `&&` 두개의 항 모두 true 일때만 true 를 반환
    - `||` 두개의 항 중 하나이상 true 이면 true 를 반환
    - `!` 부정연산자로 true 이면 false, false 이면 true 를 반환
    
- 예제
    ~~~ kotlin
    // 1. 기본 연산자
    val num1 = 13.0
    val num2 = 3.0
    println("num1 + num2 = ${num1 + num2}")
    println("num1 - num2 = ${num1 - num2}")
    println("num1 * num2 = ${num1 * num2}")
    println("num1 / num2 = ${num1 / num2}")
    println("num1 % num2 = ${num1 % num2}")
    
    // 2. 나머지 연산자
    val n = 4
    if ((n % 2) == 1)
        println("n is an Odd")
    if ((n % 2) == 0)
        println("n is an Even")
    
    // 3. 증감 연산자
    var num3 = 10
    var num4 = 10
    var result1 = ++num3
    var result2 = num4++
    
    // 4. 논리 연산자
    var check = (5>3) && (5>2)  // 두개의 항이 모두 참일 때 true
    check = (5>3) || (2>5)      // 두개중 하나의 항이 참일 때 true
    check = !(5>3)              // 참인 경우 거짓으로, 거짓인 경우 참으로 변경
    ~~~
- 결과
    ~~~ kotlin
    num1 + num2 = 16.0
    num1 - num2 = 10.0
    num1 * num2 = 39.0
    num1 / num2 = 4.333333333333333
    num1 % num2 = 1.0
    n is an Even
    result1 : 11
    result2 : 10
    num3 : 11
    num4 : 11
    true
    true
    false
    ~~~

<br>

#### BitShift.kt

- 비트연산자
    - 기계가 이해할수 있는 0, 1 을 처리하는데 사용
    - 값을 2진수로 변환 후 왼쪽, 오른쪽으로 값을 옮기며 연산
    - `4.shl(bits)` 4 를 bits 만큼 **왼쪽으로 이동**
    - `4.shr(bits)` 4 를 bits 만큼 **오른쪽으로 이동**
    - `4.ushr(bits)` 4 를 bits 만큼 **오른쪽으로 이동 (부호없음)**
    - `4.and(bits)` 4 와 bits 로 **논리곱 연산**
    - `4.or(bits)` 4 를 bits 로 **논리합 연산**
    - `4.xor(bits)` 4 를 bits 로 **배타적 연산**
    - `4.inv()` 4 를 **뒤집음**
    
- 예제 1. 비트연산자
    ~~~ kotlin
    var x = 4
    var y = 0b0000_1010
    var z = 0x0F
    
    println("x shl 2 -> ${x shl 2}")
    println("x.inv() -> ${x.inv()}")
    println("y shr 2 -> ${y/4}, ${y shr 2}")
    println("x shl 4 -> ${x+16}, ${x shl 4}")
    println("z shl 4 -> ${z+16}, ${z shl 4}")
    
    x = 64
    println("x shr 2 -> ${x/4}, ${x shr 2}")
    ~~~
- 결과1
    ~~~ kotlin
    x shl 2 -> 16
    x.inv() -> -5
    y shr 2 -> 2, 2
    x shl 4 -> 20, 64
    z shl 4 -> 31, 240
    x shr 2 -> 16, 16
    ~~~
- 예제 2. ushr
    ~~~ kotlin
    val number1 = 5
    val number2 = -5
    
    println(number1 shr 1)
    println(number1 ushr 1) // 변화 없음
    println(number2 shr 1)  // 부호비트가 1로 유지
    println(number2 ushr 1) // 부호비트가 0이 되면서 변경
    ~~~
- 결과 2 
    ~~~ kotlin
    2
    2
    -3
    2147483645
    ~~~
- 예제 3. 비트 논리 연산
    ~~~ kotlin
    val number3 = 12
    val number4 = 25
    
    println(number3 or number4)     // result = number3.or(number4) 와 동일
    println(number3 and number4)    // result = number3.and(number4) 와 동일
    println(number3 xor number4)    // result = number3.xor(number4) 와 동일
    ~~~
- 결과 3
    ~~~ kotlin
    29
    8
    21
    ~~~