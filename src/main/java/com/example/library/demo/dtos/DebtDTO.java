package com.example.library.demo.dtos;

import java.time.LocalDate;

/**
 * 
 * @Author alxyg
 */
public record DebtDTO(
		Long id,
		Long idSocio,
		Long idBookLoan,
		Double amount, 
		LocalDate createdAt
		) {

}
