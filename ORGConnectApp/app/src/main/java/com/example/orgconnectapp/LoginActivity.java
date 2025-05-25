package com.example.orgconnectapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    SharedPreferences sp;
    EditText loginName, loginPassword;
    Button loginBtn;
    TextView intoSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sp = getSharedPreferences("login",MODE_PRIVATE);

        if(sp.getBoolean("logged",false)){
            goToMainActivity();
        }

        loginName = findViewById(R.id.loginName);
        loginPassword = findViewById(R.id.loginPassword);
        loginBtn = findViewById(R.id.loginBtn);
        intoSignup = findViewById(R.id.intoSignUp);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!validName() | !validPassword()){

                }else{
                    checkAdmin();
                }
            }
        });

        intoSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }

    private void goToMainActivity() {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public Boolean validName(){

        String val = loginName.getText().toString();
        if (val.isEmpty()){
            loginName.setError("User Cannot Be Empty");
            return false;
        }else {
            loginName.setError(null);
            return true;
        }
    }
    public Boolean validPassword(){

        String val = loginPassword.getText().toString();
        if (val.isEmpty()){
            loginPassword.setError("Password Cannot Be Empty");
            return false;
        }else {
            loginPassword.setError(null);
            return true;
        }
    }

    public void checkAdmin(){
        String adminName = loginName.getText().toString().trim();
        String adminPassword = loginPassword.getText().toString().trim();

        DatabaseReference reference2 = FirebaseDatabase.getInstance().getReference("User");
        Query checkAdminDatabase = reference2.orderByChild("name").equalTo(adminName);

        checkAdminDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()){
                    loginName.setError(null);
                    String passwordFromDB = snapshot.child(adminName).child("password").getValue(String.class);

                    if (passwordFromDB.equals(adminPassword)){
                        loginName.setError(null);
                        sp.edit().putBoolean("logged",true).apply();
                        goToMainActivity();
                    }else{
                        loginPassword.setError("Invalid Credentials");
                        loginPassword.requestFocus();
                    }
                }else{
                    loginName.setError("User does not exist");
                    loginName.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}