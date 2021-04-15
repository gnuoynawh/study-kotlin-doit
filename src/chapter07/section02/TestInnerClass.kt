package chapter07.section02

/*
    내부 클래스
        - 정적 클래스 : static 키워드를 가지며 외부 클래스를 인스턴스화하지 않고 바로 사용 가능한 내부 클래스 (주로 빌더에 이용)
        - 멤버 클래스 : 인스턴스 클래스로도 불리며 외부 클래스의 필드나 메서드와 연동
        - 지역 클래스 : 초기화 블록이나 메서드 내의 블록에서만 유효한 클래스
        - 익명 클래스 : 이름이 없고 주로 일회용 객체를 인스턴스화하면서 오버라이드 메서드를 구현하는 내부 클래스

 */

/*
    이너(Inner)라는 의미가 내부라는 뜻이지만 여기서는 특별한 키워드인 inner를 사용하고 있으므로 이너 클래스라고 부르겠습니다.
    단순히 내부에 작성된 중첩 클래스와는 좀 다른 역할을 합니다.
    클래스 안에 이너 클래스를 정의할 수 있는데 이때 이너 클래스는 바깥 클래스의 멤버들에 접근할 수 있습니다.
 */
class Smartphone(val model: String) {

    private val cpu = "Exynos"

    inner class ExternalStorage(val size: Int) {
        fun getInfo() = "${model}: Installed on $cpu with ${size}Gb" // 바깥 클래스의 프로퍼티 접근
    }
}

fun main() {

    // 이너
    val mySdcard = Smartphone("S7").ExternalStorage(32)
    println(mySdcard.getInfo())
}
