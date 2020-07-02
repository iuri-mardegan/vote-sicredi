package br.com.sicredi.vote.repository;

import br.com.sicredi.vote.model.Voto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends CrudRepository<Voto, Integer> {

}
