package com.example.demo_.dao;

import com.example.demo_.models.Book;
import com.example.demo_.models.SCard;
import com.example.demo_.models.TCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITCardRepository extends CrudRepository<TCard, Long> {
    List<SCard> findByDateInIsNull();

    List<SCard> findByDateInIsNotNull();

    @Query("SELECT s FROM SCard s WHERE s.book = :book AND s.dateIn > CURRENT_DATE")
    public List<TCard> findActiveLoansByBook(@Param("book") Book book);
}
