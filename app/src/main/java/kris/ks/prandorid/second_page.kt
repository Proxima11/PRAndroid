package kris.ks.prandorid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class second_page : AppCompatActivity() {
    companion object{
        val res = "result"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.second_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.history)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //back to first page
        var _btnBack = findViewById<Button>(R.id.back)
        _btnBack.setOnClickListener {
            val intentBack = Intent(this@second_page, MainActivity::class.java).apply {
            }
            startActivity(intentBack)
        }

        //history (third page)
        var _btnHistory = findViewById<Button>(R.id.history1)
        _btnHistory.setOnClickListener {
            val intentHistory = Intent(this@second_page, third_page::class.java).apply {

            }
            startActivity(intentHistory)
        }

        val intentOp = intent.getStringExtra(res)

        val result = compute(intentOp)

        val show_result = findViewById<TextView>(R.id.result_display)
        third_page.dataHistory.add(HistoryCalc(intentOp, result.toInt()))
        show_result.text = result
    }

    fun compute(operation: String?): String{
        var first_num = ""
        if (operation != null) {
            var sec = false
            var op = ""
            var second_num = ""
            for((index, opr) in operation.withIndex()){
                if(opr.equals('1') || opr.equals('2') || opr.equals('3') || opr.equals('4') || opr.equals('5') || opr.equals('6') || opr.equals('7') || opr.equals('8') || opr.equals('9') || opr.equals('0')){
                    if (!sec){
                        first_num += opr
                    }
                    else{
                        second_num += opr
                    }
                }
                else{
                    if (sec){
                        if (op.equals("+")){
                            first_num = (first_num.toInt() + second_num.toInt()).toString()
                            second_num = ""
                        }
                        else if (op.equals("-")){
                            first_num = (first_num.toInt() - second_num.toInt()).toString()
                            second_num = ""
                        }
                        else if (op.equals("x")){
                            first_num = (first_num.toInt() * second_num.toInt()).toString()
                            second_num = ""
                        }
                        else if (op.equals("/")){
                            if(second_num.toInt() != 0) {
                                first_num = (first_num.toInt() / second_num.toInt()).toString()
                                second_num = ""
                            }else{
                                first_num = "INVALID DIVIDED BY ZERO"
                                break
                            }
                        }
                        sec = false
                    }

                    if (!sec){
                        op = opr.toString()
                        sec = true
                    }
                }

                if(index == operation.length-1){
                    if (op.equals("+")){
                        first_num = (first_num.toInt() + second_num.toInt()).toString()
                    }
                    else if (op.equals("-")){
                        first_num = (first_num.toInt() - second_num.toInt()).toString()
                    }
                    else if (op.equals("x")){
                        first_num = (first_num.toInt() * second_num.toInt()).toString()
                    }
                    else if (op.equals("/")){
                        if(second_num.toInt() != 0) {
                            first_num = (first_num.toInt() / second_num.toInt()).toString()
                        }else{
                            first_num = "INVALID DIVIDED BY ZERO"
                            break
                        }
                    }
                }
            }
        }
        return first_num
    }
}