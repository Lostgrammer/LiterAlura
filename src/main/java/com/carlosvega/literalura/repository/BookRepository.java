package com.carlosvega.literalura.repository;

import com.carlosvega.literalura.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
