package it.dstech.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.dstech.model.Prodotto;
import it.dstech.repository.ProdottiRepository;

@Service
@Transactional
public class ServiceProdotto {
	@Autowired ProdottiRepository repo;
	
	public void save(Prodotto prodotto) {
		repo.save(prodotto);
	}
	
	public List<Prodotto> listAll() {
		return (List<Prodotto>) repo.findAll();
	}
	
	public Prodotto get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
