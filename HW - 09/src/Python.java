/**
 * Homework 9 -- Python Class
 *
 * This is the Python class of homework 9
 *
 * @author Junaid Javed, javedj@purdue.edu
 * @version October 26, 2019
 *
 */
public class Python extends ProgrammingLanguage {

    public Python(String fileName) {
        super("Python Virtual Machine (PVM)",
                ".py",
                "",
                "python " + fileName,
                fileName);
    }

    @Override
    public String toString() {
        return "The standard version of Python uses the " + getCompiler() + " compiler.\n" +
                "All versions of Python have file extensions with " + getExtension() + ".\n" +
                "To run the file " + getFilename() + " you would need the following command:\n" +
                getRunConfig();
    }

    public void printStrengths() {
        System.out.println("Python has simple syntax and is easily extensible.");
    }

    public void printWeaknesses() {
        System.out.println("Python is slower than other languages " +
                "and not suited for mobile development.");
    }

    @Override
    public boolean isObjectOriented() {
        return true;
    }
}
