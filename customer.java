public class customer {
    String firstName;
    String lastName;
    String phoneNumber;
    int Points;
    public customer(){}
    public customer(String firstName,String lastName,String phoneNumber,int Points){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.Points = Points;
    }
    public int getPoints() {
        return Points;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setPoints(int points) {
        Points = points;
    }
    public void printMeanu(){}
    public void attainPoints(String str){}
}
