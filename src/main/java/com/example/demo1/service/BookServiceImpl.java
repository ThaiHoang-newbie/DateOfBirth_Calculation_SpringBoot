package com.example.demo1.service;

import com.example.demo1.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {


    @Override
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        Book book1 = new Book();
        book1.setId(1L);
        book1.setName("Book name 1");
        books.add(book1);
        return books;
    }

}
