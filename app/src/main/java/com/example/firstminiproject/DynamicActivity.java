package com.example.firstminiproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DynamicActivity extends AppCompatActivity {
    ListView listOptions;
    String[] beaches, waterParks, temples, malls, archetectures, markets;
    String  selectedpos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamic_list);
        listOptions = findViewById(R.id.listOptions123);
        beaches = getResources().getStringArray(R.array.beaches);
        waterParks = getResources().getStringArray(R.array.waterParks);
        temples = getResources().getStringArray(R.array.temples);
        malls = getResources().getStringArray(R.array.malls);
        archetectures = getResources().getStringArray(R.array.bestArchetecture);
        markets = getResources().getStringArray(R.array.markets);

        ArrayList<String>beachList = new ArrayList<>();
        for(int i=0;i<beaches.length;i++){
            beachList.add(beaches[i]);
        }
        ArrayList<String>templesList = new ArrayList<>();
        for(int i=0;i<temples.length;i++){
            templesList.add(temples[i]);
        }
        ArrayList<String>waterParksList = new ArrayList<>();
        for(int i=0;i<waterParks.length;i++){
            waterParksList.add(waterParks[i]);
        }
        ArrayList<String>mallsList = new ArrayList<>();
        for(int i=0;i<malls.length;i++){
            mallsList.add(malls[i]);
        }
        ArrayList<String>marketsList = new ArrayList<>();
        for(int i=0;i<markets.length;i++){
            marketsList.add(markets[i]);
        }
        ArrayList<String>archetecturesList = new ArrayList<>();
        for(int i=0;i<archetectures.length;i++){
            archetecturesList.add(archetectures[i]);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent data = getIntent();
       // selectedpos = data.getIntExtra("position", 0);
        selectedpos = data.getStringExtra("position");


        if (selectedpos.equals("Beaches")) {
            getSupportActionBar().setTitle("Beaches");
            DynamicListCustomAdapter dc = new DynamicListCustomAdapter(this, R.layout.dynamic_list_item, beachList);
            listOptions.setAdapter(dc);
        }
        if (selectedpos.equals("Temples")) {
            getSupportActionBar().setTitle("Temples");
            DynamicListCustomAdapter dc1 = new DynamicListCustomAdapter(this, R.layout.dynamic_list_item, templesList);
           // ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, temples);
            listOptions.setAdapter(dc1);
        }
        if (selectedpos.equals("Water Parks")) {
            getSupportActionBar().setTitle("Water Parks");
            DynamicListCustomAdapter dc2 = new DynamicListCustomAdapter(this, R.layout.dynamic_list_item, waterParksList);
           // ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, waterParks);
            listOptions.setAdapter(dc2);
        }
        if (selectedpos.equals("Shopping Malls")) {
            getSupportActionBar().setTitle("Shopping Malls");
            DynamicListCustomAdapter dc3 = new DynamicListCustomAdapter(this, R.layout.dynamic_list_item, mallsList);
           // ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, malls);
            listOptions.setAdapter(dc3);
        }
        if (selectedpos.equals("Markets")) {
            getSupportActionBar().setTitle("Markets");
            DynamicListCustomAdapter dc4 = new DynamicListCustomAdapter(this, R.layout.dynamic_list_item, marketsList);
           // ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, markets);
            listOptions.setAdapter(dc4);
        }
        if (selectedpos.equals("Best Architectures")) {
            getSupportActionBar().setTitle("Best Architectures");
            DynamicListCustomAdapter dc5 = new DynamicListCustomAdapter(this, R.layout.dynamic_list_item, archetecturesList);
           // ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, archetectures);
            listOptions.setAdapter(dc5);
        }


        listOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Intent i0 = new Intent(getApplicationContext(), InfornationActivity.class);
                        i0.putExtra("SelectedCategoryPosition",selectedpos);
                        i0.putExtra("SelectedPlacePosition",i);
                        //Toast.makeText(DynamicActivity.this, "SelectedCategoryPosition is "+selectedpos+"and SelectedPlacePosition is "+i, Toast.LENGTH_LONG).show();
                        startActivity(i0);
                        break;
                    case 1:
                        Intent i1 = new Intent(getApplicationContext(), InfornationActivity.class);
                        i1.putExtra("SelectedCategoryPosition",selectedpos);
                        i1.putExtra("SelectedPlacePosition",i);
                        //Toast.makeText(DynamicActivity.this, "SelectedCategoryPosition is "+selectedpos+"and SelectedPlacePosition is "+i, Toast.LENGTH_LONG).show();
                        startActivity(i1);
                        break;
                    case 2:
                        Intent i2 = new Intent(getApplicationContext(), InfornationActivity.class);
                        i2.putExtra("SelectedCategoryPosition",selectedpos);
                        i2.putExtra("SelectedPlacePosition",i);
                        //Toast.makeText(DynamicActivity.this, "SelectedCategoryPosition is "+selectedpos+"and SelectedPlacePosition is "+i, Toast.LENGTH_LONG).show();
                        startActivity(i2);
                        break;
                    case 3:
                        Intent i3 = new Intent(getApplicationContext(), InfornationActivity.class);
                        i3.putExtra("SelectedCategoryPosition",selectedpos);
                        i3.putExtra("SelectedPlacePosition",i);
                        //Toast.makeText(DynamicActivity.this, "SelectedCategoryPosition is "+selectedpos+"and SelectedPlacePosition is "+i, Toast.LENGTH_LONG).show();
                        startActivity(i3);
                        break;
                    case 4:
                        Intent i4 = new Intent(getApplicationContext(), InfornationActivity.class);
                        i4.putExtra("SelectedCategoryPosition",selectedpos);
                        i4.putExtra("SelectedPlacePosition",i);
                        //Toast.makeText(DynamicActivity.this, "SelectedCategoryPosition is "+selectedpos+"and SelectedPlacePosition is "+i, Toast.LENGTH_LONG).show();
                        startActivity(i4);
                        break;

                    case 5:
                        Intent i5 = new Intent(getApplicationContext(), InfornationActivity.class);
                        i5.putExtra("SelectedCategoryPosition",selectedpos);
                        i5.putExtra("SelectedPlacePosition",i);
                        //Toast.makeText(DynamicActivity.this, "SelectedCategoryPosition is "+selectedpos+"and SelectedPlacePosition is "+i, Toast.LENGTH_LONG).show();
                        startActivity(i5);
                        break;

                    case 6:
                        Intent i6 = new Intent(getApplicationContext(), InfornationActivity.class);
                        i6.putExtra("SelectedCategoryPosition",selectedpos);
                        i6.putExtra("SelectedPlacePosition",i);
                        //Toast.makeText(DynamicActivity.this, "SelectedCategoryPosition is "+selectedpos+"and SelectedPlacePosition is "+i, Toast.LENGTH_LONG).show();
                        startActivity(i6);
                        break;

                    case 7:
                        Intent i7 = new Intent(getApplicationContext(), InfornationActivity.class);
                        i7.putExtra("SelectedCategoryPosition",selectedpos);
                        i7.putExtra("SelectedPlacePosition",i);
                        //Toast.makeText(DynamicActivity.this, "SelectedCategoryPosition is "+selectedpos+"and SelectedPlacePosition is "+i, Toast.LENGTH_LONG).show();
                        startActivity(i7);
                        break;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, Grid_Activity.class);
        startActivity(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
