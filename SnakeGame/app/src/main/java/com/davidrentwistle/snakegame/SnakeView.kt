package com.davidrentwistle.snakegame

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class SnakeView(context: Context) : View(context) {
    private val paint = Paint().apply {
        color = Color.RED
    }
    private val snake = mutableListOf<Pair<Float, Float>>()
    private var foodX = 0f
    private var foodY = 0f

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            it.drawCircle(foodX, foodY, 20f, paint)
            for (pair in snake) {
                it.drawCircle(pair.first, pair.second, 20f, paint)
            }
        }
    }
}