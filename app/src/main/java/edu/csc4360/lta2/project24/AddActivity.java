package com.example.wineinventory;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity implements AddDialog.ExampleDialogListener  {

    private TextView name;
    private TextView type;
    private TextView grape;
    private TextView location;
    private TextView quantity;
    private TextView price;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name = (TextView) findViewById(R.id.tvname);
        type = (TextView) findViewById(R.id.tvtype);
        grape = (TextView) findViewById(R.id.tvgrape);
        location = (TextView) findViewById(R.id.tvlocation);
        quantity = (TextView) findViewById(R.id.tvquantity);
        price = (TextView) findViewById(R.id.tvprice);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

    }
    public void openDialog() {
        AddDialog exampleDialog = new AddDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    public void applyTexts(String name1, String type1, String grape1, String location1, String quantity1, String price1) {
        name.setText("Name: "+name1);
        type.setText("Type: "+type1);
        grape.setText("Grape: "+grape1);
        location.setText("Location: "+location1);
        quantity.setText("Quantity: "+quantity1);
        price.setText("Price: "+price1);
    }


}