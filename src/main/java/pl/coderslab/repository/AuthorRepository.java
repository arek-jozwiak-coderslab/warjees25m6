package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findAllByEmail(String email);

    List<Author> findAllByPesel(String pesel);

    List<Author> findAllByLastName(String lastName);

    List<Author> findByFirstNameAndLastNameAllIgnoreCase(String s1, String s2);

    @Query("select a from Author a where a.email LIKE ?1%")
    List<Author> getByEmailStart(String s);
}
