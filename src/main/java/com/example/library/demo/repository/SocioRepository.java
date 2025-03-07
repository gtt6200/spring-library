package com.example.library.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.demo.entity.SocioEntity;

/**
 * @author alxyg
 */
@Repository
public interface SocioRepository extends JpaRepository<SocioEntity, Long>{

		Optional<SocioEntity> findById(Long id);
		
		List<SocioEntity> findByNameContainingIgnoreCase(String name);
		List<SocioEntity> findByLastNameContainingIgnoreCase(String lastName);
		List<SocioEntity> findByNameAndLastNameContainingIgnoreCase(String name, String lastName);
		
		void deleteById(Long id);
}
