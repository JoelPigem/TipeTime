package com.joelpigem.tipetime

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.joelpigem.tipetime.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //val editTextCostOfService: EditText = findViewById(R.id.cost_of_service)

       // val radioButtonTwenty: RadioButton = findViewById(R.id.option_twenty_percent)
       // val radioButtonFifteen: RadioButton = findViewById(R.id.option_fifteen_percent)
        // val radioButtonEighteen: RadioButton = findViewById(R.id.option_eighteen_percent)

        //val buttonCalculate: Button = findViewById(R.id.calculate_button)
        //val textViewTipResult: TextView = findViewById(R.id.tip_result)

        binding.calculateButton.setOnClickListener{
            val costOfServiceString = binding.costOfService.text.toString()
            val costOfService = costOfServiceString.toDoubleOrNull()
            if (binding.optionTwentyPercent.isChecked) {
                if (costOfService != null) {
                    binding.tipResult.text =  (costOfService * 0.2).toString()
                }
                else {
                    Toast.makeText(this, getString(R.string.possa_algun_valor),Toast.LENGTH_SHORT).show()
                }
            }
            else if (binding.optionFifteenPercent.isChecked) {
                if (costOfService != null) {
                    binding.tipResult.text =  (costOfService * 0.18).toString()
                }
                else {
                    Toast.makeText(this, getString(R.string.possa_algun_valor),Toast.LENGTH_SHORT).show()
                }
            }
            else if (binding.optionEighteenPercent.isChecked){
                if (costOfService != null) {
                    binding.tipResult.text =  (costOfService * 0.15).toString()
                }
                else {
                    Toast.makeText(this, getString(R.string.possa_algun_valor),Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}