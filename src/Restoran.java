import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Restoran {
    Scanner sc = new Scanner(System.in);
    Menu menu = new Menu();
    Order order = new Order();

    public static void main(String[] args) {
        Restoran re = new Restoran();
        re.callMenu();
    }

    private void callMenu() {
        while (true) {
            int option = printCallMenuCommand();
            if (chooseMenuOption(option)) return;
        }
    }

    private boolean chooseMenuOption(int option) {
        switch (option) {
            case 0 -> {
                return true;
            }
            case 1 -> addMenu();
            case 2 -> getMenu();
            case 3 -> createOrder();
            case 4 -> getOrder();
            case 5 -> System.out.println(order.getTotalPrice());
            default -> System.out.println("Invalid option");
        }
        return false;
    }

    private int printCallMenuCommand() {
        System.out.println("" +
                "----|Enter menu|----");
        System.out.println("0. Exit system\n" +
                "1. Add menu\n" +
                "2. Get menu\n" +
                "3. CreateOrder\n" +
                "4. GetOrder\n" +
                "5. GetTotalPrice\n");
        int option = getInt("Enter menu option: ");
        return option;
    }


    public void addMenu() {
        while (true) {
            int option = printMenuCommand();

            if (option == 1) {
                String mealName = getString("Add meal name: ");
                long mealId = getLong("Enter meal id:");
                BigDecimal mealPrice = getBigDecimal("Enter meal price: ");
                Meal meal = new Meal(mealId, mealName, mealPrice);
                menu.addMeal(meal);
            } else if (option == 2) {
                String drinkName = getString("Add drink name: ");
                long drinkId = getLong("Enter drink id:");
                BigDecimal drinkPrice = getBigDecimal("Enter drink price: ");
                Drink drink = new Drink(drinkId, drinkName, drinkPrice);
                menu.addDrink(drink);
            } else {
                return;
            }
        }
    }

    private int printMenuCommand() {
        System.out.println("-----|Add menu|------ ");
        System.out.println("1.Meal: ");
        System.out.println("2.Drink: ");
        System.out.println("3.Exit: ");
        int option = getInt("Enter menu option: ");
        sc.nextLine();
        return option;
    }

    private  int getInt(String title) {
        System.out.println(title);
        int intValue = sc.nextInt();
        return intValue;
    }

    private BigDecimal getBigDecimal(String title) {
        System.out.println(title);
        BigDecimal bidDesValue = BigDecimal.valueOf(sc.nextInt());
        return bidDesValue;
    }


    private long getLong(String title) {
        System.out.println(title);
        long longValue = sc.nextInt();
        return longValue;
    }

    private String getString(String title) {
        System.out.println(title);
        String stringValue = sc.nextLine();
        return stringValue;
    }

    public void getMenu() {
        System.out.println("-----------Meals----------");
        List<Meal> meals = menu.getMeals();

        for (Meal meal : meals) {
            System.out.println(meal);
        }

        System.out.println("-----------Drinks----------");
        List<Drink> drinks = menu.getDrinks();

        for (Drink drink : drinks) {
            System.out.println(drink);
        }

    }

    public void createOrder() {
        while (true) {
            int option = printOrderCommand();
            if (option == 1) {
                long id = getLong("Enter meal id:");
                addMeals(id);
            } else if (option == 2) {
                long id = getLong("Enter drink id:");
                addDrink(id);
            } else {
                return;
            }
        }
    }

    private int printOrderCommand() {
        System.out.println("------|Create Order|------------ ");
        System.out.println("1.Meal: ");
        System.out.println("2.Drink: ");
        System.out.println("3.Exit: ");
        int option = getInt("Enter menu option: ");
        sc.nextLine();
        return option;
    }

    public void getOrder() {
        System.out.println("-----------Meals----------");
        List<Meal> meals = order.getMeals();

        for (Meal meal : meals) {
            System.out.println(meal);
        }

        System.out.println("-----------Drinks----------");
        List<Drink> drinks = order.getDrinks();

        for (Drink drink : drinks) {
            System.out.println(drink);
        }

    }

    private void addDrink(long id) {

        for (Drink drink : menu.getDrinks()) {
            if (drink.getId() == id) {
                order.addDrink(drink);
            }

        }
    }

    private void addMeals(long id) {
        for (Meal meal : menu.getMeals()) {
            if (meal.getId() == id) {
                order.addMeal(meal);
            }
        }
    }

}


