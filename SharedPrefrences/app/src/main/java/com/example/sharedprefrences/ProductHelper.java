package com.example.sharedprefrences;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ProductHelper extends BaseAdapter {

    Context context;
    List<Product> productList;

    public ProductHelper(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1,null);
        TextView textView=view.findViewById(android.R.id.text1);
        textView.setText(productList.get(position).toString());

        return view;
    }
}
