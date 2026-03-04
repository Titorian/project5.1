package com.example.tipcalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.chip.Chip
import android.widget.TextView
class MainActivity : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val priceInput = findViewById<TextInputEditText>(R.id.textInputEditText)
        val outputText = findViewById<TextView>(R.id.output);
        val tip20 = findViewById<Chip>(R.id.tip20)
        val tip25 = findViewById<Chip>(R.id.tip25)
        val tip15 = findViewById<Chip>(R.id.tip15)
        val notip = findViewById<Chip>(R.id.notip)
        val tipamount = findViewById<TextView>(R.id.tipamounT)
        val test = findViewById<TextInputEditText>(R.id.textInputEditText)



        priceInput.setOnClickListener{
            test.hint=""
        }


        tip15.setOnClickListener{

            val price = priceInput.text.toString().toDoubleOrNull()
            if (price != null) {
                val tip = price * .15
                val total = price + (price * 0.15)
                outputText.text = "$%.2f".format(total)
                tipamount.text = "Tip= $%.2f".format(tip)
            } else {
                outputText.text = "Enter a valid number"
            }
        }

        tip20.setOnClickListener {
            val price = priceInput.text.toString().toDoubleOrNull()

            if (price != null) {
                val total = price + (price * 0.20)
                val tip = price * .20
                outputText.text = "$%.2f".format(total)
                tipamount.text = "Tip= $%.2f".format(tip)
            } else {
                outputText.text = "Enter a valid number"
            }
        }

        tip25.setOnClickListener {
            val price = priceInput.text.toString().toDoubleOrNull()

            if (price != null) {
                val total = price + (price * 0.25)
                val tip = price * .25
                outputText.text = "$%.2f".format(total)
                tipamount.text = "Tip= $%.2f".format(tip)
            } else {
                outputText.text = "Enter a valid number"
            }
        }

        notip.setOnClickListener {
            val price = priceInput.text.toString().toDoubleOrNull()

            if (price != null) {
                outputText.text = "$%.2f".format(price)
                tipamount.text=""
            } else {
                outputText.text = "Enter a valid number"
            }
        }



    }
}