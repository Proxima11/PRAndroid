package kris.ks.prandorid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class third_page : AppCompatActivity() {
    companion object{
        val dataHistory : ArrayList<HistoryCalc> = arrayListOf()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.third_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.history)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var _btnBack = findViewById<Button>(R.id.Back2)
        _btnBack.setOnClickListener {
            val intenttoBack = Intent(this@third_page, MainActivity::class.java).apply {
            }
            startActivity(intenttoBack)
        }
    }


}