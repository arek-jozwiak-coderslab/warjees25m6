package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    EntityManager entityManager;

    public List<Book> findAll() {
        return entityManager.createQuery("SELECT b from Book b").getResultList();
    }

    public List<Book> getRatingList(int rating) {
        Query query = entityManager.createQuery("SELECT b from Book b where b.rating=:rat");
        query.setParameter("rat", rating);
        return query.getResultList();
    }

    public void save(Book book) {
        entityManager.persist(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book));
    }

    public List<Book> getBooksWithPublisher() {
        return entityManager.createQuery("select b from Book b join b.publisher").getResultList();
    }

    public List<Book> getBooksForPublisher(Publisher publisher) {
        Query query = entityManager.createQuery("select b from Book b where b.publisher = :publisher");
        query.setParameter("publisher", publisher);
        return query.getResultList();
    }

    public List<Book> getBooksForPublisherId(long id) {
        Query query = entityManager.createQuery("select b from Book b where b.publisher.id = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }

    public List<Book> getBooksForAuthor(Author author) {
        Query query = entityManager.createQuery("select b from Book b where :author member of b.authors");
        query.setParameter("author", author);
        return query.getResultList();
    }

    public List<Book> getBooksForAuthorById(long id) {
        Query query = entityManager.createQuery("select b from Book b join b.authors as au where au.id = : id");
        query.setParameter("id", id);
        return query.getResultList();
    }
}
