package library_management;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.System;

public class Library {
    // attributes
    private ArrayList <Book> booksDataArrayList;


    // constructor
    public Library(ArrayList <Book> booksDataArrayList) {
        this.booksDataArrayList = booksDataArrayList;
    }


    // methods
    /* ======================================================= OPERATIONS ON THE LIBRARY ======================================================= */
    /* ========================================================================================================================================= */

    // method that checks if a book is in the database (array)
    // we check in the title list or in the isbn list because each book have an unique title or an unique isbn number
    public boolean isBookInDataBase(Book book) {
        String titleOfTheBook = book.getTitle();    // get the title of the book
        String isbnNumber = book.getIsbn();    // get the ISBN number of the book

        for (Book i: this.booksDataArrayList) {
            String title = i.getTitle();    // get the title of the i book
            String isbn = i.getIsbn();    // get the isbn number of the i book
            if (titleOfTheBook.equals(title) || isbnNumber.equals(isbn)) {    // if the title of the book or the isbn number of the book is equal to a title or an isbn number in the list
                return true;    // the book is in the database, so it returns True
            }
        }
        return false;     // if at the end of the loop the title and the isbn number is different from all the title and isbn number element of the list, then returns false
    }


    // method that adds a new book to the list of books
    public void addBook(Book book) {
        boolean checkBookInDataBase = this.isBookInDataBase(book);    // check if the book is already in the database
        // we use the keyword 'this' alone to refer to the current object (type Library) to which the method 'isBookInDatabase' is used

        if (checkBookInDataBase == true) {    // the book is in the database
            System.out.println();    // print blank line (for output aesthetic)
            System.out.println("The book is already in the database !");    // displays a message
            System.out.println();    // print blank line (for output aesthetic)
        } else {
            this.booksDataArrayList.add(book);    // adds the book in the database

            System.out.println();    // print blank line (for output aesthetic)
            System.out.println("Book added !");    // displays a message to confirm that the book is added to the database
            System.out.println();    // print blank line (for output aesthetic)
        }
    }


    // method to get the list of books available
    public ArrayList <Book> getBooksAvailable() {
        ArrayList <Book> booksAvailable = new ArrayList <Book> ();    // set an empty arrayList in which books available will be stored
        boolean availability;    // create a variable to store the value of book availability

        for (Book i: this.booksDataArrayList) {
            availability = i.getAvailability();    // get the value of i book availability
            if (availability == true) {    // if the book is available
                booksAvailable.add(i);    // we add the book to the arrayList created at the beginning
            }
        }

        return booksAvailable;    // returns the list of books available
    }


    // method to update a book's information
    public void udpateBookData(Book book) {
        //String title = book.getTitle();    // get the title of the book passed as parameter
        //String isbn = book.getIsbn();    // get the isbn number of the book passed as parameter
        int idx = 0;    // sets the index at 0
        //String iTitle;
        //String iIsbn;

        for (Book i: this.booksDataArrayList) {
            //iTitle = i.getTitle();    // get the title of the i book
            //iIsbn = i.getIsbn();    // get the isbn number of the i book
            
            if (i.equals(book)) {    // if the i book is the same as the book passes as parameter...
                this.booksDataArrayList.set(idx, book);    // modify the information of that book at index idx
            }

            idx += 1;    // increase the value of the index
        }
    }


    // method to udpate books availabilities when a book is BORROWED
    public int borrowBook(Book book) {
        boolean checkBookInDataBase = this.isBookInDataBase(book);    // check if the book is already in the database

        if (checkBookInDataBase == false) {
            System.out.println();    // print blank line (for output aesthetic)
            System.out.println("The book is not in the database !");    // displays a message if the book isn't in the database
            System.out.println();    // print blank line (for output aesthetic)
            return -1;    // returns -1 if the book is not in the database
        } else {
            boolean available = book.getAvailability();    // get the availability of the book passed as parameter

            for (Book i: this.booksDataArrayList) {
                // if i book is the same as book and the i book availability doesn't match the book availability (i book: true & book: false) and the availability of the book is false
                if (i.equals(book) && !(i.isBookAvailabilityMatches(book)) && available == false) {
                    book.setAvailability(false);    // set the availability of the book to false
                    this.udpateBookData(book);    // update the book's data

                    System.out.println();    // print blank line (for output aesthetic)
                    System.out.println("Book borrowed !");    // displays a message to confirm that the book is borrowed
                    System.out.println();    // print blank line (for output aesthetic)
                    return 0;    // return 0 if the change of the boolean value was made
                } 
            }
        }

        System.out.println();    // print blank line (for output aesthetic)
        System.out.println("The book is not available.");    // else, displays a message saying that the book isn't available
        System.out.println();    // print blank line (for output aesthetic)
        return 1;    // returns -1 if the change of the boolean value was not made
    }


