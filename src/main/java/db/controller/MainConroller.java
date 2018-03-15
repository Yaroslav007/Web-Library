package db.controller;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import db.dao.AuthorDao;
import db.entity.Author;
import db.entity.Book;
import db.service.AuthorService;
import db.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/")
public class MainConroller {

    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    @RequestMapping(value= "/", method = RequestMethod.GET)
    public String mainPage(ModelMap model, HttpSession session) {
        return "mainPage";
    }

    @RequestMapping(value= "/createBook", method = RequestMethod.GET)
    public String createBook() {
        return "createBook";
    }

    @RequestMapping(value= "/createAuthor", method = RequestMethod.GET)
    public String createAuthor() {
        return "createAuthor";
    }

    @RequestMapping(value= "/addAuthorToList", method = RequestMethod.POST)
    public String addAuthorToList(@RequestParam("book-id") Integer id,ModelMap model) {
        Book book = bookService.getOne(id);
        model.addAttribute("book",book);
        return "addAuthorToList";
    }

    @RequestMapping(value= "/updateB", method = RequestMethod.POST)
    public String updateB(@RequestParam("book-id") Integer id,ModelMap model) {
        Book book = bookService.getOne(id);
        model.addAttribute("book",book);
        return "updateBook";
    }

    @RequestMapping(value= "/updateBook",  method = RequestMethod.POST)
    public String updateBook(@RequestParam Integer id,@RequestParam String name,
                             @RequestParam String genre,
                             @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date publicationDate) {
        Book book = bookService.getOne(id);
        book.setBookName(name);
        book.setGenre(genre);
        book.setPublicationDate(publicationDate);
        bookService.save(book);
       return "mainPage";
    }

    @RequestMapping(value= "/findBook", method = RequestMethod.GET)
    public String findBook() {
        return "findBook";
    }

    @RequestMapping(value= "/saveBook", method = RequestMethod.POST)
    public String saveBook(@RequestParam String name, @RequestParam String genre,
                       @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date publicationDate){
        Book book = new Book(name,publicationDate,genre);
        List<Book> allbooks = bookService.findAll();
        if (!allbooks.contains(book)) {
            bookService.save(book);
            System.out.println("Book saved: " + book);
            return "mainPage";
        } else {
            System.out.println("Skip save Author, already exist");
            return "error";
        }
    }

    @RequestMapping(value= "/saveAuthor", method = RequestMethod.POST)
    public String saveAuthor(@RequestParam String name, @RequestParam String surname,
                           @RequestParam String gender, ModelMap model,
                             @RequestParam  @DateTimeFormat(pattern="yyyy-MM-dd")Date birthday){
        Author author = new Author(name,surname,gender,birthday);
        List<Author> allAuthors = authorService.findAll();

        if(!allAuthors.contains(author)) {
            authorService.save(author);
            System.out.println("Author was saved to database");
            return "mainPage";
        } else {
            System.out.println("Skip save Author, already exist");
            return "error";
        }
    }

    @RequestMapping(value= "/searchBook", method = RequestMethod.POST)
    public String searchBook(@RequestParam String name,ModelMap model){
        List<Book> books = bookService.findBookByName(name);
        model.addAttribute("books", books);
        return "findBook";
    }
    @RequestMapping(value= "/book-{id}", method = RequestMethod.GET)
    public String oneBook(@PathVariable("id") Integer id, ModelMap model) {
        Book book = bookService.getOne(id);
        List<Author> authors = book.getAuthors();
        model.addAttribute("authors",authors);
        model.addAttribute("book", book);
        return "book";
    }
    @RequestMapping(value= "/deleteBook", method = RequestMethod.GET)
    public String deleteBook(@RequestParam("book-id") Integer bookId, HttpSession session, ModelMap model){
        Book book = bookService.getOne(bookId);
        bookService.delete(book);
        System.out.println("Book deleted!");
        return "mainPage";
    }
    @RequestMapping(value= "/deleteFromAuthorsList", method = RequestMethod.GET)
    public String deleteFromAuthorsList(@RequestParam("book-id") Integer bookId,@RequestParam("author-id") Integer authorId){
        Book book = bookService.getOne(bookId);
        Author author = authorService.getOne(authorId);
        List<Author> authors = book.getAuthors();

        Iterator<Author> iter = authors.iterator();

        while (iter.hasNext()) {
            Author author1 = iter.next();
            if (author1.getId() == (author.getId())) {
                iter.remove();
            }
        }
        bookService.save(book);
        return "mainPage";
    }

    @RequestMapping(value= "/addAuthorToAlist", method = RequestMethod.POST)
    public String addAuthorToAlist(@RequestParam("book-id") Integer bookId,@RequestParam String name,
                                   @RequestParam String surname,@RequestParam String gender,
                                   @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date birthday){
        Author author = new Author(name,surname,gender,birthday);
        List<Author> allAuthors = authorService.findAll();
        System.out.println(allAuthors);
        if(!allAuthors.contains(author)) {
            System.out.println("Author was saved to database");
            authorService.save(author);
        }

        Book book = bookService.getOne(bookId);
        if (!book.getAuthors().contains(author)) {
            book.getAuthors().add(author);
            bookService.save(book);
        }
        return "mainPage";
    }
    //////////////// AUTHOR//////////

