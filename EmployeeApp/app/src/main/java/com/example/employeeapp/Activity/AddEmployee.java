package com.example.employeeapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.employeeapp.R;

public class AddEmployee extends AppCompatActivity {

    EditText editId,editName,editSalary;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_employee);
        editId=findViewById(R.id.editId);
        editName=findViewById(R.id.editName);
        editSalary=findViewById(R.id.editSalary);



    }
 public void save(View view){
     Employee e=new Employee();
     e.setId(Integer.parseInt(editId.getText().toString()));
     e.setName(editName.getText().toString());
     e.setSalary(Double.parseDouble(editSalary.getText().toString()));
     Intent intent=new Intent();
     setResult(1,intent);
     finish();

 }
 public  void  cancel(View view){
        finish();
 }


}