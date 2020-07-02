package br.com.sicredi.vote.repository;

import br.com.sicredi.vote.model.Pauta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PautaRepository extends CrudRepository<Pauta, Integer> {

}
