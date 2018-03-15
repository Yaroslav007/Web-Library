package db.service;

import db.entity.Book;

import java.util.List;
import java.util.Set;

public interface BookService {

    void save(Book book);

    List<Book> findAll();

    Book getOne(int id);

    void delete(Book book);

    List<Book> findBookByName(String name);

    Set<Book> booksHasMoreAuthors();

    Integer numberBookByGenre(String genre);
}
