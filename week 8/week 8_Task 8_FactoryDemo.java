import java.util.*;
import java.security.*;

interface Food {
    public String getType();
}

class Pizza implements Food {
    public String getType() {
        return "Someone ordered a Fast Food!";
    }
}

class Cake implements Food {
    public String getType() {
        return "Someone ordered a Dessert!";
    }
}

class FoodFactory {
    public Food getFood(String order) {
        // Complete this method
        if (order.equalsIgnoreCase("pizza")) {
            return new Pizza();
        } else if (order.equalsIgnoreCase("cake")) {
            return new Cake();
        }
        return null;
    }
}

public class FactoryDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating the factory
        FoodFactory foodFactory = new FoodFactory();

        // Factory instantiates an object
        Food food = foodFactory.getFood(sc.nextLine());

        System.out.println("The factory returned " + food.getClass());
        System.out.println(food.getType());
    }
}