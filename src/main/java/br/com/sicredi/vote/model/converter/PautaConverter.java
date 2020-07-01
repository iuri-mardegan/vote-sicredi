package br.com.sicredi.vote.model.converter;

import br.com.sicredi.vote.model.Pauta;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class PautaConverter implements AttributeConverter<Pauta, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Pauta attribute) {
        return attribute != null ? attribute.getId() : null;
    }

    @Override
    public Pauta convertToEntityAttribute(Integer dbData) {
        return dbData != null ? new Pauta(dbData) : null;
    }
}
