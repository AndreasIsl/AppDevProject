package com.example.appdevkalender

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
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
    private lateinit var calenderDayBtns: Array<Button>


    @SuppressLint("ResourceAsColor")
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

        val statusTV = binding.statusTV
        val appointmentTV = binding.appointmentsTV

          calenderDayBtns = arrayOf<Button>(
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


        makeBtnInvisibleAndVisible(chosenMonth)
        calenderDayBtns[chosenDay - 1].setBackgroundColor(R.color.green)

        previousBtn.setOnClickListener {
            if(chosenMonth  == 0){
                chosenMonth = 11
                chosenYear --
                dateBtn.text = "${months[chosenMonth]} ${chosenYear}"
            }else {
                chosenMonth --
                dateBtn.text = "${months[chosenMonth]} ${chosenYear}"
            }
            makeBtnInvisibleAndVisible(chosenMonth)
            //check if its the current month if not make the currentdayBtn white

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
            makeBtnInvisibleAndVisible(chosenMonth)
            //check if its the current month if not make the currentdayBtn white

        }


        for (btn in calenderDayBtns.indices) {
            calenderDayBtns[btn].setOnClickListener {
                statusTV.text = "${btn + 1}.${chosenMonth + 1}.${chosenYear}"
                appointmentTV.text = "${btn + 1} of ${months[chosenMonth]} no Appointments "
            }
        }




    }

    private fun checkIfCurrentDate(date: Date): Boolean {
        if (date.year == year && date.month == month) {
            return true
        }
        return false
    }

    private fun checkIfCurrentMonthIs31(month: Int): Boolean {
        if (month == 0 || month == 2 || month == 4 || month == 6 || month == 7 || month == 9 || month == 11){
            return true
        }
        return false
    }

    private fun makeBtnInvisibleAndVisible(month: Int) {
        if (checkIfCurrentMonthIs31(month)) {
            calenderDayBtns[30].visibility = View.VISIBLE
            calenderDayBtns[29].visibility = View.VISIBLE
            calenderDayBtns[28].visibility = View.VISIBLE
        } else if (month == 1) {
            calenderDayBtns[30].visibility = View.GONE
            calenderDayBtns[29].visibility = View.GONE
            calenderDayBtns[28].visibility = View.GONE
        } else {
            calenderDayBtns[30].visibility = View.GONE
            calenderDayBtns[29].visibility = View.VISIBLE
            calenderDayBtns[28].visibility = View.VISIBLE
        }
    }
}