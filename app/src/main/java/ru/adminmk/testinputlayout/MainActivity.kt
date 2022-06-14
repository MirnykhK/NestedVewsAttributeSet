package ru.adminmk.testinputlayout

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ContextThemeWrapper
import com.google.android.material.textfield.TextInputEditText
import ru.adminmk.testinputlayout.databinding.ActivityMainBinding
import ru.adminmk.testinputlayout.databinding.DividerBinding

private const val TAG = "EDIT_TEXT_TAG"

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val holder = binding.llHolder
        //-------------------

        val editTextWInputForTIL = getWInputEditText()
        binding.tilOnlyGroupWInput.addView(editTextWInputForTIL)

        addViewDivider(holder)

        //-------------------

//        val editTextWInput = getWInputEditText()
//        holder.addView(editTextWInput)
//
//        addViewDivider(holder)

        Log.d(TAG, "et_from_xml_2_elements  ${binding.etFromXml2Elements2.paddingLeft}")
        Log.d(TAG, "et_from_xml ${binding.etFromXml2.paddingLeft}")
        Log.d(TAG, "et from constructor inside TIL ${editTextWInputForTIL.paddingLeft}")
//        Log.d(TAG, "et from constructor w input ${editTextWInput.paddingLeft}")
    }

    private fun getWInputEditText(): View {
        return TextInputEditText(
            ContextThemeWrapper(binding.tilOnlyGroupWInput.context, R.style.ThemeOverlay_Style1),
            null,
            androidx.appcompat.R.attr.editTextStyle
        ).apply {
            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

//            val margin16dp = this@MainActivity.dipToPixels(16f).toInt()
//
//            layoutParams.setMargins(
//                margin16dp,
//                margin16dp,
//                margin16dp,
//                0
//            )

            this@apply.layoutParams = layoutParams
            this@apply.maxLines = 1
            this@apply.imeOptions = EditorInfo.IME_ACTION_DONE
            this@apply.inputType = android.text.InputType.TYPE_CLASS_TEXT or
                        android.text.InputType.TYPE_TEXT_VARIATION_NORMAL

            this.setText("from constructor")
        }
    }

    private fun Context.dipToPixels(dipValue: Float) =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, resources.displayMetrics)

    private fun Context.addViewDivider(parent: ViewGroup) =
        DividerBinding.inflate(LayoutInflater.from(this), parent, true)
}
