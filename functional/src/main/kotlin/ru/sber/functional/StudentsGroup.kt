package ru.sber.functional

class StudentsGroup {

    lateinit var students: List<Student>

    fun filterByPredicate(value: (Student) -> Boolean): List<Student> = students.filter{ oneStudent -> value(oneStudent) }

    fun init(vararg students: () -> Student) {
        if (!this::students.isInitialized)
            this.students = ArrayList(students.size)

        students.forEach { this.students += it() }
    }

}
