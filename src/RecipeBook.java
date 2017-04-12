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

	public CookingRecipe addRecipe(String name, RecipeIngredient[] ingredients) {
		if(recipeBook[0] == null){
			add(name,ingredients);
		} //FIXME
		return null;
	}

	// FIXME methods below
	public String toString() {
		return "Book Name: " + bookName;
	}

	public boolean equals(Object test) {
		return true;
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
			temp[i] = recipeBook[i];
		}
		recipeBook = temp;
	}
}
