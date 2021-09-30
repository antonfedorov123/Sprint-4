package ru.sber.functional

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StudentsGroupTest {

    @Test
    fun initTest() {

        val group = StudentsGroup()

        group.init(
            { Student(firstName = "Незнайка", lastName = "", averageRate = 2.0) },
            { Student(firstName = "Винтик",   lastName = "", averageRate = 5.0, specialization = "Весёлый механик", age = 10)  },
            { Student(firstName = "Шпунтик",  lastName = "", averageRate = 5.0, specialization = "Весёлый механик", city = "Москва") },
        )

        assertEquals(3, group.students.count())

    }

}