package com.example.firstminiproject;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class SQLiteHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Mumbai_darshan.db";

    private static final int DATABASE_VERSION = 1;


    public static final String TABLE_NAME = "price_table";


    public static final String ID = "Id";

    public static final String CATEGORY = "Category";

    public static final String PRICE = "Price";


    SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Called when the database is created for the first time
        /* First the database instance should be created using the method like getReadableDatabase()
         * or getWritableDatabase() based on the type of access required.
         */

        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY," + CATEGORY
                + " VARCHAR(25),"+ PRICE +" INTEGER )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Called when the database needs to be upgraded. The implementation should use this method to drop tables,
        //add tables, or do anything else it needs to upgrade to the new schema version.

        Log.w("LOG_TAG", "Upgrading database from version " + oldVersion + " to " + newVersion
                + ", which will destroy all old data");

        // KILL PREVIOUS TABLE IF UPGRADED
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // CREATE NEW INSTANCE OF TABLE
        onCreate(db);
    }

        public ArrayList<String> getData() {
            ArrayList<String> data= new ArrayList<String>();
            final String COL2 = "Price";
            try {
                String Table_Name = "price_table";

             //   String selectQuery = "SELECT Price FROM " + Table_Name +  " where Category = '" + "Adult" + "'";
                String selectQuery = "SELECT Price FROM " + Table_Name;
                SQLiteDatabase db = this.getReadableDatabase();
                Cursor cursor = db.rawQuery(selectQuery, null);

                if (cursor.moveToFirst()) {
                    do {
                        String data1="";
                        // get  the  data into array,or class variable
                        data1=(cursor.getString(cursor.getColumnIndex(COL2)));
                      //  Toast.makeText(this, "Prices are "+data1,Toast.LENGTH_LONG ).show();

                        data.add(data1);
                    } while (cursor.moveToNext());
                }
                db.close();

            }catch (Exception e){
               e.printStackTrace();
            } return data;
        }

    }
