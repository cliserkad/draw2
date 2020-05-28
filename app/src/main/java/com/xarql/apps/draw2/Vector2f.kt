package com.xarql.apps.draw2

import kotlin.math.abs
import kotlin.math.sqrt

/**
 * This class represents a point, as a displacement from an origin
 * floats are used for compatibility with android.graphics.Canvas
 */
class Vector2f(var x: Float = 0f, var y: Float = 0f) {
    constructor(vector: Vector2f) : this(vector.x, vector.y)

    fun withX(x: Float): Vector2f {
        return Vector2f(x, this.y);
    }

    fun withY(y: Float): Vector2f {
        return Vector2f(this.x, y);
    }

    fun withOffset(vector: Vector2f): Vector2f {
        return Vector2f(this.x + vector.x, this.y + vector.y)
    }

    fun distanceFrom(other: Vector2f): Float {
        // casting might lead to bad precision
        return distanceDouble(other).toFloat()
    }

    fun distanceDouble(other: Vector2f): Double {
        // sqrt with double input returns a double,
        // so I am using it to try to get more precision
        return abs(sqrt(((other.x - x) + (other.y - y)).toDouble()))
    }

    override fun equals(vector: Any?): Boolean {
        if (vector != null && vector is Vector2f)
            return vector.x == x && vector.y == y
        else
            return false
    }

    override fun toString(): String {
        return "x:$x & y:$y";
    }
}