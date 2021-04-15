package com.odin.checkpassword.password

import java.util.regex.Pattern

object CheckPassword {

    private val PATTERN_ALPHABET = Pattern.compile("^(?=.*[A-Za-z])")
    private val PATTERN_NUMBER = Pattern.compile("^(?=.*[0-9])")
    private val PATTERN_SPECIAL_CHAR = Pattern.compile("^(?=.*[~!@#\$%^&*|'\";:?<>,.\\[\\]{}+=_-])")

    private val FromToMax = 8..20
    private val FromToMin = 8..10
    private const val MIN_MATCH_COUNT = 3

    /**return type boolean*/
    fun isValidPassword(password: String): Boolean {
        var count = 0

        if (PATTERN_ALPHABET.matcher(password).find()) count += 1
        if (PATTERN_NUMBER.matcher(password).find()) count += 1
        if (PATTERN_SPECIAL_CHAR.matcher(password).find()) count += 1

        return count >= MIN_MATCH_COUNT && password.length in FromToMax
    }

    /**return type Enum*/
    fun isValidPasswordType(password: String): InputWarningType {
        var count = 0

        if (PATTERN_ALPHABET.matcher(password).find()) count += 1
        if (PATTERN_NUMBER.matcher(password).find()) count += 1
        if (PATTERN_SPECIAL_CHAR.matcher(password).find()) count += 1

        val isValid = count >= MIN_MATCH_COUNT && password.length in FromToMax

        return if (isValid) {
            if (password.length in FromToMin) {
                InputWarningType.WARNING
            } else {
                InputWarningType.GREAT
            }
        } else {
            InputWarningType.DANGEROUS
        }
    }
}