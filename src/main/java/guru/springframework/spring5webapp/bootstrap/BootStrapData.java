package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by TanVOD on Apr, 2021
 */

@Component
public class BootStrapData implements CommandLineRunner {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author tan  = new Author("Tan", "Vo");
        Book kafka = new Book("kafka", "123123");

        tan.getBooks().add(kafka);
        kafka.getAuthors().add(tan);

        authorRepository.save(tan);
        bookRepository.save(kafka);




        Author vo  = new Author("vo", "Vo");
        Book abc = new Book("abc", "123132");

        vo.getBooks().add(abc);
        abc.getAuthors().add(vo);

        authorRepository.save(vo);
        bookRepository.save(abc);

        System.out.println("_______"+bookRepository.count());
        System.out.println("_______"+authorRepository.count());
    }
}
