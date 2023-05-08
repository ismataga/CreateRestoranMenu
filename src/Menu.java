import java.util.ArrayList;
import java.util.List;

public class Menu {
    private  List<Meal>   meals;
    private  List<Drink>  drinks;


    public List<Meal> getMeals() {
        return meals;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public Menu() {
        this.meals=new ArrayList<>();
        this.drinks=new ArrayList<>();
    }

    public void  addMeal(Meal meal){
        meals.add(meal);
    }
    public void  addDrink(Drink drink){

        drinks.add(drink);
    }

}
