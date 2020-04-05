package com.example.demo.repositories;

import com.example.demo.model.Author;
import org.springframework.data.repository.CrudRepository;
// ctrl + b
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
