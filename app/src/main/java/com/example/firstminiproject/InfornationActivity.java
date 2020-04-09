package com.example.firstminiproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class InfornationActivity extends AppCompatActivity {
    String Selected_Category;
    int Selected_Place;
    ImageView placeImage;
    TextView addressValue;
    TextView descriptionValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infornation);

        placeImage = findViewById(R.id.placeImage);
        addressValue = findViewById(R.id.tvAddressValue);
        descriptionValue = findViewById(R.id.tvDescriptionValue);

        Intent data = getIntent();
        Selected_Category = data.getStringExtra("SelectedCategoryPosition");
        Selected_Place = data.getIntExtra("SelectedPlacePosition",0);
       // Toast.makeText(this, Selected_Category+","+Selected_Place, Toast.LENGTH_SHORT).show();

        setData(Selected_Category,Selected_Place );

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void setData(String selected_category, int Selected_Place) {
        if(selected_category.equals("Beaches")){
            if(Selected_Place == 0){
                getSupportActionBar().setTitle("Aksa Beach");
                placeImage.setImageResource(R.drawable.aksabeach);
                addressValue.setText(getResources().getString(R.string.aksaAdd));
                descriptionValue.setText(getResources().getString(R.string.aksaInfo));
            }
            if(Selected_Place == 1){
                getSupportActionBar().setTitle("Kashid Beach");
                placeImage.setImageResource(R.drawable.kashidbeach);
                addressValue.setText(getResources().getString(R.string.kashidAdd));
                descriptionValue.setText(getResources().getString(R.string.kashidInfo));
            }
            if(Selected_Place == 2){
                getSupportActionBar().setTitle("Alibaug Beach");
                placeImage.setImageResource(R.drawable.beach);
                addressValue.setText(getResources().getString(R.string.alibagAdd));
                descriptionValue.setText(getResources().getString(R.string.alibagInfo));
            }
            if(Selected_Place == 3){
                getSupportActionBar().setTitle("Gorai Beach");
                placeImage.setImageResource(R.drawable.goraibeach);
                addressValue.setText(getResources().getString(R.string.goraiAdd));
                descriptionValue.setText(getResources().getString(R.string.goraiInfo));
            }
            if(Selected_Place == 4){
                getSupportActionBar().setTitle("Juhu Beach");
                placeImage.setImageResource(R.drawable.juhubeach);
                addressValue.setText(getResources().getString(R.string.juhuAdd));
                descriptionValue.setText(getResources().getString(R.string.juhuInfo));
            }
            if(Selected_Place == 5){
                getSupportActionBar().setTitle("Nagaon Beach");
                placeImage.setImageResource(R.drawable.nagaonbeach);
                addressValue.setText(getResources().getString(R.string.nagaonAdd));
                descriptionValue.setText(getResources().getString(R.string.nagaonInfo));
            }
            if(Selected_Place == 6){
                getSupportActionBar().setTitle("Arnala Beach");
                placeImage.setImageResource(R.drawable.arnalabeach);
                addressValue.setText(getResources().getString(R.string.arnalaAdd));
                descriptionValue.setText(getResources().getString(R.string.arnalaInfo));
            }
        }

        if(selected_category.equals("Temples")){
            if(Selected_Place == 0){
                getSupportActionBar().setTitle("Shree Sidhivinayak Temple");
                placeImage.setImageResource(R.drawable.shreesiddhivinayaktemple);
                addressValue.setText(getResources().getString(R.string.sidTempAdd));
                descriptionValue.setText(getResources().getString(R.string.sidTempInfo));
            }
            if(Selected_Place == 1){
                getSupportActionBar().setTitle("Mahalaxmi Temple");
                placeImage.setImageResource(R.drawable.mahalakshmitemple);
                addressValue.setText(getResources().getString(R.string.mahalaxmiTempAdd));
                descriptionValue.setText(getResources().getString(R.string.mahalaxmiTempInfo));
            }
            if(Selected_Place == 2){
                getSupportActionBar().setTitle("Babulnath Temple");
                placeImage.setImageResource(R.drawable.babulnathtemple);
                addressValue.setText(getResources().getString(R.string.babulnathTempAdd));
                descriptionValue.setText(getResources().getString(R.string.babulnathTempInfo));
            }
            if(Selected_Place == 3){
                getSupportActionBar().setTitle("Tungareshwar Temple");
                placeImage.setImageResource(R.drawable.tungareshwartemple);
                addressValue.setText(getResources().getString(R.string.tungaTempAdd));
                descriptionValue.setText(getResources().getString(R.string.tungaTempInfo));
            }
            if(Selected_Place == 4){
                getSupportActionBar().setTitle("Walkeshwar Temple");
                placeImage.setImageResource(R.drawable.walkeshwartemple);
                addressValue.setText(getResources().getString(R.string.walkTempAdd));
                descriptionValue.setText(getResources().getString(R.string.walkTempInfo));
            }
            if(Selected_Place == 5){
                getSupportActionBar().setTitle("Mumba Devi Temple");
                placeImage.setImageResource(R.drawable.mumbadevi);
                addressValue.setText(getResources().getString(R.string.mumbaTempAdd));
                descriptionValue.setText(getResources().getString(R.string.mumbaTempInfo));
            }
        }

        if(selected_category.equals("Water Parks")){
            if(Selected_Place == 0){
                getSupportActionBar().setTitle("Water Kingdom");
                placeImage.setImageResource(R.drawable.waterkingdom);
                addressValue.setText(getResources().getString(R.string.waterkAdd));
                descriptionValue.setText(getResources().getString(R.string.waterkInfo));
            }
            if(Selected_Place == 1){
                getSupportActionBar().setTitle("Suraj Water Park");
                placeImage.setImageResource(R.drawable.surajwaterpark);
                addressValue.setText(getResources().getString(R.string.surajwpAdd));
                descriptionValue.setText(getResources().getString(R.string.surajwpInfo));
            }
            if(Selected_Place == 2){
                getSupportActionBar().setTitle("Tikujini Wadi Water Park");
                placeImage.setImageResource(R.drawable.tikijiniwadiwaterpark);
                addressValue.setText(getResources().getString(R.string.tikujiniwadiAdd));
                descriptionValue.setText(getResources().getString(R.string.tikujiniwadiInfo));
            }
            if(Selected_Place == 3){
                getSupportActionBar().setTitle("Aqua Imagica");
                placeImage.setImageResource(R.drawable.aquaimagica);
                addressValue.setText(getResources().getString(R.string.aquaIwAdd));
                descriptionValue.setText(getResources().getString(R.string.aquaIwInfo));
            }
            if(Selected_Place == 4){
                getSupportActionBar().setTitle("Great Escape Water Park");
                placeImage.setImageResource(R.drawable.greatescapewaterpark);
                addressValue.setText(getResources().getString(R.string.greatewpAdd));
                descriptionValue.setText(getResources().getString(R.string.greatewpInfo));
            }
        }

        if(selected_category.equals("Shopping Malls")){
            if(Selected_Place == 0){
                getSupportActionBar().setTitle("RCity Mall");
                placeImage.setImageResource(R.drawable.rcitymallghatkopar);
                addressValue.setText(getResources().getString(R.string.rcityAdd));
                descriptionValue.setText(getResources().getString(R.string.rcityInfo));
            }
            if(Selected_Place == 1){
                getSupportActionBar().setTitle("Raghuleela Mall");
                placeImage.setImageResource(R.drawable.raghuleelamall);
                addressValue.setText(getResources().getString(R.string.raghulelaAdd));
                descriptionValue.setText(getResources().getString(R.string.raghulelaInfo));
            }
            if(Selected_Place == 2){
                getSupportActionBar().setTitle("Infiniti Mall");
                placeImage.setImageResource(R.drawable.infinitymallandheri);
                addressValue.setText(getResources().getString(R.string.infinitiAdd));
                descriptionValue.setText(getResources().getString(R.string.infinitiInfo));
            }
            if(Selected_Place == 3){
                getSupportActionBar().setTitle("Oberoi Mall");
                placeImage.setImageResource(R.drawable.oberoimallgoregaon);
                addressValue.setText(getResources().getString(R.string.oberoiAdd));
                descriptionValue.setText(getResources().getString(R.string.oberoiInfo));
            }
            if(Selected_Place == 4){
                getSupportActionBar().setTitle("High Street Phoenix Mall");
                placeImage.setImageResource(R.drawable.phoenixmarketcity);
                addressValue.setText(getResources().getString(R.string.phoenixAdd));
                descriptionValue.setText(getResources().getString(R.string.phoenixInfo));
            }
            if(Selected_Place == 5){
                getSupportActionBar().setTitle("Viviana Mall");
                placeImage.setImageResource(R.drawable.vivianamall);
                addressValue.setText(getResources().getString(R.string.vivianaAdd));
                descriptionValue.setText(getResources().getString(R.string.vivianaInfo));
            }
            if(Selected_Place == 6){
                getSupportActionBar().setTitle("Palladium Mall");
                placeImage.setImageResource(R.drawable.palladiummall);
                addressValue.setText(getResources().getString(R.string.palladiumAdd));
                descriptionValue.setText(getResources().getString(R.string.palladiumInfo));
            }
            if(Selected_Place == 7){
                getSupportActionBar().setTitle("Prime Mall");
                placeImage.setImageResource(R.drawable.primemall);
                addressValue.setText(getResources().getString(R.string.primeAdd));
                descriptionValue.setText(getResources().getString(R.string.primeInfo));
            }
        }

        if(selected_category.equals("Markets")){
            if(Selected_Place == 0){
                getSupportActionBar().setTitle("Zaveri Bazar");
                placeImage.setImageResource(R.drawable.zaveribazar);
                addressValue.setText(getResources().getString(R.string.zaveribAdd));
                descriptionValue.setText(getResources().getString(R.string.zaveribInfo));
            }
            if(Selected_Place == 1){
                getSupportActionBar().setTitle("Chor Bazar");
                placeImage.setImageResource(R.drawable.chorbazar);
                addressValue.setText(getResources().getString(R.string.chorbAdd));
                descriptionValue.setText(getResources().getString(R.string.chorbInfo));
            }
            if(Selected_Place == 2){
                getSupportActionBar().setTitle("Infinity Mall");
                placeImage.setImageResource(R.drawable.beach);
                addressValue.setText(getResources().getString(R.string.alibagAdd));
                descriptionValue.setText(getResources().getString(R.string.alibagInfo));
            }
        }

        if(selected_category.equals("Best Architectures")){
            if(Selected_Place == 0){
                getSupportActionBar().setTitle("Gateway of India");
                placeImage.setImageResource(R.drawable.gatewayofindia);
                addressValue.setText(getResources().getString(R.string.gatewayAdd));
                descriptionValue.setText(getResources().getString(R.string.gatewayInfo));
            }
            if(Selected_Place == 1){
                getSupportActionBar().setTitle("Chatrapati Shivaji Maharaj Terminus");
                placeImage.setImageResource(R.drawable.cst);
                addressValue.setText(getResources().getString(R.string.csmtAdd));
                descriptionValue.setText(getResources().getString(R.string.csmtInfo));
            }
            if(Selected_Place == 2){
                getSupportActionBar().setTitle("Maharashtra Police Headquarters");
                placeImage.setImageResource(R.drawable.policeheadquarters);
                addressValue.setText(getResources().getString(R.string.policehAdd));
                descriptionValue.setText(getResources().getString(R.string.policehInfo));
            }
            if(Selected_Place == 3){
                getSupportActionBar().setTitle("Taj Mahal Palace");
                placeImage.setImageResource(R.drawable.tajmahalpalace);
                addressValue.setText(getResources().getString(R.string.tajAdd));
                descriptionValue.setText(getResources().getString(R.string.tajInfo));
            }
            if(Selected_Place == 4){
                getSupportActionBar().setTitle("Chatrapati Shivaji Maharaj Vastu Sangrahalaya");
                placeImage.setImageResource(R.drawable.shivajimahargvastusangrahalaya);
                addressValue.setText(getResources().getString(R.string.vastuAdd));
                descriptionValue.setText(getResources().getString(R.string.vastuInfo));
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
