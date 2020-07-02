# vote-sicredi

Estou trabalhando com Get para poder fazer as chamadas de endpoint direto no navegador

Cadastro da pauta é aberto no link
http://localhost:8080/pauta
O tempo de voto é contado em 1 minuto apartir da data de cadastro da mesma

Os Votos validos podem ser feitos no link  
http://localhost:8080/voto/{cpf}/{idPauta}/{voto}

O resultado da pauta pode ser recuperado em http://localhost:8080/resultado-pauta/{idPauta}

a url do arquivo do h2 é jdbc:h2:file:./voto-db, este pode ser acessado no http://localhost:8080/h2-console

Para o versionamento dos endpoints, podemos trabalhar organizando no link, algo como:

http://localhost:8080/v1/pauta 

http://localhost:8080/v2/pauta