package com.example.retromobileapp;

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

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserSearchActivity extends AppCompatActivity {


    TextView textName,textEmail,textMobile;
    EditText editId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_search);
        textName=findViewById(R.id.textName);
        textEmail=findViewById(R.id.textEmail);
        textMobile=findViewById(R.id.textMobile);
        editId=findViewById(R.id.editId);

    }
    public void search(View view){
      int id = Integer.parseInt(editId.getText().toString());
      RetrofitClient.getInstance().getApi().getUserById(id).enqueue(new Callback<JsonObject>() {
          @Override
          public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
              if(response.body().get("stats").getAsString().equals("sucess")){
                  JsonElement element= response.body().get("data");
                  if(element!=null){
                      JsonObject object=element.getAsJsonObject();
                      textName.setText(object.get("name").getAsString());
                      textMobile.setText(object.get("mobile").getAsString());
                      textEmail.setText(object.get("email").getAsString());

                  }else{
                      textName.setText("Name");
                      textEmail.setText("Email");
                      textMobile.setText("Mobile");
                  }
              }
          }

          @Override
          public void onFailure(Call<JsonObject> call, Throwable throwable) {
              Toast.makeText(UserSearchActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
          }
      });


    }


}