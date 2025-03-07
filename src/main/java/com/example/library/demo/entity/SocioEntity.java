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
import lombok.ToString;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "socio")
public class SocioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private Integer age;
	@Column(nullable = false)
	private LocalDate start;
	
	@Column(nullable = false)
	private LocalDate toUp;
	
	@OneToMany(mappedBy = "idSocio", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BookLoanEntity> bookLoans;
	
	@OneToMany(mappedBy = "idSocio", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DebtEntity> debts;
}
