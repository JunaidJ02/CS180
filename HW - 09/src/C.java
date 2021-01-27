/**
 * Homework 9 -- C Class
 *
 * This is the C class of homework 9
 *
 * @author Junaid Javed, javedj@purdue.edu
 * @version October 26, 2019
 *
 */
public class C extends ProgrammingLanguage {

    public C(String fileName) {
        super("gcc",
                ".c",
                "-o",
                "gcc -o " +
                        fileName.replaceAll(".c", "") +
                        " " + fileName + " && ./" +
                        fileName.replaceAll(".c", ""),
                fileName);
    }

    @Override
    public String toString() {
        return "C uses the " + getCompiler() + " compiler, " +
                "has file extensions with " + getExtension() + " and " +
                "to run the file " + getFilename() + " you would need the following command:\n" +
                getRunConfig();
    }

    public void printStrengths() {
        System.out.println("C is a small language and " +
                "provides programmers with low-level control.");
    }

    public void printWeaknesses() {
        System.out.println("C allows programmers to perform" +
                " potentially dangerous actions with few checks.");
    }

    @Override
    public boolean isObjectOriented() {
        return false;
    }
}
