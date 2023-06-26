package com.example.appdevkalender

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import com.example.appdevkalender.databinding.ActivityMainBinding
import java.time.Month
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val calendar = Calendar.getInstance()
    private  val year = calendar.get(Calendar.YEAR)
    private val month = calendar.get(Calendar.MONTH)
    private val day = calendar.get(Calendar.DAY_OF_MONTH)

    private fun checkIfCurrentDate(date: Date): Boolean {
        if (date.year == year && date.month == month) {
            return true
        }
        return false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val months = arrayOf("Jannuar","Februar","März","April","May","Juny","July","August","September","Oktober","November","December")
        val previousBtn = binding.btnBefore
        val nextBtn = binding.btnNext

        var chosenYear = year
        var chosenMonth = month
        var chosenDay = day
        var chour = 0
        var cminute = 0

        val dateBtn = binding.btnDate
        dateBtn.text = "${months[chosenMonth]} $chosenYear"

        val calenderDayBtns = arrayOf<Button>(
            binding.btnKalender1,
            binding.btnKalender2,
            binding.btnKalender3,
            binding.btnKalender4,
            binding.btnKalender5,
            binding.btnKalender6,
            binding.btnKalender7,
            binding.btnKalender8,
            binding.btnKalender9,
            binding.btnKalender10,
            binding.btnKalender11,
            binding.btnKalender12,
            binding.btnKalender13,
            binding.btnKalender14,
            binding.btnKalender15,
            binding.btnKalender16,
            binding.btnKalender17,
            binding.btnKalender18,
            binding.btnKalender19,
            binding.btnKalender20,
            binding.btnKalender21,
            binding.btnKalender22,
            binding.btnKalender23,
            binding.btnKalender24,
            binding.btnKalender25,
            binding.btnKalender26,
            binding.btnKalender27,
            binding.btnKalender28,
            binding.btnKalender29,
            binding.btnKalender30,
            binding.btnKalender31
        )

        calenderDayBtns[chosenDay - 1].setBackgroundColor(ContextCompat.getColor(this, R.color.green))
        Log.d("test", "chosenMonth = ${months[0]}")
        previousBtn.setOnClickListener {
            if(chosenMonth  == 0){
                chosenMonth = 11
                chosenYear --
                dateBtn.text = "${months[chosenMonth]} ${chosenYear}"
            }else {
                chosenMonth --
                dateBtn.text = "${months[chosenMonth]} ${chosenYear}"
            }
        }

        nextBtn.setOnClickListener {
            if(chosenMonth  == 11){
                chosenMonth = 0
                chosenYear ++
                dateBtn.text = "${months[chosenMonth]} ${chosenYear}"
            } else {
                chosenMonth ++
                dateBtn.text = "${months[chosenMonth]} ${chosenYear}"

            }
        }
    }
}