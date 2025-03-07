package com.example.library.demo.dtos;

import java.time.LocalDate;

/**
 * 
 * @Author alxyg
 */
public record SocioDTO(
		Long id,
		String name,
		String lastName,
		LocalDate start,
		LocalDate toUp
		) {}
