/**
 * Homework 6 -- Bookstore Class
 *
 * This is the Bookstore class of homework 6
 *
 * @author Junaid Javed, javedj@purdue.edu
 * @version September 30, 2019
 *
 */
public class Bookstore {

    private int row;
    private int col;
    private Book[][][] bookshelf;

    /**
     * Construct a newly allocated {@code Bookstore} object with given parameters
     * @param row Number of rows in each shelf
     * @param col Number of columns in each shelf
     * @param books Array of books to be placed in the bookshelf
     */
    public Bookstore(int row, int col, Book[] books) {
        this.row = row;
        this.col = col;
        bookshelf = new Book[10][row][col];
        int currentBook = 0;
        while (currentBook < books.length - 1) {
            for (int currentShelf = 0; currentShelf < 10; currentShelf++) {
                for (int currentRow = 0; currentRow < row; currentRow++) {
                    for (int currentCol = 0; currentCol < col; currentCol++) {
                        if (currentBook == books.length) {
                            break;
                        }
                        bookshelf[currentShelf][currentRow][currentCol] = books[currentBook++];
                    }
                }
            }
        }
    }

    /**
     * Book look up in bookshelf using the name of the book
     * @param name Name of the book
     * @return String with the format    Book: [name] [bookISBN] [author] [lowest price]
     */
    public String lookUpName(String name) {
        for (int i = 0; i < bookshelf.length; i++) {
            for (int j = 0; j < bookshelf[i].length; j++) {
                for (int k = 0; k < bookshelf[i][j].length; k++) {
                    if(bookshelf[i][j][k] != null) {
                        if (bookshelf[i][j][k].getName()
                                .equals(name)) {
                            return "Book: " + bookshelf[i][j][k].getName() + " " + bookshelf[i][j][k].getBookISBN() + " " + bookshelf[i][j][k].getAuthor() + " " + bookshelf[i][j][k].getLowestPrice();
                        }
                    }
                }
            }
        }
        return "Not found";
    }

    /**
     * Book look up in bookshelf using the ISBN of the book
     * @param bookISBN bookISBN of the book
     * @return String with the format    Book: [name] [bookISBN] [author] [lowest price]
     */
    public String lookUpBookISBN(int bookISBN) {
        for (int i = 0; i < bookshelf.length; i++) {
            for (int j = 0; j < bookshelf[i].length; j++) {
                for (int k = 0; k < bookshelf[i][j].length; k++) {
                    if (bookshelf[i][j][k]
                            != null) {
                        if (bookshelf[i][j][k].getBookISBN() == bookISBN) {
                            return "Book: " + bookshelf[i][j][k].getName() + " " + bookshelf[i][j][k].getBookISBN() + " " + bookshelf[i][j][k].getAuthor() + " " + bookshelf[i][j][k].getLowestPrice();
                        }
                    }
                }
            }
        }
        return "Not found";
    }

    public Book[][][] getBookshelf() {
        return bookshelf;
    }
}


