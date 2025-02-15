package com.example.retromobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEditActivity extends AppCompatActivity {
   EditText editName;
   EditText editEmail;
   EditText editPassword;
   EditText editMobile;

   TextView textName;
   User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        editMobile = findViewById(R.id.editMobile);

        textName = findViewById(R.id.textName);
        textName.setText("Add User");
        user=new User();
        finish();


    }
private void insertUser(){

}




    public void save(View view){
      user.setName(editName.getText().toString());
      user.setEmail(editEmail.getText().toString());
      user.setMobile(editMobile.getText().toString());
      user.setPassword(editPassword.getText().toString());

      RetrofitClient.getInstance().getApi().insertUsers(user).enqueue(new Callback<JsonObject>() {
          @Override
          public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
              Toast.makeText(AddEditActivity.this, "Insert Method Called", Toast.LENGTH_SHORT).show();
          }

          @Override
          public void onFailure(Call<JsonObject> call, Throwable throwable) {
              Toast.makeText(AddEditActivity.this, "Insert Failed", Toast.LENGTH_SHORT).show();
          }
      });




    }
}