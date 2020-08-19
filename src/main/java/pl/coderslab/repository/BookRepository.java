package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Category;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByTitle(String title);

    List<Book> findAllByCategory(Category category);

    List<Book> findAllByCategoryId(long id);

    List<Book> findAllByAuthorsContains(Author author);

    List<Book> findAllByPublisher(Author author);

    List<Book> findAllByRating(int rating);

    Book findFirstByCategoryOrderByTitle(Category category);

}
