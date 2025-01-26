package com.example.books;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import lombok.*;

@Data
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BookDto {

    @JsonIgnore
    private Integer bookId;
     String title;
     String author;
     Double price;
     String category;

    public BookDto(Integer bookId, String title, String author, Double price, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.category = category;
    }
}
