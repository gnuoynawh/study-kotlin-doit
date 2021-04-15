package chapter07.section02


/*
    어노테이션 클래스
        - 코드에 부가정보를 추가하는 기능
        - @ 기호와 함께 나타내는 표기법으로 주로 컴파일러나 프로그램 실행 시간에서 사전 처리를 위해 사용

            @Test         : 유닛 테스트
            @JvmStatic    : 자바코드에서 컴패니언 객체 접근

        - 선언

            annotation class 클래스

        - 속성
            @Target     : 애노테이션이 지정되어 사용할 종류를 정의 (클래스, 함수, 프로퍼티)
            @Retention  : 애노테이션을 컴파일된 클래스 파일에 저장할 것인지 실행 시간에 반영할 것인지 결정
            @Repeatable : 애노테이션을 같은 요소에 여러 번 사용 가능하게 할지를 결정
            @MustBeDocumented : 애노테이션이 API의 일부분으로 문서화하기 위해 사용
 */

/*
    열거형 클래스
        - 여러 개의 상수를 선언하고 열거된 값을 조건에 따라 선택할 수 있는 특수한 클래스
        - 자료형이 동일한 상수를 나열

        enum class 클래스이름 [(생성자)] {
            상수1[(값)], 상수2[(값)], 상수3[(값)], ...
            [; 프로퍼티 혹은 메서드]
        }

 */
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

enum class DayOfWeek(val num: Int) {
    MONDAY(0), TUESDAY(1), WEDNESDAY(2), THURSDAY(3), FRIDAY(4), SATURDAY(5), SUNDAY(6)
}

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255,0,0), ORANGE(255,166,0),
    YELLOW(255,255,0), GREEN(0,255,0), BLUE(0,0,255),
    INDIGO(75,0,130), VIOLET(238,130,238);  // 세미콜론으로 끝을 알림

    fun rgb() = (r * 256 + g) * 256 + b // 메서드 포함 가능
}

fun main() {
    var day = DayOfWeek.SATURDAY
    when(day.num) {
        0, 1, 2, 3, 4, 5 -> println("Week")
        6, 7 -> println("Weekend")
    }

    println(Color.BLUE.rgb())
}