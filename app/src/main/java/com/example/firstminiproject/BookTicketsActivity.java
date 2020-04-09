package com.example.firstminiproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class BookTicketsActivity extends AppCompatActivity {
    Button btnProceed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_tickets);

        getSupportActionBar().setTitle("Book Tickets Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnProceed = (Button)findViewById(R.id.btnProceed);

        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proceed = new Intent(getApplicationContext(),BookTicketConfirmationActivity.class);
                startActivity(proceed);
            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