    // method to update books availabilities when a book is RETURNED
    public int returnBook(Book book) {
        boolean checkBookInDataBase = this.isBookInDataBase(book);    // check if the book is already in the database

        if (checkBookInDataBase == false) {
            System.out.println();    // print blank line (for output aesthetic)
            System.out.println("The book is not in the database !");    // displays a message if the book isn't in the database
            System.out.println();    // print blank line (for output aesthetic)
            return -1;    // returns -1 if the book is not in the database
        } else {
            boolean available = book.getAvailability();    // get the availability of the book passed as parameter

            for (Book i: this.booksDataArrayList) {
                // if i book is the same as book and the i book availability doesn't match the book availability (i book: false & book: true) and the availability of the book is true
                if (i.equals(book) && !(i.isBookAvailabilityMatches(book)) && available == true) {
                    book.setAvailability(true);    // set the availability of the book to true
                    this.udpateBookData(book);    // update the book's data

                    System.out.println();    // print blank line (for output aesthetic)
                    System.out.println("Book returned !");    // displays a message to confirm that the book is borrowed
                    System.out.println();    // print blank line (for output aesthetic)
                    return 0;    // return 0 if the change of the boolean value was made
                } 
            }
        }

        System.out.println();    // print blank line (for output aesthetic)
        System.out.println("Error ! The book is already available.");    // else, displays a message saying that the book isn't available
        System.out.println();    // print blank line (for output aesthetic)
        return 1;    // returns -1 if the change of the boolean value was not made
    }


    // method to search a book by a given title
    public void searchBookByTitle(String title) {
        ArrayList <Book> titles = new ArrayList<>();    // create an empty arrayList <Book> to store all the books in the database that matches the given title of the book

        for (Book i: this.booksDataArrayList) {
            String iTitle = i.getTitle();    // get the title of the i book
            if (iTitle.equalsIgnoreCase(title)) {    // we use equalsIgnoreCase to ignore the case of the string when comparing the name of the i book and the name given as parameter
                titles.add(i);    // adds the book to the list created earlier, if the title of the i book matches the given title
            }
        }

        if (titles.isEmpty() == false) {    // if the arrayList of titles is not empty, we display the book corresponding to that title
            Book.printBooksDatabase(titles);
        } else {
            System.out.println("There is no book(s) corresponding to that title.");    // ohterwise, we display a message
        }
    }


    // method to search a book(s) by a given author
    public void searchBooksByAuthor(String author) {
        ArrayList <Book> authors = new ArrayList<>();    // create an empty arrayList <Book> to store all the books in the database that matches the given author of the book

        for (Book i: this.booksDataArrayList) {
            String iAuthor = i.getAuthor();    // get the author of the i book
            if (iAuthor.equalsIgnoreCase(author)) {    // we use equalsIgnoreCase to ignore the case of the string when comparing the author of the i book and the author given as parameter
                authors.add(i);    // adds the book to the list created earlier, if the author of the i book matches the given author
            }
        }

        if (authors.isEmpty() == false) {    // if the arrayList of authors is not empty, we display the book corresponding to that author
            Book.printBooksDatabase(authors);
        } else {
            System.out.println("There is no book(s) corresponding to that author.");    // ohterwise, we display a message
        }
    }


