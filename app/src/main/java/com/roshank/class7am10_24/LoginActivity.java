package com.roshank.class7am10_24;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText username, password;
    Button login, register;
    SharedPreferences preferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
preferences = getSharedPreferences("Userinfo", 0);
        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);

        login = (Button) findViewById(R.id.login1);
        register = (Button) findViewById(R.id.register1);

        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

@Override
public void onClick(View view) {
    if (view.getId()==R.id.login1) {
        loginProcess();
    }else if(view.getId()==R.id.register1){
                    registerProcess();
    }
}

    public void loginProcess() {
        String usernameValue = username.getText().toString();
        String passwordValue = password.getText().toString();

        String registeredUsername = preferences.getString("username", "");
        String registeredPassword = preferences.getString("password", "");

        Toast.makeText(this, "Username:" + usernameValue + "Password:" + passwordValue, Toast.LENGTH_SHORT).show();
        if (usernameValue.equals(registeredUsername) && passwordValue.equals(registeredPassword)) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
        }
    }


        public void registerProcess ()
        {
            Intent intent = new Intent(this, Register_Activity.class);
            startActivity(intent);
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.login_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.register){
            Intent intent = new Intent(this, Register_Activity.class);
            startActivity(intent);
        }else if (id == R.id.home) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }else if (id == R.id.register1) {
            Toast.makeText(this, "Register 1", Toast.LENGTH_SHORT).show();

        }


        return super.onOptionsItemSelected(item);
    }
}


