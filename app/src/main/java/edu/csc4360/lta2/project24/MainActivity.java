package edu.csc4360.lta2.project24;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    DatabaseHandler myDb;

    EditText modelText, brandText, yearText, costText, invenText, typeText, idText;
    Button addbtn, viewbtn, searchbtn, deletebtn, updatebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHandler(this);

        modelText =(EditText)findViewById(R.id.modelText);
        brandText =(EditText)findViewById(R.id.brandText2);
        yearText =(EditText)findViewById(R.id.yearText3);
        costText =(EditText)findViewById(R.id.costText4);
        invenText =(EditText)findViewById(R.id.invenText5);
        typeText =(EditText)findViewById(R.id.typeText6);
        idText =(EditText)findViewById(R.id.idText7);
        addbtn=(Button)findViewById(R.id.Addbtn);
        AddData();

        viewbtn=(Button)findViewById(R.id.viewbtn) ;
        viewAll();

        searchbtn=(Button)findViewById(R.id.searchbtn);
        search();

        deletebtn=(Button)findViewById(R.id.deletebtn);
        deleteData();

        updatebtn=(Button)findViewById(R.id.updatebtn);
        updateData();
    }

    public void AddData(){
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDb.insertData(modelText.getText().toString(),
                        brandText.getText().toString(),
                        typeText.getText().toString(),
                        yearText.getText().toString(),
                        costText.getText().toString(),
                        invenText.getText().toString());
            }
        });
    }
    public void viewAll(){
        viewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor result = myDb.getAllData();
                if (result.getCount() == 0) {
                    //message
                    showMessage("Error","no data");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (result.moveToNext()){
                    buffer.append("wineId :"+ result.getString(0)+"\n");
                    buffer.append("model :"+ result.getString(1)+"\n");
                    buffer.append("brand :"+ result.getString(2)+"\n");
                    buffer.append("type :"+ result.getString(3)+"\n");
                    buffer.append("year :"+ result.getString(4)+"\n");
                    buffer.append("cost :"+ result.getString(5)+"\n\n");
                }
                showMessage("data",buffer.toString());
            }
        });
    }
    public void search(){
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor result = myDb.search(brandText.getText().toString());
                if (result.getCount() == 0) {
                    //message
                    showMessage("Error","no data");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (result.moveToNext()){
                    buffer.append("wineId :"+ result.getString(0)+"\n");
                    buffer.append("model :"+ result.getString(1)+"\n");
                    buffer.append("brand :"+ result.getString(2)+"\n");
                    buffer.append("type :"+ result.getString(3)+"\n");
                    buffer.append("year :"+ result.getString(4)+"\n");
                    buffer.append("cost :"+ result.getString(5)+"\n\n");
                }
                showMessage("data",buffer.toString());
            }
        });
    }

    public void deleteData(){
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDb.deleteData(idText.getText().toString());
            }
        });
    }

    public void updateData(){
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDb.updateData(idText.getText().toString(),
                        modelText.getText().toString(),
                        brandText.getText().toString(),
                        typeText.getText().toString(),
                        yearText.getText().toString(),
                        costText.getText().toString(),
                        invenText.getText().toString());
            }
        });
    }

    public void showMessage(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
