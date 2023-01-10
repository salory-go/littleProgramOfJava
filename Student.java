import java.util.*;

public class Student extends customer{
    Map<String ,Integer> Students = new HashMap<>();
    public Student(String firstName,String lastName,String phoneNumber,int Points){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.Points = Points;
        Students.put("Fries",3);
        Students.put("Soft Drink",1);
        Students.put("Sandwich",10);
        Students.put("Sandwich combo",15);
    }

    public void printMeanu(){
        Set<String> foods = Students.keySet();
        for(String i :foods){
            System.out.println(String.format("%-10s",i)+String.format("%-10s",Students.get(i))+" Points");
        }
        System.out.println("Please input the food name:");
    }
    public void attainPoints(String food){
        this.Points+=Students.get(food);
    }
}
