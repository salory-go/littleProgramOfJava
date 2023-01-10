import java.util.*;
import java.io.PrintWriter;
import java.io.IOException;

class LabProgram {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String fileName = scnr.nextLine(); // name of the file to read data
        // structure to store the data from the file
        class Students {// structure is Students
            String lastName; // last name of the student
            String firstName; // first name of the student
            int score1;// score of the student in the first lab
            int score2;// score of the student in the second lab
            int score3;// score of the student in the third lab
            char grade;// grade of the student
        }
        // arraylist to store the data from the file
        ArrayList<Students> students = new ArrayList<Students>();
        double sumScore1 = 0, sumScore2 = 0, sumScore3 = 0;
        // open file
        try {
            Scanner inputFile = new Scanner(new java.io.File(fileName));
            while (inputFile.hasNext()) {
                Students student = new Students();// create a new student
                student.lastName = inputFile.next();// last name of the student
                student.firstName = inputFile.next();// first name of the student
                student.score1 = inputFile.nextInt();// score of the student in the first lab
                student.score2 = inputFile.nextInt();// score of the student in the second lab
                student.score3 = inputFile.nextInt();// score of the student in the third lab
                // calculate the grade of the student
                double average = (student.score1 + student.score2 + student.score3) / 3.0;
                sumScore1 += student.score1;// add the score of the student in the first lab to the total score
                sumScore2 += student.score2;// add the score of the student in the second lab to the total score
                sumScore3 += student.score3;// add the score of the student in the third lab to the total score
                if (average >= 90) {// if the average is greater than or equal to 90
                    student.grade = 'A';// grade of the student is A
                } else if (average >= 80) {// if the average is greater than or equal to 80
                    student.grade = 'B';// grade of the student is B
                } else if (average >= 70) {// if the average is greater than or equal to 70
                    student.grade = 'C';// grade of the student is C
                } else if (average >= 60) {// if the average is greater than or equal to 60
                    student.grade = 'D';// grade of the student is D
                } else {// if the average is less than 60
                    student.grade = 'F';// grade of the student is F
                } // end of if else statement
                students.add(student);// add the student to the arraylist
            } // end of while loop
            inputFile.close();// close the file
        } catch (IOException e) {// if the file is not found
            System.out.println("File not found");// print the error message
        } // end of try catch statement
        int n = students.size();
        // write the students data to file report.txt in tab separated format
        try {
            // open file
            PrintWriter outputFile = new PrintWriter("report.txt");
            for (Students student : students) {
                outputFile.print(student.lastName + "\t");// write the last name of the student to the file
                outputFile.print(student.firstName + "\t");// write the first name of the student to the file
                outputFile.print(student.score1 + "\t");// write the score of the student in the first lab to the file
                outputFile.print(student.score2 + "\t");// write the score of the student in the second lab to the file
                outputFile.print(student.score3 + "\t");// write the score of the student in the third lab to the file
                outputFile.println(student.grade);// write the grade of the student to the file
            }
            // output correct to 2 decimal places
            outputFile.printf("\nAverages: Midterm1 %.2f, Midterm2 %.2f, Final %.2f\r", sumScore1 / n, sumScore2 / n, sumScore3 / n);

            outputFile.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        scnr.close();
    }
}