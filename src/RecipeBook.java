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

	public CookingRecipe[] findRecipes(RecipeIngredient[] ingredients) {
		int num = 0;
		for(CookingRecipe recipe: recipeBook){
			if(recipe.getNumberOfIngredients() >= ingredients.length){
				boolean allFound = true;
				for(RecipeIngredient ing : ingredients){
					if(recipe.getRecipeIngredient(ing) == null){
						allFound = false;
					}
				}
				if(allFound){
					num++;
				}
			}
		}
		if(num == 0){
			return null;
		}
		CookingRecipe[] temp = new CookingRecipe[num];
		
		for(int i = 0, j = 0; i < recipeBook.length; i++){
			if(recipeBook[i].getNumberOfIngredients() >= ingredients.length){
				boolean allFound = true;
				for(int k = 0; k < ingredients.length; k++){
					if(recipeBook[i].getRecipeIngredient(ingredients[k]) == null){
						allFound = false;
					}
				}
				
				if(allFound){
					temp[j] = recipeBook[i];
					j++;
				}
			}
		}
		return temp;
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

	public String toString() {
		String temp = "RecipeBook\nbookName=" + bookName;
		if (get(0) == null) {
			temp = temp + "\n[\n" + get(0);
		} else {
			temp = temp + "\n[";
			for (int i = 0; i < recipeBook.length; i++) {
				temp = temp + "\n" + get(i);
			}
		}
		return temp + "\n]";
	}

	//oder of cooking recipes does not matter
	public boolean equals(Object test) {
		if(test instanceof RecipeBook){
			if(((RecipeBook)test).getBookName().equals(this.bookName)){
				if(((RecipeBook) test).getRecipeBook().length == recipeBook.length){
					for(int i = 0; i < recipeBook.length; i++){
						//iterate through each recipe in recipeBook
						boolean found = false;
						for(int j = 0; j < ((RecipeBook) test).getRecipeBook().length; j++){
							//iterate through reach recipe in test.getRecipeBook()
							if(recipeBook[i].equals(((RecipeBook) test).getRecipeBook()[j])){
								found = true;
								//if one of the recipes are equal: found = true
							}
						}
						if(!found){
							return false;
						}
					}
					return true; //all recipes are found
				}
			}
		}
		return false;
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
