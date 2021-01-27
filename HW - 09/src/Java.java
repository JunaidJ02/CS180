/**
 * Homework 9 -- Java Class
 *
 * This is the Java class of homework 9
 *
 * @author Junaid Javed, javedj@purdue.edu
 * @version October 26, 2019
 *
 */
public class Java extends ProgrammingLanguage {

    public Java(String fileName) {
        super("Java Virtual Machine (JVM)",
                ".java",
                "",
                "javac " + fileName + " && java " + fileName.replaceAll(".java", ""),
                fileName);
    }

    @Override
    public String toString() {
        return "Java uses the " + getCompiler() + " compiler, " +
                "and has file extensions with " + getExtension() + ".\n" +
                "To run the file " + getFilename() + " you would need the following command:\n" +
                getRunConfig();
    }

    public void printStrengths() {
        System.out.println("Java is a general purpose object-oriented language, " +
                "making it well suited for most general development.");
    }

    public void printWeaknesses() {
        System.out.println("Because Java is run on a virtual machine," +
                " it can be slower than other languages.");
    }

    @Override
    public boolean isObjectOriented() {
        return true;
    }
}
