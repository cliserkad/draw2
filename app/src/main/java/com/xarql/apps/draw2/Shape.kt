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
            val sin = sin(Math.toRadians(rotation.getDegrees().toDouble()))
            val cos = cos(Math.toRadians(rotation.getDegrees().toDouble()))


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

    private fun rotate(point: Vector2f): Vector2f {
        return rotatePoint(point, origin, rotation)
    }

    // draws a polygon made from the points() function
    open fun drawOn(canvas: Canvas) {
        var points: MutableList<Vector2f> = points()
        points.add(points[0])
        var i = 0
        while (i < points.size) { // apply rotation to each point
            points[i] = rotate(points[i])
            i++
        }
        i = 0
        while (i < points.size - 1) { // draw lines between points
            drawLine(canvas, points[i], points[i + 1])
            i++
        }
    }

}