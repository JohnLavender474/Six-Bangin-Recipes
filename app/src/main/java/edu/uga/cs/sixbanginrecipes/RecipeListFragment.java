package edu.uga.cs.sixbanginrecipes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

/**
 * The fragment for the list of recipes. This fragment displays a list of recipes and allows the
 * user to select a recipe to view its details.
 */
public class RecipeListFragment extends ListFragment {

    private static final String TAG = "RecipeListFragment";

    private boolean twoFragmentsActivity;
    private int recipeIndex;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the fragment (e.g. upon
     * screen orientation changes).
     */
    public RecipeListFragment() {
        twoFragmentsActivity = false;
        recipeIndex = 0;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        try {
            super.onViewCreated(view, savedInstanceState);

            Log.d(TAG, "onActivityCreated(): savedInstanceState: " + savedInstanceState);

            // Sets a list of foods to the list view
            String[] foods = getResources().getStringArray(R.array.foods);
            setListAdapter(
                    new ArrayAdapter<>(
                            getActivity(),
                            android.R.layout.simple_list_item_activated_1,
                            foods
                    ));

            View detailsFrame = getActivity().findViewById(R.id.recipeInfo);
            Log.d(TAG, "onActivityCreated(): detailsFrame: " + detailsFrame);
            twoFragmentsActivity = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

            if (savedInstanceState != null) {
                recipeIndex = savedInstanceState.getInt("recipeIndex", 0);
                Log.d(TAG, "onActivityCreated(): restored versionIndex: " + recipeIndex);
            }

            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            getListView().setItemChecked(recipeIndex, true);

            if (twoFragmentsActivity) {
                showRecipeInfo(recipeIndex);
                getListView().smoothScrollToPosition(recipeIndex);
            }
        } catch (Exception e) {
            Log.d(TAG, "onViewCreated(): Exception: " + e);
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Handle a click on a recipe in the list.
     *
     * @param l        The ListView where the click happened
     * @param v        The view that was clicked within the ListView
     * @param position The position of the view in the list
     * @param id       The row id of the item that was clicked
     */
    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        try {
            showRecipeInfo(position);
        } catch (Exception e) {
            Log.d(TAG, "onListItemClick(): Exception: " + e);
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Save the current state of this fragment.
     *
     * @param outState Bundle in which to place your saved state.
     */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        try {
            super.onSaveInstanceState(outState);
            outState.putInt("recipeIndex", recipeIndex);
            Log.d(TAG, "onSaveInstanceState(): saved recipeIndex: " + recipeIndex);
        } catch (Exception e) {
            Log.d(TAG, "onSaveInstanceState(): Exception: " + e);
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Show the recipe info fragment.
     *
     * @param recipeIndex the index of the recipe to show
     */
    void showRecipeInfo(int recipeIndex) {
        this.recipeIndex = recipeIndex;

        if (twoFragmentsActivity) {
            getListView().setItemChecked(recipeIndex, true);
            RecipeInfoFragment details = (RecipeInfoFragment)
                    getParentFragmentManager().findFragmentById(R.id.recipeInfo);

            Log.d(TAG, "showAndroidVersionInfo(): details: " + details);

            if (details == null || details.getRecipeIndex() != recipeIndex) {
                details = RecipeInfoFragment.newInstance(recipeIndex);
                FragmentTransaction fragmentTransaction = getParentFragmentManager()
                        .beginTransaction();
                fragmentTransaction.replace(R.id.recipeInfo, details);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.commit();
            }
        } else {
            Intent intent = new Intent();
            intent.setClass(getActivity(), RecipeInfoActivity.class);
            intent.putExtra("recipeIndex", recipeIndex);

            startActivity(intent);
        }
    }

}
