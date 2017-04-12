/*Neil Opena
 * 110878452
 * CSE 114
 * Homework #5
 */
public class RecipeBook {
	// will contain multiple CookingRecipes
	private String bookName;
	private CookingRecipe[] recipeBook = new CookingRecipe[1];

	public RecipeBook(String bookName) {
		this.bookName = bookName;
	}

	public String getBookName() {
		return bookName;
	}

	public CookingRecipe[] getRecipeBook() {
		return recipeBook;
	}

	public CookingRecipe addRecipe(String name, RecipeIngredient[] ingredients) {
		if (recipeBook[0] == null) {
			add(name, ingredients);
			return get(0);
		} else {
			for (int i = 0; i < recipeBook.length; i++) {
				if (get(i).getName().equals(name)) {
					return null; // contains the same name
				}
			}
			extend();
			add(name, ingredients);
			return get(recipeBook.length - 1);
		}

	}

	public CookingRecipe removeRecipe(String name) {
		for (int i = 0; i < recipeBook.length; i++) {
			if (get(i).getName().equals(name)) {
				return deleteFromBook(i);
			}
		}
		return null;
	}

	public CookingRecipe[] findRecipes(RecipeIngredient[] ingredient) {
		int num = 0;
		// FIXME
		CookingRecipe[] temp = new CookingRecipe[num];
		return null;
	}

	public CookingRecipe[] findRecipesWithFewIngredients(int numberOfIngredients) {
		int num = 0;
		for (int i = 0; i < recipeBook.length; i++) {
			if (get(i).getNumberOfIngredients() < numberOfIngredients) {
				num++;
			}
		}
		if (num == 0) {
			return null;
		}
		CookingRecipe[] temp = new CookingRecipe[num];
		for (int i = 0, j = 0; i < recipeBook.length; i++) {
			if (get(i).getNumberOfIngredients() < numberOfIngredients) {
				temp[j] = get(i);
				j++;
			}
		}
		return temp;
	}

	public CookingRecipe[] findRecipesLowCalories() {
		int num = 0;
		float lowest = get(0).calculateCalories();

		for (int i = 0; i < recipeBook.length; i++) {
			if (get(i).calculateCalories() < lowest) {
				lowest = get(i).calculateCalories();
			}
		}
		for (int i = 0; i < recipeBook.length; i++) {
			if (get(i).calculateCalories() == lowest) {
				num++;
			}
		}

		CookingRecipe[] temp = new CookingRecipe[num];

		for (int i = 0, j = 0; i < recipeBook.length; i++) {
			if (get(i).calculateCalories() == lowest) {
				temp[j] = get(i);
				j++;
			}
		}
		return temp;
	}

	// FIXME look at PIAZZA
	public String toString() {
		String temp = "Book Name: " + bookName + " Recipes: ";
		if (get(0) == null) {
			temp = temp + get(0);
		} else {
			for (int i = 0; i < recipeBook.length; i++) {
				temp = temp + get(i).getName() + ", ";
			}
		}
		return temp;
	}

	// FIXME methods below
	public boolean equals(Object test) {
		return true;
	}

	public CookingRecipe get(int index) {
		return recipeBook[index];
	}

	private void removeNull() {
		int counter = 0;
		for (int i = 1; i < recipeBook.length; i++) {
			if (get(i) == null) {
				counter++;
			}
		}
		CookingRecipe[] temp = new CookingRecipe[recipeBook.length - counter];
		for (int i = 0, j = 0; i < recipeBook.length; i++) {
			if (get(i) != null) {
				temp[j] = get(i);
				j++;
			}
		}

		recipeBook = temp;
	}

	private CookingRecipe deleteFromBook(int index) {
		CookingRecipe temp = get(index);
		recipeBook[index] = null;
		removeNull();
		return temp;
	}

	private void add(String name, RecipeIngredient[] ingredients) {
		CookingRecipe temp = new CookingRecipe(name);
		for (int i = 0; i < ingredients.length; i++) {
			temp.addOrUpdateRecipeIngredient(ingredients[i], ingredients[i].getQuantity());
		}
		recipeBook[recipeBook.length - 1] = temp;

	}

	private void extend() {
		CookingRecipe[] temp = new CookingRecipe[recipeBook.length + 1];
		for (int i = 0; i < recipeBook.length; i++) {
			temp[i] = get(i);
		}
		recipeBook = temp;
	}

}
