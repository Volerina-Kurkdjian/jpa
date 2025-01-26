package com.example.books;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    Integer getCountOfBooks(String author);
    Integer getBookCount(String author);

    Integer getCountByAuthor( String author);

    List<BookEntity> getBooksByAuth(String author);


//    BookEntity createBook(BookEntity bookDto);
//
//    BookEntity createBookDto(BookDto bookDto);

    BookEntity createBookCorrect(BookDto bookDto);
}
