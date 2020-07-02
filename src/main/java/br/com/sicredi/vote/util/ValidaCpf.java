package br.com.sicredi.vote.util;

import br.com.sicredi.vote.exception.UsuarioException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ValidaCpf {

    static public void validaCpf(String strCpf) throws UsuarioException {
        strCpf = strCpf.replaceAll("\\D+","");
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet("https://user-info.herokuapp.com/users/" + strCpf);

            CloseableHttpResponse response = null;
            response = httpClient.execute(request);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new UsuarioException("Cpf Invalido!");
            } else if (!EntityUtils.toString(response.getEntity()).contains("ABLE_TO_VOTE")){
                throw new UsuarioException("Voto não permitido!");
            }
        } catch (IOException e) {
            throw new UsuarioException("Falha no servico de consulta de cpf!");
        }
    }
}
