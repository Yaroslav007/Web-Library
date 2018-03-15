package db.service.impl;

import db.dao.AuthorDao;
import db.dao.BookDao;
import db.entity.Author;
import db.entity.Book;
import db.service.AuthorService;
import db.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    AuthorService authorService;

    @Autowired
    private BookDao bookDao;

    @Override
    public void save(Book book) {
        bookDao.save(book);
    }

    @Transactional
    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Transactional
    @Override
    public Book getOne(int id) {
        Book one = bookDao.getOne(id);
        System.out.println(one.getAuthors());
        return one;
    }

    @Override
    public void delete(Book book) {
        bookDao.delete(book);
    }

    @Transactional
    @Override
    public List<Book> findBookByName(String name) {
        List<Book> userByNamme = bookDao.findBookByName(name);
        for (Book b:userByNamme){
            b.getAuthors();
        }
        return userByNamme;
    }
    @Transactional
    @Override
    public Set<Book> booksHasMoreAuthors(){
        Set<Book> resulte = new HashSet<>();

        List<Author> allaAuthors = authorService.findAll();
        for (Author author1:allaAuthors){
            if (author1.getBooks().size()>1){
                resulte.addAll(author1.getBooks());
            }
        }
        return resulte;
    }

    @Override
    public Integer numberBookByGenre(String genre) {
        return bookDao.numberBookByGenre(genre);
    }


}
