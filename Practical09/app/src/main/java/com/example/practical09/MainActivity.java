package com.example.practical09;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ImageView iv;
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Spinner and ImageView
        sp = findViewById(R.id.spinner);
        iv = findViewById(R.id.imageView);

        // Strings from the resource folder (res/values/strings.xml)
        String[] animals = getResources().getStringArray(R.array.animal_array);

        // Create an adapter and set it for the spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, animals);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

        // Set the item selected listener
        sp.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Change image based on selected spinner item
        switch (position) {
            case 0:
                iv.setImageResource(R.drawable.cat);  // Image for "Cat"
                break;
            case 1:
                iv.setImageResource(R.drawable.dog);  // Image for "Dog"
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // No action needed for now
    }
}
