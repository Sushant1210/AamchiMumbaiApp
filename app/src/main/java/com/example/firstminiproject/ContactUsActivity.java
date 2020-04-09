package com.example.firstminiproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class ContactUsActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout l1, l2, l3, l4,l5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        l1 = findViewById(R.id.Ll1);
        l2 = findViewById(R.id.Ll2);
        l3 = findViewById(R.id.Ll3);
        l4 = findViewById(R.id.Ll4);
        l5 = findViewById(R.id.Ll5);

        //  l1.setOnClickListener(this);
        l2.setOnClickListener(this);
        l3.setOnClickListener(this);
        l4.setOnClickListener(this);
        l5.setOnClickListener(this);

        getSupportActionBar().setTitle("Contact Us");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

 /*   @Override
    public void onBackPressed() {
        Intent i = new Intent(this, DashboardActivity.class);
        startActivity(i);
    }*/

    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Ll1:
                break;

            case R.id.Ll2:
                Intent i2 = new Intent(Intent.ACTION_DIAL);
                i2.setData(Uri.parse("tel:8898073298"));
                startActivity(i2);
                break;

            case R.id.Ll3:
                Intent i3 = new Intent(Intent.ACTION_DIAL);
                i3.setData(Uri.parse("tel:02224158765"));
                startActivity(i3);
                break;

            case R.id.Ll4:
                Intent i4 = new Intent(Intent.ACTION_SEND);
                i4.setData(Uri.parse("mailto:sushantkale1995@gmail.com"));
                i4.setType("text/plain");
                startActivity(i4);
                break;

            case R.id.Ll5:
                Intent i5 = new Intent(Intent.ACTION_VIEW);
                i5.setData(Uri.parse("http://ww4.mumbaidarshan.com/mf.php"));
                startActivity(i5);
                break;

            default:
                break;
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
