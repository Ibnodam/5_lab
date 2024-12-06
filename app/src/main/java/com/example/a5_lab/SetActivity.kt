package com.example.a5_lab

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a5_lab.databinding.ActivitySetBinding
import android.content.Intent


class SetActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOk.setOnClickListener{
            // Получаем значения из полей, если поле пустое, то передаем 0
            var red = binding.redInput.text.toString().toIntOrNull() ?: 0
            if(red > 255) red = 255
            var green = binding.greenInput.text.toString().toIntOrNull() ?: 0
            if(green > 255) green = 255
            var blue = binding.blueInput.text.toString().toIntOrNull() ?: 0
            if(blue > 255) blue = 255

            var left_checked: Boolean = binding.leftCheck.isChecked
            var right_checked: Boolean = binding.rightCheck.isChecked

            // Создаем Intent для передачи данных обратно в MainActivity
            val resultIntent = Intent(this, MainActivity::class.java).apply {
                putExtra("RED_VALUE", red)
                putExtra("GREEN_VALUE", green)
                putExtra("BLUE_VALUE", blue)
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