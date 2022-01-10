package cycle4;

import util.Testable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Components extends Testable {

    public Components(String filePath) {
        super(filePath);
    }

    @Override
    public void test() throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(inputFilePath));

        int recipes = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < recipes; i++) {
            Scanner recipeLine = new Scanner(scanner.nextLine());
            Recipe r = new Recipe(recipeLine.next());
            recipeLine.next();
            while(recipeLine.hasNext()){
                r.addItem(recipeLine.next());
            }
        }

        int toCraftCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < toCraftCount; i++) {
            println(Recipe.recipes.get(scanner.nextLine()).craft());
        }
    }

    private static class Recipe{

        /**
         * The collection of recipes
         */
        public static final HashMap<String, Recipe> recipes = new HashMap<>();

        /**
         * The recipe of the item
         */
        protected HashMap<String, Integer> recipe;

        /**
         * Name of the item
         */
        protected String name;

        public Recipe(String name) {
            this.name = name;
            recipes.put(name, this);
            recipe = new HashMap<>();
        }

        /**Adds an item to the recipe
         *
         * @param item Item to add to the recipe
         */
        public void addItem(String item){
            recipe.putIfAbsent(item, 0);
            recipe.put(item, recipe.get(item) + 1);
        }

        /**Recursively creates the recipe
         *
         * @return A String of the components needed for the item
         */
        public String craft(){

            StringBuilder sb = new StringBuilder();
            HashMap<String, Integer> finalRecipe = new HashMap<>();

            craft(finalRecipe);

            List<String> compenents = finalRecipe.keySet().stream().sorted().toList();

            compenents.forEach(c -> {
                sb.append(c).append(" ").append(finalRecipe.get(c)).append("\n");
            });
            sb.append("***");

            return sb.toString();
        }

        /**Adds the items in its recipe crafts each component
         *
         * @param currentRecipe The current recipe being crafted
         * @return The current recipe being crafted
         */
        public HashMap<String, Integer> craft(HashMap<String, Integer> currentRecipe){

            for (String s : recipe.keySet()) {
                Recipe r = recipes.get(s);
                if(r == null){
                    r = new RecipeRoot(s);
                }
            }

            for (String s : recipe.keySet()) {
                Recipe r = recipes.get(s);
                for(int i = 0; i < recipe.get(s); i++) {
                    r.craft(currentRecipe);
                }
            }
            return currentRecipe;
        }
    }

    private static final class RecipeRoot extends Recipe{

        public RecipeRoot(String name) {
            super(name);
        }

        /**Adds the root ingredient to the recipe
         *
         * @param currentRecipe The current recipe being crafted
         * @return The currentRecipe being crafted
         */
        @Override
        public HashMap<String, Integer> craft(HashMap<String, Integer> currentRecipe) {
            currentRecipe.putIfAbsent(name, 0);
            currentRecipe.put(name, currentRecipe.get(name) + 1);
            return currentRecipe;
        }
    }
}