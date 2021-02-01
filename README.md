# Pessoas-api
Projeto utilizando Spring Boot 2.1.7, Java 8 , Mysql, Oauth2.0.

## Acessando o sistema:
O Sistema possuí 2 usuários: 
- Admin:
	- Permissão para criar, atualizar, buscar e excluir um cadastro.
	- Para acessar utilizar o login: admin@softplan.com.br e senha: usuario
- Usuário:
	- Permissão para criar , buscar e atualizar um cadastro.
	- Para acessar utilizar o login: usuario@softplan.com.br e senha: usuario

Se desejar altere os valores no arquivo src/main/resources/db/migration/V02__criar_e_registrar_usuarios_e_permissoes.sql

Necessário ter banco de dados Mysql com o usuário root e senha root configurados.

## Token
Estou utilizando autenticação Oauth2. Para gerar o token utilizar o comando abaixo.
```
curl --location --request POST 'http://localhost:8080/oauth/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--header 'Authorization: Basic YW5ndWxhcjpAbmd1bEByMA==' \
--data-urlencode 'client=angular' \
--data-urlencode 'username=admin@softplan.com.br' \
--data-urlencode 'password=admin' \
--data-urlencode 'grant_type=password'
``` 

O Projeto foi desenvolvido seguindo as obrigações abaixo citadas:
## A demanda
Deverá ser criada uma aplicação de cadastro de pessoas:

### Back-end
A aplicação, a ser desenvolvida em Java, deverá expor uma API de cadastro, alteração, remoção e consulta de pessoas com as seguintes informações: 
 - Nome - obrigatório
 - Sexo
 - E-mail - não obrigatório, deve ser validado caso preenchido
 - Data de Nascimento - obrigatório, deve ser validada
 - Naturalidade
 - Nacionalidade
 - CPF - obrigatório, deve ser validado (formato e não pode haver dois cadastros com mesmo cpf)

Obs: a data de cadastro e atualização dos dados devem ser armazenados.

### Front-end
A aplicação deverá ser acessível via navegador e possuir uma tela com formulário.
Não há restrição em relação à tecnologia para o desenvolvimento do frontend.

### Segurança
O acesso à aplicação só poderá ser realizado por um usuário pré-existente via autenticação **basic**.
Substitui por autenticação OAuth.

### Código fonte
A aplicação deverá possuir um endpoint **/source** acessível sem autenticação via **HTTP GET** que deverá retornar o link do projeto no github com o código fonte do projeto desenvolvido.

https://github.com/leandroneis/prova_softplan_back-end
https://github.com/leandroneis/prova_softplan_front-end


## Docker
A aplicação deverá estar disponível em uma imagem docker a partir do **docker-hub** e não deve exigir configurações/parâmetros. Ou seja, ao rodar a imagem, deve levantar a aplicação e funcionar.

	- https://hub.docker.com/repository/docker/lgn200/prova_softplan_leandro_neis_pessoa_api
	- https://hub.docker.com/repository/docker/lgn200/prova_softplan_leandro_neis_pessoa_ui

Se desejar criar um container docker com o projeto fazer as seguintes alterações:
 - No arquivo application.properties alterar no spring.datasource.url alterar de localhost para db
 - No linux executar o comando mvn clean install && sudo docker-compose up --build --force-recreate -d

 
## Swagger
A API deverá conter documentação executável que poderá ser utilizada durante seu desenvolvimento. (Utilizar swagger).
A aplicação possuí documentação swagger. Ps: Não consegui fazer funcinar o token no swagger, assim não é possível utilizar o token para testar.


## Heroku
 - https://leandroneis-pessoa-ui.herokuapp.com/


## Será incluso ainda....
- Teste de integração da API em linguagem de sua preferência (Damos importância para pirâmide de testes).
- Integração com OAuth 2 Google (https://developers.google.com/identity/protocols/OAuth2).
- Implementar Chat entre as pessoas que estão na aplicação.
- Versão 2 da API que deve incluir endereço da pessoa como dado obrigatório. Versão 1 deve continuar funcionando. 
