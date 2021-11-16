package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Attaching listeners to all the views
        val box_one = findViewById<TextView>(R.id.box_one)
        val box_two = findViewById<TextView>(R.id.box_two)
        val box_three = findViewById<TextView>(R.id.box_three)
        val box_four = findViewById<TextView>(R.id.box_four)
        val box_five = findViewById<TextView>(R.id.box_five)
        val constraint_layout = findViewById<ConstraintLayout>(R.id.constraint_layout)

        val clickableViews : List<View> =
            listOf(box_one, box_two, box_three,
                box_four, box_five, constraint_layout)

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }


    /**
     * Sets the background color of a view depending on it's resource id.
     * This is a way of using one click handler to do similar operations on a group of views.
     *
     * Demonstrates three different ways of setting colors.
     *     * Using a color constant from the Color class.
     *     * Using an Android color resource
     *     * Using a custom color defined in color.xml
     */
    private fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color class colors for background
            R.id.box_one -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five -> view.setBackgroundResource(android.R.color.holo_green_light)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}