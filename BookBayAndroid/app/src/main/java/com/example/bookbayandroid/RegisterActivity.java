package com.example.bookbayandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextEmail;
    EditText mTextName;
    EditText mTextHouseNo;
    EditText mTextStreet;
    EditText mTextLocality;
    EditText mTextPostalCode;
    EditText mTextLandmark;
    EditText mTextCity;
    EditText mTextState;
    EditText mTextMobileNo;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("Register");

        mTextUsername = (EditText)findViewById(R.id.editText_username);
        mTextEmail = (EditText)findViewById(R.id.editText_email);
        mTextName = (EditText)findViewById(R.id.editText_name);
        mTextHouseNo = (EditText)findViewById(R.id.editText_houseno);
        mTextStreet = (EditText)findViewById(R.id.editText_street);
        mTextLocality = (EditText)findViewById(R.id.editText_locality);
        mTextPostalCode = (EditText)findViewById(R.id.editText_postalcode);
        mTextLandmark = (EditText)findViewById(R.id.editText_landmark);
        mTextCity = (EditText)findViewById(R.id.editText_city);
        mTextState = (EditText)findViewById(R.id.editText_state);
        mTextMobileNo = (EditText)findViewById(R.id.editText_mobileno);
        mTextPassword = (EditText)findViewById(R.id.editText_password);
        mTextCnfPassword = (EditText)findViewById(R.id.editText_confirmpassword);
        mButtonRegister = (Button)findViewById(R.id.button_register);
        mTextViewLogin = (TextView)findViewById(R.id.textview_login);
        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(LoginIntent);
            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                OnSignup(view);
            }
        });

    }

    public void OnSignup(View view) {
        String user_name = mTextUsername.getText().toString();
        String email = mTextEmail.getText().toString();
        String name = mTextName.getText().toString();
        String houseno = mTextHouseNo.getText().toString();
        String street = mTextStreet.getText().toString();
        String locality = mTextLocality.getText().toString();
        String postalcode = mTextPostalCode.getText().toString();
        String landmark = mTextLandmark.getText().toString();
        String city = mTextCity.getText().toString();
        String state = mTextState.getText().toString();
        String mobileno = mTextMobileNo.getText().toString();
        String password = mTextPassword.getText().toString();
        String cnfpassword = mTextCnfPassword.getText().toString();
        String type = "signup";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, user_name, email, name, houseno, street, locality, postalcode, landmark, city, state, mobileno, password, cnfpassword);
    }
}