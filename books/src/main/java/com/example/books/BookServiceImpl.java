package com.example.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {


    @Autowired
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;


    public BookServiceImpl(BookRepository bookRepository,BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper=bookMapper;
    }

    @Override
    public Integer getCountOfBooks(String author) {
        return bookRepository.get_books_by_author(author);
    }

    @Override
    public Integer getBookCount(String author) {
        return bookRepository.getBookCount(author);
    }

    @Override
    @Transactional //because we are referring to a query that is in the entity class
    //we don't use @Transactional for the other methods because they are directly creating custom queries
    public Integer getCountByAuthor(String author) {
        return bookRepository.getCountByAuthor(author);
    }

    @Override
    public List<BookEntity> getBooksByAuth(String author) {
        return bookRepository.getBooksByAuth(author);
    }

//    @Override
//    public BookEntity createBookDto(BookDto bookDto) {
//        BookEntity bookEntity = new BookEntity();
//        bookEntity.setTitle(bookDto.getTitle());
//        bookEntity.setAuthor(bookDto.getAuthor());
//        bookEntity.setPrice(bookDto.getPrice());
//        bookEntity.setCategory(bookDto.getCategory());
//        return bookRepository.save(bookEntity);
//    }

//    @Override
//    public BookEntity createBook(BookEntity bookEntity) {
//        return bookRepository.save(bookEntity);
//    }

    @Override
    public BookEntity createBookCorrect(BookDto bookDto) {
        BookEntity bookEntity = bookMapper.bookEntity(bookDto);
        return bookRepository.save(bookEntity);
    }

}
