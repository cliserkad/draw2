package com.xarql.apps.draw2

/**
 * Rotation holds a Double value that marks degrees of
 * clockwise rotation within the bounds [0, 360]
 */
class Rotation(degrees: Double = 0.0) {
    private var degrees: Double = 0.0

    init {
        setDegrees(degrees)
    }

    fun setDegrees(degrees: Double) {
        this.degrees = degrees % 360
    }

    fun getDegrees(): Double {
        // ensure degrees is within [0, 360]
        if (degrees > 360 || degrees < 0)
            setDegrees(degrees)
        return degrees
    }

    fun add(degrees: Double) {
        setDegrees(getDegrees() + degrees)
    }

    fun add(rotation: Rotation) {
        add(rotation.getDegrees())
    }

}