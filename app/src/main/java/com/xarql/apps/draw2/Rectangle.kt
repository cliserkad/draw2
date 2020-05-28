package com.xarql.apps.draw2

open class Rectangle(
    var width: Float = 100f,
    var height: Float = 100f,
    rotation: Rotation = Rotation(),
    origin: Vector2f = Vector2f()
) : Shape(rotation, origin) {

    override fun points(): MutableList<Vector2f> {
        val topLeft = origin;
        val bottomRight = origin.withOffset(Vector2f(width, height))
        val topRight = origin.withX(bottomRight.x)
        val bottomLeft = origin.withY(bottomRight.y)
        return mutableListOf(topLeft, topRight, bottomRight, bottomLeft)
    }
}