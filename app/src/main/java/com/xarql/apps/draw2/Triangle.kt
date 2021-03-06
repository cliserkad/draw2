package com.xarql.apps.draw2

class Triangle(
    var pointA: Vector2f = Vector2f(),
    var pointB: Vector2f = Vector2f(),
    var pointC: Vector2f = Vector2f(),
    rotation: Rotation = Rotation(),
    origin: Vector2f = Vector2f()
) : Shape(rotation, origin) {

    override fun points(): MutableList<Vector2f> {
        return mutableListOf(
            pointA.withOffset(origin),
            pointB.withOffset(origin),
            pointC.withOffset(origin)
        )
    }
}