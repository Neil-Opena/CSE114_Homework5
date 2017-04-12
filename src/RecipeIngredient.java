/*Neil Opena
 * 110878452
 * CSE 114
 * Homework #5
 */
public class RecipeIngredient extends Ingredient {
	//FINISHED
	private float quantity;

	public RecipeIngredient(String name, String measuringUnit, int caloriesPerUnit, float quantity) {
		super(name, measuringUnit, caloriesPerUnit);
		this.quantity = quantity;
	}

	public float getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(float quantity){
		this.quantity = quantity;
	}
	//FIXME look at PIAZZA
	public String toString() {
		return super.toString() + " Quantity: " + quantity;
	}

	public boolean equals(Object test) {
		if(test instanceof RecipeIngredient){
			RecipeIngredient ingredient = (RecipeIngredient) test;
			if(ingredient.getName().equals(this.getName()) && (ingredient.getMeasuringUnit().equals(this.getMeasuringUnit())) && (ingredient.getCaloriesPerUnit() == this.getCaloriesPerUnit()) && (ingredient.getQuantity() == this.getQuantity())){
				return true;
			}
		}else if(test instanceof Ingredient){
			Ingredient temp = (Ingredient) test;
			if(super.equals(temp)){
				return true;
			}
		}
		return false;
	}

}
