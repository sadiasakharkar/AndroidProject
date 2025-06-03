package com.example.practical07;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextPhone;
    Button buttonCall;
    final String defaultNumber = "1234567890";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPhone = findViewById(R.id.editTextPhone);
        buttonCall = findViewById(R.id.buttonCall);

        buttonCall.setOnClickListener(v -> {
            String number = editTextPhone.getText().toString().trim();

            if (number.isEmpty()) {
                number = defaultNumber;
                Toast.makeText(this, "Using default number: " + defaultNumber, Toast.LENGTH_SHORT).show();
            }

            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent); // No runtime permission check here
        });
    }
}
