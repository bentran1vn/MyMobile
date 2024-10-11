package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

public class MainActivity extends AppCompatActivity {
    private EditText editTextUsername, editTextPassword;
    private TextView textViewUserMessage, textViewPassMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.editTextTextUser);
        editTextPassword = findViewById(R.id.editTextTextPass);
        textViewUserMessage = findViewById(R.id.textViewUserMessage);
        textViewPassMessage = findViewById(R.id.textViewPassMessage);

        Button loginButton = findViewById(R.id.button);

        loginButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                handleLogin();
            }
        });
    }

    private void handleLogin() {
        // Get the username and password input
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // Reset error messages
        textViewUserMessage.setVisibility(View.INVISIBLE);
        textViewPassMessage.setVisibility(View.INVISIBLE);

        // Simple validation
        if (TextUtils.isEmpty(username)) {
            textViewUserMessage.setText("Username is required");
            textViewUserMessage.setVisibility(View.VISIBLE);
        }

        if (TextUtils.isEmpty(password)) {
            textViewPassMessage.setText("Password is required");
            textViewPassMessage.setVisibility(View.VISIBLE);
        }

        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            // Dummy logic for username and password validation
            if (username.equals("admin") && password.equals("1234")) {
                Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();

                // Move to HomePage after successful login
                Intent intent = new Intent(MainActivity.this, ProductPage.class);
                startActivity(intent);

                // Optional: Call finish() to close the login activity
                finish();
            } else {
                Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
            }
        }
    }
}