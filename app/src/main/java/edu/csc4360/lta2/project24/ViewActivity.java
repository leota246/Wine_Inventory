package com.example.wineinventory;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ViewActivity extends AppCompatActivity{

    private Button edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        getSupportActionBar().setTitle("View Item");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //when edit button is clicked, redirected to editactvity
        edit = (Button) findViewById(R.id.editbtn);
        edit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(ViewActivity.this, EditActivity.class));

            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menubar,menu);
        return true;
    }

    public boolean onOptionItemsSelected(MenuItem item){
        int id = item.getItemId();

        switch(item.getItemId()) {
            case R.id.menu:
                Intent menuintent= new Intent("android.intent.action.MAIN");
                this.startActivity(menuintent);
                break;
            case R.id.view:
                Intent viewintent= new Intent("android.intent.action.MAIN");
                this.startActivity(viewintent);
                break;
            case R.id.edit:
                Intent editintent = new Intent(this,EditActivity.class);
                this.startActivity(editintent);
                break;
            case R.id.search:
                Intent searchintent = new Intent(this,SearchActivity.class);
                this.startActivity(searchintent);
                break;
            case R.id.add:
                Intent addintent = new Intent(this,AddActivity.class);
                this.startActivity(addintent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

}
