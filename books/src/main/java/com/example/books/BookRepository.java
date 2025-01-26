package com.example.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {

    //calling a stored procedure by mapping the method name same as procedure name
    @Procedure
    Integer get_books_by_author(String author);

    //calling a store procedure using procedureName, as value for the attribute
    @Procedure(procedureName = "get_books_by_author")
    Integer getBookCount(String author);

    //using @NamedStoreProcedureQuery annotation, use @Transactional in Service
    @Procedure(name="getBookCountByAuthor")
    Integer getCountByAuthor(@Param("auth") String author);

    //Using Query annotation only with procedures that take only input parameters, no output parameters
    @Query(value="call new_procedure22(:auth)",nativeQuery = true)
    List<BookEntity> getBooksByAuth(@Param("auth")String author);
}
