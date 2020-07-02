package br.com.sicredi.vote.repository;

import br.com.sicredi.vote.model.Pauta;
import br.com.sicredi.vote.model.Voto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotoRepository extends CrudRepository<Voto, Integer> {

    List<Voto> findByPauta(Pauta pauta);

}
