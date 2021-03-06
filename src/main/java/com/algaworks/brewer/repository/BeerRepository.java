package com.algaworks.brewer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.brewer.model.Beer;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Long> {

	Optional<Beer> findBySku(String sku);
	
}
