package com.example.firstminiproject;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PaymentSuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_success);
        TextView tvTxnIdValue,tvDateValue,tvTimeValue,tvRemarksValue,tvAmtValue,tvBenefNameValue,tvBenefVpaValue;
        Button btnHome;
        String amt,remarks,txnId,bnfName,bnfVpa,adultqty,childQty,infantQty;

        tvTxnIdValue = (TextView)findViewById(R.id.tvTxnIdValue);
        tvDateValue = (TextView)findViewById(R.id.tvDateValue);
        tvTimeValue = (TextView)findViewById(R.id.tvTimeValue);
        tvRemarksValue = (TextView)findViewById(R.id.tvRemarksValue);
        tvAmtValue = (TextView)findViewById(R.id.tvAmtValue);
        tvBenefNameValue = (TextView)findViewById(R.id.tvBenefNameValue);
        tvBenefVpaValue = (TextView)findViewById(R.id.tvBenefVpaValue);

        btnHome = (Button)findViewById(R.id.btnHome);

        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.header_center);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PaymentSuccessActivity.this,DashboardActivity.class);
                startActivity(i);
            }
        });

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh.mm aa");
        String currentDateandTime = sdf.format(new Date());
        String dateformat = currentDateandTime;
        String date = dateformat.substring(0,10);
        String time = dateformat.substring(11,dateformat.length());

        Intent getPaymentData = getIntent();
        Bundle data = getPaymentData.getBundleExtra("paymentData");
        amt = data.getString("amt");
        remarks = data.getString("remarks");
        txnId  = data.getString("txnId");
        bnfVpa = data.getString("benefVpa");
        bnfName = data.getString("benefName");
        adultqty =  data.getString("adultQty");
        childQty =  data.getString("childQty");
        infantQty =  data.getString("infantQty");

        tvTxnIdValue.setText(txnId);
        tvBenefNameValue.setText(bnfName);
        tvBenefVpaValue.setText(bnfVpa);
        tvRemarksValue.setText(remarks);
        tvAmtValue.setText(amt);
        tvDateValue.setText(date);
        tvTimeValue.setText(time);
    }

    @Override
    public void onBackPressed() {
    }
}
