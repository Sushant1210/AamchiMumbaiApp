package com.example.firstminiproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
   // EditText  password, confirmpassword, emailId;
    TextInputEditText username, password, confirmpassword, emailId;
    TextInputLayout tvEmail,tvUname,tvPassword,tvConfirmPass;
    Button btnBackRegister;
    RadioButton rbMale, rbFemale;
    RadioGroup rbGender;
    SharedPreferences storeData;
    TextView  tvGender;
    SharedPreferences.Editor editor;
    String flow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Intent data = getIntent();
        flow = data.getStringExtra("flowValue");

        tvUname = findViewById(R.id.tvUname);
        tvEmail = findViewById(R.id.tvEmail);
        tvGender = findViewById(R.id.tvGender);
        tvPassword = findViewById(R.id.tvPassword);
        tvConfirmPass = findViewById(R.id.tvConfirmPassword);
        username = findViewById(R.id.etUname);
        emailId = findViewById(R.id.etEmail);
        password = findViewById(R.id.etpassword1);
        confirmpassword = findViewById(R.id.etConfirmpassword);
        btnBackRegister = findViewById(R.id.btnBack);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        rbGender = findViewById(R.id.rbGender);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (!flow.equals("registration")) {
            tvUname.setHint("New Username");
            tvPassword.setHint("New Password");
            tvConfirmPass.setHint("Confirm New Password");
            tvEmail.setVisibility(View.GONE);
            tvGender.setVisibility(View.GONE);
            rbGender.setVisibility(View.GONE);
            btnBackRegister.setText("Submit");
            Objects.requireNonNull(getSupportActionBar()).setTitle("Set New Credentials");
        } else {
            Objects.requireNonNull(getSupportActionBar()).setTitle("Registration");
        }
        btnBackRegister.setOnClickListener(this);
        rbGender.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                storeAndPassData();
                break;

            default:
                break;
        }
    }


    private void storeAndPassData() {
        if (isValidregistration()) {
            if (!flow.equals("registration")) {
                Toast.makeText(this, "New Credentials have been Set Successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
            }

            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
//            i.putExtra("username", username.getText().toString());
//            i.putExtra("email", emailId.getText().toString());
//            i.putExtra("password", password.getText().toString());
//            i.putExtra("gender", rbMale.isChecked() ? "Male" : "Female");
            storeData = getSharedPreferences("userRegData", MODE_PRIVATE);
            editor = storeData.edit();
            editor.putString("username", username.getText().toString());
            editor.putString("password", password.getText().toString());
            if (flow.equals("registration")) {
                editor.putString("user email", password.getText().toString());
            }

            editor.putString("count", "1");
           // editor.commit();
            editor.apply();
            startActivity(i);
        }
    }

    private boolean isValidregistration() {
        if (!flow.equals("registration")) {
            if (username.getText().toString().equals("")) {
                username.requestFocus();
                username.setError("Please Enter New Username");
                return false;
            } else if (password.getText().toString().equals("")) {
                password.requestFocus();
                password.setError("Please Enter New Password");
                return false;
            } else if (confirmpassword.getText().toString().equals("")) {
                confirmpassword.requestFocus();
                confirmpassword.setError("Please Enter Confirm Password");
                return false;
            } else if (!password.getText().toString().equals(confirmpassword.getText().toString())) {
                Toast.makeText(this, "Password and confirm password should be same", Toast.LENGTH_SHORT).show();
                return false;
            } else {
                return true;
            }
        } else {
            if (username.getText().toString().equals("")) {
                username.requestFocus();
                username.setError("Please Enter Username");
                return false;
            } else if (emailId.getText().toString().equals("")) {
                emailId.requestFocus();
                emailId.setError("Please Enter Email-Id");
                return false;
            } else if (!rbMale.isChecked() && !rbFemale.isChecked()) {
                Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show();
                return false;
            } else if (password.getText().toString().equals("")) {
                password.requestFocus();
                password.setError("Please Enter Password");
                return false;
            } else if (confirmpassword.getText().toString().equals("")) {
                confirmpassword.requestFocus();
                confirmpassword.setError("Please Enter Confirm Password");
                return false;
            } else if (!password.getText().toString().equals(confirmpassword.getText().toString())) {
                Toast.makeText(this, "Password and confirm password should be same", Toast.LENGTH_SHORT).show();
                return false;
            } else {
                return true;
            }
        }
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        tvGender.setTextColor(getResources().getColor(R.color.colorPrimary));
    }
}
