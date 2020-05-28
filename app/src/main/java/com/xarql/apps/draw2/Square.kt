package com.xarql.apps.draw2

class Square(
    size: Float = 0f,
    rotation: Rotation = Rotation(),
    origin: Vector2f = Vector2f()
) : Rectangle(size, size, rotation, origin) {
    fun setSize(size: Float) {
        super.width = size
        super.height = size
    }
}