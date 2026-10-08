import java.util.Scanner;

class Student {
    String studentName;
    String rollNumber;
    double marks;
    String courseName;
    int courseCredits;

    public Student(String studentName, String rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

       public double calculateFee() {
        return courseCredits * 1500.0;
    }

       public boolean checkEligibility() {
        return marks >= 50.0;
    }

       public double calculateScholarship(double totalFee) {
        if (marks >= 85.0) {
            return totalFee * 0.20; 
        } else if (marks >= 70.0 && marks <= 84.0) {
            return totalFee * 0.10; 
        } else {
            return 0.0;         }
    }

    public double calculateFinalFee() {
        double totalFee = calculateFee();
        double scholarship = calculateScholarship(totalFee);
        return totalFee - scholarship;
    }

    public void displayDetails() {
        double totalFee = calculateFee();
        double scholarship = calculateScholarship(totalFee);
        double finalFee = calculateFinalFee();

        System.out.println("\n--- Student Registration Details ---");
        System.out.println("Student Name : " + studentName);
        System.out.println("Roll Number  : " + rollNumber);
        System.out.println("Marks        : " + marks);
        System.out.println("Course Name  : " + courseName);
        System.out.println("Course Credits: " + courseCredits);
        System.out.println("Eligibility  : Eligible");
        System.out.println("Total Fee    : Rs. " + totalFee);
        System.out.println("Scholarship  : Rs. " + scholarship);
        System.out.println("Final Fee    : Rs. " + finalFee);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter Roll Number: ");
        String rollNumber = scanner.nextLine();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();

        System.out.print("Enter Course Credits: ");
        int courseCredits = scanner.nextInt();

                Student student = new Student(studentName, rollNumber, marks, courseName, courseCredits);

    
        if (student.checkEligibility()) {
           
            student.displayDetails();
        } else {
                      System.out.println("\n--- Student Registration Details ---");
            System.out.println("Student Name : " + studentName);
            System.out.println("Roll Number  : " + rollNumber);
            System.out.println("Eligibility  : Not Eligible (Marks are below 50)");
        }

        scanner.close();
    }
}