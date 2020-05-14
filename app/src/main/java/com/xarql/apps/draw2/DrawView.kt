package com.xarql.apps.draw2

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

class DrawView constructor(context: Context) : View(context) {
    var shapes: MutableList<Shape> = ArrayList()

    constructor(context: Context, attributes: AttributeSet) : this(context) {
        val pointA = Vector2f(50f, 50f)
        val pointB = Vector2f(50f, 0f)
        val pointC = Vector2f(100f, 50f)
        var triangle = Triangle(pointA, pointB, pointC, Rotation(), Vector2f())
        shapes.add(triangle)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas != null)
            for (shape in shapes)
                shape.drawOn(canvas)
    }
}