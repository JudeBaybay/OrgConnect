package com.example.orgconnectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    EditText signupName,signupPassword;
    TextView intoLogin;
    Button signupBtn;
    FirebaseDatabase database2;
    DatabaseReference reference2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signupName = findViewById(R.id.signupName);
        signupPassword = findViewById(R.id.signupPassword);
        intoLogin = findViewById(R.id.intoLogIn);
        signupBtn = findViewById(R.id.signupBtn);

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database2 = FirebaseDatabase.getInstance();
                reference2 = database2.getReference("User");

                String name = signupName.getText().toString();
                String password = signupPassword.getText().toString();

                HelperClass helperClass  = new HelperClass(name,password);
                reference2.child(name).setValue(helperClass);

                Toast.makeText(SignupActivity.this, "Signup Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        intoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}