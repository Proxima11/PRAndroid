package kris.ks.prandorid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.first_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.history)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var operation = ""
        var display = findViewById<TextView>(R.id.display)


        var _btnSum = findViewById<Button>(R.id.summary)
        _btnSum.setOnClickListener {
            val intentRes = Intent(this@MainActivity, second_page::class.java).apply {

            }
            startActivity(intentRes)
        }

        var _btnHist = findViewById<Button>(R.id.history2)
        _btnHist.setOnClickListener {
            val intentHist = Intent(this@MainActivity, third_page::class.java).apply {

            }
            startActivity(intentHist)
        }

        var _btnOne = findViewById<Button>(R.id.one)
        _btnOne.setOnClickListener {
            operation += "1"
            display.setText(operation)
        }

        var _btnTwo = findViewById<Button>(R.id.two)
        _btnTwo.setOnClickListener {
            operation += "2"
            display.setText(operation)
        }

        var _btnThree = findViewById<Button>(R.id.three)
        _btnThree.setOnClickListener {
            operation += "3"
            display.setText(operation)
        }

        var _btnFour = findViewById<Button>(R.id.four)
        _btnFour.setOnClickListener {
            operation += "4"
            display.setText(operation)
        }

        var _btnFive = findViewById<Button>(R.id.five)
        _btnFive.setOnClickListener {
            operation += "5"
            display.setText(operation)
        }

        var _btnSix = findViewById<Button>(R.id.six)
        _btnSix.setOnClickListener {
            operation += "6"
            display.setText(operation)
        }

        var _btnSeven = findViewById<Button>(R.id.seven)
        _btnSeven.setOnClickListener {
            operation += "7"
            display.setText(operation)
        }

        var _btnEight = findViewById<Button>(R.id.eight)
        _btnEight.setOnClickListener {
            operation += "8"
            display.setText(operation)
        }

        var _btnNine = findViewById<Button>(R.id.nine)
        _btnNine.setOnClickListener {
            operation += "9"
            display.setText(operation)
        }

        var _btnZero = findViewById<Button>(R.id.zero)
        _btnZero.setOnClickListener {
            if (!operation.equals("")){
                operation += "0"
                display.setText(operation)
            }

        }

        var _btnMultiply = findViewById<Button>(R.id.multiple)
        _btnMultiply.setOnClickListener {
            if (!operation.equals("") || !operation[operation.length-1].equals("+") || !operation[operation.length-1].equals("-") || !operation[operation.length-1].equals("x") || !operation[operation.length-1].equals("/")){
                operation += "x"
                display.setText(operation)
            }
        }

        var _btnMinus = findViewById<Button>(R.id.minus)
        _btnMinus.setOnClickListener {
            if (!operation.equals("") || !operation[operation.length-1].equals("+") || !operation[operation.length-1].equals("-") || !operation[operation.length-1].equals("x") || !operation[operation.length-1].equals("/")){
                operation += "-"
                display.setText(operation)
            }
        }

        var _btnPlus = findViewById<Button>(R.id.plus)
        _btnPlus.setOnClickListener {
            if (!operation.equals("") || !operation[operation.length-1].equals("+") || !operation[operation.length-1].equals("-") || !operation[operation.length-1].equals("x") || !operation[operation.length-1].equals("/")){
                operation += "+"
                display.setText(operation)
            }
        }

        var _btnDivide = findViewById<Button>(R.id.division)
        _btnDivide.setOnClickListener {
            if (!operation.equals("") || !operation[operation.length-1].equals("+") || !operation[operation.length-1].equals("-") || !operation[operation.length-1].equals("x") || !operation[operation.length-1].equals("/")){
                operation += "/"
                display.setText(operation)
            }
        }
    }
}