package com.example.employeesql;

import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
 RecyclerView recyclerView;
 List<String> countries;

 CountryAdaptar countryAdaptar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       getCountries();
       adap




    }

    public void getCountries(){
        CountryDbHelper dbHelper=new CountryDbHelper(this);

    }
}