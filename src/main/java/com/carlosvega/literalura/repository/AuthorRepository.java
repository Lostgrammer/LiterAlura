package com.carlosvega.literalura.repository;

import com.carlosvega.literalura.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
