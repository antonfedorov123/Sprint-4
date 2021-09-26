abstract class Validator<T> {
    abstract fun validate(value: T?): List<ErrorCode>
}

class PhoneValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {

        if (value == null) return listOf(ErrorCode.NULL_VALUE)

        val errors: MutableList<ErrorCode> = ArrayList()
        if (value.length != 11)
            return listOf(ErrorCode.PHONE_NUMBER_LENGTH)
        if (!(value.first() == '7' || value.first() == '8'))
            errors.add(ErrorCode.PHONE_NUMBER_7_OR_8)
        if (!value.all { it in '0'..'9' })
            errors.add(ErrorCode.INVALID_CHARACTER)

        return errors
    }
}

class NameValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {

        if (value == null) return listOf(ErrorCode.NULL_VALUE)

        if (value.length > 16)
            return listOf(ErrorCode.NAME_IS_TOO_LONG)
        if (!value.all { it in 'А'..'Я' || it in 'а'..'я'})
            return listOf(ErrorCode.INVALID_CHARACTER)

        return ArrayList()
    }
}

class EmailValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {

        if (value == null) return listOf(ErrorCode.NULL_VALUE)

        if (value.length < 5) {
            return listOf(ErrorCode.EMAIL_IS_TOO_SHORT)
        }
        // Проверяем длину емейла перед проверкой на формат
        if (value.length > 32) {
            return listOf(ErrorCode.EMAIL_IS_TOO_LONG)
        }

        val emailFormat = "[A-z]+@[A-z]+\\.[A-z]+".toRegex()
        if (!value.matches(emailFormat)) {
            return listOf(ErrorCode.EMAIL_WRONG_FORMAT)
        }

        return ArrayList()
    }
}

class SnilsValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {

        if (value == null) return listOf(ErrorCode.NULL_VALUE)

        if (value.length != 11)
            return listOf(ErrorCode.SNILS_LENGTH)
        if (!value.all { it in '0'..'9' })
            return listOf(ErrorCode.INVALID_CHARACTER)

        var i = 9
        val RANGE_FROM_0_TO_8 = IntRange(0, 8)
        val RANGE_FROM_9_TO_10 = IntRange(9, 10)
        val sum = value.substring(RANGE_FROM_0_TO_8)
            .sumOf { Character.getNumericValue(it) * i-- }
        val check = value.substring(RANGE_FROM_9_TO_10).toInt()

        if (!compareSum(sum, check))
            return listOf(ErrorCode.SNILS_SUMM_CHECK)

        return ArrayList()
    }

    private fun compareSum(sum: Int, check: Int) : Boolean = when (sum) {
        in 0..99 -> sum == check
        in 100..101 -> 0 == check
        else -> sum % 101 == check
    }
}



