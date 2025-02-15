package com.example.recycle;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder>{
    Context context;
    ArrayList<Contacts> arrayList;

    public ContactAdapter(Context context, ArrayList<Contacts> arrayList) {
        this.context = context;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.contactlists,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     holder.textContacts.setText(arrayList.get(position).name);
     holder.textNumber.setText(arrayList.get(position).number);

     holder.linearLayout.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Dialog dialog=new Dialog(context);
             dialog.setContentView(R.layout.add_contacts);
             EditText editName=dialog.findViewById(R.id.editName);
             EditText editNumber=dialog.findViewById(R.id.editNumber);
             Button btAdd=dialog.findViewById(R.id.btAdd);
             btAdd.setText("Update");
             editName.setText(arrayList.get(position).name);
             editNumber.setText(arrayList.get(position).number);


             btAdd.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     String name="",number="";
                     if(!editName.getText().toString().equals("")){
                         name =editName.getText().toString();
                     }else {
                         Toast.makeText(context, "Please enter name", Toast.LENGTH_SHORT).show();
                     }
                     if(!editNumber.getText().toString().equals("")){
                         number=editNumber.getText().toString();

                     }else{
                         Toast.makeText(context, "Please enter number", Toast.LENGTH_SHORT).show();
                     }
                 arrayList.set(position,new Contacts(name,number));
                     notifyItemChanged(position);
                 dialog.dismiss();
                 }
             });
             dialog.show();
         }
     });
     holder.linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
         @Override
         public boolean onLongClick(View v) {
             AlertDialog.Builder builder=new AlertDialog.Builder(context)
                     .setTitle("Delete")
                     .setMessage("Are you sure you want to delete this contact")
                     .setIcon(R.drawable.delete)
                     .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             arrayList.remove(position);
                             notifyItemRemoved(position);


                         }
                     }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {

                         }
                     });
             builder.show();


             return false;
         }
     });

    }

    @Override
    public int getItemCount() {
        Log.e("getItemCount: ", ""+arrayList.size() );
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
     TextView textNumber,textContacts;
     ImageView imageView;
     LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           textNumber= itemView.findViewById(R.id.textNumber);
            textContacts= itemView.findViewById(R.id.textContacts);
            imageView= itemView.findViewById(R.id.imageView);
            linearLayout= itemView.findViewById(R.id.linearLayout);



        }
    }


}
