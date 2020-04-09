package com.example.firstminiproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class Grid_Activity extends AppCompatActivity {

    GridView gridView;
    String[] placesWord = {"Beaches","Temples","Water Parks","Shopping Malls","Markets","Best Architectures"};
    int[] placeImages = {R.drawable.beach,R.drawable.temple,R.drawable.waterpark,R.drawable.mall,R.drawable.markets,R.drawable.architecture};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_);

        getSupportActionBar().setTitle("Places To Explore");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gridView = findViewById(R.id.viewData);
        gridView.setHorizontalSpacing(20);
        gridView.setVerticalSpacing(20);

        MainAdapter  adapter = new MainAdapter(Grid_Activity.this,placesWord,placeImages);
        gridView.setAdapter(adapter);

        //final Intent i = new Intent(this,DynamicActivity.class);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(),DynamicActivity.class);
                i.putExtra("position", placesWord[+position]);
                startActivity(i);
               // Toast.makeText(Grid_Activity.this, "YOu Clicked"+placesWord[+position], Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, DashboardActivity.class);
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
