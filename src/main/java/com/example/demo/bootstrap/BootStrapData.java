package com.example.demo.bootstrap;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author james = new Author("James", "Stuart");
        Author adam = new Author("Adam", "Stuart");

        Book book1 = new Book("Title 1", "1234");
        Book book2 = new Book("Title 2", "5678");
        Book book3 = new Book("Title 3", "5678");
        Book book4 = new Book("Non exisiting one", "5678");

        james.getBooks().add(book1);
        james.getBooks().add(book2);

        adam.getBooks().add(book2);

        authorRepository.save(james);
        authorRepository.save(adam);

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);

        System.out.println("Bootstrap started...");
        System.out.println("Number of books in repository: " + bookRepository.count());
        System.out.println("Number of authors in repository: " + authorRepository.count());
    }
}