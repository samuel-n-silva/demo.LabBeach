package samuel.demo.LabBeach.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import samuel.demo.LabBeach.models.Praias;
import samuel.demo.LabBeach.services.PraiasService;

@RestController
@RequestMapping(value="/api/praias")
public class PraiasControllers {
	@Autowired
	PraiasService service;
	
	@GetMapping
	public List<Praias> listarPraias(){
		return service.listarPraias();
	}
	
	@GetMapping(value="/status")
	public List<Praias> listarPraias(@RequestParam String status) {
	    return service.listarPraiasPorStatus(status);
	}
	
	@GetMapping(value="/acessibilidade")
	public List<Praias> listarPraias(@RequestParam Boolean acessibilidade) {
	    return service.listarPraiasComAcessibilidade(acessibilidade);
	}
	
	@PostMapping
	public void cadastrar(@RequestBody Praias praias) {
	    service.salvar(praias);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		service.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@PathVariable Long id, @RequestBody Praias praias) {
		service.atualizar(id, praias);
	}
}
