package com.xarql.apps.draw2

/**
 * Rotation holds a Double value that marks degrees of
 * clockwise rotation within the bounds [0, 360]
 */
class Rotation(private var degrees: Float = 0.0f) {

    init {
        setDegrees(degrees)
    }

    fun setDegrees(degrees: Float) {
        this.degrees = degrees % 360
    }

    fun getDegrees(): Float {
        // ensure degrees is within [0, 360]
        if (degrees > 360 || degrees < 0)
            setDegrees(degrees)
        return degrees
    }

    fun add(degrees: Float) {
        setDegrees(getDegrees() + degrees)
    }

    fun add(rotation: Rotation) {
        add(rotation.getDegrees())
    }

}