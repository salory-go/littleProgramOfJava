import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Senior extends customer{
    Map<String ,Integer> Senior = new HashMap<>();
    public Senior(String firstName,String lastName,String phoneNumber,int Points){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.Points = Points;
        Senior.put("Fries",0);
        Senior.put("Soft Drink",0);
        Senior.put("Sandwich",20);
        Senior.put("Sandwich combo",30);
    }
    public void printMeanu(){
        Set<String> foods = Senior.keySet();
        for(String i :foods){
            System.out.println(String.format("%-8s",i)+String.format("%8d",Senior.get(i)));
        }
        System.out.println("Please input the food name:");
    }
    public void attainPoints(String food){
        this.Points+=Senior.get(food);
    }
}
