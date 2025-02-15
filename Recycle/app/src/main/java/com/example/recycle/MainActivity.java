package com.example.recycle;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     RecyclerView recycleView;
     FloatingActionButton add;
     EditText editName,editNumber;
     Button btAdd;
     ContactAdapter contactAdapter;

     ArrayList<Contacts> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      recycleView=findViewById(R.id.recycleView);
      add=findViewById(R.id.add);

      arrayList.add(new Contacts(R.drawable.contacts,"Virat","98643726327"));
      arrayList.add(new Contacts(R.drawable.contacts,"Rohit","9123556771"));

        recycleView.setLayoutManager(new LinearLayoutManager(this));

        ContactAdapter contactAdapter=new ContactAdapter(this,arrayList);
        recycleView.setAdapter(contactAdapter);

      add.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Dialog dialog=new Dialog(MainActivity.this);
              dialog.setContentView(R.layout.add_contacts);
              editName=dialog.findViewById(R.id.editName);
              editNumber=dialog.findViewById(R.id.editNumber);
              btAdd=dialog.findViewById(R.id.btAdd);

              btAdd.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      String name="",number="";
                      if(!editName.getText().toString().equals("")){
                       name =editName.getText().toString();
                      }else {
                          Toast.makeText(MainActivity.this, "Name can't be Empty", Toast.LENGTH_SHORT).show();
                      }
                      if(!editNumber.getText().toString().equals("")){
                      number=editNumber.getText().toString();}
                      else{
                          Toast.makeText(MainActivity.this, "Number can't be Empty", Toast.LENGTH_SHORT).show();
                      }
                      arrayList.add(new Contacts(name,number));
                      contactAdapter.notifyItemChanged(arrayList.size()-1);
                      recycleView.scrollToPosition(arrayList.size()-1);
                      dialog.dismiss();

                  }
              });
               dialog.show();

          }
      });

    }
}