package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var firstOperandET: EditText
    private lateinit var secondOperandET: EditText

    private lateinit var ButtonSummBTN: Button
    private lateinit var ButtonDivBTN: Button

    private lateinit var ButtonResetBTN: Button
    private lateinit var ButtonExitBTN: Button

    private lateinit var resultTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        firstOperandET = findViewById(R.id.firstOperandET)
        secondOperandET = findViewById(R.id.secondOperandET)

        ButtonSummBTN = findViewById(R.id.ButtonSummBTN)
        ButtonDivBTN = findViewById(R.id.ButtonDivBTN)

        ButtonExitBTN = findViewById(R.id.ButtonExitBTN)
        ButtonResetBTN = findViewById(R.id.ButtonResetBTN)

        resultTV = findViewById(R.id.Result)

        ButtonSummBTN.setOnClickListener(this)
        ButtonDivBTN.setOnClickListener(this)
        ButtonResetBTN.setOnClickListener(this)
        ButtonExitBTN.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        var check = true
        if (v.id == R.id.ButtonExitBTN) finish()
        if (firstOperandET.text.isEmpty() || secondOperandET.text.isEmpty()) {
            return
        }

        var first = firstOperandET.text.toString()
        var second = secondOperandET.text.toString()

        var result = when (v.id) {
            R.id.ButtonSummBTN -> Operation(first,second).sumFirstSecond()
            R.id.ButtonDivBTN -> Operation(first,second).diffFirstSecond()
            R.id.ButtonResetBTN -> {
                firstOperandET.text.clear()
                secondOperandET.text.clear()
                check = false
            }

            else -> 0

        }



        if (!check) resultTV.text = "Результат"   else resultTV.text = result.toString()

    }

}