    @RequestMapping(value= "/findAuthor", method = RequestMethod.GET)
    public String findAuthor() {
        return "findAuthor";
    }

    @RequestMapping(value= "/searchAuthor", method = RequestMethod.POST)
    public String searchAuthor(@RequestParam String name,ModelMap model){
        List<Author> authors = authorService.findAuthorByName(name);
        model.addAttribute("authors", authors);
        return "findAuthor";
    }

    @RequestMapping(value= "/author-{id}", method = RequestMethod.GET)
    public String oneAuthor(@PathVariable("id") Integer id, ModelMap model) {
        Author author = authorService.getOne(id);
        List<Book> books = author.getBooks();
        model.addAttribute("author",author);
        model.addAttribute("books", books);
        return "author";
    }

    @RequestMapping(value= "/deleteFromBooksList", method = RequestMethod.GET)
    public String deleteFromBooksList(@RequestParam("book-id") Integer bookId,
                                      @RequestParam("author-id") Integer authorId,ModelMap model){
        Book book = bookService.getOne(bookId);
        Author author = authorService.getOne(authorId);

        List<Book> books = author.getBooks();
        Iterator<Book> iter = books.iterator();
        while (iter.hasNext()) {
            Book book1 = iter.next();
            if (book1.getId() == (book.getId())) {
                iter.remove();
            }
        }
        authorService.save(author);
        return "mainPage";
    }

    @RequestMapping(value= "/deleteAuthor", method = RequestMethod.GET)
    public String deleteAuthor(@RequestParam("author-id") Integer authorId, ModelMap model){
        Author author = authorService.getOne(authorId);
        authorService.delete(author);
        System.out.println("Author deleted!");
        return "mainPage";
    }

    @RequestMapping(value= "/updateA", method = RequestMethod.POST)
    public String updateA(@RequestParam("author-id") Integer id,ModelMap model) {
        Author author = authorService.getOne(id);
        model.addAttribute("author",author);
        return "updateAuthor";
    }

    @RequestMapping(value= "/updateAuthor",  method = RequestMethod.POST)
    public String updateAuthor(@RequestParam Integer id,@RequestParam String name, @RequestParam String surname,
                               @RequestParam String gender, ModelMap model,
                               @RequestParam  @DateTimeFormat(pattern="yyyy-MM-dd")Date birthday) {
        Author author = authorService.getOne(id);
        author.setAuthorName(name);
        author.setAuthorSurname(surname);
        author.setGender(gender);
        author.setBirthday(birthday);
        authorService.save(author);
        return "mainPage";
    }

    @RequestMapping(value= "/addBookToList", method = RequestMethod.POST)
    public String addBookToList(@RequestParam("author-id") Integer id,ModelMap model) {
        Author author = authorService.getOne(id);
        model.addAttribute("author",author);
        return "addBookToList";
    }

    @RequestMapping(value= "/addBookToAList", method = RequestMethod.POST)
    public String addBookToAList(@RequestParam("author-id") Integer authorId,@RequestParam String name,
                                 @RequestParam String genre,
                                 @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd")  Date publicationDate){
        Book book = new Book(name,publicationDate,genre);
        List<Book> bookList = bookService.findAll();
        if (!bookList.contains(book)){
            bookService.save(book);
        }
        Author author = authorService.getOne(authorId);
        if (!author.getBooks().contains(book)){
            author.getBooks().add(book);
            authorService.save(author);
        }
        return "mainPage";
    }
//____________________________TASKS__________________________________


    @RequestMapping(value= "/task2", method = RequestMethod.GET)
    public String older55(ModelMap model){
        List<Author> authors = authorService.older55();
         model.addAttribute("authors",authors);
        return "findAuthor";
    }


    @RequestMapping(value= "/task3", method = RequestMethod.GET)
    public String bookHasMoreAuthors(ModelMap model){
        Set<Book> books = bookService.booksHasMoreAuthors();
        model.addAttribute("books", books);
        return "findBook";
    }

    @RequestMapping(value= "/task4", method = RequestMethod.GET)
        public String getAuthorWithAlmosrBook(ModelMap model){
        Author author = authorService.getAuthorWithAlmostBook();
        List<Book> books = author.getBooks();
        model.addAttribute("author",author);
        model.addAttribute("books", books);
        return "author";
    }

    @RequestMapping(value= "/task5", method = RequestMethod.GET)
    public String numberBooksByGenre(ModelMap model){
        return "numberBooksByGenre";
    }

    @RequestMapping(value= "/searchNumberByGenre", method = RequestMethod.GET)
    public String searchNumberByGenre( @RequestParam String genre, ModelMap model){
        Integer numberBookByGenre = bookService.numberBookByGenre(genre);
        model.addAttribute("number", numberBookByGenre);
        model.addAttribute("genre", genre);
        return "numberBooksByGenre";
    }
}
