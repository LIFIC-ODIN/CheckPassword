package com.odin.checkpassword.password

sealed class InputWarningType {
    object NONE: InputWarningType()
    object DANGEROUS: InputWarningType()
    object WARNING: InputWarningType()
    object GREAT: InputWarningType()
}