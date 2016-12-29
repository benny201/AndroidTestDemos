package com.example.benny.databasetest;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MyDataBaseHelper myDataBaseHelper;
    private Button button;
    private Button CrateDataButton;
    private Button UpdateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDataBaseHelper = new MyDataBaseHelper(this, "Book.db", null, 4);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                myDataBaseHelper.getWritableDatabase();

            }
        });

        CrateDataButton = (Button) findViewById(R.id.CrateButton);
        CrateDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = myDataBaseHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();

                // first table
                contentValues.put("author", "Benny's Success");
                contentValues.put("pages", 888);
                contentValues.put("name", "Benny");
                db.insert("Book", null, contentValues);
                contentValues.clear();

                // second table
                //contentValues.put("name", "hello word");
                //contentValues.put("code", 1);
                //db.insert("Category", null, contentValues);
                //contentValues.clear();

            }
        });

        UpdateButton = (Button) findViewById(R.id.UpdateButton);
        UpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = myDataBaseHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("pages", 777);
                db.update("Book", contentValues, "name = ?", new String[] {"Benny's success"});

            }
        });
    }





}
