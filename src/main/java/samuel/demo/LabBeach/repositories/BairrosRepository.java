package samuel.demo.LabBeach.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import samuel.demo.LabBeach.models.Bairros;

@Repository
public interface BairrosRepository extends CrudRepository<Bairros, Long> {

	Optional<Bairros> findByNome(String nome);

}
