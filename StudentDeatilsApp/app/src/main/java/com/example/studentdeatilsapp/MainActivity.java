package com.example.studentdeatilsapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.helper.widget.Grid;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   Toolbar toolBar;
   RecyclerView recyclerView;
   List<Student> studentList;
  StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        toolBar=findViewById(R.id.toolBar);
        recyclerView=findViewById(R.id.recycleView);
        setSupportActionBar(toolBar);
        studentList=new ArrayList<>();
        studentList.add(new Student(1,"jatin","Dmc", 80.0));
        studentAdapter=new StudentAdapter(this,studentList);
        recyclerView.setAdapter(studentAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

    }



    ActivityResultLauncher launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult	(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == 1) {
                Intent intent = result.getData();
                Student student = (Student) intent.getSerializableExtra("student");
                Log.e( "onActivityResult: ", student.toString());
                Toast.makeText(MainActivity.this, student.toString()+"", Toast.LENGTH_SHORT).show();
                studentList.add(student);


            }
        }
    });



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent=new Intent(this, AddStudent.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}