package it.dstech.repository;

import org.springframework.data.repository.CrudRepository;

import it.dstech.model.Prodotto;

public interface ProdottiRepository extends CrudRepository<Prodotto, Long> {

}
