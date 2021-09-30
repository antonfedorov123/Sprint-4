package ru.sber.functional

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PowFactoryTest {
    @Test
    fun `buildPowFunction should return lambda It should calculate to second power`() {
        assertEquals(1,   PowFactory.buildPowFunction(1000)(1))
        assertEquals(9,   PowFactory.buildPowFunction(2)(3))
        assertEquals(0,   PowFactory.buildPowFunction(2)(0))
        assertEquals(-27, PowFactory.buildPowFunction(3)(-3))
    }
}
