package com.example.studentskillslist

import kotlin.random.Random

data class StudentSkillsList(
    var studentName: String ,
    var studentSkillsName: String
) {
    companion object {
        var studentNames = arrayListOf(
            "Albert" ,
            "Ben" ,
            "Cameron" ,
            "Daniel" ,
            "Elijah" ,
            "Flintoff" ,
            "George" ,
            "Hughes" ,
            "Isaac" ,
            "Joe" ,
            "Kirsten" ,
            "Lawrence" ,
            "Michael" ,
            "Nathan" ,
            "Oscar" ,
            "Pope" ,
            "Quinn" ,
            "Ryan" ,
            "Sam" ,
            "Tim" ,
            "Ulric" ,
            "Victor" ,
            "Winston" ,
            "Xavier" ,
            "Yoel" ,
            "Zak"
        )
        var studentSkillsNames = arrayListOf(
            "C++" ,
            "C" ,
            "Python" ,
            "Java" ,
            "Kotlin" ,
            "Swift" ,
            "JavaScript" ,
            "Objective-C" ,
            "Git" ,
            "Android Development" ,
            "IOS Development" ,
            "Machine Learning" ,
            "Deep Learning" ,
            "Front-End Development" ,
            "Back-End Development"
        )

        fun getStudentsList(noOfStudents: Int): ArrayList<StudentSkillsList> {
            var arrayListOfStudents = ArrayList<StudentSkillsList>()
            for(i in 0 until noOfStudents) {
                arrayListOfStudents.add (
                    StudentSkillsList(
                        studentNames[Random.nextInt(26)] ,
                        studentSkillsNames[Random.nextInt(15)]
                    )
                )
            }
            return arrayListOfStudents
        }
    }
}