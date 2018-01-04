package db.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "author_surname")
    private String authorSurname;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "author")
    List<Book> books = new ArrayList<>();

    public Author(String authorName, String authorSurname) {
        this.authorName = authorName;
        this.authorSurname = authorSurname;
    }
    public static Comparator<Author> AuthorNameComparator = new Comparator<Author>() {

        public int compare(Author s1, Author s2) {
            String authorName1 = s1.getAuthorName().toUpperCase();
            String authorName2 = s2.getAuthorName().toUpperCase();

            return authorName1.compareTo(authorName2);
        }
    };

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", authorSurname='" + authorSurname + '\'' +
                '}';
    }
}
