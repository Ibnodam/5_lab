package com.example.a5_lab


import android.content.Intent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.graphics.Color
import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.a5_lab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

         binding.btnHelp.setOnClickListener{
            showHelpDialog()
        }
        binding.btnExit.setOnClickListener{
            finishAffinity()
        }
        binding.btnInput.setOnClickListener {

            val intent = Intent(this, SetActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        // Получаем данные из Intent
        val intent = intent
        val red = intent.getIntExtra("RED_VALUE", 0)
        val green = intent.getIntExtra("GREEN_VALUE", 0)
        val blue = intent.getIntExtra("BLUE_VALUE", 0)
        val left_checked = intent.getBooleanExtra("LEFT_CHECKED", false)
        val right_checked = intent.getBooleanExtra("RIGHT_CHECKED", false)

        // Отображаем полученные значения
        if (red != 0 || green != 0 || blue != 0) {
            Toast.makeText(this, "Click 'change' button to set: Red: $red, Green: $green, Blue: $blue", Toast.LENGTH_LONG).show()
        }

        binding.btnChange.setOnClickListener{
        if(left_checked) binding.left.setBackgroundColor(Color.rgb(red, green, blue))
        if(right_checked) binding.right.setBackgroundColor(Color.rgb(red, green, blue))
        }
    }

    
    private fun showHelpDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Manual for this APP")
        builder.setMessage("1. Input color - set RGB color. \n" +
                "2. Change - confirm new RGB changes. \n" +
                "3. Exit - close APP. \n" +
                "4. Help - manual for this APP. \n")
        builder.setPositiveButton("ОК") { dialog, _ -> dialog.dismiss() }
        builder.show()
    }
}
