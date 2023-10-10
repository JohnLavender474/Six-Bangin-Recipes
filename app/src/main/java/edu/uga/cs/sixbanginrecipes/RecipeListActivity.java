package edu.uga.cs.sixbanginrecipes;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import edu.uga.cs.sixbanginrecipes.recipes.Recipes;

/**
 * The activity for the list of recipes. This activity displays a list of recipes and allows the
 * user to select a recipe to view its details.
 */
public class RecipeListActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Log.d(TAG, "Calling onCreate()");
            Recipes.initialize(getResources());
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_six_bangin_recipes_main);
        } catch (Exception e) {
            Log.d(TAG, "onCreate(): " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
