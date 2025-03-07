package com.example.library.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.library.demo.entity.BookLoanEntity;
import com.example.library.demo.entity.SocioEntity;


/**
 * 
 * @Author alxyg
 */
public interface BookLoanRepository extends JpaRepository<BookLoanEntity, Long>{

	Optional<BookLoanEntity> findById(Long id);
	
	List<BookLoanEntity> findByIdSocio(SocioEntity idSocio);
	
	@Modifying
	@Query("UPDATE BookLoanEntity b SET b.returnDate = :newReturnDate WHERE b.id = :loanId ")
	void extendLoan(@Param("loanId") Long loanId, @Param("newReturnDate") LocalDate newReturnDate);

	@Query("SELECT b FROM BookLoanEntity b WHERE b.idSocio.id = :socioId AND b.returnDate > :currentDate")
	List<BookLoanEntity> findActiveLoansBySocioId(@Param("socioId") Long socioId, 
																						@Param("currentDate")  LocalDate currentDate);
	
	@Query("SELECT COUNT(b) FROM BookLoanEntity b WHERE b.idSocio.id = :socioId AND b.returnDate > :currentDate")
	int countActiveLoansBySocioId(@Param("socioId") Long socioId,
															@Param("currentDate") LocalDate currentDate);
	
	@Query("SELECT b FROM BookLoanEntity b WHERE b.idSocio.id = :socioId AND b.returnDate < :currentDate AND b.returned = false")
	List<BookLoanEntity> findOverdueLoansById(@Param("socioId") Long socioId,
																			@Param("currentDate") LocalDate currentDate);
	
	@Query("SELECT b FROM BookLoanEntity b WHERE b.returnDate < :currentDate AND b.returned = false")
	List<BookLoanEntity> findOverdueLoans(@Param("currentDate") LocalDate currentDate);
	
	@Modifying
	@Query("UPDATE BookLoanEntity b SET b.returned = true WHERE b.id = :loanId")
	void markLoanAsReturned(@Param("loanId") Long loanId);
}
