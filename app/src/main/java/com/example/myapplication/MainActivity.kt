package com.example.myapplication

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val	spnGender = findViewById<Spinner>(R.id.spn_gender)
        val	editTextAge =	findViewById<EditText>(R.id.txt_age)
        val	btnCalculate = findViewById<Button>(R.id.btn_calculate)
        val	textViewResult = findViewById<TextView>(R.id.txt_result)

        spnGender.adapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, listOf("Male",	"Female"))

        btnCalculate.setOnClickListener {
            val gender = spnGender.selectedItem as String
            val age: Int? = editTextAge.text.toString().toIntOrNull()

            if(age == null) {
                textViewResult.text = "Please insert a valid age"
            } else {
                var result = 0

                if (gender == "Male") {
                    result = 65 - age
                } else {
                    result = 60 - age
                }
                if(result > 0) {
                    textViewResult.text = "You are gonna retire in $result years"
                } else {
                    textViewResult.text = "Take a break!"
                }
            }
        }
    }
}