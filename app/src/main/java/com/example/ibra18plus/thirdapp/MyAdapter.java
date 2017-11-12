package com.example.ibra18plus.thirdapp;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ibra18plus on 2017-11-12.
 */

public class MyAdapter extends ArrayAdapter<Product> {

    public MyAdapter(@NonNull Context context, @LayoutRes ArrayList<Product> products) {
        super(context, R.layout.one_row, products);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.one_row, parent, false);
        Product singlePosition = getItem(position);

        TextView textView4 = (TextView) view.findViewById(R.id.textView4);
        textView4.setText(singlePosition.getName());

        TextView textView5 = (TextView) view.findViewById(R.id.textView5);
        textView5.setText(singlePosition.getPrice());

        ImageView imageView = view.findViewById(R.id.imageView2);
        imageView.setImageResource(singlePosition.getImage());

        return view;
    }

    @Override
    public void remove(Product object) {
        super.remove(object);
    }


}
