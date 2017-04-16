/*Neil Opena
 * 110878452
 * CSE 114
 * Homework #5
 */
public class TestRecipeBook {

	public static void main(String[] args) {
		// Ingredients
		// testIngredients();

		// RecipeIngredients
		// testRecipeIngredients();

		// CookingRecipe
		testCookingRecipe();
		//testCookingRecipe2();
		
		// RecipeBook
		//testRecipeBook();
	}

	public static void testIngredients() {
		Ingredient apple = new Ingredient("Apples", "grams", 10);
		Ingredient banana = new Ingredient("Bananas", "grams", 15);
		Ingredient appleTest = new Ingredient("Apples", "grams", 10);

		System.out.println(apple + "\n");
		System.out.println(banana + "\n");
		System.out.println(appleTest + "\n");

		System.out.println(apple.getName());
		System.out.println(apple.getMeasuringUnit());
		System.out.println(apple.getCaloriesPerUnit());

		System.out.println("\n" + apple.equals(banana));
		System.out.println(apple.equals(appleTest));
	}

	public static void testRecipeIngredients() {
		RecipeIngredient flour = new RecipeIngredient("Flour", "cups", 20, 2);
		RecipeIngredient sugar = new RecipeIngredient("Sugar", "cups", 35, 1.25f);
		RecipeIngredient flourTest = new RecipeIngredient("Flour", "cups", 20, 3);

		System.out.println(flour + "\n");
		System.out.println(sugar + "\n");

		System.out.println(flour.getName());
		System.out.println(flour.getMeasuringUnit());
		System.out.println(flour.getCaloriesPerUnit());
		System.out.println(flour.getQuantity());

		System.out.println("\n" + flour.equals(sugar));
		System.out.println(flour.equals(flourTest));
		flourTest.setQuantity(2);
		System.out.println(flour.equals(flourTest));

		Ingredient flourTestTwo = new Ingredient("Flour", "cups", 20);
		System.out.println("\n" + flour.equals(flourTestTwo));
	}

	public static void testCookingRecipe() {
		RecipeIngredient bakingSoda = new RecipeIngredient("Baking Soda", "teaspoons", 12, 2);
		RecipeIngredient cinnamon = new RecipeIngredient("Cinnamon", "teaspoons", 17, 2);
		RecipeIngredient apple = new RecipeIngredient("Apples", "slices", 7, 9);
		RecipeIngredient flour = new RecipeIngredient("Flour", "cups", 20, 2);
		RecipeIngredient sugar = new RecipeIngredient("Sugar", "cups", 35, 1.25f);

		CookingRecipe muffinRecipe = new CookingRecipe("Muffin Recipe");
		muffinRecipe.addOrUpdateRecipeIngredient(bakingSoda, 0);
		muffinRecipe.addOrUpdateRecipeIngredient(sugar, 0);
		muffinRecipe.addOrUpdateRecipeIngredient(bakingSoda, 1);
		muffinRecipe.addOrUpdateRecipeIngredient(sugar, 1);
		muffinRecipe.addOrUpdateRecipeIngredient(flour, 1);

		// System.out.println("\n" + muffinRecipe.getName());
		Ingredient banana = new Ingredient("Banana", "slices", 1);
		// System.out.println(muffinRecipe.getRecipeIngredient(banana));
		// System.out.println(muffinRecipe.getRecipeIngredient(bakingSoda).getName());
		// System.out.println(muffinRecipe.getRecipeIngredient("Sugar").getName());

		// System.out.println();
		muffinRecipe.addOrUpdateRecipeIngredient(banana, 0);
		muffinRecipe.addOrUpdateRecipeIngredient(banana, 1);
		muffinRecipe.addOrUpdateRecipeIngredient(apple, 1);
		// System.out.println(muffinRecipe.calculateCalories());
		muffinRecipe.removeRecipeIngredient(banana);
		// System.out.println(muffinRecipe.calculateCalories());
		muffinRecipe.removeRecipeIngredient(apple);
		System.out.println(muffinRecipe);
		System.out.println(muffinRecipe.getNumberOfIngredients());
		// System.out.println(muffinRecipe.getRecipeIngredient(apple));
		System.out.println(muffinRecipe.calculateCalories());

		CookingRecipe test = new CookingRecipe("Muffin Recipe");
		System.out.println();

		test.addOrUpdateRecipeIngredient(banana, 1);
		test.addOrUpdateRecipeIngredient(sugar, 1);
		test.addOrUpdateRecipeIngredient(flour, 1);
		System.out.println(muffinRecipe.equals(test));
		test.removeRecipeIngredient(banana);
		test.addOrUpdateRecipeIngredient(bakingSoda, 1);
		System.out.println(test.equals(muffinRecipe));

		System.out.println("\n" + test);
		System.out.println(test.getNumberOfIngredients());
		System.out.println(test.calculateCalories());

	}
	
