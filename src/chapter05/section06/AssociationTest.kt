package chapter05.section06

// 연관관계
class Patient1(val name: String) {

    fun doctorList(d: Doctor1) {  // 인자로 참조
        println("Patient: $name, Doctor: ${d.name}")
    }
}

class Doctor1(val name: String) {
    fun patientList(p: Patient1) { // 인자로 참조
        println("Doctor: $name, Patient: ${p.name}")
    }
}

fun main() {
    val doc1 = Doctor1("KimSabu")
    val patient1 = Patient1("Kildong")
    doc1.patientList(patient1)
    patient1.doctorList(doc1)
}