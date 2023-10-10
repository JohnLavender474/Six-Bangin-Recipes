package edu.uga.cs.sixbanginrecipes.recipes;

import edu.uga.cs.sixbanginrecipes.R;

public enum RecipeFile {
    SPICY_SPAGHETTI(R.raw.spicy_spaghetti, R.drawable.spicy_spaghetti),
    PORK_GRAVY(R.raw.pork_gravy, R.drawable.pork_gravy),
    BEEF_BIRYANI(R.raw.beef_biryani, R.drawable.beef_biryani),
    CHEESY_PASTA(R.raw.cheesy_pasta, R.drawable.cheesy_pasta),
    MEAT_LOAF(R.raw.meat_loaf, R.drawable.meat_loaf),
    MAC_N_CHEESE(R.raw.mac_n_cheese, R.drawable.mac_n_cheese);

    private final int file;
    private final int image;

    RecipeFile(int file, int image) {
        this.file = file;
        this.image = image;
    }

    public int getFile() {
        return file;
    }

    public int getImage() {
        return image;
    }
}