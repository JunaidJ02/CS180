import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The {@code ColorEngine} class is what defines the Color fixer algorithm. It will read the broken file in,
 * collapse the array twice, via the {@code collapseArrayList} method, and the {@code analyzeColors} method.
 *
 */

/**
 * Homework 7 -- Color engine Class
 *
 * This is the Bookstore class of homework 7
 *
 * @author Junaid Javed, javedj@purdue.edu
 * @version October 11, 2019
 *
 */
public class ColorEngine {

    @SuppressWarnings("FieldCanBeLocal")
    private static ArrayList<String> contentsOfFile;
    @SuppressWarnings("FieldCanBeLocal")
    private static ArrayList<String> collapsedContents;
    private static ArrayList<String> toWrite = new ArrayList<>();

    public static void main(String[] args) throws UnsupportedColorSpectrumException {
        //System.out.println("What is the name of the color file you would like to fix?");
        //System.out.println("What is the name of the file you would like to dump the updated contents to?");

        // To Do - Prompts are included above.
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("What is the name of the color file you would like to fix?");
            String inputFileName = s.nextLine();
            System.out.println("What is the name of the file you would like to dump the updated contents to?");
            String outputFileName = s.nextLine();

            contentsOfFile = readFile(inputFileName);
            collapsedContents = collapseArrayList(contentsOfFile);
            analyzeColors(collapsedContents);
            writeFile(toWrite, outputFileName);
        } catch (FileNotFoundException i) {
            System.out.println("File not found " + i.getMessage());
        }

    }

    /**
     * This method should check whether the passed file name exists, and if it does, then it should read the contents
     * of the file into an {@code ArrayList} of {@code String}s. If the file doesn't exist, the {@code
     * FileNotFoundException} should be thrown.
     *
     * @param fileName The file name to read from
     * @return The {@code ArrayList} to read the file contents into
     * @throws FileNotFoundException
     */

    private static ArrayList<String> readFile(String fileName) throws FileNotFoundException {
        ArrayList<String> arrayList = new ArrayList<>();

        try {
            File f = new File(fileName);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            while (br.ready()) {
                arrayList.add(br.readLine());
            }

        } catch (FileNotFoundException f) {
            throw f;
        } catch (IOException i) {
            System.out.println("Error " + i.getMessage());
        }

        return arrayList;
    }

    /**
     * Collapses an {@code ArrayList} into a third of its size. Should collapse the {@code ArrayList} from
     * having an integer on each line to each line containing three integers.
     *
     * @param toCollapse The pre-collapsed {@code ArrayList}
     * @return the newly collapsed {@code ArrayList}
     */
    private static ArrayList<String> collapseArrayList(ArrayList<String> toCollapse) {
        ArrayList<String> collapsedList = new ArrayList<>();
        for (int i = 0; i < toCollapse.size() - 8; i += 9) {
            collapsedList.add(toCollapse.get(i) +
                    toCollapse.get(i + 1) +
                    toCollapse.get(i + 2) + ", " +
                    toCollapse.get(i + 3) +
                    toCollapse.get(i + 4) +
                    toCollapse.get(i + 5) +
                    ", " + toCollapse.get(i + 6) +
                    toCollapse.get(i + 7) +
                    toCollapse.get(i + 8));
        }

        return collapsedList;
    }

    /**
     * This method should instantiate a new {@code ColorApproximator} object, and create a new {@code Color} object
     * using the data from the {@code ArrayList} parameter's data. It should then add a string of this template to
     * the {@code ArrayList} that holds the data that will be written to the file.
     * <p>
     * 0,0,0 is approximately the color BLACK
     *
     * @param toAnalyze The 'brokencolors.txt' file, that has been 'collapsed' once, into three digits per line.
     * @throws UnsupportedColorSpectrumException thrown if the {@code Color} constructor throws an exception.
     */
    private static void analyzeColors(ArrayList<String> toAnalyze) throws UnsupportedColorSpectrumException {
        for (String str : toAnalyze) {
            String[] colorsString;
            colorsString = str.split(", ");

            Color color = new Color("INVALID",
                    Integer.parseInt(colorsString[0]),
                    Integer.parseInt(colorsString[1]),
                    Integer.parseInt(colorsString[2]));
            ColorApproximation colorApproximation = new ColorApproximation(color);
            toWrite.add(str + " is approximately the color " + colorApproximation.approximateColor());
        }

    }

    /**
     * This method should take in a parameter of an ArrayList, containing the fixed numbers and their color
     * approximations. It should print the contents of the ArrayList to a file, with a new line
     *
     * @param dataToWrite The {@code ArrayList} that contains the data to write to the text file
     * @param filename    The filename of the file you want to write data to
     */


    private static void writeFile(ArrayList<String> dataToWrite, String filename) {
        File f = new File(filename);

        try {
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            for (String str : dataToWrite) {
                bw.write(str);
            }
            fw.close();
        } catch (IOException i) {
            System.out.println(i.getMessage());
        }

    }
}