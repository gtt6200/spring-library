package com.example.library.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @Author alxyg
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "debt")
public class DebtEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_socio", nullable = false)
	private SocioEntity idSocio;
	@ManyToOne
	@JoinColumn(name = "id_book_loan", nullable = false)
	private BookLoanEntity idBookLoan;
	@Column(nullable = false)
	private Double amount;
	@Column(nullable = false)
	private boolean paid;
	@Column(nullable = false)
	private LocalDate createdAt;
	
	

}
