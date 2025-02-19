import java.util.*;

// MealPlan Interface
interface MealPlan {
    String getMealType();
    List<String> getMeals();
}

// Vegetarian Meal Plan
class VegetarianMeal implements MealPlan {
    private List<String> meals = Arrays.asList("Vegetable Stir-Fry", "Lentil Soup", "Grilled Cheese Sandwich");

    @Override
    public String getMealType() {
        return "Vegetarian";
    }

    @Override
    public List<String> getMeals() {
        return meals;
    }
}

// Vegan Meal Plan
class VeganMeal implements MealPlan {
    private List<String> meals = Arrays.asList("Quinoa Salad", "Tofu Scramble", "Vegan Burrito");

    @Override
    public String getMealType() {
        return "Vegan";
    }

    @Override
    public List<String> getMeals() {
        return meals;
    }
}

// Keto Meal Plan
class KetoMeal implements MealPlan {
    private List<String> meals = Arrays.asList("Grilled Chicken", "Avocado Salad", "Egg & Cheese Omelet");

    @Override
    public String getMealType() {
        return "Keto";
    }

    @Override
    public List<String> getMeals() {
        return meals;
    }
}

// High-Protein Meal Plan
class HighProteinMeal implements MealPlan {
    private List<String> meals = Arrays.asList("Grilled Salmon", "Protein Shake", "Chicken Breast & Rice");

    @Override
    public String getMealType() {
        return "High-Protein";
    }

    @Override
    public List<String> getMeals() {
        return meals;
    }
}

// Generic Meal Plan Class
class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void displayMealPlan() {
        System.out.println("Meal Plan Type: " + mealPlan.getMealType());
        System.out.println("Meals: " + mealPlan.getMeals());
    }

    public T getMealPlan() {
        return mealPlan;
    }
}

// Meal Plan Generator
class MealPlanGenerator {
    // Generic Method to Create a Meal Plan
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealType) {
        return new Meal<>(mealType);
    }
}

// Main Class
public class PersonalizedMealPlan {
    public static void main(String[] args) {
        // Generate different meal plans dynamically
        Meal<VegetarianMeal> vegetarianPlan = MealPlanGenerator.generateMealPlan(new VegetarianMeal());
        Meal<VeganMeal> veganPlan = MealPlanGenerator.generateMealPlan(new VeganMeal());
        Meal<KetoMeal> ketoPlan = MealPlanGenerator.generateMealPlan(new KetoMeal());
        Meal<HighProteinMeal> highProteinPlan = MealPlanGenerator.generateMealPlan(new HighProteinMeal());

        // Display generated meal plans
        vegetarianPlan.displayMealPlan();
        System.out.println();
        veganPlan.displayMealPlan();
        System.out.println();
        ketoPlan.displayMealPlan();
        System.out.println();
        highProteinPlan.displayMealPlan();
    }
}