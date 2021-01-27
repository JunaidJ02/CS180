import java.util.Scanner;

/**
 * A program to generate Fibonacci numbers
 *
 * <p>Purdue University -- CS18000 -- Fall 2019 -- HW4</p>
 */

public class Fibonacci {
    ////////////////// Do not edit code above //////////////////////

    //TODO: Implement seqeuncer

    public static int sequence;
    public static int firstNum = 0;
    public static int secodnNum = 1;
    public static int thirdNum = 1;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Welcome to Fibonacci Sequencer\n");
        chooseMode(s);
        s.close();
        ////////////////// Do not edit code below //////////////////////
    }


    public static void chooseMode(Scanner s) {
        System.out.println("Enter an Option:");
        System.out.println("A for Sequence");
        System.out.println("B for Matrix");
        System.out.println("C for Fibonacci string");
        String mode = s.next();
        if (mode.toLowerCase().equals("a")) {
            ModeA(s);
        } else if (mode.toLowerCase().equals("b")) {
            ModeB(s);
        } else if (mode.toLowerCase().equals("c")) {
            ModeC(s);
        } else {
            System.out.println("Input not valid");
            runAgain(s);
        }
        ////////////////// Do not edit code below //////////////////////
    }

    public static int getFibonacci(int sqnc) {
        sequence = sqnc;
        firstNum = 0;
        secodnNum = 1;
        thirdNum = 1;
        int i = 0;
        if (sequence == 0) {
            thirdNum = 0;
            return 0;
        }
        while (sequence != 0) {
            for (i = 0; i < sequence - 1; i++) {
                thirdNum = firstNum + secodnNum;
                firstNum = secodnNum;
                secodnNum = thirdNum;
            }
            i = 0;
            return thirdNum;

        }
        return thirdNum;
    }


    public static void ModeA(Scanner s) {
        System.out.println("Enter 0 to exit");
        System.out.println("Enter Sequence:");
        while (true) {
            int answer = getFibonacci(s.nextInt());
            if (answer != 0) {
                System.out.println(answer);
            } else {
                break;
            }
        }
        runAgain(s);
    }

    public static void ModeB(Scanner s) {
        System.out.println("Enter Dimensions:");
        int rows = s.nextInt();
        int columns = s.nextInt();

        int currentSequence = 1;
        for (int countRows = 1; countRows <= rows; countRows++) {
            for (int countColumns = 1; countColumns <= columns; countColumns++) {
                System.out.print(getFibonacci(currentSequence++));
                System.out.print(" ");
            }
            System.out.println();
        }
        runAgain(s);
    }

    public static void ModeC(Scanner s) {
        System.out.println("Enter Fibonacci String:");
        String original = s.next();
        String reversed = "";
        String fibonacci = "";

        for (int i = original.length(); i > 0; i--) {
            reversed += original.substring(i - 1, i);
        }
        for (int i = 0; i < reversed.length(); i++) {
            if (reversed.charAt(i) == '0') {
                fibonacci += "1";
            } else {
                fibonacci += "0";
            }

        }
        System.out.println(fibonacci);
        runAgain(s);


    }

    public static void runAgain(Scanner s) {
        System.out.println("Press Y to run again");
        String runAgain = s.next();
        if (runAgain.toLowerCase().equals("y")) {
            chooseMode(s);
        } else {
            System.out.println("Thank you using Fibonacci Sequencer");
            s.close();
        }
    }
}