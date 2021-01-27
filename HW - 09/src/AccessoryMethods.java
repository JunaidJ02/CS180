/**
 * Homework 9 -- AccessoryMethods Class
 *
 * This is the AccessoryMethods class of homework 9
 *
 * @author Junaid Javed, javedj@purdue.edu
 * @version October 26, 2019
 *
 */
public class AccessoryMethods {
    public static boolean isPlatformIndependent(ProgrammingLanguage pl) {
        if (pl.getExtension().equals(".java") ||
                pl.getExtension().equals(".py")) return true;
        else if (pl.getExtension().equals(".c") ||
                pl.getExtension().equals(".cpp")) return false;
        else {
            System.out.println("Error, invalid language!");
            return false;
        }
    }

    public static String compilerAge(ProgrammingLanguage pl) {
        String extension = pl.getExtension();
        switch (extension) {
            case ".cpp":
                return "2017";
            case ".c":
                return "2018";
            case ".py":
            case ".java":
                return "2019";
            default:
                return "Invalid";
        }
    }

    public static String identifyLanguage(String filename) {
        String extension = filename.substring(filename.indexOf('.'));
        switch (extension) {
            case ".cpp":
                return "C++";
            case ".c":
                return "C";
            case ".py":
                return "Python";
            case ".java":
                return "Java";
            default:
                return "Unknown language";
        }
    }


}
