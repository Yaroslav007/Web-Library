package db.service;

import db.entity.Author;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface AuthorService {

    void save(Author author);

    List<Author> findAll();

    Author getOne(int id);

    void delete(Author author);

    List<Author> findAuthorByName(String name);

    List<Author> older55();

    Author getAuthorWithAlmostBook();
}
