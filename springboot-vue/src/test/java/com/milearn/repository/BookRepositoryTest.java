package com.milearn.repository;

import com.milearn.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void findAll() {
        System.out.println(bookRepository.findAll());
    }

    @Test
    void save() {
        Book book = new Book();
        book.setName("MybatisPlus");
        book.setAuthor("mimi");
        Book book1 = bookRepository.save(book);
        System.out.println(book1);

    }

    @Test
    void findByID() {
        Book book = bookRepository.findById(1).get();
        System.out.println(book);

    }

    @Test
    void update() {
        Book book = new Book();
        book.setId(1);
        book.setName("  ");
        book.setAuthor(" ");
        bookRepository.save(book);

    }

    @Test
    void delete() {
        bookRepository.deleteById(1);
    }


}