    // method to search a book by a given isbn number
    public void searchBookByISBN(String isbn) {
        ArrayList <Book> isbns = new ArrayList<>();    // create an empty arrayList <Book> to store all the books in the database that matches the given isbn of the book

        for (Book i: this.booksDataArrayList) {
            String iIsbn = i.getIsbn();    // get the isbn number of the i book
            if (iIsbn.equalsIgnoreCase(isbn)) {    // we use equalsIgnoreCase to ignore the case of the string when comparing the isbn of the i book and the isbn given as parameter
                isbns.add(i);    // adds the book to the list created earlier, if the isbn of the i book matches the given isbn
            }
        }

        if (isbns.isEmpty() == false) {    // if the arrayList of isbns is not empty, we display the book corresponding to that isbn
            Book.printBooksDatabase(isbns);
        } else {
            System.out.println("There is no book(s) corresponding to that isbn.");    // ohterwise, we display a message
        }
    }


    // method to search a book(s) by a given year
    public void searchBooksByYear(int year) {
        ArrayList <Book> years = new ArrayList<>();    // create an empty arrayList <Book> to store all the books in the database that matches the given year of the book

        for (Book i: this.booksDataArrayList) {
            int iYear = i.getYear();    // get the year of the i book
            if (iYear == year) {    // comparing the year of the i book and the year given as parameter
                years.add(i);    // adds the book to the list created earlier, if the year of the i book matches the given year
            }
        }

        if (years.isEmpty() == false) {    // if the arrayList of years is not empty, we display the book corresponding to that year
            Book.printBooksDatabase(years);
        } else {
            System.out.println("There is no book(s) corresponding to that year.");    // ohterwise, we display a message
        }
    }


    public void searchBooks(Scanner input) {
        displaySearchMenu();    // displays the menu
        System.out.print("Option: ");
        String option = input.nextLine();    // reads the user input for the option chosen
        System.out.println();

        while (!(option.equals("E"))) {    // as long as the user input isn't  the "E" option, which is the "return to main menu" option
            switch (option) {
                case "A":    // search a book by the title
                    System.out.print("Book title: ");
                    String bookTitle = input.nextLine();    // reads and takes the book title entered by the user

                    this.searchBookByTitle(bookTitle);    // displays the list of books matching the title or displays a message
                    break;    // to stop the execution and the test of the other cases
                case "B":
                    System.out.print("Book author: ");
                    String bookAuthor = input.nextLine();    // reads and takes the book author entered by the user

                    this.searchBooksByAuthor(bookAuthor);    // displays the list of books matching the author or displays a message
                    break;    // to stop the execution and the test of the other cases
                case "C":
                    System.out.print("Book ISBN: ");
                    String bookIsbn = input.nextLine();    // reads and takes the book isbn number entered by the user

                    this.searchBookByISBN(bookIsbn);    // displays the list of books matching the isbn number or displays a message
                    break;    // to stop the execution and the test of the other cases
                case "D":
                    System.out.print("Book year: ");
                    int bookYear = input.nextInt();    // reads and takes the book year entered by the user
                    input.nextLine();    // to place the cursor at the next line

                    this.searchBooksByYear(bookYear);    // displays the list of books matching the year or displays a message
                    break;    // to stop the execution and the test of the other cases
                default:
                    System.out.println("Your input isn't an option that was listed.");    // warns the user that the option he entered is not valid
            }

            System.out.println();
            displaySearchMenu();    // displays the menu
            System.out.print("Option: ");
            option = input.nextLine();    // reads the user input for the option chosen
            System.out.println();
        }
    } 




    /* ======================================================= DISPLAYS/ INPUTS METHODS =================================================== */
    /* =================================================================================================================================== */

    // method to display a book database of a library in a table format
    public void printBooksDatabase() {
        System.out.println("ID\t\tTitle\t\tAuthor\t\tISBN\t\tYear\t\tAvailable");

        for (Book i: this.booksDataArrayList) {
            if (i != null) {
                System.out.println(
                    i.getID() + "\t\t" + i.getTitle() + "\t" + i.getAuthor() + "\t" + i.getIsbn() + "\t" + i.getYear() + "\t\t" + i.getAvailability()
                );
            }
        }
    }


