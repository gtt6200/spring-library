package com.example.library.demo.dtos;

import java.time.LocalDate;

/**
 * 
 * @Author alxyg
 */
public record BookDTO(
		Long id,
		String title,
		String author,
		LocalDate publishYear,
		String editorial
		) {

}
