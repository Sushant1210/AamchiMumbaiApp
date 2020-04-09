package com.example.firstminiproject;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PaymentActivity extends AppCompatActivity {

    EditText etName,etUpiID,etAmt,etRemarks;
    Button btnPay;
    String adultqty,childQty,infantQty,adultPrice,childPrice,InfantPrice,totalAmt;
    String amtArray[];
    final int UPI_PAYMENT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        getSupportActionBar().setTitle("Payment Confirmation");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etName = (EditText)findViewById(R.id.etName);
        etName.setEnabled(false);
        etUpiID = (EditText)findViewById(R.id.etUpiId);
        etUpiID.setEnabled(false);
        etAmt = (EditText)findViewById(R.id.etAmt);
        etAmt.setEnabled(false);
        etRemarks = (EditText)findViewById(R.id.etRemarks);
        btnPay = (Button)findViewById(R.id.btnPay);

        Intent getData = getIntent();
        Bundle data = getData.getBundleExtra("tripData");
        adultqty = data.getString("adultQty");
        childQty = data.getString("childQty");
        infantQty = data.getString("infantQty");
        adultPrice = data.getString("adultPrice");
        childPrice = data.getString("childPrice");
        InfantPrice = data.getString("infantPrice");
        totalAmt = data.getString("totalSum");

        etAmt.setText(totalAmt);

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPaymentVaidate()){
                    amtArray = etAmt.getText().toString().split(" ");
                    totalAmt = amtArray[1];
                    payUsingUpi(etName.getText().toString(),etUpiID.getText().toString(),etRemarks.getText().toString(),totalAmt);
                }
            }
        });
    }

    void payUsingUpi(String toString, String toString1, String toString2, String toString3) {
        Uri uri =
                new Uri.Builder()
                        .scheme("upi")
                        .authority("pay")
                        .appendQueryParameter("pa", etUpiID.getText().toString()) //Virtual ID (Account)
                        .appendQueryParameter("pn", etName.getText().toString())
                        //  .appendQueryParameter("mc", "your-merchant-code")
                        //  .appendQueryParameter("tr", "your-transaction-ref-id")
                        .appendQueryParameter("tn", etRemarks.getText().toString())
                        .appendQueryParameter("am",totalAmt)
                        .appendQueryParameter("cu", "INR")
                        //  .appendQueryParameter("url", "your-transaction-url")
                        .build();

        Intent upiPayIntent = new Intent(Intent.ACTION_VIEW);
        upiPayIntent.setData(uri);

        Intent chooser = Intent.createChooser(upiPayIntent,"Pay Using");

        if(chooser.resolveActivity(getPackageManager()) != null){
            startActivityForResult(chooser,UPI_PAYMENT);
        }else{
            Toast.makeText(this, "No UPI App found, Please install one to continue", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("Main","response " +resultCode);

        switch (requestCode) {
            case UPI_PAYMENT:
                if ((RESULT_OK == resultCode) && (requestCode == UPI_PAYMENT)) {
                    if (data != null) {
                        String trxt = data.getStringExtra("response");
                        Log.e("UPI", "onActivityResult: " + trxt);
                        ArrayList<String> dataList = new ArrayList<>();
                        dataList.add(trxt);
                        upiPaymentDataOperation(dataList);
                    } else {
                        Log.e("UPI", "onActivityResult: " + "Return data is null");
                        ArrayList<String> dataList = new ArrayList<>();
                        dataList.add("nothing");
                        upiPaymentDataOperation(dataList);
                    }
                } else {
                    //when user simply back without payment
                    Log.e("UPI", "onActivityResult: " + "Return data is null");
                    ArrayList<String> dataList = new ArrayList<>();
                    dataList.add("nothing");
                    upiPaymentDataOperation(dataList);
                }
                break;
        }
    }
    private void upiPaymentDataOperation(ArrayList<String> data) {
        if (isConnectionAvailable(PaymentActivity.this)) {
            String str = data.get(0);
            Log.e("UPIPAY", "upiPaymentDataOperation: "+str);
            String paymentCancel = "";
            if(str == null) str = "discard";
            String status = "";
            String approvalRefNo = "";
            String response[] = str.split("&");
            try{
                for (int i = 0; i < response.length; i++) {
                    String equalStr[] = response[i].split("=");
                    if (equalStr.length >= 2) {
                        if (equalStr[0].toLowerCase().equals("Status".toLowerCase())) {
                            status = equalStr[1].toLowerCase();
                        } else if (equalStr[0].toLowerCase().equals("ApprovalRefNo".toLowerCase()) || equalStr[0].toLowerCase().equals("txnRef".toLowerCase())) {
                            approvalRefNo = equalStr[1];
                        }
                    } else {
                        paymentCancel = "Payment cancelled by user.";
                    }
                }
            }catch (Exception err){
                err.printStackTrace();
            }
            if (status.equals("success")) {
                //Code to handle successful transaction here.
                Intent i = new Intent(this,PaymentSuccessActivity.class);
                Bundle b = new Bundle();
                b.putString("remarks",etRemarks.getText().toString());
                b.putString("txnId",approvalRefNo);
                b.putString("amt", etAmt.getText().toString());
                b.putString("benefVpa",etUpiID.getText().toString());
                b.putString("benefName",etName.getText().toString());
                b.putString("adultQty",adultqty);
                b.putString("childQty",childQty);
                b.putString("infantQty",infantQty);
                i.putExtra("paymentData",b);
                startActivity(i);

                Toast.makeText(PaymentActivity.this, "Transaction successful.", Toast.LENGTH_SHORT).show();
                Log.e("UPI", "payment successfull: "+approvalRefNo);
            }
            else if("Payment cancelled by user.".equals(paymentCancel)) {
                Toast.makeText(PaymentActivity.this, "Payment cancelled by user.", Toast.LENGTH_SHORT).show();
                Log.e("UPI", "Cancelled by user: "+approvalRefNo);
            }
            else {
                Toast.makeText(PaymentActivity.this, "Transaction failed.Please try again", Toast.LENGTH_SHORT).show();
                Log.e("UPI", "failed payment: "+approvalRefNo);
            }
        } else {
            Log.e("UPI", "Internet issue: ");
            Toast.makeText(PaymentActivity.this, "Internet connection is not available. Please check and try again", Toast.LENGTH_SHORT).show();
        }
    }
    public static boolean isConnectionAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnected()
                    && netInfo.isConnectedOrConnecting()
                    && netInfo.isAvailable()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean isPaymentVaidate(){
        if(etRemarks.getText().toString().equals(" ") || etRemarks.getText().toString() == null ){
            Toast.makeText(this,"Please Enter Remarks",Toast.LENGTH_SHORT).show();
            return false;
        }else{
            return true;
        }
    }
}

