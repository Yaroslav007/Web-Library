package db.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
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

    @Column(name = "author_gender")
    private String gender;

    @Column(name = "author_birthday")
    private Date birthday;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="author_book",
            joinColumns=@JoinColumn(name="author_id"),
            inverseJoinColumns=@JoinColumn(name="book_id"))
    private List<Book> books;

    public Author(String authorName, String authorSurname, String gender, Date birthday) {
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.gender = gender;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (authorName != null && author.authorName != null && !authorName.equalsIgnoreCase(author.authorName)) {
            return false;
        }
        if (authorSurname != null &&  author.authorSurname != null
                && !authorSurname.equalsIgnoreCase(author.authorSurname)) {
            return false;
        }
        if (gender != null && author.gender != null && !gender.equalsIgnoreCase(author.gender)) {
            return false;
        }
        return birthday != null ? birthday.equals(author.birthday) : author.birthday == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + authorName.hashCode();
        result = 31 * result + authorSurname.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + birthday.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", authorSurname='" + authorSurname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
