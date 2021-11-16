package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Attaching listeners to all the views
        val boxOne = findViewById<TextView>(R.id.box_one)
        val boxTwo = findViewById<TextView>(R.id.box_two)
        val boxThree = findViewById<TextView>(R.id.box_three)
        val boxFour = findViewById<TextView>(R.id.box_four)
        val boxFive = findViewById<TextView>(R.id.box_five)
        val constraint_layout = findViewById<ConstraintLayout>(R.id.constraint_layout)
        val redButton = findViewById<Button>(R.id.red_button)
        val blueButton = findViewById<Button>(R.id.blue_button)
        val yellowButton = findViewById<Button>(R.id.yellow_button)

        val clickableViews : List<View> =
            listOf(boxOne, boxTwo, boxThree,
                boxFour, boxFive, constraint_layout)

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }

        redButton.setOnClickListener { boxThree.setBackgroundResource(R.color.my_red) }
        yellowButton.setOnClickListener { boxFour.setBackgroundResource(R.color.my_yellow) }
        blueButton.setOnClickListener { boxFive.setBackgroundResource(R.color.my_blue) }

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