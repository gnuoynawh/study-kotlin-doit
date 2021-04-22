package chapter08.section03


fun main() {

    /*
        이스케이프 문자의 종류

            \t - 탭
            \r - 캐리지 리턴
            \\ - 백슬래시
            \b - 백스페이스
            \$ - 달러기호
            \n - 개행
            \' - 작은 따옴표
            \" - 큰 따옴표
     */
    val str = "\tYou're just too \"good\" to be true\n\tI can't take my eyes off you."
    val uni = "\uAC00" // 한글 코드의 범위 AC00-D7AF

    println(str)
    println(uni)


    // 개행을 넣지않고 원본문자열 그대로 개행까지 표시가능
    // trimMargin("|") 을 사용하여 특정 문자 기준으로 공백(tab 등)을 제거할 수 있음
    // 특정문자의 default 는 | 이다.
    val text = """
    | Tell me and I forget.
    | Teach me and I remember.
    | Involve me and I learn.
    : (Benjamin Franklin)
    """.trimMargin(":") // trim default는 |
    println(text)


    // 형식 문자
    val pi = 3.1415926
    val dec = 10
    val s = "hello"
    println("pi = %.2f, %e, %3d, %x, %s".format(pi, pi, dec, dec, s))

    val number: Int = "123".toInt()

}