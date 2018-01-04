package db.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Comparator;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Book{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "book_name")
    private String bookName;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    private Author author;

    public Book(String name) {
        this.bookName = name;
    }

    public static Comparator<Book> BookNameComparator = new Comparator<Book>() {

        public int compare(Book s1, Book s2) {
            String BookName1 = s1.getBookName().toUpperCase();
            String BookName2 = s2.getBookName().toUpperCase();

            return BookName1.compareTo(BookName2);
        }
    };


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author=" + author +
                '}';
    }
}

