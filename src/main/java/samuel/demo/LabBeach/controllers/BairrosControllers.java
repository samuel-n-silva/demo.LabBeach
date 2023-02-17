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
import org.springframework.web.bind.annotation.RestController;

import samuel.demo.LabBeach.models.Bairros;
import samuel.demo.LabBeach.services.BairrosService;

@RestController
@RequestMapping(value="/api/bairros")
public class BairrosControllers {
	@Autowired
	BairrosService service;
	
	@PostMapping
	public void cadastrar(@RequestBody Bairros bairros) {
		service.salvar(bairros);
	}
	
	@GetMapping
	public List<Bairros> listarBairros(){
		return service.listarBairros();
	}
	
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.deleteById(id);
    }
    
	@PutMapping("/{id}")
	public void atualizar(@PathVariable Long id, @RequestBody Bairros bairros) {
		service.atualizar(id, bairros);
	}
}
