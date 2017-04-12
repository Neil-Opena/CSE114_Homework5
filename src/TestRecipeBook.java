/*Neil Opena
 * 110878452
 * CSE 114
 * Homework #5
 */
public class TestRecipeBook {
	
	public static void main(String[] args){
		System.out.println("Testing:");
		System.out.println("_____________________________________________________________");
		Ingredient apples = new Ingredient("Apple","Slices",100);
		System.out.println(apples);
		Ingredient Apples = new Ingredient("Apple","Slices",100);
		System.out.println(Apples);
		System.out.println("apples.equals(Apples): "+ apples.equals(Apples)); //true
		Integer one = new Integer(1);
		System.out.println("apples.equals(one): " +apples.equals(one)); //false
		System.out.println("_____________________________________________________________");
		RecipeIngredient apple1 = new RecipeIngredient("Apple","Slices",100,8.0f);
		System.out.println(apple1);
		RecipeIngredient apple2 = new RecipeIngredient("Apple","Slices",100,8.0f);
		System.out.println(apple2);
		System.out.println("apple1.equals(apple2): "+ apple1.equals(apple2)); //true
		System.out.println("apple1.equals(Apples): "+ apple1.equals(Apples)); //false
		System.out.println("_____________________________________________________________");
		Ingredient banana = new Ingredient("Banana","Slices",101);
		Ingredient icecream = new Ingredient("Ice Cream","Scoops",250);
		CookingRecipe bananaSplit = new CookingRecipe("Banana Split");
		bananaSplit.addOrUpdateRecipeIngredient(banana, 420);
		bananaSplit.addOrUpdateRecipeIngredient(icecream, 420);
		Ingredient nuts = new Ingredient("Nuts","Grams",100);
		bananaSplit.addOrUpdateRecipeIngredient(nuts, 420);
		bananaSplit.addOrUpdateRecipeIngredient(nuts, 69);
		System.out.println(bananaSplit + "\n");
		System.out.println("BanaSplit: ");
		for(int i = 0; i < bananaSplit.getNumberOfIngredients(); i++){
			System.out.println(bananaSplit.getRecipeIngredient(bananaSplit.get(i)));
		}
		System.out.println("Total Calories: " + bananaSplit.calculateCalories());
		CookingRecipe second = new CookingRecipe("Banana Split");
		second.addOrUpdateRecipeIngredient(banana, 420);
		second.addOrUpdateRecipeIngredient(icecream, 420);
		second.addOrUpdateRecipeIngredient(nuts, 69);
		System.out.println(second.equals(bananaSplit));
		System.out.println("_____________________________________________________________");
		RecipeBook book1 = new RecipeBook("My Recipe Book");
		System.out.println("Added: " + book1.addRecipe("Banana Split",bananaSplit.getRecipe()));
		System.out.println("Added: " + book1.addRecipe(second.getName() + " test", second.getRecipe()));
		System.out.println(book1);
		
		System.out.println("\n" + "Low Calories:");
		for(int i = 0; i < book1.findRecipesLowCalories().length; i++){
			System.out.println(book1.findRecipesLowCalories()[i]);
		}
		
		System.out.println("\n" + "Few Ingredients:");
		for(int i = 0; i < book1.findRecipesWithFewIngredients(5).length; i++){
			System.out.println(book1.findRecipesWithFewIngredients(5)[i]);
		}
	}
	
}
