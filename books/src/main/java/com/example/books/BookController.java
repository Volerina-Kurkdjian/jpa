package com.example.books;


import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    public BookController(BookService bookService,BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper=bookMapper;
    }

    @GetMapping("/count/{author}")
    public ResponseEntity<Integer> getCountOfBooks(@PathVariable String author) {
        Integer count = bookService.getCountOfBooks(author);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/getBookCount/{author}")
    public ResponseEntity<Integer> getBookCount(@PathVariable String author) {
        Integer count = bookService.getBookCount(author);
        return ResponseEntity.ok(count);
    }


    @GetMapping("/getCountByAuthor/{author}")
    public ResponseEntity<Integer> getCountByAuthor(@PathVariable String author) {
        Integer count = bookService.getCountByAuthor(author);
        return ResponseEntity.ok(count);
    }

//    @GetMapping("/books-by-author/{author}")
//    public ResponseEntity<List<BookEntity>> getBooksByAuth(@PathVariable String author) {
//        List<BookEntity> books = bookService.getBooksByAuth(author);
//        return ResponseEntity.ok(books);
//    }

//    @PostMapping
//    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
//        BookEntity createdBook = bookService.createBook(bookDto);
//        BookDto createdBookDto = BookDto.builder()
//                .bookId(createdBook.getBookId())
//                .title(createdBook.getTitle())
//                .author(createdBook.getAuthor())
//                .price(createdBook.getPrice())
//                .category(createdBook.getCategory())
//                .build();
//        return ResponseEntity.ok(createdBookDto);
//    }

//    @GetMapping("/books-by-author/{author}")
//    public ResponseEntity<List<BookDto>> getBooksByAuth(@PathVariable String author) {
//        List<BookDto> bookDtos = bookService.getBooksByAuth(author).stream().map(book -> {
//            BookDto bookDto = new BookDto();
//            bookDto.setBookId(book.getBookId());
//            bookDto.setTitle(book.getTitle());
//            bookDto.setAuthor(book.getAuthor());
//            bookDto.setPrice(book.getPrice());
//            bookDto.setCategory(book.getCategory());
//            return bookDto;
//        }).collect(Collectors.toList());
//        return ResponseEntity.ok(bookDtos);
//    }
//
//    @PostMapping
//    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
//        BookEntity createdBook = bookService.createBook(bookDto);
//        BookDto createdBookDto = new BookDto();
//        createdBookDto.setBookId(createdBook.getBookId());
//        createdBookDto.setTitle(createdBook.getTitle());
//        createdBookDto.setAuthor(createdBook.getAuthor());
//        createdBookDto.setPrice(createdBook.getPrice());
//        createdBookDto.setCategory(createdBook.getCategory());
//        return ResponseEntity.ok(createdBookDto);
//    }

//    @GetMapping("/books-by-author/{author}")
//    public ResponseEntity<List<BookDto>> getBooksByAuth(@PathVariable String author) {
//        List<BookEntity> bookEntities = bookService.getBooksByAuth(author);
//        List<BookDto> bookDtos = new ArrayList<>();
//
//        for (BookEntity book : bookEntities) {
//            BookDto bookDto = new BookDto();
//            bookDto.setBookId(book.getBookId());
//            bookDto.setTitle(book.getTitle());
//            bookDto.setAuthor(book.getAuthor());
//            bookDto.setPrice(book.getPrice());
//            bookDto.setCategory(book.getCategory());
//            bookDtos.add(bookDto);
//        }
//
//        return ResponseEntity.ok(bookDtos);
//    }
//
//    @PostMapping("/dto")
//    public ResponseEntity<BookDto> createBookDto(@RequestBody BookDto bookDto) {
//        BookEntity createdBook = bookService.createBookDto(bookDto);
//        BookDto createdBookDto = new BookDto();
//        createdBookDto.setBookId(createdBook.getBookId());
//        createdBookDto.setTitle(createdBook.getTitle());
//        createdBookDto.setAuthor(createdBook.getAuthor());
//        createdBookDto.setPrice(createdBook.getPrice());
//        createdBookDto.setCategory(createdBook.getCategory());
//        return ResponseEntity.ok(createdBookDto);
//    }

    @GetMapping("/books-by-author/{author}")
    public ResponseEntity<List<BookEntity>> getBooksByAuth(@PathVariable String author) {
        List<BookEntity> bookEntities = bookService.getBooksByAuth(author);
        return ResponseEntity.ok(bookEntities);
    }

    @PostMapping
    public ResponseEntity<BookEntity> createBook(@RequestBody BookDto bookDto) {
        BookEntity createdBook = bookService.createBookCorrect(bookDto);
        return ResponseEntity.ok(createdBook);
    }
}
