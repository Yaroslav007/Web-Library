package db.service.impl;

import db.dao.AuthorDao;
import db.entity.Author;
import db.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorDao authorDao;

    @Override
    public void save(Author author) {
        authorDao.save(author);
    }

    @Override
    public List<Author> findAll() {
        return authorDao.findAll();
    }

    @Transactional
    @Override
    public Author getOne(int id) {
        Author author = authorDao.getOne(id);
        System.out.println(author.getBooks());
        return author;
    }

    @Override
    public void delete(Author author) {
        authorDao.delete(author);
    }

    @Override
    public List<Author> findAuthorByName(String name) {
        List<Author> authorByName = authorDao.findAuthorByName(name);
        return authorByName;
    }

    @Override
    public List<Author> older55() {
        Calendar yeasAgo = Calendar.getInstance();
        yeasAgo.add(Calendar.YEAR, -55);
        Date startDate = yeasAgo.getTime();
        List<Author> whrerAge55 = authorDao.older55(startDate);
        return whrerAge55;
    }

    @Transactional
    @Override
    public Author getAuthorWithAlmostBook(){
        List<Author> allAuthors = authorDao.findAll();
        Author result = allAuthors.get(0);
        for (Author author:allAuthors){
            if(author.getBooks().size()>result.getBooks().size()){
                result = author;
            }
        }
        return result;
    }
}
