
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    boolean issued;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.issued = false;
    }

    void display() {
        System.out.println(id + " - " + title + " - "
                + (issued ? "Issued" : "Available"));
    }
}

public class LibraryManagementSystem {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int nextId = 1;

    static Book findBook(int id) {
        for (Book b : books) {
            if (b.id == id) return b;
        }
        return null;
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== LIBRARY MANAGEMENT ===");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    books.add(new Book(nextId++, title));
                    System.out.println("Book added!");
                    break;

                case 2:
                    if (books.isEmpty()) {
                        System.out.println("No books available.");
                    } else {
                        for (Book b : books) b.display();
                    }
                    break;

                case 3:
                    System.out.print("Enter book ID: ");
                    Book found = findBook(sc.nextInt());
                    if (found != null) found.display();
                    else System.out.println("Book not found.");
                    break;

                case 4:
                    System.out.print("Enter book ID: ");
                    Book issue = findBook(sc.nextInt());
                    if (issue == null) {
                        System.out.println("Book not found.");
                    } else if (issue.issued) {
                        System.out.println("Already issued.");
                    } else {
                        issue.issued = true;
                        System.out.println("Book issued!");
                    }
                    break;

                case 5:
                    System.out.print("Enter book ID: ");
                    Book ret = findBook(sc.nextInt());
                    if (ret == null) {
                        System.out.println("Book not found.");
                    } else if (!ret.issued) {
                        System.out.println("Book was not issued.");
                    } else {
                        ret.issued = false;
                        System.out.println("Book returned!");
                    }
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}
