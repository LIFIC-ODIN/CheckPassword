package com.odin.checkpassword

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.odin.checkpassword.password.CheckPassword
import com.odin.checkpassword.password.InputWarningType

class MainViewModel : ViewModel() {

    private val _inputType = MutableLiveData<InputWarningType>()
    val inputType: LiveData<InputWarningType> get() = _inputType

    val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            _inputType.value = s?.let {
                if (it.isEmpty()) {
                    InputWarningType.NONE
                } else {
                    CheckPassword.isValidPasswordType(it.toString())
                }
            } ?: run {
                InputWarningType.NONE
            }
        }
    }

}