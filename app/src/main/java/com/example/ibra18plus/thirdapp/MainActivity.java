package com.example.ibra18plus.thirdapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static void setListAdapter() {
        MainActivity.listAdapter.notifyDataSetChanged();
    }

    private static ArrayAdapter<Product> listAdapter;
    private static ListView listView;
    private static ArrayList<Product> arrayWithProducts = new ArrayList<>();
    private boolean isAdded=false;
    private static int count = 0;
    private static int countHelper = count;

    String[] names;
    String[] prices;
    int[] photos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        names = getResources().getStringArray(R.array.names);
        prices = getResources().getStringArray(R.array.prices);
        photos = new int[]{R.drawable.car1, R.drawable.car2, R.drawable.car3, R.drawable.car4, R.drawable.car5};

        Configuration configuration = getResources().getConfiguration();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        AppFragment topSectionFragment = new AppFragment();
        fragmentTransaction.replace(android.R.id.content, topSectionFragment);

        setContentView(R.layout.activity_main);

        if (!isAdded) {
            arrayWithProducts.clear();
            for (int i=0;i<5;i++){
                arrayWithProducts.add(new Product(names[i], prices[i], photos[i]));
            }

            isAdded = true;
        }

        final ListView listView = (ListView) findViewById(R.id.listView);

        listAdapter = new MyAdapter(this, arrayWithProducts);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                count = listView.getCheckedItemCount();
                if (count == 0) {
                    Toast.makeText(MainActivity.this, R.string.zero, Toast.LENGTH_LONG).show();
                    return;
                }
                Resources res = getResources();
                String itemsFound = res.getQuantityString(R.plurals.numberOfSelectedItems, count, count);
                Toast.makeText(MainActivity.this, "" + itemsFound, Toast.LENGTH_LONG).show();
                countHelper = count;
            }
        });


    }


}
