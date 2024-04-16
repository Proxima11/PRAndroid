package kris.ks.prandorid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class second_page : AppCompatActivity() {
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
    }

}