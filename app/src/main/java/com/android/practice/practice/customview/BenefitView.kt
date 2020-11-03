package com.android.practice.practice.customview

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.android.practice.practice.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BenefitView(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    init {
        inflate(context, R.layout.benefit_view, this)

        val floatingButton: FloatingActionButton = findViewById(R.id.send)
        val editText: EditText = findViewById(R.id.et)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.BenefitView)

        floatingButton.setImageDrawable(attributes.getDrawable(R.styleable.BenefitView_image))
        editText.setText(attributes.getString(R.styleable.BenefitView_text))
        attributes.recycle()

    }

}