import java.util.Scanner;


public class BusinessCard {
    public static void main(String[] args) {
        String name;
        int yearOfBirth;
        double gpa;
        String major;
        String email;

        Scanner scanner = new Scanner(System.in);

        // Collect User's Name
        System.out.print("Enter your Name: ");
        name = scanner.nextLine();

        // Collect User's Year of Birth
        System.out.print("Enter your Year of Birth: ");
        yearOfBirth = scanner.nextInt();

        // Collect User's GPA
        System.out.print("Enter your GPA: ");
        gpa = scanner.nextDouble();
        scanner.nextLine();

        // Collect User's Major
        System.out.print("Enter your Major: ");
        major = scanner.nextLine();

        // Collect User's Email
        System.out.print("Enter your email: ");
        email = scanner.nextLine();

        // Print all information
        System.out.println("Name: " + name);
        System.out.println("Age: " + (2019 - yearOfBirth));
        System.out.println("GPA: " + String.format("%.3g", gpa));
        System.out.println("Major: " + major);
        System.out.println("Email: " + email);
    }
}
