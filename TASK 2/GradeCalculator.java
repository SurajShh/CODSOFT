import java.io.*;
import java.util.*;

public class GradeCalculator {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Welcome to Grade Calculator");

    System.out.print("Enter the mark in Subject-1 : ");
    int subject1= sc.nextInt();

    System.out.print("Enter the mark in Subject-2 : ");
    int subject2= sc.nextInt();

    System.out.print("Enter the mark in Subject-3 : ");
    int subject3= sc.nextInt();

    System.out.print("Enter the mark in Subject-4 : ");
    int subject4= sc.nextInt();

    System.out.print("Enter the mark in Subject-5 : ");
    int subject5= sc.nextInt();

    System.out.println(" Thank you for Entering your marks Here's you Grade ");
    int total = subject1 + subject2 + subject3 + subject4 + subject5;

    double percentage = (double)total/5;
    String grade = "";

    if( subject1 < 35 || subject2 < 35 || subject3 < 35 || subject4 < 35 || subject5 < 35 )
    {
        grade = "Fail";
    }
    else if( percentage < 100 && percentage >= 85){
        grade = "Distinction";
    }
    else if( percentage < 85 && percentage >= 60){
        grade = "First Class";
    }
    else if( percentage < 60 && percentage >= 50){
        grade = "Second Class";
    }
    else {
        grade = "Third Class";
    }

    System.out.println("Total Marks : "+ total);
    System.out.println("Average percentage : "+ percentage);
    System.out.println("Grade Obtained : "+ grade);

}
     
}