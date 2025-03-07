package com.example.library.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.demo.entity.BookEntity;

/**
 * @author alxyg
 */
public interface BookRepository extends JpaRepository<BookEntity, Long> {
	
	Optional<BookEntity> findById(Long id);
	List<BookEntity> findByTitleContainingIgnoreCase(String title);
	List<BookEntity> findByAuthorContainingIgnoreCase(String author);
	void deleteById(Long id);
}
