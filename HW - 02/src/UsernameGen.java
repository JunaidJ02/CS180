import java.util.Scanner;

public class UsernameGen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fullName;
        String firstInitial;
        String lastName;
        int birthYear;
        int age;

        System.out.println("What is your full name?");
        fullName = scanner.nextLine();

        System.out.println("What is your birth year?");
        birthYear = scanner.nextInt();

        firstInitial = (fullName.substring(0,1)).toLowerCase();
        lastName = (fullName.substring(fullName.indexOf(' ') + 1)).toLowerCase();

        System.out.println("Your username is " + firstInitial + lastName + (2019 - birthYear));

    }
}
