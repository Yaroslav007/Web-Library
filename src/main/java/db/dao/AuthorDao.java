package db.dao;

import db.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface AuthorDao extends JpaRepository<Author, Integer> {

    @Query("select a from Author a where a.id = :authorId")
    Author getOne(@Param("authorId") Integer authorId);

    @Query("SELECT a FROM Author a WHERE a.authorName LIKE %?1")
    List<Author> findAuthorByName(String name);

    @Query("select a from Author a WHERE a.birthday>= :expDate ORDER BY a.birthday ASC")
    List<Author> older55(@Param("expDate") Date expDate);

}
