/*Neil Opena
 * 110878452
 * CSE 114
 * Homework #5
 */
public class CookingRecipe {
	// contains multiple RecipeIngredient(s)
	//FINISHED
	private String name;
	private RecipeIngredient[] recipe = new RecipeIngredient[1];

	public CookingRecipe(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void addOrUpdateRecipeIngredient(Ingredient ingredient, float quantity) {
		if (recipe[0] == null) {
			add(ingredient,quantity);
		} else {
			if (getRecipeIngredient(ingredient) != null) {
				getRecipeIngredient(ingredient).setQuantity(quantity);
			} else {
				extend();
				add(ingredient, quantity);
			}
		}
	}

	
	public RecipeIngredient getRecipeIngredient(Ingredient ingredient) {
		if (ingredient instanceof RecipeIngredient){
			Ingredient temp = new Ingredient(ingredient.getName(),ingredient.getMeasuringUnit(),ingredient.getCaloriesPerUnit());
			for (int i = 0; i < recipe.length; i++) {
				if (recipe[i].equals(temp)) {
					return recipe[i];
				}
			}
			return null;
		}
		for (int i = 0; i < recipe.length; i++) {
			if (recipe[i].equals(ingredient)) {
				return recipe[i];
			}
		}
		return null;
	}

	public RecipeIngredient getRecipeIngredient(String ingredientName) {
		for (int i = 0; i < recipe.length; i++) {
			if (recipe[i].getName().equals(ingredientName)) {
				return recipe[i];
			}
		}
		return null;
	}

	public RecipeIngredient removeRecipeIngredient(Ingredient ingredient) {
		if (getRecipeIngredient(ingredient) != null) {
			RecipeIngredient temp = getRecipeIngredient(ingredient);
			// remove here
			deleteFromRecipe(temp);
			removeNull();
			return temp;
		}
		return null;
	}

	public RecipeIngredient removeRecipeIngredient(String ingredientName) {
		if (getRecipeIngredient(ingredientName) != null) {
			RecipeIngredient temp = getRecipeIngredient(ingredientName);
			// remove here
			deleteFromRecipe(temp);
			removeNull();
			return temp;
		}
		return null;
	}

	public float calculateCalories() {
		float total = 0;
		for (int i = 0; i < recipe.length; i++) {
			total += (recipe[i].getQuantity() * recipe[i].getCaloriesPerUnit());
		}
		return total;
	}

	public int getNumberOfIngredients() {
		return recipe.length;
	}

	public String toString() {
		String temp = "Recipe Name: " + name + " Ingredients:";
		for (int i = 0; i < recipe.length; i++) {
			temp = temp + recipe[i].getName() + ", ";
		}
		return temp;
	}
	
	public RecipeIngredient get(int index){
		return recipe[index];
	}

	public boolean equals(Object test){
		if(test instanceof CookingRecipe){
			if(((CookingRecipe) test).getNumberOfIngredients() != this.getNumberOfIngredients()){
				return false;
			}else if(!((CookingRecipe) test).getName().equals(this.getName())){
				return false;
			}
			for(int i = 0; i < recipe.length; i++){
				if(!((CookingRecipe) test).get(i).equals(recipe[i])){
					return false;
				}
			}
			
			return true;
		}
		return false;
	}

	private void extend() {
		RecipeIngredient[] temp = new RecipeIngredient[recipe.length + 1]; // add
																			// one
																			// to
																			// recipe
		for (int i = 0; i < recipe.length; i++) {
			temp[i] = recipe[i];
		}
		recipe = temp; // change identifier of array
	}

	private void add(Ingredient ingredient, float quantity) {
		RecipeIngredient temp = new RecipeIngredient(ingredient.getName(), ingredient.getMeasuringUnit(),
				ingredient.getCaloriesPerUnit(), quantity);
		recipe[recipe.length - 1] = temp;
	}

	private void deleteFromRecipe(RecipeIngredient ingredient) {
		for (int i = 0; i < recipe.length; i++) {
			if (recipe[i].equals(ingredient)) {
				recipe[i] = null;
			}
		}
	}

	private void removeNull() {
		int counter = 0;
		for (int i = 0; i < recipe.length; i++) {
			if (recipe[i] == (null)) {
				counter++;
			}
		}
		RecipeIngredient[] temp = new RecipeIngredient[recipe.length - counter];
		for (int i = 0, j = 0; i < recipe.length; i++) {
			if (recipe[i] != null) {
				temp[j] = recipe[i];
				j++;
			}
		}

		recipe = temp; // change identifier of array
	}
}
