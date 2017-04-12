/*Neil Opena
 * 110878452
 * CSE 114
 * Homework #5
 */
public class Ingredient {
	// FINISHED
	private String name;
	private String measuringUnit;
	private int caloriesPerUnit;

	public Ingredient(String name, String measuringUnit, int caloriesPerUnit) {
		this.name = name;
		this.measuringUnit = measuringUnit;
		this.caloriesPerUnit = caloriesPerUnit;
	}

	public String getName() {
		return this.name;
	}

	public String getMeasuringUnit() {
		return this.measuringUnit;
	}

	public int getCaloriesPerUnit() {
		return this.caloriesPerUnit;
	}

	public String toString() {
		return "Name: " + name + " MeasuringUnit: " + measuringUnit + " CaloriesPerUnit: " + caloriesPerUnit;

	}

	public boolean equals(Object test) {
		if (test instanceof Ingredient) {
			Ingredient ingredient = (Ingredient) test;
			if ((ingredient.getName().equals(name)) && (ingredient.getMeasuringUnit().equals(measuringUnit))
					&& (ingredient.getCaloriesPerUnit() == caloriesPerUnit)) {
				return true;
			}
		}
		return false;

	}

}
