package com.roshank.class7am10_24;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Register_Activity extends AppCompatActivity {

    //assigning objects
    EditText username, password, phone, address, email;
    RadioGroup gender;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);


        preferences = getSharedPreferences("Userinfo", 0);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        address = (EditText) findViewById(R.id.address);

        gender = (RadioGroup) findViewById(R.id.gender);

        findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processRegister();
            }
        });
    }


    public void processRegister() {
        String usernameValue = username.getText().toString();
        String passwordValue = password.getText().toString();
        String emailValue = email.getText().toString();
        String phoneValue = phone.getText().toString();
        String addressValue = address.getText().toString();

        RadioButton checkedRadioButton = (RadioButton) findViewById(gender.getCheckedRadioButtonId());
        String genderValue = checkedRadioButton.getText().toString();

        if (isEmpty(username) && isEmpty(password) && isValidEmail(email) && isValidPhone(phone) && isEmpty(address)) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("username", usernameValue);
            editor.putString("password", passwordValue);
            editor.putString("email", emailValue);
            editor.putString("phone", phoneValue);
            editor.putString("address", addressValue);
            editor.putString("gender", genderValue);

            editor.apply();

            Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show();
        }
    }

    //validation of user input
    public boolean isEmpty(EditText view) {

        if (view.getText().length() > 0) {
            return true;
        } else {
            view.setError("Enter Value");
            return false;
        }
    }

    public boolean isValidPhone(EditText view) {

        if (view.getText().length() == 10 && view.getText().toString().startsWith("98")) {
            return true;
        } else {
            view.setError("Must start with 98");
            return false;
        }
    }
    public boolean isValidEmail(EditText view) {

        if (Patterns.EMAIL_ADDRESS.matcher(view.getText().toString()).matches()) {
            return true;
        } else {
            view.setError("Enter valid email address");
            return false;
        }
    }
}








