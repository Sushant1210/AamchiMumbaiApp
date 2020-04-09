package com.example.firstminiproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class GallaryActivity extends AppCompatActivity {

    RecyclerView galleryRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallary_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Gallery");
        galleryRecyclerView = findViewById(R.id.galleryrecyclerView);

        setAdapter();
    }

    private void setAdapter() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        galleryRecyclerView.setLayoutManager(layoutManager);
        galleryRecyclerView.setHasFixedSize(true);
        MyGalleryAdapter myGalleryAdapter = new MyGalleryAdapter(this, getList());
        galleryRecyclerView.setAdapter(myGalleryAdapter);
    }

    private List<Gallery> getList() {
        List<Gallery> galleryList = new ArrayList<>();
       // galleryList.add(new Gallery("Beaches",R.drawable.beach));
        galleryList.add(new Gallery("Mumbadevi Temple",R.drawable.mumbadevi));
        galleryList.add(new Gallery("Waterkingdom",R.drawable.waterkingdom));
        galleryList.add(new Gallery("Chatrapati Shivaji Maharaj Terminus",R.drawable.cst));
        galleryList.add(new Gallery("Kashid Beach",R.drawable.kashidbeach));
        galleryList.add(new Gallery("Aqua Imagica",R.drawable.aquaimagica));
        galleryList.add(new Gallery("Babulnath Temple",R.drawable.babulnathtemple));
        galleryList.add(new Gallery("Gateway Of India",R.drawable.gatewayofindia));
        galleryList.add(new Gallery("Infinity Mall, Andheri",R.drawable.infinitymallandheri));
        galleryList.add(new Gallery("Zaveri Bazar",R.drawable.zaveribazar));
        galleryList.add(new Gallery("Prime Mall",R.drawable.primemall));
        galleryList.add(new Gallery("Arnala Beach",R.drawable.arnalabeach));
        galleryList.add(new Gallery("Aksa Beach",R.drawable.aksabeach));
        galleryList.add(new Gallery("Great Escape Water Park",R.drawable.greatescapewaterpark));
        galleryList.add(new Gallery("Mahalakshmi Temple",R.drawable.mahalakshmitemple));
        galleryList.add(new Gallery("Kashid Beach",R.drawable.kashidbeach));
        galleryList.add(new Gallery("Tungareshwar Temple",R.drawable.tungareshwartemple));
        galleryList.add(new Gallery("Nagaon Beach",R.drawable.nagaonbeach));
        galleryList.add(new Gallery("Chor Bazar",R.drawable.chorbazar));
        galleryList.add(new Gallery("Kelwa Beach",R.drawable.kelwabeach));
        galleryList.add(new Gallery("Suraj Water Park",R.drawable.surajwaterpark));
        galleryList.add(new Gallery("Shree Siddhivinayak Temple",R.drawable.shreesiddhivinayaktemple));
        galleryList.add(new Gallery("Shivaji Maharg Vastu Sangrahalaya",R.drawable.shivajimahargvastusangrahalaya));
        galleryList.add(new Gallery("Rcity Mall, Ghatkopar",R.drawable.rcitymallghatkopar));
        galleryList.add(new Gallery("Gorai Beach",R.drawable.goraibeach));
        galleryList.add(new Gallery("Walkeshwar Temple",R.drawable.walkeshwartemple));
        galleryList.add(new Gallery("Viviana Mall",R.drawable.vivianamall));
        galleryList.add(new Gallery("Tajmahal palace",R.drawable.tajmahalpalace));
        galleryList.add(new Gallery("K-star Mall, Chembur",R.drawable.kstarmall));
        galleryList.add(new Gallery("Water Park",R.drawable.waterpark));
        galleryList.add(new Gallery("Market",R.drawable.markets));
        return galleryList;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
