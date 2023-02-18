package samuel.demo.LabBeach.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import samuel.demo.LabBeach.models.Praias;

public interface PraiasRepository extends CrudRepository<Praias, Long> {
	
	@Query("SELECT p FROM Praias p WHERE p.status = :status")
    List<Praias> findByStatus(@Param("status") String status);
	
	@Query("SELECT p FROM Praias p WHERE p.acessibilidade = :acessibilidade")
    List<Praias> findByacessibilidade(@Param("acessibilidade") boolean acessibilidade);
	
	Optional<Praias> findByNome(String nome);
}
