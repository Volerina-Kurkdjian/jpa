package com.example.books;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.persistence.NamedStoredProcedureQuery;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
//this is called from the Repository
@NamedStoredProcedureQuery(
        name="getBookCountByAuthor",
        procedureName = "get_books_by_author",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "auth",type=String.class),
                @StoredProcedureParameter(mode=ParameterMode.OUT,name = "total",type = Integer.class)
        }
)

@Entity
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @JsonIgnoreProperties
    private Integer bookId;
    private String title;
    private String author;
    @Column(name="cost")
    private Double price;
    private String category;

}
