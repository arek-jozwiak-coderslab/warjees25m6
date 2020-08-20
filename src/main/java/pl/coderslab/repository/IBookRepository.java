package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Category;
import pl.coderslab.model.Publisher;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {














    List<Book> findAllByTitle(String title);

    List<Book> findAllByCategory(Category category);

    List<Book> findAllByCategoryId(long id);

    List<Book> findAllByAuthorsContains(Author author);

    List<Book> findAllByPublisher(Author author);

    List<Book> findAllByRating(int rating);

    Book findFirstByCategoryOrderByTitle(Category category);

    @Query(value = "select b from Book b where b.title=?1")
    List<Book> findByHaryPoter(String title);

    @Query(value = "select b from Book b where b.category=?1")
    List<Book> findByCat(Category category);

    @Query(value = "select b from Book b where b.rating>=?1 and b.rating<?2")
    List<Book> findByRat(int rat1, int rat2);

    @Query(value = "select b from Book b where b.publisher=?1")
    List<Book> findByPub(Publisher publisher);

    @Query(value = "select * from books where category_id=?1 order by title limit 1", nativeQuery = true)
    Book findFirstByCat(int categoryId);

}
