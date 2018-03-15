package db.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

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

    @Column(name = "book_publicationDate")
    private Date publicationDate;

    @Column(name = "book_genre")
    private String genre;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="author_book",
            joinColumns=@JoinColumn(name="book_id"),
            inverseJoinColumns=@JoinColumn(name="author_id"))
    private List<Author> authors;

    public Book(String bookName, Date publicationDate, String genre) {
        this.bookName = bookName;
        this.publicationDate = publicationDate;
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        if (bookName != null && book.bookName != null && !bookName.equalsIgnoreCase(book.bookName)) {
            return false;
        }
        if (publicationDate != null && book.publicationDate != null
                && publicationDate.getTime() != book.publicationDate.getTime()) {
            return false;
        }
        return genre != null ? genre.equalsIgnoreCase(book.genre) : book.genre == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
        result = 31 * result + (publicationDate != null ? publicationDate.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", publicationDate=" + publicationDate +
                ", genre='" + genre + '\'' +
                ", authors= " + authors+ '\'' +
                '}';
    }
}

