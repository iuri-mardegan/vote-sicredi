package br.com.sicredi.vote.model.converter;

import br.com.sicredi.vote.model.Usuario;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class UsuarioConverter implements AttributeConverter<Usuario, String> {

    @Override
    public String convertToDatabaseColumn(Usuario attribute) {
        return attribute != null ? attribute.getCpf() : null;
    }

    @Override
    public Usuario convertToEntityAttribute(String dbData) {
        return dbData != null ? new Usuario(dbData) : null;
    }
}
