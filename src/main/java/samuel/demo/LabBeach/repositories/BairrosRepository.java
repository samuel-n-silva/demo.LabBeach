package samuel.demo.LabBeach.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import samuel.demo.LabBeach.models.Bairros;

@Repository
public interface BairrosRepository extends CrudRepository<Bairros, Long> {

}
