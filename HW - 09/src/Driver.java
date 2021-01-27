import java.util.Scanner;

/**
 * Homework 9 -- Driver Class
 *
 * This is the Driver class of homework 9
 *
 * @author Junaid Javed, javedj@purdue.edu
 * @version October 26, 2019
 *
 */
public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! Input the file you would like to process:");
        String filename = scanner.nextLine();
        System.out.println("Here is your selected file's language information:");
        System.out.println("-----");

        String language = AccessoryMethods.identifyLanguage(filename);
        Object pl = new Object();
        switch (language) {
            case "Java":
                pl = new Java(filename);
                break;
            case "C":
                pl = new C(filename);
                break;
            case "C++":
                pl = new CPlusPlus(filename);
                break;
            case "Python":
                pl = new Python(filename);
                break;
        }

        System.out.println(pl.toString());

        boolean platformIndependent = AccessoryMethods.isPlatformIndependent((ProgrammingLanguage) pl);
        if (platformIndependent) {
            System.out.println("It is platform independent.");
        } else {
            System.out.println("It is not platform independent.");
        }

        System.out.println("The compiler was last updated in " +
                AccessoryMethods.compilerAge((ProgrammingLanguage) pl) + ".");

        if (pl instanceof Java) {
            Java java = new Java(filename);
            java.printStrengths();
            java.printWeaknesses();
        } else if (pl instanceof C) {
            C c = new C(filename);
            c.printStrengths();
            c.printWeaknesses();
        } else if (pl instanceof CPlusPlus) {
            CPlusPlus cPlusPlus = new CPlusPlus(filename);
            cPlusPlus.printStrengths();
            cPlusPlus.printWeaknesses();
        } else if (pl instanceof Python) {
            Python python = new Python(filename);
            python.printStrengths();
            python.printWeaknesses();
        }

        System.out.println("-----");
    }
}
