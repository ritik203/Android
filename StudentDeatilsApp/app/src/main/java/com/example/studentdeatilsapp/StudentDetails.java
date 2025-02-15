package com.example.studentdeatilsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StudentDetails extends AppCompatActivity {

    TextView textRollNo,textName,textCourse,textMarks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_details);
        textRollNo=findViewById(R.id.textRollNo);
        textName=findViewById(R.id.textName);
        textCourse=findViewById(R.id.textCourse);
        textMarks=findViewById(R.id.textMarks);

        Intent intent= getIntent();
        Student s= (Student) intent.getSerializableExtra("student");
        textRollNo.setText("Id"+s.getRollno());
        textName.setText("Rollno"+s.getName());
        textCourse.setText("Course"+s.getCourse());
        textMarks.setText("marks"+s.getMarks());



    }
}