package com.example.wineinventory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {

    private Button back;
    private Button delete;
    private Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        getSupportActionBar().setTitle("Edit Item");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // delete button will have an alert dialog for user to confirm.
        // if yes then entire row from database will be removed and updated
        // then will be redirected to main menu
        delete = (Button) findViewById(R.id.deletebtn);
        delete.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(EditActivity.this, MainActivity.class));

            }
        });

        // save button will update database with changes, toast messsage will present
        //then redirected to viewactivity where the updated content ill be shown
        save = (Button) findViewById(R.id.savebtn);
        save.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(EditActivity.this, ViewActivity.class));

            }
        });
    }
}
