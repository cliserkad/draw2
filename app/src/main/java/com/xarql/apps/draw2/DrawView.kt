package com.xarql.apps.draw2

import android.content.Context
import android.util.AttributeSet
import android.view.View

class DrawView constructor(context: Context) : View(context) {
    var shapes: MutableList<Unit> = ArrayList()

    init {
        println("init received")
    }

    constructor(context: Context, attributes: AttributeSet) : this(context) {
        var enabled = attributes.getAttributeValue(0).toBoolean();
        if (enabled)
            println("enabled DrawView")
        else
            println("disabled DrawView")
    }
}