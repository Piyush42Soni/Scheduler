package com.example.scheduler

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.scheduler.database.Points
import com.example.scheduler.database.repo.PointsRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MonthlyAdapter@Inject constructor(
    private val dataSet: List<Points>
): RecyclerView.Adapter<MonthlyAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val constraintLayout:ConstraintLayout
        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.textView2)
            constraintLayout=view.findViewById(R.id.yoho)
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)

        return ViewHolder(view)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = dataSet[position].Date.toString().subSequence(0..1)
        if((dataSet[position].Book>20) and (((dataSet[position].Coding_Questions)>2) or ((dataSet[position].CollegeStudy)>=1)) and ((dataSet[position].Calories_burnt)>460)){
            viewHolder.textView.setBackgroundColor(Color.GREEN)
        }
        else if((((dataSet[position].Coding_Questions)>2) or ((dataSet[position].CollegeStudy)>=1)) and ((dataSet[position].Calories_burnt)>300)){
            viewHolder.textView.setBackgroundColor(Color.YELLOW)
        }
        else{
            viewHolder.textView.setBackgroundColor(Color.GRAY)
        }
    }
    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
