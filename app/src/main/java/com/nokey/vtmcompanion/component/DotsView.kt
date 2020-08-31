package com.nokey.vtmcompanion.component

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.CheckBox
import androidx.constraintlayout.widget.ConstraintLayout
import com.nokey.vtmcompanion.R

class DotsView : ConstraintLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        context.obtainStyledAttributes(attrs, R.styleable.DotsView).apply {
            setDots(getInteger(R.styleable.DotsView_dots, 0))
        }.recycle()
    }

    init {
        View.inflate(context, R.layout.dot_tracker_view, this)
    }

    fun setDots(dots: Int) {
        findViewById<CheckBox>(R.id.dot_one).isChecked = dots >= 1
        findViewById<CheckBox>(R.id.dot_two).isChecked = dots >= 2
        findViewById<CheckBox>(R.id.dot_three).isChecked = dots >= 3
        findViewById<CheckBox>(R.id.dot_four).isChecked = dots >= 4
        findViewById<CheckBox>(R.id.dot_five).isChecked = dots == 5
    }
}