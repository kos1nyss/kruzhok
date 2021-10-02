package com.bobnevpavel.app.util

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bobnevpavel.app.CourcesFragment
import com.bobnevpavel.app.CourseFragment
import com.bobnevpavel.app.R
import com.bobnevpavel.app.model.Course
import com.squareup.picasso.Picasso

class CoursesAdapter(val list:List<HashMap<String, Object>>, val coursesFragment:CourcesFragment) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CoursesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.simple_course_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as CoursesViewHolder
        Log.d("Data", list[position].toString())
        val ageText = "От " + list[position].get("age_from").toString() + " до " + list[position].get("age_to")
        viewHolder.title.text = list[position].get("title").toString()
        viewHolder.coast.text = list[position].get("price").toString() + " рублей"
        viewHolder.location.text = list[position].get("address").toString()
        viewHolder.ages.text = ageText
        Picasso.get().load(list[position]["image_url"].toString()).into(viewHolder.image)
        viewHolder.arrow.setOnClickListener(View.OnClickListener {
            coursesFragment.startCourseFragment(list[position])
        })
    }

    override fun getItemCount(): Int {
        return list.size
    }
    class CoursesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val item = itemView
        val image = itemView.findViewById<ImageView>(R.id.course_image)
        val title = itemView.findViewById<TextView>(R.id.course_title)
        val ages = itemView.findViewById<TextView>(R.id.course_ages)
        val coast = itemView.findViewById<TextView>(R.id.course_coast)
        val location = itemView.findViewById<TextView>(R.id.course_location)
        val arrow = itemView.findViewById<ImageView>(R.id.arrow)
    }
}