    // method to let the user enter a book information
    public static Book inputBook(Scanner input) {
        System.out.print("Book ID: ");
        int id = input.nextInt();    // reads the book's id entered by the user
        input.nextLine();    // to place the cursor at the next line

        System.out.print("Book title: ");
        String title = input.nextLine();    // reads the book's title entered by the user

        System.out.print("Book author: ");
        String author = input.nextLine();    // reads the book's author entered by the user

        System.out.print("Book ISBN: ");
        String isbn = input.nextLine();    // reads the book's isbn number entered by the user

        System.out.print("Book year: ");
        int year = input.nextInt();    // reads the book year entered by the user
        input.nextLine();    // to place the cursor at the next line

        System.out.println();
        System.out.println("Write true if the book is returned, otherwise write false if the book is borrowed.");
        System.out.println("Choose the boolean value if you're just adding a book.");
        System.out.print("Book availability (true/false): ");
        boolean availability = input.nextBoolean();    // reads the book's availability entered by the user
        input.nextLine();    // to place the cursor at the next line

        return new Book(id, title, author, isbn, year, availability);    // returns a book with the information entered by the user
    }


    // method to display the menu
    public static void displayMenu() {
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Select an option: ");
        System.out.println("A: add a book");
        System.out.println("B: get the list of books available");
        System.out.println("C: borrow a book");
        System.out.println("D: return a book");
        System.out.println("E: search a book");
        System.out.println("F: show the books database");
        System.out.println("Q: exit");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.print("Option: ");
    }


    // method to display the menu for searching a book
    public static void displaySearchMenu() {
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Select an option: ");
        System.out.println("A: search a book by title");
        System.out.println("B: search books by author");
        System.out.println("C: search a book by isbn");
        System.out.println("D: search books by year");
        System.out.println("E: return to main menu");
        System.out.println("---------------------------------------------------------------------------------------------");
    }








    /* ======================================================= MAIN METHOD =============================================================== */
    /* =================================================================================================================================== */

    public static void main(String[] args) {
        ArrayList <Book> booksDatabase = new ArrayList<Book>(
            Arrays.asList(
                new Book(1, "titleOne", "authorOne", "4194395944", 1995, false),
                new Book(2, "titleTwo", "authorTwo", "7567497358", 2004, true),
                new Book(3, "titleThree", "authorThree", "8353129337", 2020, false),
                new Book(4, "titleFour", "authorFour", "0018434724", 2017, false),
                new Book(5, "titleFive", "authorFive", "6300016501", 2014, true)
            )
        );    // the database
        Library theLibrary = new Library(booksDatabase);    // connecting the database to the library
        Scanner input = new Scanner(System.in);    // create a new Scanner object to read the user input

        displayMenu();    // displays the menu
        String option = input.nextLine();    // let the user enter an option
        System.out.println();

        while (!(option.equals("Q"))) {    // loop as long as the user doesn't choose to quit
            switch (option) {
                case "A":    // add a book option
                    Book aBook = inputBook(input);    // let the user enter a book information to add to the database
                    theLibrary.addBook(aBook);    // adds the book to the library (database)
                    break;    // to stop the execution and the test of the other cases
                case "B":    // get the list of available books option
                    System.out.println("List of available books: ");
                    Book.printBooksDatabase(theLibrary.getBooksAvailable());    // displays all the books available
                    break;    // to stop the execution and the test of the other cases
                case "C":    // borrow a book option
                    aBook = inputBook(input);    // let the user enter a book information to add to the database
                    theLibrary.borrowBook(aBook);    // sets the availability of the book to false because the book is borrowed
                    break;    // to stop the execution and the test of the other cases
                case "D":    // return a book option
                    aBook = inputBook(input);    // let the user enter a book information to add to the database
                    theLibrary.returnBook(aBook);    // sets the availability of the book to true because the book is returned
                    break;    // to stop the execution and the test of the other cases
                case "E":
                    theLibrary.searchBooks(input);    // displays the menu for searching selection (by title, ..., by year)
                    break;
                case "F":
                    theLibrary.printBooksDatabase();    // displays the library database (table of books)
                    break;
                default:
                    System.out.println("Your input isn't an option that was listed.");    // warns the user that the option he entered is not valid
            }
            
            System.out.println();
            displayMenu();    // displays the menu
            option = input.nextLine();    // let the user enter an option
            System.out.println();
        }
       
        System.out.println("Library exit.");
        input.close();    // close the scanner
    }
}
