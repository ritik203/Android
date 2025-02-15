package com.example.app1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editName,editEmail,editPhone,editPassword;
    TextView textName,textEmail,textPhone;
    Button btCancel;

    public static final String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName=findViewById(R.id.editName);
        editEmail=findViewById(R.id.editEmail);
        editPhone=findViewById(R.id.editPhone);
        editPassword=findViewById(R.id.editPassword);
        textName=findViewById(R.id.textName);
        textEmail=findViewById(R.id.textEmail);
        textPhone=findViewById(R.id.textPhone);
        btCancel=findViewById(R.id.btCancel);


        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG,"Cancel button clicked ");
                finish();
            }
        });
    }
public void save(View view){
        Log.e(TAG,"SaveButton clicked");
        String name=editName.getText().toString();
    String email=editEmail.getText().toString();
    String phone=editPhone.getText().toString();
    String password=editPassword.getText().toString();
    Log.e(TAG,name);
    Log.e(TAG,email);
    Log.e(TAG,phone);
    Log.e(TAG,password);
    textName.setText(name);
    textEmail.setText(email);
    textPhone.setText(phone);



}



}