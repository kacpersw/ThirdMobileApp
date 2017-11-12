package com.example.ibra18plus.thirdapp;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.Locale;

/**
 * Created by Ibra18plus on 2017-11-12.
 */

public class AppFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);

        ImageButton plButton = (ImageButton) view.findViewById(R.id.poland_flag_ib);
        plButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                changeLanguage("pl");
            }
        });

        ImageButton enButton = (ImageButton) view.findViewById(R.id.england_flag_ib);
        enButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                changeLanguage(("en"));
            }
        });


        return view;
    }

    public void changeLanguage(String language) {
        String languageToLoad = language;
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getActivity().getBaseContext().getResources().updateConfiguration(config,
                getActivity().getBaseContext().getResources().getDisplayMetrics());
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }

}