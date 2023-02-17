package samuel.demo.LabBeach.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import samuel.demo.LabBeach.models.Bairros;
import samuel.demo.LabBeach.services.BairrosService;

@RestController
@RequestMapping(value="/api")
public class BairrosControllers {
	@Autowired
	BairrosService service;
	
	@PostMapping(value="/bairros")
	public void cadastrar(@RequestBody Bairros bairros) {
		service.salvar(bairros);
	}
	
	@GetMapping(value="/bairros")
	public List<Bairros> listarBairros(){
		return service.listarBairros();
	}
	
    @DeleteMapping("/bairros/{id}")
    public void excluir(@PathVariable Long id) {
        service.deleteById(id);
    }
}
