package com.example.firstminiproject;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText username, password;
    Button btnLogin, btnRegister;
    String Username, Password;
    SharedPreferences getstoredData;
    TextView forgotCreds;
    String flow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        username = findViewById(R.id.etUname);
        password = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        forgotCreds = findViewById(R.id.tvForgotCredentials);

        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        forgotCreds.setOnClickListener(this);

        this.getSupportActionBar().hide();

        //Objects.requireNonNull(getSupportActionBar()).setTitle("Login");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                loginPageValidate();
                break;

            case R.id.btnRegister:
                try{
                    flow = "registration";
                    Intent i1 = new Intent(getApplicationContext(), RegistrationActivity.class);
                    i1.putExtra("flowValue","registration");
                    startActivity(i1);
//                    Username = getstoredData.getString("username",null);
//                    Password = getstoredData.getString("password",null);
                }catch (Exception err){

                }
                break;

            case R.id.tvForgotCredentials:
                try{
                    flow = "forgotCredentials";
                    Intent i1 = new Intent(getApplicationContext(), RegistrationActivity.class);
                    i1.putExtra("flowValue","forgotCredentials");
                    startActivity(i1);
//                    Username = getstoredData.getString("username",null);
//                    Password = getstoredData.getString("password",null);
                }catch (Exception err){

                }
                break;

                default:
                break;
        }

    }

    private void loginPageValidate() {
        try {
//            Intent data = getIntent();
//            Username = data.getStringExtra("username");
//            Password = data.getStringExtra("password");
             getstoredData = getSharedPreferences("userRegData",MODE_PRIVATE);
             Username = getstoredData.getString("username",null);
             Password = getstoredData.getString("password",null);

            if (Username.equals("") || Password.equals("")) {
                Toast.makeText(this, "Enter Username", Toast.LENGTH_SHORT).show();
            }
            if (username.getText().toString().equals("") || username.getText().toString() == null) {
                username.requestFocus();
                username.setError("Enter Username");
            } else if (password.getText().toString().equals("") || password.getText().toString() == null) {
                password.requestFocus();
                password.setError("Enter password");
            } else {
                if (!username.getText().toString().equals(Username) || !password.getText().toString().equals(Password)) {
                    Toast.makeText(this, "You are not Registered User OR Please Enter Valid Username and Password that you have set during Registration", Toast.LENGTH_LONG).show();
                } else {

                    Intent i = new Intent(getApplicationContext(), DashboardActivity.class);
                    startActivity(i);
                    finish();
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "You are not Registered User,please do registration first.", Toast.LENGTH_SHORT).show();
        }
    }

    boolean isBackPressedTwice = false;
    @Override
    public void onBackPressed() {
     if(isBackPressedTwice){
         //super.onBackPressed();
         return;
     }
        isBackPressedTwice = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                isBackPressedTwice = false;
                System.exit(0);
            }
        }, 2000);
    }

//    public boolean onOptionsItemSelected(MenuItem item) {
//        if(item.getItemId() == android.R.id.home){
//            finish();
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
