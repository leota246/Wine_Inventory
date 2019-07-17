package com.example.wineinventory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button view;
    private Button search;
    private Button edit;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        view = (Button) findViewById(R.id.viewbtn);
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ViewActivity.class));

            }
        });

        search = (Button) findViewById(R.id.searchbtn);
        search.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
               // startActivity(new Intent(MainActivity.this, SearchActivity.class));
            }
        });

        edit = (Button) findViewById(R.id.editdelbtn);
        edit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EditActivity.class));

            }
        });

        add = (Button) findViewById(R.id.addbtn);
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddActivity.class));

            }
        });
    }
}

