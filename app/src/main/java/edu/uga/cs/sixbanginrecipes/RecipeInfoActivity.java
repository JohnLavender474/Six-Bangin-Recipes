package edu.uga.cs.sixbanginrecipes;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

/**
 * An activity representing a single Recipe detail screen. This activity is only used narrow width
 * devices. On tablet-size devices, item details are presented side-by-side with a list of items in
 * a {@link RecipeListActivity}.
 * <p>
 * This activity is mostly just a 'shell' activity containing nothing more than a
 * {@link RecipeInfoFragment}.
 */
public class RecipeInfoActivity extends AppCompatActivity {

    private static final String TAG = "RecipeInfoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Log.d(TAG, "Calling onCreate()");
            super.onCreate(savedInstanceState);

            // Set up the action bar.
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null)
                actionBar.setDisplayHomeAsUpEnabled(true);

            // If the orientation is landscape, we shouldn't need this activity.
            if (getResources().getConfiguration().orientation ==
                    Configuration.ORIENTATION_LANDSCAPE) {
                Log.d(TAG, "onCreate(): in landscape mode; returning");
                finish();
                return;
            }

            // If we get here, we're in portrait mode, so we need to create the fragment.
            Log.d(TAG, "onCreate(): in portrait mode; replacing fragments");
            RecipeInfoFragment recipeInfoFragment = new RecipeInfoFragment();
            Log.d(TAG, "onCreate(): recipeInfoFragment: " + recipeInfoFragment);
            recipeInfoFragment.setArguments(getIntent().getExtras());

            // Display the fragment as the main content.
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportFragmentManager().beginTransaction().replace(
                    android.R.id.content, recipeInfoFragment).commit();
        } catch (Exception e) {
            Log.d(TAG, "onCreate(): " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Handle the back button.
     *
     * @param item the menu item selected
     * @return true if the back button was selected; otherwise, false
     */
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
