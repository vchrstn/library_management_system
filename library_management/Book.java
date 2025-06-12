package library_management;
import java.util.ArrayList;

public class Book {
    // attributes
    private int id;
    private String title;
    private String author;
    private String isbn;
    private int year;
    private boolean availability;

    // constructor
    public Book(int bookID, String bookTitle, String bookAuthor, String bookIsbn, int bookYear, boolean bookAvailability) {
        this.id = bookID;
        this.title = bookTitle;
        this.author = bookAuthor;
        this.isbn = bookIsbn;
        this.year = bookYear;
        this.availability = bookAvailability;
    }




    /* ======================================================= GETTERS AND SETTERS ======================================================= */
    /* =================================================================================================================================== */

    // method to get the book ID
    public int getID() {
        return id;    // returns the book's id
    }

    // method to set the id of the book
    public void setID(int newID) {
        this.id = newID;
    }

    // method to get the title of the book
    public String getTitle() {
        return title;    // returns the book's title
    }

    // method to set the title of a book
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    // method to get the author of the book
    public String getAuthor() {
        return author;    // returns the book's author
    }

    // method to set the author of a book
    public void setAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    // method to get the isbn number of a book
    public String getIsbn() {
        return isbn;    // returns the isbn number of a book
    }

    // method to set the isbn number of a book
    public void setIsbn(String newIsbn) {
        this.isbn = newIsbn;
    }

    // method to get the year the book was published
    public int getYear() {
        return year;    // returns the year
    }

    // method to set the year of a book
    public void setYear(int newYear) {
        this.year = newYear;
    }

    // method to get the availability of a book
    public boolean getAvailability() {
        return availability;    // returns the availability of a book
    }

    // method to set the availability of a book
    public void setAvailability(boolean newAvailability) {
        this.availability = newAvailability;
    }




    /* ======================================================= DISPLAYS METHODS ========================================================== */
    /* =================================================================================================================================== */

    // method to display a book's information
    public void printBookInformation() {
        System.out.println("ID: " + id + " - Title: " + title + " - Author: " + author + " - ISBN: " + isbn + " - Year: " + year + " - Available: " + availability);
    }

    // method to display a book in a list format
    public void printBookAsList() {
        System.out.println("[" + id + ", " + title + ", " + author + ", " + isbn + ", " + year + ", " + availability + "]");
    }

    // method to display a book database with an arrayList <Book> type
    public static void printBooksDatabase(ArrayList <Book> booksDatabase) {
        System.out.println("ID\t\tTitle\t\tAuthor\t\tISBN\t\tYear\t\tAvailable");

        for (Book i: booksDatabase) {
            if (i != null) {
                System.out.println(
                    i.getID() + "\t\t" + i.getTitle() + "\t" + i.getAuthor() + "\t" + i.getIsbn() + "\t" + i.getYear() + "\t\t" + i.getAvailability()
                );
            }
        }
    }




    /* ======================================================= OTHER METHODS ============================================================= */
    /* =================================================================================================================================== */

    // method to check if the availability of the current book is the same as the availability of the book passed as parameter
    public boolean isBookAvailabilityMatches(Book book) {
        if (this.getAvailability() == book.getAvailability()) {    // get the availability of the current book and the book passed as parameter then compare them
            return true;    // if the availabilities are equal, returns true
        } else {
            return false;    // else, returns false
        }
    }

    // method to check if the current book and the book passed as parameter are the same
    public boolean equals(Book book) {
        if (title.equals(book.getTitle()) && isbn.equals(book.getIsbn())) {    // we use the title and the isbn number because they are unique for each book
            return true;    // if the i book is the same as the book passes as parameter, returns true
        } else {
            return false;    // else, returns false
        }
    }
}
