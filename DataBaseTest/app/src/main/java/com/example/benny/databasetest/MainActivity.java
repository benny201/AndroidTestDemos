package com.example.benny.databasetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MyDataBaseHelper myDataBaseHelper;
    private Button button;
    private Button CrateDataButton;
    private Button UpdateButton;
    private Button DeleteButton;
    private Button RetrieveButton;
    private String TAG = "BENNY!!!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDataBaseHelper = new MyDataBaseHelper(this, "Book.db", null, 4);

        // create database
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                myDataBaseHelper.getWritableDatabase();

            }
        });

        // add data
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
                contentValues.put("author", "B");
                contentValues.put("pages", 66);
                contentValues.put("name", "Fuck");
                db.insert("Book", null, contentValues);
                contentValues.clear();

            }
        });

        // update data
        UpdateButton = (Button) findViewById(R.id.UpdateButton);
        UpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = myDataBaseHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("pages", 77);
                db.update("Book", contentValues, "name = ?", new String[] {"Fuck"});

            }
        });

        //delete data
        DeleteButton = (Button) findViewById(R.id.deleteButton);
        DeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = myDataBaseHelper.getWritableDatabase();
                db.delete("Book", "pages > ?", new String[]{"500"});
            }
        });

        //Retrieve Data
        RetrieveButton = (Button) findViewById(R.id.RetrieveData);
        RetrieveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = myDataBaseHelper.getWritableDatabase();
                Cursor cursor = db.query("Book", null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));

                        Log.d(TAG, name + author + pages);
                    } while(cursor.moveToNext());
                }
            }
        });


    }





}
