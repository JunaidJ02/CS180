import java.util.Scanner;

public class CareerTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String prevAnswer;

        System.out.println("Would you like a career test?");
        prevAnswer = scanner.nextLine();

        // Take career test
        if(prevAnswer.equals("yes")){
            System.out.println("Is money important for you?");
            prevAnswer = scanner.next();

            // Money is important
            if(prevAnswer.equals("yes")){
                System.out.println("Are you an introvert or an extrovert?");
                prevAnswer = scanner.next();

                // Introvert
                if(prevAnswer.equals("introvert")){
                    System.out.println("Would you like to work with animals or people?");
                    prevAnswer = scanner.next();

                    // Want to work with animals
                    if(prevAnswer.equals("animals")){
                        System.out.println("Are you scared of blood?");
                        prevAnswer = scanner.next();

                        // Scared of blood
                        if(prevAnswer.equals("yes")){
                            System.out.println("Ecologist");

                        // Not scared of blood
                        }else{
                            System.out.println("Veterinarian");
                        }
                    // Want to work with people
                    }else{
                        System.out.println("Are you scared of blood?");
                        prevAnswer = scanner.next();

                        // Scared of blood
                        if(prevAnswer.equals("yes")){
                            System.out.println("Software Engineer");

                            // Not scared of blood
                        }else{
                            System.out.println("Investment Banker");
                        }
                    }



                //Extrovert
                }else{
                    System.out.println("Would you like to work with animals or people?");
                    prevAnswer = scanner.next();


                    // Want to work with animals
                    if(prevAnswer.equals("animals")){
                        System.out.println("Are you scared of blood?");
                        prevAnswer = scanner.next();

                        // Scared of blood
                        if(prevAnswer.equals("yes")){
                            System.out.println("Veterinarian");

                            // Not scared of blood
                        }else{
                            System.out.println("Farmer");
                        }

                        // Want to work with people
                    }else{
                        System.out.println("Are you scared of blood?");
                        prevAnswer = scanner.next();

                        // Scared of blood
                        if(prevAnswer.equals("yes")){
                            System.out.println("Actor");

                            // Not scared of blood
                        }else{
                            System.out.println("Doctor");
                        }
                    }
                }


            // Money is not important
            }else{
                System.out.println("Are you an introvert or an extrovert?");
                prevAnswer = scanner.next();

                // Introvert
                if(prevAnswer.equals("introvert")){
                    System.out.println("Would you like to work with animals or people?");
                    prevAnswer = scanner.next();

                    // Want to work with animals
                    if(prevAnswer.equals("animals")){
                        System.out.println("Are you scared of blood?");
                        prevAnswer = scanner.next();

                        // Scared of blood
                        if(prevAnswer.equals("yes")){
                            System.out.println("Zookeeper");

                            // Not scared of blood
                        }else{
                            System.out.println("Cook");
                        }
                        // Want to work with people
                    }else{
                        System.out.println("Are you scared of blood?");
                        prevAnswer = scanner.next();

                        // Scared of blood
                        if(prevAnswer.equals("yes")){
                            System.out.println("College Professor");

                            // Not scared of blood
                        }else{
                            System.out.println("Artist");
                        }
                    }



                    //Extrovert
                }else{
                    System.out.println("Would you like to work with animals or people?");
                    prevAnswer = scanner.next();


                    // Want to work with animals
                    if(prevAnswer.equals("animals")){
                        System.out.println("Are you scared of blood?");
                        prevAnswer = scanner.next();

                        // Scared of blood
                        if(prevAnswer.equals("yes")){
                            System.out.println("Zookeeper");

                            // Not scared of blood
                        }else{
                            System.out.println("Animal Control Worker");
                        }

                        // Want to work with people
                    }else{
                        System.out.println("Are you scared of blood?");
                        prevAnswer = scanner.next();

                        // Scared of blood
                        if(prevAnswer.equals("yes")){
                            System.out.println("Teacher");

                            // Not scared of blood
                        }else{
                            System.out.println("Teacher");
                        }
                    }
                }

            }


        // Do not want to take career test.
        }else{
            System.out.println("Ok, maybe next time.");
        }
    }
}
