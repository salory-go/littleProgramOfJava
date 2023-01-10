import java.util.Scanner;

public class serviceManage {
    static service manager = new service();
    static Scanner sc = new Scanner(System.in);
    static customer temp = new customer();
    public static void main(String[] args) {
        System.out.println("loading....");
        manager.loadData();
        System.out.println("********Welcome********");
        while (true){
            lableA:
            System.out.println("Please input what you want:");
            System.out.println("1.add customer information");
            System.out.println("2.edit customer information");
            System.out.println("3.order food");
            System.out.println("4.exchange food by Points");
            System.out.println("5.print the customers who has Points more than 50");
            System.out.println("6.save data\n");
            String choice  = sc.nextLine();
            switch (choice){
                case "1":manager.addCustomer();break;
                case "2":manager.editCustomer();break;
                case "3":
                    System.out.println("please input the customer's phone number:");
                    String phonenmuber = sc.nextLine();
                    for(customer i : manager.customers){
                        if(i.phoneNumber.equals(phonenmuber)){
                            manager.AttainPoints(i);break;
                        }
                    }
                    break;
                case "4":System.out.println("please input the customer's phone number:");
                    phonenmuber = sc.nextLine();
                    for(customer i : manager.customers){
                        if(i.phoneNumber.equals(phonenmuber)){
                            manager.PointsExchaneg(i);break;
                        }
                    }
                    break;
                case "5":manager.print();break;
                case "6":manager.saveData();return;
                default:
                    System.out.println("invalid input");
            }
        }




    }
}
