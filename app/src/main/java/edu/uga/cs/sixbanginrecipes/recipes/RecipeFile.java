package edu.uga.cs.sixbanginrecipes.recipes;

import edu.uga.cs.sixbanginrecipes.R;

public enum RecipeFile {
    SPICY_SPAGHETTI(R.raw.spicy_spaghetti),
    PORK_GRAVY(R.raw.pork_gravy),
    BEEF_BIRYANI(R.raw.beef_biryani),
    CHEESY_PASTA(R.raw.cheesy_pasta),
    MEAT_LOAF(R.raw.meat_loaf),
    MAC_N_CHEESE(R.raw.mac_n_cheese);

    private final int file;

    RecipeFile(int file) {
        this.file = file;
    }

    public int getFile() {
        return file;
    }
}