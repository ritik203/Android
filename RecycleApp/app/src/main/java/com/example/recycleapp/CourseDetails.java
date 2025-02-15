package com.example.recycleapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CourseDetails extends AppCompatActivity {
    TextView textName,textEligibilty,textDescription,textFees;
  ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);
        imageView = findViewById(R.id.image);
        textName = findViewById(R.id.textName);

        textEligibilty = findViewById(R.id.textEligi);

        textDescription = findViewById(R.id.textDetails);
        textFees = findViewById(R.id.textFees);

         Intent intent=getIntent();
        Course course= (Course) intent.getSerializableExtra("course");
         imageView.setImageResource(course.getImage());
         textName.setText(course.getCourseName());
        textEligibilty.setText(course.getEligibility());

        textDescription.setText(course.getCourseDesc());
        textFees.setText(""+ course.getFees());




    }



}