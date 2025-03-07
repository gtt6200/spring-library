package com.example.library.demo.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class BookEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String author;
	@Column(nullable = false)
	private LocalDate publishYear;
	@Column(nullable = false)
	private String editorial;
	
	@OneToMany(mappedBy = "idBook", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookLoanEntity> bookLoans;

}
