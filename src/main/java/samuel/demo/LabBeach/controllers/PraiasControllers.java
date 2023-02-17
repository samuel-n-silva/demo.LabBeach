package samuel.demo.LabBeach.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import samuel.demo.LabBeach.models.Praias;
import samuel.demo.LabBeach.services.PraiasService;

@RestController
@RequestMapping(value="/api")
public class PraiasControllers {
	@Autowired
	PraiasService service;
	
	@GetMapping(value="/praias")
	public List<Praias> listarPraias(){
		return service.listarPraias();
	}
}
