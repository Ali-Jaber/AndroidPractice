package com.android.practice.practice.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.use
import com.android.practice.practice.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BenefitView : ConstraintLayout {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(
        context,
        attrs,
        defStyleAttr,
        0
    )

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        LayoutInflater.from(context).inflate(R.layout.benefit_view, this, true)

        val floatingButton: FloatingActionButton = findViewById(R.id.send)
        val editText: EditText = findViewById(R.id.et)

        attrs?.also {
            val attributes = context.obtainStyledAttributes(it, R.styleable.BenefitView)

            floatingButton.setImageDrawable(attributes.getDrawable(R.styleable.BenefitView_image))
            editText.hint = attributes.getString(R.styleable.BenefitView_text)
            attributes.recycle()
        }

    }


//    init {
//
//
//    }

}