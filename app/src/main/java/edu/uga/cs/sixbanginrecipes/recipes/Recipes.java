package edu.uga.cs.sixbanginrecipes.recipes;

import android.content.res.Resources;
import android.util.Log;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recipes {

    private static final String TAG = "Recipes";

    private static List<Recipe> recipes;

    public static void initialize(Resources resources) {
        recipes = new ArrayList<>();

        Gson gson = new Gson();
        for (RecipeFile recipeFile : RecipeFile.values()) {
            final InputStream stream = resources.openRawResource(recipeFile.getFile());

            try (stream) {
                InputStreamReader reader = new InputStreamReader(stream);
                Recipe recipe = gson.fromJson(reader, Recipe.class);

                Log.d(TAG, "initialize(): Adding recipe to recipe list: " + recipe);

                recipes.add(recipe);
            } catch (Exception e) {
                Log.d(TAG, "initialize(): Error reading recipe file: " +
                        recipeFile.getFile());
                e.printStackTrace();
            }
        }
    }

    public static List<Recipe> get() {
        if (recipes == null) {
            throw new RuntimeException("Recipes not initialized");
        }
        return Collections.unmodifiableList(recipes);
    }

}
