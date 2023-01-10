import java.io.*;
import java.util.*;

public class service {
    ArrayList<customer> customers = new ArrayList<>();
    Map<String ,Integer> pointsExchange = new HashMap<>();

    public service(){
        pointsExchange.put("Fries",100);
        pointsExchange.put("Soft Drink",50);
        pointsExchange.put("Sandwich",300);
        pointsExchange.put("Sandwich combo",400);
    }
    public void addCustomer(){
        while(true){
            try{
                Scanner sc = new Scanner(System.in);
                System.out.println("Please input your identity:");
                System.out.println("Student    Adult    Senior");
                String identity = sc.nextLine();
                while(!identity.equals("Student")&&!identity.equals("Adult")&&!identity.equals("Senior")){
                    System.out.println("Please input correct choice!");
                    System.out.println("Student\tAdult\tsenior");
                    identity = sc.nextLine();
                }
                System.out.print("Please input your name:");
                String name = sc.nextLine();
                String fastName = name.split(" ")[0];
                String latName = name.split(" ")[1];
                System.out.print("Please input your phone number:");
                String phoneNumber = sc.nextLine();
                System.out.print("Please input your Points:");
                int Points = sc.nextInt();
                switch (identity){
                    case "Student":customers.add(new Student(fastName,latName,phoneNumber,Points));break;
                    case "Adult":customers.add(new Adult(fastName,latName,phoneNumber,Points));break;
                    case "Senior":customers.add(new Senior(fastName,latName,phoneNumber,Points));break;
                }
                break;
            }
            catch (Exception e){
                System.out.println("Invalid input.");
            }
        }
    }
    public void editCustomer(){//要编辑的信息不确定
        try{
            while(true){
            Scanner sc = new Scanner(System.in);
            Iterator<customer> it = customers.iterator();
            System.out.print("Please input Your new identity:");
            String identity = sc.nextLine();
            System.out.print("Please input Your phone number:");
            String phoneNumber = sc.nextLine();
            while (it.hasNext()){
                customer i = it.next();
                if(i.phoneNumber.equals(phoneNumber)){
                    System.out.print("Please input Your new full name:");
                    String name = sc.nextLine();
                    String fastName = name.split(" ")[0];
                    String latName = name.split(" ")[1];
                    System.out.print("Please input Your Points:");
                    int Points =Integer.parseInt(sc.nextLine());
                    it.remove();
                    switch (identity){
                        case "Student":Student New1 = new Student(fastName,latName,phoneNumber,Points);
                            customers.add(New1);
                            return;
                        case "Senior":Senior New2 = new Senior(fastName,latName,phoneNumber,Points);
                            customers.add(New2);
                            return;
                        case "Adult":Adult New3 = new Adult(fastName,latName,phoneNumber,Points);
                            customers.add(New3);
                            return;
                    }
                    break;
                }
                if(!it.hasNext()){
                    System.out.println("phone number is no use");
                }
            }
        }
        }catch (Exception e){
            System.out.println("invalid input");
        }
    }
    public void print(){
        System.out.println("who has Points more than 50 are as follows:");
        for(customer i:customers){
            if(i.getPoints()>50){
                System.out.println(i.firstName+" "+i.lastName+":    "+i.Points);
            }
        }

    }
    public void AttainPoints(customer c){
        System.out.println("Welcome!");
        System.out.println("There are four food could be ordered:");
        c.printMeanu();
        Scanner sc = new Scanner(System.in);
        String food = sc.nextLine();
        if(!pointsExchange.containsKey(food)){
            System.out.println("invalid input");
            System.out.println("please chose again");
            food = sc.nextLine();
        }
        c.attainPoints(food);
        System.out.println("Thank you for your order.");

    }
    public void PointsExchaneg(customer c){
        System.out.println("Welcome!");
        System.out.println("There are four food could be exchanged by points as follows:");
        Set<String> foodname = pointsExchange.keySet();
        for(String i:foodname){
            System.out.println(i+":\t"+pointsExchange.get(i)+" Points");
        }
        Scanner sc = new Scanner(System.in);
        c.Points-=pointsExchange.get(sc.nextLine());
    }
    public void saveData(){
        System.out.println("saving...");
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("customers.csv"),'w');
            String title = "Identity,Customer_name,Phone_number,Points";
            writer.write(title);
            writer.newLine();
            for(customer i:customers){
                if(i instanceof Student){
                    writer.write("Student,");
                }
                else if(i instanceof Adult){
                    writer.write("Adult,");
                }
                else {
                    writer.write("Senior,");
                }
                writer.write(i.firstName+" "+i.lastName+","+i.phoneNumber+","+i.Points);
                writer.newLine();
            }
            writer.flush();
            writer.close();
            System.out.println("save successfully!");
        }catch (IOException e){
            System.out.println("save failed!");
        }

    }
    public void loadData(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("customers.csv"));
            reader.readLine();
            String line ="";
            while ((line = reader.readLine())!=null){
                String[] content = line.split(",");
                String[] name = content[1].split(" ");
                switch (content[0]){
                    case "Student":customers.add(new Student(name[0],name[1],content[2],Integer.parseInt(content[3])));break;
                    case "Adult":customers.add(new Adult(name[0],name[1],content[2],Integer.parseInt(content[3])));break;
                    case "Senior":customers.add(new Senior(name[0],name[1],content[2],Integer.parseInt(content[3])));break;
                }
            }
            reader.close();
            System.out.println("load successfully!");
        } catch (FileNotFoundException e){
            System.out.println("file was not founded");
        } catch (IOException e){
            System.out.println("load failed!");
        }
    }
}
