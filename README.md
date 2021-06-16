# vote-sicredi

Estou trabalhando com Get para poder fazer as chamadas de endpoint direto no navegador, outra opção seria adicionar swagger-ui ou utilizar o postman

Cadastro da pauta é aberto no link
http://localhost:8080/pauta
O tempo para voto é contado em 1 minuto apartir da data de cadastro da mesma, o id da pauta é apresentado na mensagem de retorno ao criar

Os Votos validos podem ser feitos no link  
http://localhost:8080/voto/{cpf}/{idPauta}/{voto}

O resultado da pauta pode ser recuperado em http://localhost:8080/resultado-pauta/{idPauta}

a url do arquivo do h2 é jdbc:h2:file:./voto-db, este pode ser acessado no http://localhost:8080/h2-console

Para o versionamento dos endpoints, podemos trabalhar organizando no link, algo como:

http://localhost:8080/v1/pauta 
http://localhost:8080/v2/pauta


Adicionar query by example

@Repository
public interface UsuarioDao extends CrudRepository<Usuario, Integer>, QueryByExampleExecutor<Usuario> {
}
  
Uso
  Usuario usr = new Usuario("nome do usuario");
  Example<Usuario> usuarioExample = Example.of(usr);
  usuarioDao.findAll( usuarioExample );
