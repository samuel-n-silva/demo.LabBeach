package samuel.demo.LabBeach.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samuel.demo.LabBeach.models.Praias;
import samuel.demo.LabBeach.repositories.PraiasRepository;

@Service
public class PraiasService {
	@Autowired
	PraiasRepository praiasRepository;
	
	public void salvar(Praias praias) {
		praiasRepository.save(praias);
	}
	
	public List<Praias> listarPraias(){
		return (List<Praias>) praiasRepository.findAll();
	}
	
	public void deleteById(Long id) {
		praiasRepository.deleteById(id);
    }
	
	public Praias atualizar(Long id, Praias praias) {
		Praias exPraia = praiasRepository.findById(id).get();
		exPraia.setNome(praias.getNome());
		exPraia.setStatus(praias.getStatus());
		exPraia.setAcessibilidade(praias.getAcessibilidade());
		
		return praiasRepository.save(exPraia);
	}

	public List<Praias> listarPraiasPorStatus(String status) {
		return praiasRepository.findByStatus(status);
	}
	
	public List<Praias> listarPraiasComAcessibilidade(boolean acessibilidade) {
		return praiasRepository.findByacessibilidade(acessibilidade);
	}
	
	public boolean existePraiasComNome(String nome) {
	    Optional<Praias> praias = praiasRepository.findByNome(nome);
	    return praias.isPresent();
	}
}
