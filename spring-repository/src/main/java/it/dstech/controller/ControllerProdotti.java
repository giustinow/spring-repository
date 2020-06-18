package it.dstech.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.dstech.model.Prodotto;
import it.dstech.service.ServiceProdotto;

@Controller
public class ControllerProdotti {
	@Autowired
	private ServiceProdotto service;

	@RequestMapping(value = { "/", "/home"})
	public ModelAndView home() {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/azione", method = RequestMethod.POST)
	public ModelAndView azione(@RequestParam("azione") String azione, Map<String, Object> model) {
		if ("Aggiungi".equals(azione)) {
			Prodotto prodotto = new Prodotto();
			model.put("prodotto", prodotto);
			return new ModelAndView("aggiunta");
		}
		return new ModelAndView("stampa", "lista", service.listAll());
	}

	@RequestMapping(value = "/aggiunta", method = RequestMethod.POST)
	public ModelAndView aggiunta(@ModelAttribute("prodotto") Prodotto prodotto) {
		service.save(prodotto);
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/stampa", method = RequestMethod.POST)
	public ModelAndView stampa() {
		return new ModelAndView("stampa", "lista", service.listAll());
	}

	@RequestMapping(value = "/elimina")
	public ModelAndView elimina(@RequestParam("id") Long id) {
		service.delete(id);
		ModelAndView view = new ModelAndView("stampa");
		view.addObject("lista", service.listAll());
		return view;
	}

	@RequestMapping(value = "/modifica")
	public ModelAndView modifica(@RequestParam("id") Long id) {
		ModelAndView view = new ModelAndView("modifica");
		Prodotto prodotto = service.get(id);
		view.addObject("prodotto", prodotto);
		return view;
	}
	@RequestMapping(value = "/salva", method = RequestMethod.POST)
	public ModelAndView salvaModifica(@ModelAttribute("customer") Prodotto prodotto) {
		service.save(prodotto);
		return stampa();
	}
}
