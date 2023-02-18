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
	public ResponseEntity<String> cadastrar(@RequestBody Praias praias) {
	    boolean isNomeVazioOuNulo = praias.getNome() == null || praias.getNome().trim().isEmpty();
	    boolean isAcessVazioOuNulo = praias.getAcessibilidade() == null;
	    boolean isStatusVazioOuNulo = praias.getStatus() == null || praias.getStatus().trim().isEmpty();
	    
	    if (isStatusVazioOuNulo) {
	    	return ResponseEntity.badRequest().body("O campo Status é obrigatório.");
		}
	    
	    if (isAcessVazioOuNulo) {
	    	return ResponseEntity.badRequest().body("O campo Acessibilidade é obrigatório.");
		}

	    if (isNomeVazioOuNulo) {
	        return ResponseEntity.badRequest().body("O campo nome é obrigatório.");
	    } else {
	    	try {
	            boolean existe = service.existePraiasComNome(praias.getNome());
	            
	            if (existe) {
	                return ResponseEntity.badRequest().body("O nome da praia já existe. Por favor, escolha um nome diferente.");
	            } else {
	                service.salvar(praias);
	                return ResponseEntity.ok("Praia cadastrada com sucesso.");
	            }
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao cadastrar o bairro. Por favor, tente novamente mais tarde.");
			}
	    }
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
