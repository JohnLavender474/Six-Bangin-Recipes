package edu.uga.cs.sixbanginrecipes.recipes;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Recipe implements Serializable {

    public static String RECIPE = "Recipe";

    private String name;
    private String description;
    private String[] ingredients;
    private String[] instructions;
    private String category;

    @NonNull
    @Override
    public String toString() {
        try {
            StringBuilder builder = new StringBuilder();
            builder.append(RECIPE).append(": ").append(name).append("\n\n");
            builder.append("Description: ").append(description).append("\n\n");
            builder.append("Ingredients:\n");
            for (String ingredient : ingredients) {
                builder.append("  - ").append(ingredient).append("\n");
            }
            builder.append("\nInstructions:\n");
            for (String instruction : instructions) {
                builder.append(instruction).append("\n");
            }
            builder.append("\nCategory: ").append(category);
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public String[] getInstructions() {
        return instructions;
    }

    public void setInstructions(String[] instructions) {
        this.instructions = instructions;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
