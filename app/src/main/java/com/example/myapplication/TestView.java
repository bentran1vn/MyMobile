package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.api.ProductServices;
import com.example.myapplication.model.Product;
import com.example.myapplication.repository.ProductRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestView extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_test_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button loginButton = findViewById(R.id.logout_button);

        loginButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                handleLogout();
            }
        });
    }

    private void handleLogout() {
        Intent intent = new Intent(TestView.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish(); // Optional: Close the current activity to avoid any lingering references

//        // Get the username and password input
//        String username = editTextUsername.getText().toString().trim();
//        String password = editTextPassword.getText().toString().trim();
//
//        // Reset error messages
//        textViewUserMessage.setVisibility(View.INVISIBLE);
//        textViewPassMessage.setVisibility(View.INVISIBLE);
//
//        // Simple validation
//        if (TextUtils.isEmpty(username)) {
//            textViewUserMessage.setText("Username is required");
//            textViewUserMessage.setVisibility(View.VISIBLE);
//        }
//
//        if (TextUtils.isEmpty(password)) {
//            textViewPassMessage.setText("Password is required");
//            textViewPassMessage.setVisibility(View.VISIBLE);
//        }

//        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
//            // Dummy logic for username and password validation
//            if (username.equals("admin") && password.equals("1234")) {
//                Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
//
//                // Move to HomePage after successful login
//
//
//                // Optional: Call finish() to close the login activity
//                finish();
//            } else {
//                Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
//            }
//        }
    }



}