/**
 * Homework 9 -- ProgrammingLanguages Class
 *
 * This is the ProgrammingLanguages class of homework 9
 *
 * @author Junaid Javed, javedj@purdue.edu
 * @version October 26, 2019
 *
 */
public abstract class ProgrammingLanguage {
    private String compiler;
    private String extension;
    private String runConfig;
    private String flags;
    private String filename;

    public ProgrammingLanguage(String compiler, String extension, String flags, String runConfig, String filename) {
        this.compiler = compiler;
        this.extension = extension;
        this.runConfig = runConfig;
        this.flags = flags;
        this.filename = filename;
    }

    public String getCompiler() {
        return compiler;
    }

    public abstract boolean isObjectOriented();

    public String getExtension() {
        return extension;
    }

    public void setRunConfig(String runConfig) {
        this.runConfig = runConfig;
    }

    public void setExtension(String ext) {
        this.extension = ext;
    }

    public void setCompiler(String compiler) {
        this.compiler = compiler;
    }

    public String getFlags() {
        return flags;
    }

    public String getRunConfig() {
        return runConfig;
    }

    public void addFlag(String flag) {
        this.flags = flag;
    }

    public String getFilename() {
        return filename;
    }

    public boolean equals(Object o) {
        ProgrammingLanguage obj = (ProgrammingLanguage) o;
        return (this.compiler.equals(obj.compiler) &&
                this.flags.equals(obj.flags) &&
                this.runConfig.equals(obj.runConfig) &&
                this.isObjectOriented() == obj.isObjectOriented());
    }

    public abstract void printStrengths();

    public abstract void printWeaknesses();

    @Override
    public String toString() {
        return super.toString();

    }
}
