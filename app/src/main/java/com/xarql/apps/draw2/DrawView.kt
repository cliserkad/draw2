package com.xarql.apps.draw2

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

class DrawView constructor(context: Context) : View(context) {
    var shapes: MutableList<Shape> = ArrayList()

    constructor(context: Context, attributes: AttributeSet) : this(context) {
        val vectorA = Vector2f(50f, 50f)
        val vectorB = Vector2f(50f, 0f)
        val vectorC = Vector2f(100f, 50f)
        var triangle = Triangle(vectorA, vectorB, vectorC, Rotation(30f), Vector2f(50f, 50f))
        shapes.add(triangle)

        val origin = Vector2f(100f, 100f)
        var rectangle = Rectangle(100f, 100f, Rotation(), origin)
        rectangle.rotation.add(10f)
        shapes.add(rectangle)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas != null)
            for (shape in shapes)
                shape.drawOn(canvas)
    }
}