package com.example.studentskillslist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.student_skills_list.view.*

class MainActivity : AppCompatActivity() {

    var studentsList: ArrayList<StudentSkillsList> = StudentSkillsList.getStudentsList(10)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var studentAdapter = StudentAdapter(this , studentsList)
        recyclerView.adapter = studentAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        var studentName: String
        var skillName: String

        addButton.setOnClickListener {
            studentName = etStudentName.text.toString()
            skillName = etSkillName.text.toString()
            if(studentName.isNotEmpty() && skillName.isNotEmpty()) {
                var position = studentsList.size
                studentsList.add(StudentSkillsList(studentName , skillName))
                studentAdapter.notifyItemInserted(position)
            } else {
                Toast.makeText(this , "Enter valid input!", Toast.LENGTH_SHORT).show()
            }

        }

        removeButton.setOnClickListener {
            studentName = etStudentName.text.toString()
            skillName = etSkillName.text.toString()
            if(studentName.isNotEmpty() && skillName.isNotEmpty()) {
                var position = findStudent(studentName , skillName , studentsList)
                if(position == -1) {
                    Toast.makeText(this , "Item not found!", Toast.LENGTH_SHORT).show()
                } else {
                    studentsList.removeAt(position)
                    studentAdapter.notifyItemRemoved(position)
                }
            } else {
                Toast.makeText(this , "Enter valid input!", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun findStudent(studentName: String, skillName: String, studentsList: ArrayList<StudentSkillsList>): Int {
        for(i in 0 until studentsList.size) {
            if(studentName == studentsList[i].studentName && skillName == studentsList[i].studentSkillsName)
                return i
        }
        return -1
    }

    class StudentAdapter(
        var context: Context,
        var studentsList: ArrayList<StudentSkillsList>
    ) : RecyclerView.Adapter <StudentAdapter.ViewHolder>() {
        inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
            init {
                view.setOnClickListener { view ->
                    val studentName = view.studentName.text
                    val studentSkillName = view.studentSkillName.text
                    Toast.makeText(context , "$studentName is highly skilled in $studentSkillName", Toast.LENGTH_SHORT).show()
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.student_skills_list ,
                parent ,
                false
            )
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return studentsList.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.view.studentName.text = studentsList[position].studentName
            holder.view.studentSkillName.text = studentsList[position].studentSkillsName
        }

    }
}