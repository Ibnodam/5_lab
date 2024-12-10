package com.example.a5_lab


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
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
