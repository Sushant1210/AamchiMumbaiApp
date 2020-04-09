package com.example.firstminiproject;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class BookTicketConfirmationActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText et_Travel_Date;
    TextInputLayout etTravelDate;
    SharedPreferences getData;
    String tableFlag,amtFlag;
    TextView tvAdultPrice, tvChildPrice, tvInfantPrice, tvadultAmt, tvChildAmt, tvInfantAmt, tvTripSumm, tvAmt, tvamtValue, tvSummeryVal;
    Button btnMinusAdult, btnAddAdult, btnMinusChild, btnAddChild, btnMinusInfant, btnAddInfant, btnSave,btnProceed;
    private Calendar mCalendar = Calendar.getInstance();
    private int day, month, year;
    String adultPrice;
    String childPrice;
    String infantPrice;
    boolean btnsaveFlag = false,your_date_is_outdated;
    //  private DatePickerDialog.OnDateSetListener date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ticket_confirmation);

        getSupportActionBar().setTitle("Booking Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        et_Travel_Date = (TextInputEditText) findViewById(R.id.et_Travel_Date);
        etTravelDate = (TextInputLayout) findViewById(R.id.etTravelDate);

        tvadultAmt = (TextView) findViewById(R.id.tvAmtAdult);
        tvChildAmt = (TextView) findViewById(R.id.tvAmtChildren);
        tvInfantAmt = (TextView) findViewById(R.id.tvAmtInfants);

        tvAdultPrice = (TextView) findViewById(R.id.tvadultPrice);
        tvChildPrice = (TextView) findViewById(R.id.tvChildPrice);
        tvInfantPrice = (TextView) findViewById(R.id.tvInfantsPrice);

        btnAddAdult = (Button) findViewById(R.id.btnAddAdult);
        btnAddChild = (Button) findViewById(R.id.btnAddChildren);
        btnAddInfant = (Button) findViewById(R.id.btnAddInfants);

        btnMinusAdult = (Button) findViewById(R.id.btnMinusAdult);
        btnMinusChild = (Button) findViewById(R.id.btnMinusChild);
        btnMinusInfant = (Button) findViewById(R.id.btnMinusInfants);

        btnSave = (Button)findViewById(R.id.btnSave);
        btnProceed = (Button)findViewById(R.id.btnProceed);
        btnProceed.setVisibility(View.GONE);

        btnAddAdult.setOnClickListener(this);
        btnAddChild.setOnClickListener(this);
        btnAddInfant.setOnClickListener(this);
        btnMinusAdult.setOnClickListener(this);
        btnMinusChild.setOnClickListener(this);
        btnMinusInfant.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnProceed.setOnClickListener(this);

        tvTripSumm = (TextView)findViewById(R.id.tvTripSummery);
        tvTripSumm.setVisibility(View.GONE);
        tvSummeryVal = (TextView)findViewById(R.id.tvSummeryValue);
        tvSummeryVal.setVisibility(View.GONE);
        tvAmt = (TextView)findViewById(R.id.tvAmt);
        tvAmt.setVisibility(View.GONE);
        tvamtValue = (TextView)findViewById(R.id.tvAmtValue);
        tvamtValue.setVisibility(View.GONE);

        et_Travel_Date.setOnClickListener(mClickListener);

        try {
            getData = getSharedPreferences("tableData", MODE_PRIVATE);
            tableFlag = getData.getString("tableExixtsFlag", null);
            if (tableFlag != null) {
                SQLiteHelper sqLiteHelper = new SQLiteHelper(getApplicationContext());
                ArrayList<String> priceList = sqLiteHelper.getData();
                 adultPrice = priceList.get(0);
                childPrice = priceList.get(1);
                 infantPrice = priceList.get(2);

                tvAdultPrice.setText("(₹ " + adultPrice.toString() + " each)");
                tvChildPrice.setText("(₹ " + childPrice.toString() + " each)");
                tvInfantPrice.setText("(₹ " + infantPrice.toString() + " each)");

            }
        } catch (Exception error) {
            //   Log.ERROR("Error is " +error);
        }


    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DateDialog();
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void DateDialog() {
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //et_Travel_Date.setHint("");
                et_Travel_Date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                etTravelDate.setHint("Selected Travel Date");

            }
        };

        int year = mCalendar.get(Calendar.YEAR);
        int month = mCalendar.get(Calendar.MONTH);
        int day = mCalendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dpDialog = new DatePickerDialog(this, listener, year, month, day);
        dpDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        dpDialog.show();
    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnMinusAdult:
                amtFlag = "minusAdult";
                subtractQty(amtFlag);
                calculateAmt();
                viewTripSummery();
                break;

            case R.id.btnAddAdult:
                amtFlag = "addAdult";
                addtQty(amtFlag);
                calculateAmt();
                viewTripSummery();
                break;

            case R.id.btnMinusChild:
                amtFlag = "minusChildren";
                subtractQty(amtFlag);
                calculateAmt();
                viewTripSummery();
                break;

            case R.id.btnAddChildren:
                amtFlag = "addChildren";
                addtQty(amtFlag);
                calculateAmt();
                viewTripSummery();
                break;

            case R.id.btnMinusInfants:
                amtFlag = "minusInfants";
                subtractQty(amtFlag);
                calculateAmt();
                viewTripSummery();
                break;

            case R.id.btnAddInfants:
                amtFlag = "addInfants";
                addtQty(amtFlag);
                calculateAmt();
                viewTripSummery();
                break;

            case R.id.btnSave:
                if(isbookingValid()){
                    btnsaveFlag = true;
                    viewTripSummery();
                    calculateAmt();
                }
                 
                break;

                case R.id.btnProceed:
                proceedToPay();

                break;


        }
    }

    private void proceedToPay() {
        Intent i = new Intent(this,PaymentActivity.class);
        Bundle b = new Bundle();
        b.putString("adultQty", tvadultAmt.getText().toString());
        b.putString("childQty", tvChildAmt.getText().toString());
        b.putString("infantQty", tvInfantAmt.getText().toString());
        b.putString("adultPrice", adultPrice);
        b.putString("childPrice", childPrice);
        b.putString("infantPrice", infantPrice);
        b.putString("totalSum",tvamtValue.getText().toString());

        i.putExtra("tripData",b);
        startActivity(i);
    }

    private boolean isbookingValid() {
        if(et_Travel_Date.getText().toString().equals("")){
            Toast.makeText(this,"Please Select date on which you wish to travel",Toast.LENGTH_LONG).show();
            return  false;
        }else if(! et_Travel_Date.getText().toString().equals("")) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String my_date = et_Travel_Date.getText().toString();
            Date strDate = null;
            try {
                strDate = sdf.parse(my_date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (new Date().after(strDate)) {
                your_date_is_outdated = true;
                Toast.makeText(this, "Please Select date other than today's date", Toast.LENGTH_LONG).show();
                return false;
            }else{
                if (tvadultAmt.getText().toString().equals("0") && tvChildAmt.getText().toString().equals("0") && tvInfantAmt.getText().toString().equals("0")) {
                    Toast.makeText(this, "Please Select atleast one category out of adults, children and infants", Toast.LENGTH_LONG).show();
                    return false;
                }else if (tvadultAmt.getText().toString().equals("0") && (!tvChildAmt.getText().toString().equals("0") || ! tvInfantAmt.getText().toString().equals("0"))) {
                    Toast.makeText(this, "Only Infants/Children are not allowed, please Select atleast one adult member.", Toast.LENGTH_LONG).show();
                    return false;
                }else {
                    return true;
                }
            }
        }else
            return true;
    }

    private void calculateAmt() {
        try{
            int adultSum1 = Integer.parseInt(tvadultAmt.getText().toString());
            int adultSum2 = Integer.parseInt(adultPrice);
            int a = adultSum1 * adultSum2;
            int chileSum = (Integer.parseInt(tvChildAmt.getText().toString())) * (Integer.parseInt(childPrice.toString()));
            int infantSum = (Integer.parseInt(tvInfantAmt.getText().toString())) * (Integer.parseInt(infantPrice.toString()));
            int finalSum = a + chileSum +infantSum;
            if(btnsaveFlag == true){
                tvAmt.setText("The Total amount you need to pay is");
                tvAmt.setVisibility(View.VISIBLE);
                tvamtValue.setText("₹ " +String.valueOf(finalSum));
                tvamtValue.setVisibility(View.VISIBLE);
                btnProceed.setVisibility(View.VISIBLE);
            }
        }catch (Exception err){
        }
    }

    private void addtQty(String amtFlag) {
        int value =0;
        if(amtFlag.equals("addAdult")){
            value = Integer.parseInt(tvadultAmt.getText().toString());
        }if(amtFlag.equals("addChildren")){
            value = Integer.parseInt(tvChildAmt.getText().toString());
        }if(amtFlag.equals("addInfants")){
            value = Integer.parseInt(tvInfantAmt.getText().toString());
        }
        value += 1;
        if(amtFlag.equals("addAdult")) {
            tvadultAmt.setText(String.valueOf(value));
        }if(amtFlag.equals("addChildren")) {
            tvChildAmt.setText(String.valueOf(value));
        }if(amtFlag.equals("addInfants")) {
            tvInfantAmt.setText(String.valueOf(value));
        }
    }

    private void subtractQty(String amtFlag) {
        int value =0;
        if(amtFlag.equals("minusAdult")){
            value = Integer.parseInt(tvadultAmt.getText().toString());
        }if(amtFlag.equals("minusChildren")){
            value = Integer.parseInt(tvChildAmt.getText().toString());
        }if(amtFlag.equals("minusInfants")){
            value = Integer.parseInt(tvInfantAmt.getText().toString());
        }

        if (value > 0) {
            value -= 1;
            if(amtFlag.equals("minusAdult")){
                tvadultAmt.setText(String.valueOf(value));
            }if(amtFlag.equals("minusChildren")){
                tvChildAmt.setText(String.valueOf(value));
            }if(amtFlag.equals("minusInfants")){
                tvInfantAmt.setText(String.valueOf(value));
            }

        } else {
            Toast.makeText(this, "Minimum Quantity should be Zero", Toast.LENGTH_SHORT).show();
        }
    }

    private void viewTripSummery() {
        if(btnsaveFlag == true){
            tvTripSumm.setVisibility(View.VISIBLE);
            tvSummeryVal.setVisibility(View.VISIBLE);
        }

        tvSummeryVal.setText("You have booked your Mumbai Darshan trip on "+et_Travel_Date.getText().toString()+", which includes "+tvadultAmt.getText().toString()+" adults, "+tvChildAmt.getText().toString()+" children and "+tvInfantAmt.getText().toString()+" infants.");
    }

}

