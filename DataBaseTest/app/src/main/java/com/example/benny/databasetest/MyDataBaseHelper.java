package com.example.benny.databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by benny on 16/12/27.
 */
public class MyDataBaseHelper extends SQLiteOpenHelper {

    private Context context;


    //SQL
    private static final String Create_book = "Create table Book("
                                                + "id integer primary key autoincrement,"
                                                + "author text,"
                                                + "pages integer,"
                                                + "name text)";

    private static final String Create_category = "Create table Category("
                                                + "id integer primary key autoincrement,"
                                                + "name text"
                                                + "code integer)";



    public MyDataBaseHelper(Context mContext, String name, SQLiteDatabase.CursorFactory cursor, int version) {
        super(mContext, name, cursor, version);
        context = mContext;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Create_book);
        Toast.makeText(context,"success!",Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Book");
        onCreate(db);
    }


}
