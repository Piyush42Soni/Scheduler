/*
 * Copyright (c) 2022.
 * All Rights Reserved
 */

package com.example.scheduler

import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.findFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.scheduler.database.Points
import com.example.scheduler.fragments.MonthlyFragment
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MonthlyAdapter @Inject constructor(
    private val dataSet: List<Points>
) : RecyclerView.Adapter<MonthlyAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val Button: Button
        val constraintLayout: ConstraintLayout

        init {
            // Define click listener for the ViewHolder's View.
            Button = view.findViewById(R.id.textView2)
            constraintLayout = view.findViewById(R.id.yoho)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.Button.text = dataSet[position].Date?.dayOfMonth.toString()
        if ((dataSet[position].Book > 20) and (((dataSet[position].Coding_Questions) >= 2) or ((dataSet[position].CollegeStudy) >= 1)) and ((dataSet[position].Calories_burnt) > 460)) {
            viewHolder.Button.setBackgroundColor(Color.GREEN)
        } else if ((((dataSet[position].Coding_Questions) >= 2) or ((dataSet[position].CollegeStudy) >= 1)) and ((dataSet[position].Calories_burnt) > 300)) {
            viewHolder.Button.setBackgroundColor(Color.YELLOW)
        } else {
            viewHolder.Button.setBackgroundColor(Color.GRAY)
        }
        viewHolder.Button.setOnClickListener {
            val fmt: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            val s = "Date: ${dataSet[position].Date?.format(fmt).toString()}\n" +
                    "Calories Burnt: ${dataSet[position].Calories_burnt}\n" +
                    "Screen Time: ${dataSet[position].ScreenTime}\n" +
                    "Coding Questions: ${dataSet[position].Coding_Questions}\n" +
                    "College Study: ${dataSet[position].CollegeStudy}\n" +
                    "Wake Up at: ${dataSet[position].Wake}\n" +
                    "The number of pages read of any Book: ${dataSet[position].Book}"
            val s1: String? = "Info"
            StartGameDialogFragment(s).show(
                it.findFragment<MonthlyFragment>().childFragmentManager,
                s1
            )
        }
        // Return the size of your dataset (invoked by the layout manager)
    }

    class StartGameDialogFragment @Inject constructor(cont: String) : DialogFragment() {
        private val s1 = cont
        override fun onCreateDialog(savedInstanceState: Bundle?): AlertDialog {
            return activity?.let {
                val builder = AlertDialog.Builder(it)
                    // Set the dialog title
                    // Specify the list array, the items to be selected by default (null for none),
                    // and the listener through which to receive callbacks when items are selected
                    .setMessage(s1)
                    .setPositiveButton("Ok",
                        DialogInterface.OnClickListener { dialog, id ->
                            dialog.cancel()
                        })

                builder.create()
            } ?: throw IllegalStateException("Activity cannot be null")
        }
    }

    override fun getItemCount() = dataSet.size

}
