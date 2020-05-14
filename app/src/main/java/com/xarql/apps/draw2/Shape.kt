package com.xarql.apps.draw2

import android.graphics.Canvas
import android.graphics.Paint
import kotlin.math.cos
import kotlin.math.sin

abstract class Shape(
    var rotation: Rotation = Rotation(),
    var origin: Vector2f = Vector2f()
) {
    // companion objects allow for static access
    companion object {
        val DEFAULT_PAINT: Paint = buildPaint()

        // adapted from a StackOverflow question that was in C++
        fun rotatePoint(point: Vector2f, pivot: Vector2f, rotation: Rotation): Vector2f {
            // sin and cos expect radians, but rotation stores degrees
            val sin = sin(Math.toRadians(rotation.getDegrees()))
            val cos = cos(Math.toRadians(rotation.getDegrees()))


            var out: Vector2f = Vector2f(point)
            // translate point back to origin:
            out.x -= pivot.x
            out.y -= pivot.y

            // rotate point
            val newX = out.x * cos - out.y * sin
            val newY = out.x * sin + out.y * cos

            // translate point back:
            out.x = (newX + pivot.x).toFloat()
            out.y = (newY + pivot.y).toFloat()

            return out
        }

        fun drawLine(canvas: Canvas, pointA: Vector2f, pointB: Vector2f) {
            canvas.drawLine(pointA.x, pointA.y, pointB.x, pointB.y, DEFAULT_PAINT)
        }

        private fun buildPaint(): Paint {
            var out = Paint()
            out.strokeWidth = 6f
            return out
        }
    }

    abstract fun points(): MutableList<Vector2f>

    fun rotate(amount: Rotation) {
        for (point in points())
            rotatePoint(point, origin, amount)
        rotation.add(amount)
    }

    // draws a polygon made from the points() function
    fun drawOn(canvas: Canvas) {
        var points: MutableList<Vector2f> = points();
        points.add(points.get(0))
        for (i in 0 until points.size - 1) {
            drawLine(canvas, points.get(i), points.get(i + 1))
        }
    }

}