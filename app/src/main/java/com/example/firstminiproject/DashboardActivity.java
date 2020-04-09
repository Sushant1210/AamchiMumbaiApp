package com.example.firstminiproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener{
    ListView listOptions;
    String[] options;
    String Username;
    static String tableFlag = "No";
    SharedPreferences getstoredData;
    LinearLayout layoutAboutUs, layoutVisitPlacesUs, layoutGallery, layoutContactUs, layoutBooking, layoutTravelhistory;
    SQLiteDatabase sqdb;
    SQLiteHelper sqh;
    SharedPreferences storeData;
    SharedPreferences getData;
    SharedPreferences.Editor editor;
    List chargeList;
    private static final String DATABASE_NAME = "Mumbai_darshan.db";
    public static final String TABLE_NAME = "price_table";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_customise_grid);
        initViews();
        try{
            getData = getSharedPreferences("tableData",MODE_PRIVATE);
            tableFlag = getData.getString("tableExixtsFlag",null);
           /* if(!tableFlag.equals(null)){

            }else{
                tableFlag = "No";
            }*/


            if (tableFlag==null){
                // RETRIEVE A READABLE AND WRITEABLE DATABASE
                sqh = new SQLiteHelper(this);
                sqdb = sqh.getWritableDatabase();
                storeData = getSharedPreferences("tableData", MODE_PRIVATE);
                editor = storeData.edit();


                Toast.makeText(this, "Table does not exist", Toast.LENGTH_SHORT).show();
                // METHOD #1: INSERT USING SQL QUERY
                String insertQuery = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " VALUES(1,'Adult',500);";
                sqdb.execSQL(insertQuery);
                String insertQuery1 = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " VALUES(2,'Child',200);";
                sqdb.execSQL(insertQuery1);
                String insertQuery2 = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " VALUES(3,'Infants',100);";
                sqdb.execSQL(insertQuery2);
                tableFlag = "Yes";


                editor.putString("tableExixtsFlag", tableFlag);
                //editor.commit();
                editor.apply();

                /*getWritableDatabase() Create and/or open a database that will be used for reading and writing.
                 * If database does not exist, it will call onCreate() method to create database
                 * SQLiteDatabase class has many methods to manage database, e.g. create, drop, insert, update, delete
                 * query etc.
                 */
                //  Toast.makeText(this, "Exception is "+err,Toast.LENGTH_LONG ).show();
            }

      /*      if (tableFlag != null){
               SQLiteHelper sqLiteHelper = new SQLiteHelper(getApplicationContext());
               ArrayList<String> Price = sqLiteHelper.getData();
               String adultPrice = Price.get(0);
               String childPrice = Price.get(1);

                editor.putString("tableExixtsFlag", tableFlag);
                //editor.commit();
                editor.apply();
               // String d3 = Price.get(2);
               // String d4 = Price.get(3);

               // Toast.makeText(this, "Prices are "+d1+"  "+d2,Toast.LENGTH_LONG ).show();

            }*/
            // sqdb = sqh.getWritableDatabase();
            /*if (tableFlag.equals("No")){
                // INIT OUR SQLITE HELPER
                // sqh = new SQLiteHelper(this);

                // RETRIEVE A READABLE AND WRITEABLE DATABASE
                sqdb = sqh.getWritableDatabase();

                Toast.makeText(this, "Table does not exist", Toast.LENGTH_SHORT).show();
                // METHOD #1: INSERT USING SQL QUERY
                String insertQuery = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " VALUES(1,'Adult',500);";
                sqdb.execSQL(insertQuery);
                String insertQuery1 = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " VALUES(2,'Child',200);";
                sqdb.execSQL(insertQuery1);
                tableFlag = "Yes";
                storeData = getSharedPreferences("tableData", MODE_PRIVATE);
                editor = storeData.edit();
                editor.putString("tableExixtsFlag", tableFlag.toString());
                /*getWritableDatabase() Create and/or open a database that will be used for reading and writing.
                 * If database does not exist, it will call onCreate() method to create database
                 * SQLiteDatabase class has many methods to manage database, e.g. create, drop, insert, update, delete
                 * query etc.

            }else{
                Toast.makeText(this, "Table already exist", Toast.LENGTH_SHORT).show();
            }*/
        }catch (Exception err){
            // INIT OUR SQLITE HELPER
            // sqh = new SQLiteHelper(this);



        }

    }

    private void initViews() {
        //listOptions = findViewById(R.id.listOptions);
        //options = getResources().getStringArray(R.array.dashboardOptions);

        getstoredData = getSharedPreferences("userRegData", MODE_PRIVATE);
        Username = getstoredData.getString("username", null);

        getSupportActionBar().setTitle("Welcome " + Username + " !!");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        layoutAboutUs = findViewById(R.id.layoutAboutUs);
        layoutContactUs = findViewById(R.id.layoutContactUs);
        layoutVisitPlacesUs = findViewById(R.id.layoutVisitPlacesUs);
        layoutGallery = findViewById(R.id.layoutGallery);
        layoutBooking = findViewById(R.id.layoutBooking);
        layoutTravelhistory = findViewById(R.id.layoutTravelHistory);

        layoutGallery.setOnClickListener(this);
        layoutContactUs.setOnClickListener(this);
        layoutVisitPlacesUs.setOnClickListener(this);
        layoutAboutUs.setOnClickListener(this);
        layoutBooking.setOnClickListener(this);
        layoutTravelhistory.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        openLogoutAlert();
    }


    private void openLogoutAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Logout !");
        builder.setMessage("Do you want to Logout ?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                /*Toast.makeText(getApplicationContext(), "You've choosen to delete all records", Toast.LENGTH_SHORT).show();*/
                Intent i = new Intent(DashboardActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                /*Toast.makeText(getApplicationContext(), "You've changed your mind to delete all records", Toast.LENGTH_SHORT).show();*/
            }
        });

        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_dash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_refresh) {
            openLogoutAlert();
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layoutContactUs:
                Intent i1 = new Intent(getApplicationContext(), ContactUsActivity.class);
                startActivity(i1);
                break;

            case R.id.layoutAboutUs:
                Intent i0 = new Intent(getApplicationContext(), AboutUsActivity.class);
                startActivity(i0);
                break;

            case R.id.layoutGallery:
                /*Toast.makeText(this, "Coming Soon ....", Toast.LENGTH_SHORT).show();*/
                Intent i2 = new Intent(getApplicationContext(), GallaryActivity.class);
                startActivity(i2);
                break;

            case R.id.layoutVisitPlacesUs:
                Intent i3 = new Intent(getApplicationContext(), Grid_Activity.class);
                startActivity(i3);
                break;

            case R.id.layoutBooking:
                Intent i4 = new Intent(getApplicationContext(), BookTicketsActivity.class);
                startActivity(i4);
                break;

                case R.id.layoutTravelHistory:
                /*Intent i5 = new Intent(getApplicationContext(), TravelHistoryActivity.class);
                startActivity(i5);*/
                Toast.makeText(this, "Travel History Feature Is Coming Soon..... !!", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }

}
