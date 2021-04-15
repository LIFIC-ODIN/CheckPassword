package com.odin.checkpassword.base

import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.odin.checkpassword.password.InputWarningType
import com.google.android.material.textfield.TextInputLayout
import com.odin.checkpassword.R

@BindingAdapter("bind_textWatcher")
fun setTextWatcher(editText: EditText, textWatcher: TextWatcher?) {
    textWatcher?.let { editText.addTextChangedListener(it) }
}

@BindingAdapter("bind_inputWarningType")
fun setInputTextBoxColor(textInputLayout: TextInputLayout, inputWarningType: InputWarningType?) {
    textInputLayout.boxStrokeColor = textInputLayout.context.resources.getColor(
        inputWarningType?.let {
            when (it) {
                InputWarningType.NONE -> R.color.black
                InputWarningType.DANGEROUS -> R.color.red
                InputWarningType.WARNING -> R.color.yellow
                InputWarningType.GREAT -> R.color.green
            }
        } ?: run {
            R.color.black
        }

    )
}

@BindingAdapter("bind_inputDescription")
fun setInputDescription(textView: TextView, inputWarningType: InputWarningType?) {
    inputWarningType?.let {
        textView.setTextColor(textView.context.resources.getColor(
            it.let {
                when (it) {
                    InputWarningType.NONE -> R.color.black
                    InputWarningType.DANGEROUS -> R.color.red
                    InputWarningType.WARNING -> R.color.yellow
                    InputWarningType.GREAT -> R.color.green
                }
            }
        ))
        textView.text = when (it) {
            InputWarningType.DANGEROUS -> "매우 위험합니다"
            InputWarningType.WARNING -> "할수는 있는데 안전하지 않아요."
            InputWarningType.GREAT -> "훌륭해요!"
            else -> ""
        }
    }
    textView.isVisible = inputWarningType != null

}