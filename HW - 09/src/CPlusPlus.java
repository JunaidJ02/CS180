/**
 * Homework 9 -- CPlusPlus Class
 *
 * This is the CPlusPlus class of homework 9
 *
 * @author Junaid Javed, javedj@purdue.edu
 * @version October 26, 2019
 *
 */
public class CPlusPlus extends ProgrammingLanguage {

    public CPlusPlus(String fileName) {
        super("g++",
                ".cpp",
                "-o",
                "g++ -o " +
                        fileName.replaceAll(".cpp", "") +
                        " " + fileName + " && ./" +
                        fileName.replaceAll(".cpp", ""),
                fileName);
    }

    @Override
    public String toString() {
        return "One of the compilers C++ uses is the " + getCompiler() + " compiler.\n" +
                "It has file extensions with " + getExtension() + "." +
                " To run the file " + getFilename() + " you would need the following command:\n " +
                getRunConfig();
    }

    public void printStrengths() {
        System.out.println("C++ brings together low-level management " +
                "with high-level object-oriented features.");
    }

    public void printWeaknesses() {
        System.out.println("C++ is a large, complex language and " +
                "requires manual memory management.");
    }

    @Override
    public boolean isObjectOriented() {
        return true;
    }
}
