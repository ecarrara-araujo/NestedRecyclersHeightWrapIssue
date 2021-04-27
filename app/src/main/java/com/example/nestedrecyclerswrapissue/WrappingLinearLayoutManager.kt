package com.example.nestedrecyclerswrapissue

import android.content.Context
import android.graphics.Rect
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WrappingLinearLayoutManager constructor(
    context: Context,
    @RecyclerView.Orientation orientation: Int,
    reverseLayout: Boolean
) : LinearLayoutManager(context, orientation, reverseLayout) {

    override fun isAutoMeasureEnabled(): Boolean = false

    override fun onMeasure(
        recycler: RecyclerView.Recycler,
        state: RecyclerView.State,
        widthSpec: Int,
        heightSpec: Int
    ) {
        val widthMode = View.MeasureSpec.getMode(widthSpec)
        val heightMode = View.MeasureSpec.getMode(heightSpec)
        val widthSize = View.MeasureSpec.getSize(widthSpec)
        val heightSize = View.MeasureSpec.getSize(heightSpec)
        var width = 0
        var height = 0

        for (index in 0 until itemCount) {
            val (measuredChildWidth, measuredChildHeight) = measureScrapChild(
                recycler,
                index,
                View.MeasureSpec.makeMeasureSpec(index, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(index, View.MeasureSpec.UNSPECIFIED)
            )
            if (orientation == HORIZONTAL) {
                width += measuredChildWidth

                if (measuredChildHeight > height) {
                    height = measuredChildHeight
                }
            } else {
                height += measuredChildHeight
                if (index == 0) {
                    width = measuredChildWidth
                }
            }
        }

        if (widthMode == View.MeasureSpec.EXACTLY) width = widthSize
        if (heightMode == View.MeasureSpec.EXACTLY) height = heightSize

        setMeasuredDimension(width, height)
    }

    private fun measureScrapChild(
        recycler: RecyclerView.Recycler,
        position: Int,
        widthSpec: Int,
        heightSpec: Int
    ): Pair<Int, Int> {
        val view = recycler.getViewForPosition(position)

        val layoutParams = view.layoutParams as RecyclerView.LayoutParams
        val childWidthSpec = ViewGroup.getChildMeasureSpec(
            widthSpec,
            paddingLeft + paddingRight,
            layoutParams.width
        )

        val childHeightSpec = ViewGroup.getChildMeasureSpec(
            heightSpec,
            paddingTop + paddingBottom,
            layoutParams.height
        )

        view.measure(childWidthSpec, childHeightSpec)
        val outRect = Rect()
        calculateItemDecorationsForChild(view, outRect);
        val measuredWidth = view.measuredWidth + layoutParams.leftMargin + layoutParams.rightMargin
        val measuredHeight =
            view.measuredHeight + layoutParams.bottomMargin + layoutParams.topMargin + outRect.bottom + outRect.top
        recycler.recycleView(view)

        return measuredWidth to measuredHeight
    }
}
