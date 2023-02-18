package samuel.demo.LabBeach.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<String> cadastrar(@RequestBody Bairros bairros) {
	    boolean isNomeVazioOuNulo = bairros.getNome() == null || bairros.getNome().trim().isEmpty();

	    if (isNomeVazioOuNulo) {
	        return ResponseEntity.badRequest().body("O campo nome é obrigatório.");
	    } else {
			try {
				boolean existe = service.existeBairroComNome(bairros.getNome());
				
				if (existe) {
					return ResponseEntity.badRequest().body("O nome do bairro já existe. Por favor, escolha um nome diferente.");
				} else {
					service.salvar(bairros);
					return ResponseEntity.ok("Bairro cadastrado com sucesso.");
				}
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao cadastrar o bairro. Por favor, tente novamente mais tarde.");
			}
	    }
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
