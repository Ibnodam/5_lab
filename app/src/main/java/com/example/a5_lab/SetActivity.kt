package com.example.a5_lab

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a5_lab.databinding.ActivitySetBinding


class SetActivity : AppCompatActivity() {
    lateinit var binding: ActivitySetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOk.setOnClickListener{
            val colorr: color = color(binding.redInput.text.toString().toIntOrNull() ?: 0, binding.greenInput.text.toString().toIntOrNull() ?: 0, binding.blueInput.text.toString().toIntOrNull() ?: 0)
            // Получаем значения из полей, если поле пустое, то передаем 0

            var left_checked: Boolean = binding.leftCheck.isChecked
            var right_checked: Boolean = binding.rightCheck.isChecked

            // Создаем Intent для передачи данных обратно в MainActivity
            val resultIntent = Intent(this, MainActivity::class.java).apply {
                putExtra("RED_VALUE", colorr.red)
                putExtra("GREEN_VALUE", colorr.green)
                putExtra("BLUE_VALUE", colorr.blue)
                putExtra("LEFT_CHECKED", left_checked)
                putExtra("RIGHT_CHECKED", right_checked)
            }

            // Запускаем MainActivity с переданными данными
            startActivity(resultIntent)

            // Завершаем текущую активность
            finish()
        }



    }
}
