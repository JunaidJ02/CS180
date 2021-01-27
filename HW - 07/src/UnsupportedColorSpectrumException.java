/**
 * This class represents an {@code Exception} that would be thrown if the color read from the file would
 * not fall within the RGB color space of (0-255,0-255,0-255).
 *
 */

/**
 * Homework 7 -- Unsupported color spectrum exception Class
 *
 * This is the Bookstore class of homework 7
 *
 * @author Junaid Javed, javedj@purdue.edu
 * @version October 11, 2019
 *
 */
public class UnsupportedColorSpectrumException extends Exception {
    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public UnsupportedColorSpectrumException() {
        super();
    }

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public UnsupportedColorSpectrumException(String message) {
        super(message);
    }
}