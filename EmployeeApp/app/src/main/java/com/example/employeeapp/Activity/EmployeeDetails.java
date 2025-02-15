package com.example.employeeapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.employeeapp.R;

public class EmployeeDetails extends AppCompatActivity {

    TextView textId,textName,textSalary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        textId=findViewById(R.id.textId);
        textName=findViewById(R.id.textName);
        textSalary=findViewById(R.id.textSalary);

        Intent intent=getIntent();
        Employee e= (Employee) intent.getSerializableExtra("employee");
        textId.setText("id"+e.getId());
        textName.setText("id"+e.getName());
        textSalary.setText("id"+e.getSalary());


    }
}