package chapter05.section05


open class Base1 {
    // 이 클래스에서는 a, b, c, d, e 접근 가능
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4  // 가시성 지시자 기본값은 public

    protected class Nested {
        // 이 클래스에서는 a, b, c, d, e, f 접근 가능
        public val e: Int = 5 // public 생략 가능
        private val f: Int = 6
    }
}

class Derived : Base1() {
    // 이 클래스에서는 b, c, d, e 접근 가능
    // a 는 접근 불가
    override val b = 5   // Base의 'b' 는 오버라이딩됨 - 상위와 같은 protected 지시자
}

class Other(base: Base1) {
    // base.a, base.b는 접근 불가
    // base.c와 base.d는 접근 가능(같은 모듈 안에 있으므로)
    // Base.Nested는 접근 불가, Nested::e 역시 접근 불가
}