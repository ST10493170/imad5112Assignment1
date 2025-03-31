package com.example.assignment1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get UI elements
        val timeText = findViewById<EditText>(R.id.timeText)
        val mealText = findViewById<TextView>(R.id.mealText)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val submitButton = findViewById<Button>(R.id.submitButton)

        // Reset button click listener
        resetButton.setOnClickListener {
            timeText.text.clear()  // Fixed the clear() function
            mealText.text = ""
        }

        // Meal suggestions map
        val suggestions = mapOf(
            "Morning" to "Avocado toast with eggs and orange juice, oatmeal and banana smoothie, breakfast fish sandwich and juice, cereal",
            "Mid-Morning" to "Toast with cheese and tea, strawberry smoothie, vanilla muffin, chocolate muffin, water",
            "Afternoon" to "Grilled cheese sandwich with cranberry juice, ramen noodles, bacon sandwich with grilled cheese",
            "Night" to "Meatballs with cheesy pasta and a drink, chicken Alfredo with a drink, tacos with drinks, BBQ chicken with a drink, braai meat and pap",
            "Dessert" to "Jelly and custard, Malva pudding, brownies, ice cream tower, rainbow cake, cheesecake"
        )

        // Submit button click listener
        submitButton.setOnClickListener {
            val input = timeText.text.toString().trim()

            if (input.isEmpty()) {
                Toast.makeText(this, "Please enter a time of day", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (input in suggestions) {
                mealText.text = "Suggestions: ${suggestions[input]}"
            } else {
                mealText.text = "No meal suggestions available for \"$input\"."
            }
        }
    }
}