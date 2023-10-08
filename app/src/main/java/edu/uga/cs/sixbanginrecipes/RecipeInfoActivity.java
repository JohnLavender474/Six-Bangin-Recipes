package edu.uga.cs.sixbanginrecipes;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class RecipeInfoActivity extends AppCompatActivity {

    private static final String TAG = "RecipeInfoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Log.d(TAG, "Calling onCreate()");
            super.onCreate(savedInstanceState);

            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null)
                actionBar.setDisplayHomeAsUpEnabled(true);

            if (getResources().getConfiguration().orientation ==
                    Configuration.ORIENTATION_LANDSCAPE) {
                Log.d(TAG, "onCreate(): in landscape mode; returning");
                finish();
                return;
            }

            Log.d(TAG, "onCreate(): in portrait mode; replacing fragments");
            RecipeInfoFragment recipeInfoFragment = new RecipeInfoFragment();
            Log.d(TAG, "onCreate(): recipeInfoFragment: " + recipeInfoFragment);
            recipeInfoFragment.setArguments(getIntent().getExtras());

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportFragmentManager().beginTransaction().replace(
                    android.R.id.content, recipeInfoFragment).commit();
        } catch (Exception e) {
            Log.d(TAG, "onCreate(): " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        try {
            int id = item.getItemId();
            if (id == android.R.id.home) {
                onBackPressed();
                return true;
            }
            return super.onOptionsItemSelected(item);
        } catch (Exception e) {
            Log.d(TAG, "onOptionsItemSelected(): " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
