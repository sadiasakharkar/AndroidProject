package com.example.practical05;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    EditText e1, e2;
    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.et1);
        e2 = findViewById(R.id.et2);
        bt1 = findViewById(R.id.bt);

        // Initially disable the login button
        bt1.setEnabled(false);

        // Add TextWatcher to both EditTexts
        e1.addTextChangedListener(this);
        e2.addTextChangedListener(this);

        // Adjust padding for system bars (like status bar and navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // This method is not used here, but we need to override it
    }

    @Override
    public void onTextChanged(CharSequence s, int start,  int count , int before) {
        // Enable the login button only if both fields are not empty
        bt1.setEnabled(!e1.getText().toString().isEmpty() && !e2.getText().toString().isEmpty());
    }

    @Override
    public void afterTextChanged(Editable s) {
        // This method is not used here, but we need to override it
    }

    // Method to validate login credentials
    public void Login(View view) {
        if (e1.getText().toString().equals("sadia") && e2.getText().toString().equals("123")) {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
    }
}
