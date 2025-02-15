package com.example.sharedprefrences;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddProduct extends AppCompatActivity {
  EditText editName,editPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        editName=findViewById(R.id.editName);
        editPrice=findViewById(R.id.editPrice);
    }
    public void save(View view){


    }

    public void cancel(View view){
        finish();

    }



}