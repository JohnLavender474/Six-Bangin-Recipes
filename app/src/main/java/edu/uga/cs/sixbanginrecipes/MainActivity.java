package edu.uga.cs.sixbanginrecipes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Log.d(TAG, "Calling onCreate()");
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash_screen);

            Button go = findViewById(R.id.goButton);
            go.setOnClickListener(v -> v
                    .getContext()
                    .startActivity(
                            new Intent(v.getContext(), RecipeListActivity.class)));
        } catch (Exception e) {
            Log.d(TAG, "onCreate(): " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

}
