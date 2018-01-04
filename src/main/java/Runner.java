
import db.dao.AuthorDao;
import db.dao.BookDao;
import db.dao.GenericDao;
import db.entity.Author;
import db.entity.Book;
import utills.Scan;
import java.util.Collections;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        GenericDao.openFactory();

        while (true) {
            int shoice = Scan.scannerInt("      Please, make your choise:" + "\n" +
                        "1 - add book" + "\n" +
                        "2 - remove book" + "\n" +
                        "3 - update the name of book" + "\n" +
                        "4 - show all books" + "\n" +
                        "5 - show all authors");
            switch (shoice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    showAllBooks();
                    break;
                case 5:
                    showAllAuthors();
                    break;
                default:
                    System.out.println("close program");
                    GenericDao.closeFactory();
                    return;
            }
        }
    }

    private static void showAllAuthors() {
        AuthorDao authorDao = new AuthorDao();
        List<Author> allAuthor = authorDao.getAll();

        Collections.sort(allAuthor, Author.AuthorNameComparator);
        for(Author str: allAuthor){
            System.out.println(str);
        }
    }

    private static void showAllBooks() {
        BookDao dao = new BookDao();
        List<Book> all = dao.getAll();

        Collections.sort(all, Book.BookNameComparator);
        for(Book str: all){
            System.out.println(str);
        }

    }

    private static void updateBook() {
        String bName= Scan.scannerString("Write the name of book");
        BookDao bookDao = new BookDao();
        List<Book> books = bookDao.getByName(bName);
        if(books.size() > 1) {
            int bookId = Scan.scannerInt("Enter book id to edit: ");
            for(Book book : books) {
                if(book.getId()== bookId) {
                    String bNewName= Scan.scannerString("Write new name for the book:");
                    book.setBookName(bNewName);
                    bookDao.update(book);
                    System.out.println("Updata book, new name is: "+ bNewName);
                }
            }
        } else if(books.size() == 1){
            Book book = books.get(0);
            String bNewName= Scan.scannerString("Write new name for the book:");
            book.setBookName(bNewName);
            bookDao.update(book);
            System.out.println("Updata book, new name is: "+ bNewName);
        }else{
            System.out.println("No such book with this name");
        }
    }

    private static void removeBook() {
        String bName= Scan.scannerString("Write the name of book");
        BookDao bookDao = new BookDao();
        AuthorDao authorDao = new AuthorDao();
        List<Book> books = bookDao.getByName(bName);
        if(books.size() > 1) {
            System.out.println("As you can see, we have a few books that contain such a name");
            int bookId = Scan.scannerInt("Please, Enter book id to delete: ");
            for(Book book : books) {
                if(book.getId()== bookId) {
                    Author author = book.getAuthor();
                    bookDao.remove(book);
                    authorDao.remove(author);
                    System.out.println("Author and book with title " + bName + "was removed");
                }
            }
        } else if(books.size() == 1){
            Book book = books.get(0);
            Author author = book.getAuthor();
            bookDao.remove(book);
            authorDao.remove(author);
            System.out.println("Book with title " + bName + "was removed");
        }else{
            System.out.println("No such book with this name");
        }
    }

    private static void addBook() {
        String bName = Scan.scannerString("Wtrite the name of book: ");
        Book book = new Book(bName);

        BookDao dao = new BookDao();
        AuthorDao authorDao = new AuthorDao();

        String aName = Scan.scannerString("Wtrite the name of author: ");
        String aSurname = Scan.scannerString("Wtrite the surname of author: ");
        Author author = new Author(aName, aSurname);
        System.out.println("A new book has been added");

        authorDao.save(author);
        book.setAuthor(author);
        dao.save(book);

    }
}
