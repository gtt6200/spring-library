package com.example.library.demo.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author alxyg
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BookLoan")
public class BookLoanEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private LocalDate loanDate;
	
	@Column(nullable = false)
	private LocalDate returnDate;
	
	@Column(nullable = false)
	private boolean returned;

	@ManyToOne
	@JoinColumn(name = "id_socio", nullable = false)
	private SocioEntity idSocio;
	
	@ManyToOne
	@JoinColumn(name = "id_book", nullable = false)
	private BookEntity idBook;
	
	@OneToMany(mappedBy = "idBookLoan", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DebtEntity> debts;

}
