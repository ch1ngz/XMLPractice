package com.isakovch.semmensapp

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.widget_empty_view.view.actionButton
import kotlinx.android.synthetic.main.widget_empty_view.view.subActionButton

class EmptyView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    var onActionButtonClicked: (() -> Unit)? = null
    var onSubActionButtonClicked: (() -> Unit)? = null

    init {
        View.inflate(context, R.layout.widget_empty_view, this)

        actionButton.setOnClickListener {
            onActionButtonClicked?.invoke()
        }

        subActionButton.setOnClickListener {
            onSubActionButtonClicked?.invoke()
        }
    }


}