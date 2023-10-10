package edu.uga.cs.sixbanginrecipes;

import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import edu.uga.cs.sixbanginrecipes.recipes.Recipe;
import edu.uga.cs.sixbanginrecipes.recipes.Recipes;

/**
 * The fragment for the details of a recipe. This fragment displays the details of a recipe.
 * This fragment is used in the two-pane layout for tablets and the one-pane layout for phones.
 */
public class RecipeInfoFragment extends Fragment {

    private static final String TAG = "RecipeInfoFragment";

    public RecipeInfoFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given recipe index.
     *
     * @param recipeIndex the index of the recipe to display
     * @return a new instance of this fragment for the given recipe index
     */
    public static RecipeInfoFragment newInstance(int recipeIndex) {
        try {
            Log.d(TAG, "newInstance(): recipeIndex: " + recipeIndex);

            // Create a new fragment instance
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

    /**
     * Called to have the fragment instantiate its user interface view. This is optional, and
     *
     * @param inflater           The LayoutInflater object that can be used to inflate
     *                           any views in the fragment,
     * @param container          If non-null, this is the parent view that the fragment's
     *                           UI should be attached to.  The fragment should not add the view itself,
     *                           but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     *                           from a previous saved state as given here.
     * @return Return the View for the fragment's UI, or null.
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        try {
            Log.d(TAG, "onCreateView()");

            Recipe recipe = Recipes.get().get(getRecipeIndex());
            assert recipe != null;
            int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                    12, getActivity().getResources().getDisplayMetrics());

            ScrollView scroller = new ScrollView(getActivity());
            LinearLayout layout = new LinearLayout(getActivity());
            layout.setOrientation(LinearLayout.VERTICAL);

            ImageView imageView = new ImageView(getActivity());
            imageView.setPadding(padding, padding, padding, padding);
            imageView.setMaxHeight(300);
            imageView.setMaxWidth(300);
            imageView.setImageResource(recipe.getImage());
            layout.addView(imageView);

            TextView textView = new TextView(getActivity());
            textView.setPadding(padding, padding, padding, padding);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            textView.setText(recipe.toString());
            layout.addView(textView);

            scroller.addView(layout);
            return scroller;
        } catch (Exception e) {
            Log.d(TAG, "onCreateView(): " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Returns the index of the recipe to display.
     *
     * @return the index of the recipe to display
     */
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
