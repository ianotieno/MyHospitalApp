package com.example.myhospitalapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
 EditText edUsername, edPassword;
 Button btn;
 TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUsername = findViewById(R.id.editTextUsername);
        edPassword = findViewById(R.id.editTextPassword);
        tv = findViewById(R.id.textViewNewUser);
        btn = findViewById(R.id.buttonLogin);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edUsername.getText().toString();
                String password= edPassword.getText().toString();
                Database db = new Database(getApplicationContext(),"healthcare",null, 1);

                if (username.isEmpty() || password.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Fill are required fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(db.login(username,password)==1){
                        Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username",username);
                        editor.apply();
                        startActivity(new Intent(LoginActivity.this,HomeActivity.class));


                    }else{
                        Toast.makeText(LoginActivity.this, "Invalid Username and Password", Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

    }
}