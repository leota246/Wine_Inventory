package com.example.wineinventory;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {

    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        getSupportActionBar().setTitle("Search Item");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        search = (Button) findViewById(R.id.searchbtn);


    }
}
