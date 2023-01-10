import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Adult extends customer {
    Map<String, Integer> Adults = new HashMap<>();


    public Adult(String firstName, String lastName, String phoneNumber, int Points) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.Points = Points;
        Adults.put("Fries", 3);
        Adults.put("Soft Drink", 1);
        Adults.put("Sandwich", 15);
        Adults.put("Sandwich combo", 20);
    }

    public void printMeanu() {
        Set<String> foods = Adults.keySet();
        for (String i : foods) {
            System.out.println(String.format("%-8s", i) + String.format("%8d", Adults.get(i)));
        }
        System.out.println("Please input the food name:");
    }

    public void attainPoints(String food) {
        this.Points += Adults.get(food);
    }
}
