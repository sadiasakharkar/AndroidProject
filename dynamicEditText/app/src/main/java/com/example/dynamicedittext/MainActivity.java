package com.example.dynamicedittext;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        collectNumber();
    }

    public void collectNumber() {
        // Get references to UI elements
        EditText numberEditText = findViewById(R.id.numberEditText);
        Button submit = findViewById(R.id.submit);
        LinearLayout linearLayout = findViewById(R.id.linearlayout);

        // Button click listener
        submit.setOnClickListener(v -> {
            String input = numberEditText.getText().toString();

            if (!input.isEmpty()) {
                int number = Integer.parseInt(input);

                if (number > 0) {
                    linearLayout.removeAllViews(); // Clear previous TextViews

                    // Generate 'number' TextViews dynamically
                    for (int i = 1; i <= number; i++) {
                        TextView textView = new TextView(MainActivity.this);
                        textView.setText("Hello " + i);
                        textView.setTextSize(20);
                        linearLayout.addView(textView); // Add TextView to layout
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Enter number > 0", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
