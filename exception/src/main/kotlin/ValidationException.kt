class ValidationException(val errorCode: Array<ErrorCode>) : RuntimeException(errorCode.joinToString(",") { it.msg })

enum class ErrorCode(val code: Int, val msg: String) {
    INVALID_CHARACTER(100, "Недопустимый символ"),
    NULL_VALUE(101, "Null значение переменной"),

    // PHONE
    PHONE_NUMBER_LENGTH(200, "Номер телефона не равен 11 символам"),
    PHONE_NUMBER_7_OR_8(201, "Номер телефона начинается не с 7 или 8"),

    // NAME
    NAME_IS_TOO_LONG(300, "Имя/Фамилия превысили 16 символов"),

    // EMAIL
    EMAIL_IS_TOO_LONG(400, "Длина email'а больше 32 символов"),
    EMAIL_IS_TOO_SHORT(401, "Длина email'а меньше 5 символов"),
    EMAIL_WRONG_FORMAT(402, "В Email не содержит символа '@' или содержит больше одного символа '@' "),

    // SNILS
    SNILS_LENGTH(500, "Код СНИЛСа слишком короткий/длинный"),
    SNILS_SUMM_CHECK(501, "Указан неверный код СНИЛСа")


}