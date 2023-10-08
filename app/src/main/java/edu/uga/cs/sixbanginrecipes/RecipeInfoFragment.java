package edu.uga.cs.sixbanginrecipes;

import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import edu.uga.cs.sixbanginrecipes.recipes.Recipe;
import edu.uga.cs.sixbanginrecipes.recipes.Recipes;

public class RecipeInfoFragment extends Fragment {

    private static final String TAG = "RecipeInfoFragment";

    public RecipeInfoFragment() {}

    public static RecipeInfoFragment newInstance(int recipeIndex) {
        try {
            Log.d(TAG, "newInstance(): recipeIndex: " + recipeIndex);

            RecipeInfoFragment fragment = new RecipeInfoFragment();
            Log.d(TAG, "newInstance(): fragment: " + fragment);

            Bundle args = new Bundle();
            args.putInt("recipeIndex", recipeIndex);
            fragment.setArguments(args);

            return fragment;
        } catch (Exception e) {
            Log.d(TAG, "newInstance(): " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        try {
            Log.d(TAG, "onCreateView()");

            ScrollView scroller = new ScrollView(getActivity());
            TextView textView = new TextView(getActivity());
            scroller.addView(textView);

            int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                    12, getActivity().getResources().getDisplayMetrics());

            textView.setPadding(padding, padding, padding, padding);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            Recipe recipe = Recipes.get().get(getRecipeIndex());
            assert recipe != null;
            textView.setText(recipe.toString());

            return scroller;
        } catch (Exception e) {
            Log.d(TAG, "onCreateView(): " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public int getRecipeIndex() {
        try {
            if (getArguments() == null) {
                throw new RuntimeException("getArguments() is null");
            }
            return getArguments().getInt("recipeIndex", 0);
        } catch (Exception e) {
            Log.d(TAG, "getRecipeIndex(): " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
