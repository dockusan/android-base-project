package com.an.dagger.ui.custom

import android.content.Context
import com.google.android.material.card.MaterialCardView
import android.util.AttributeSet

class AspectRatioCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {

    private val ratio = 1.4f

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val ratioHeight = (measuredWidth * ratio).toInt()
        setMeasuredDimension(measuredWidth, ratioHeight)
        val lp = layoutParams
        lp.height = ratioHeight
        layoutParams = lp
    }
}