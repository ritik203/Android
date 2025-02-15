package com.example.studentdeatilsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddStudent extends AppCompatActivity {
EditText editRollno,editName,editMarks,editCourse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        editRollno=findViewById(R.id.editRollNo);
        editName=findViewById(R.id.editName);
        editCourse=findViewById(R.id.editCourse);
        editMarks=findViewById(R.id.editMarks);

    }

    public  void save(View view){
        Student student=new Student();
        student.setRollno(Integer.parseInt(editRollno.getText().toString()));
        student.setName(editName.getText().toString());
        student.setCourse(editCourse.getText().toString());
        student.setMarks(Double.parseDouble(editMarks.getText().toString()));

        Intent intent=new Intent();
        intent.putExtra("student",student);
        setResult(1,intent);
        finish();

    }

    public  void btCancel(View view){
        finish();
    }
}