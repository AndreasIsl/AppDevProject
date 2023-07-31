package com.example.appdevkalender

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.appdevkalender.databinding.ActivityMainBinding
import java.util.*

data class Event(
    val title: String,
    val description: String,
    val time: String
)

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val calendar = Calendar.getInstance()
    private val chosenYear = calendar.get(Calendar.YEAR)
    private val chosenMonth = calendar.get(Calendar.MONTH)
    private val chosenDay = calendar.get(Calendar.DAY_OF_MONTH)
    private lateinit var calenderDayBtns: Array<Button>
    private val eventsMap: HashMap<String, Event> = HashMap()

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Rest of the code remains the same

        binding.btnAddEvent.setOnClickListener {
            val selectedDate = "${chosenDay}.${chosenMonth + 1}.${chosenYear}"
            showAddEventDialog(selectedDate)
        }
    }

    // Rest of the code remains the same

    private fun showAddEventDialog(date: String) {
        val dialog = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.dialog_add_event, null)
        dialog.setView(dialogView)
        dialog.setTitle("Add Event")

        val eventTitleEditText = dialogView.findViewById<EditText>(R.id.etEventTitle)
        val eventDescriptionEditText = dialogView.findViewById<EditText>(R.id.etEventDescription)
        // Add any other EditTexts or pickers for time, etc.

        dialog.setPositiveButton("Save") { _, _ ->
            val eventTitle = eventTitleEditText.text.toString()
            val eventDescription = eventDescriptionEditText.text.toString()
            // Get the time from other input fields in the dialog.

            val currentDate = getCurrentDate()
            val year = currentDate.get(Calendar.YEAR)
            val month = currentDate.get(Calendar.MONTH) + 1 // Months are zero-based, so we add 1
            val day = currentDate.get(Calendar.DAY_OF_MONTH)
            val hour = currentDate.get(Calendar.HOUR_OF_DAY)
            val minute = currentDate.get(Calendar.MINUTE)

            println("Current Date: $year-$month-$day")
            val event = Event(eventTitle, eventDescription, "$year-$month-$day $hour:$minute")
            eventsMap[date] = event

            // Update the UI for the corresponding day button to show the event icon.
            // updateDayButtonWithEventIcon(date)
        }

        dialog.setNegativeButton("Cancel") { dialog: DialogInterface, _: Int ->
            dialog.cancel()
        }

        dialog.show()
    }

    fun getCurrentDate(): Calendar {
        return Calendar.getInstance()
    }

    /*private fun updateDayButtonWithEventIcon(date: String) {
        val day = date.substringBefore(".")
        val buttonIndex = day.toInt() - 1

        // Set the event icon on the day button.
        calenderDayBtns[buttonIndex].setCompoundDrawablesWithIntrinsicBounds(
            0, 0, R.drawable.event_icon, 0
        )
    }*/
}
