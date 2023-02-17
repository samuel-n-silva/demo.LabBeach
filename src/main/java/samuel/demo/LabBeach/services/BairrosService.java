package samuel.demo.LabBeach.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import samuel.demo.LabBeach.models.Bairros;
import samuel.demo.LabBeach.repositories.BairrosRepository;

@Service
public class BairrosService {
	@Autowired
	BairrosRepository bairroRepository;
	
	public void salvar(Bairros bairros) {
		bairroRepository.save(bairros);
	}
	
	public List<Bairros> listarBairros(){
		return (List<Bairros>) bairroRepository.findAll();
	}
	
	public void deleteById(Long id) {
        bairroRepository.deleteById(id);
    }
	
	public void atualizar(Long id, Bairros bairros) {
		Bairros exBairro = bairroRepository.findById(id).get();
		
		exBairro.setNome(bairros.getNome());
		exBairro.setDescrincao(bairros.getDescrincao());
		exBairro.setPopulacao(bairros.getPopulacao());
		bairroRepository.save(exBairro);
	}
}
