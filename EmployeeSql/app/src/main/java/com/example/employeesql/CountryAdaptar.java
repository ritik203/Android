package com.example.employeesql;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryAdaptar  extends RecyclerView.Adapter<CountryAdaptar.MyViwerHolder> {
  Context context;
  List<String> countries;

    public CountryAdaptar(Context context, List<String> countries) {
        this.context = context;
        this.countries = countries;
    }

    @NonNull
    @Override
    public MyViwerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1,null);
        return new MyViwerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViwerHolder holder, int position) {
    holder.textCountry.setText(countries.get(position));

    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class MyViwerHolder extends RecyclerView.ViewHolder{
         TextView textCountry;

        public MyViwerHolder(@NonNull View itemView) {
            super(itemView);
            textCountry=itemView.findViewById(android.R.id.text1);
        }
    }
}
