package db.dao;

import db.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {


    @Query("SELECT b FROM Book b WHERE b.bookName LIKE %:name%")
    List<Book> findBookByName(@Param("name") String name);

    @Query("select b from Book b where b.id = :bookId")
    Book getOne(@Param("bookId") Integer bookId);

    @Query("SELECT COUNT(id) FROM Book b WHERE b.genre LIKE ?1")
    Integer numberBookByGenre(String genre);

}
