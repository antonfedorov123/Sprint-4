package ru.sber.functional

class StudentsGroup {

    lateinit var students: List<Student>

    fun filterByPredicate(value: (Student) -> Boolean): List<Student> = students.filter{ oneStudent -> value(oneStudent) }



}
