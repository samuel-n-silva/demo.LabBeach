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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import samuel.demo.LabBeach.models.Bairros;
import samuel.demo.LabBeach.models.Praias;
import samuel.demo.LabBeach.services.BairrosService;
import samuel.demo.LabBeach.services.PraiasService;

@RestController
@RequestMapping(value="/api")
public class HomeControllers {
	@Autowired
	BairrosService serviceBairro;
	
	@Autowired
	PraiasService servicePraia;
	
	@PostMapping("/bairros")
	@Operation(
			description = "Cadastrar Bairro",
			responses = {
					@ApiResponse(responseCode = "200", ref = "sucessAPI"),
					@ApiResponse(responseCode = "400", ref = "badRequestAPI"),
					@ApiResponse(responseCode = "500", ref = "internalServerErrorAPI")
			}
	)
	public ResponseEntity<String> cadastrar(@RequestBody Bairros bairros) {
	    boolean isNomeVazioOuNulo = bairros.getNome() == null || bairros.getNome().trim().isEmpty();

	    if (isNomeVazioOuNulo) {
	        return ResponseEntity.badRequest().body("O campo nome é obrigatório.");
	    } else {
			try {
				boolean existe = serviceBairro.existeBairroComNome(bairros.getNome());
				
				if (existe) {
					return ResponseEntity.badRequest().body("O nome do bairro já existe. Por favor, escolha um nome diferente.");
				} else {
					serviceBairro.salvar(bairros);
					return ResponseEntity.ok("Bairro cadastrado com sucesso.");
				}
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao cadastrar o bairro. Por favor, tente novamente mais tarde.");
			}
	    }
	}
	
	@GetMapping("/bairros")
	public List<Bairros> listarBairros(){
		return serviceBairro.listarBairros();
	}
	
    @DeleteMapping("/bairros/{id}")
    public void excluirBairro(@PathVariable Long id) {
    	serviceBairro.deleteById(id);
    }
    
	@PutMapping("/bairros/{id}")
	public void atualizar(@PathVariable Long id, @RequestBody Bairros bairros) {
		serviceBairro.atualizar(id, bairros);
	}
	
	@GetMapping("/praias")
	public List<Praias> listarPraias(){
		return servicePraia.listarPraias();
	}
	
	@GetMapping(value="/praias/status")
	public List<Praias> listarPraias(@RequestParam String status) {
	    return servicePraia.listarPraiasPorStatus(status);
	}
	
	@GetMapping(value="/praias/acessibilidade")
	public List<Praias> listarPraias(@RequestParam Boolean acessibilidade) {
	    return servicePraia.listarPraiasComAcessibilidade(acessibilidade);
	}
	
	@PostMapping("/praias")
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
	            boolean existe = servicePraia.existePraiasComNome(praias.getNome());
	            
	            if (existe) {
	                return ResponseEntity.badRequest().body("O nome da praia já existe. Por favor, escolha um nome diferente.");
	            } else {
	            	servicePraia.salvar(praias);
	                return ResponseEntity.ok("Praia cadastrada com sucesso.");
	            }
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao cadastrar o bairro. Por favor, tente novamente mais tarde.");
			}
	    }
	}
	
	@DeleteMapping("/praias/{id}")
	public void excluirPraia(@PathVariable Long id) {
		servicePraia.deleteById(id);
	}
	
	@PutMapping("/praias/{id}")
	public void atualizar(@PathVariable Long id, @RequestBody Praias praias) {
		servicePraia.atualizar(id, praias);
	}
}
