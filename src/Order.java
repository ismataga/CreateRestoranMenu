import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private List<Meal> meals;
    private  List<Drink>  drinks;

    public int getOrderId() {
        return orderId;
    }

    public List<Meal> getMeals() {
        return meals;
    }



    public List<Drink> getDrinks() {
        return drinks;
    }



    public BigDecimal getTotalPrice(){
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Meal meal : meals) {
           totalPrice =  totalPrice.add(meal.getPrice());
        }
        for (Drink drink : drinks) {
            totalPrice = totalPrice.add(drink.getPrice());
        }
        System.out.println("Total price" );
        return   totalPrice;
    }
    public Order() {
        this.meals=new ArrayList<>();
        this.drinks=new ArrayList<>();
    }

    public void addMeal(Meal meal){
        meals.add(meal);
    }

    public void  addDrink(Drink drink){
        drinks.add(drink);
    }


}
