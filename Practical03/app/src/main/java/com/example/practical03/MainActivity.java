package com.example.practical03;

import android.os.Bundle;
import android.util.Log;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);  // Links to activity_main.xml

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            Log.d("message", "onCreate is called");
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("message", "onStart is called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("message", "onResume is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("message", "onPause is called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("message", "onStop is called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("message", "onRestart is called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("message", "onDestroy is called");
    }
}