	public static void testCookingRecipe2(){
		CookingRecipe a = new CookingRecipe("A");
		a.addOrUpdateRecipeIngredient(new Ingredient("Apple","slices",0), 0);
		a.addOrUpdateRecipeIngredient(new Ingredient("Banana","slices",0), 0);
		System.out.println(a);
		
		CookingRecipe b = new CookingRecipe("A");
		b.addOrUpdateRecipeIngredient(new Ingredient("Banana","slices",0), 11);
		b.addOrUpdateRecipeIngredient(new Ingredient("Apple","slices",0), 11);
		b.addOrUpdateRecipeIngredient(new Ingredient("Banana","slices",0), 0);
		b.addOrUpdateRecipeIngredient(new Ingredient("Apple","slices",0), 0);

		
		System.out.println();
		System.out.println(b);
		
		System.out.println();
		System.out.println(a.equals(b));
		
		
	}

	public static void testRecipeBook() {
		RecipeIngredient bakingSoda = new RecipeIngredient("Baking Soda", "teaspoons", 12, 2);
		RecipeIngredient cinnamon = new RecipeIngredient("Cinnamon", "teaspoons", 17, 2);
		RecipeIngredient apple = new RecipeIngredient("Apples", "slices", 7, 9);
		RecipeIngredient flour = new RecipeIngredient("Flour", "cups", 20, 2);
		RecipeIngredient sugar = new RecipeIngredient("Sugar", "cups", 35, 1.25f);
		RecipeIngredient banana = new RecipeIngredient("Bananas", "slices", 12, 1);
		RecipeIngredient nuts = new RecipeIngredient("Nuts", "grams", 19, 1);

		CookingRecipe one = new CookingRecipe("ONE");
		one.addOrUpdateRecipeIngredient(bakingSoda, 1);
		one.addOrUpdateRecipeIngredient(cinnamon, 1);
		one.addOrUpdateRecipeIngredient(apple, 1);
		one.addOrUpdateRecipeIngredient(flour, 1);
		one.addOrUpdateRecipeIngredient(sugar, 1);

		CookingRecipe two = new CookingRecipe("TWO");
		two.addOrUpdateRecipeIngredient(apple, 1);
		two.addOrUpdateRecipeIngredient(bakingSoda, 1);
		two.addOrUpdateRecipeIngredient(cinnamon, 1);
		two.addOrUpdateRecipeIngredient(flour, 1);
		two.addOrUpdateRecipeIngredient(sugar, 1);
		two.addOrUpdateRecipeIngredient(banana, 0);
		
		CookingRecipe three = new CookingRecipe("THREE");
		three.addOrUpdateRecipeIngredient(bakingSoda, 1);
		three.addOrUpdateRecipeIngredient(cinnamon, 1);
		three.addOrUpdateRecipeIngredient(apple, 1);
		three.addOrUpdateRecipeIngredient(flour, 1);
		three.addOrUpdateRecipeIngredient(sugar, 0);

		RecipeBook bookOne = new RecipeBook("Book One");
		bookOne.addRecipe(one.getName(), one.getRecipe());
		bookOne.addRecipe(two.getName(), two.getRecipe());
		bookOne.addRecipe(three.getName(), three.getRecipe());
		// bookOne.removeRecipe(two.getName());
		// bookOne.removeRecipe("ONE");
		System.out.println(bookOne);
		System.out.println("Number of Recipes: " + bookOne.getRecipeBook().length + "\n");

		RecipeIngredient[] list = { bakingSoda, cinnamon,nuts };
		System.out.print("Number of recipes in book that satisfy list: ");
		try {
			System.out.println(bookOne.findRecipes(list).length);
		} catch (Exception ex) {
			System.out.println(bookOne.findRecipes(list));
		}
		
		System.out.println("\nONE num ingredients: " + bookOne.get(0).getNumberOfIngredients());
		System.out.println("TWO num ingredients: " + bookOne.get(1).getNumberOfIngredients());
		System.out.println("THREE num ingredients: " + bookOne.get(2).getNumberOfIngredients());
		
		int num = 7;
		try{
		System.out.println(bookOne.findRecipesWithFewIngredients(num).length);
		}catch (Exception ex){
			System.out.println(bookOne.findRecipesWithFewIngredients(num));
		}
		System.out.println("\nONE calories: " + bookOne.get(0).calculateCalories());
		System.out.println("TWO calories: " + bookOne.get(1).calculateCalories());
		System.out.println("THREE calories: " + bookOne.getRecipeBook()[2].calculateCalories());
		System.out.println(bookOne.findRecipesLowCalories().length);
		
		RecipeBook bookTwo = new RecipeBook("Book One");
		System.out.println(bookOne);
		
		System.out.println("=============================================");
		bookTwo.addRecipe(two.getName(), two.getRecipe());
		bookTwo.addRecipe(three.getName(), three.getRecipe());
		bookTwo.addRecipe(one.getName(), one.getRecipe());
		//bookTwo.addRecipe(" ", one.getRecipe());
		bookTwo.get(2).addOrUpdateRecipeIngredient(sugar, 999);
		//bookTwo.get(2).addOrUpdateRecipeIngredient(sugar,1);
		
		System.out.println(bookTwo);
		System.out.println("\n" + bookOne.equals(bookTwo));
		
	}

}
