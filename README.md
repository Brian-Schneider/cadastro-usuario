# Cadastro de Usuário

Trata-se de um serviço de cadastro de clientes que tem por objetivo se utilizar da API Viacep para preencher os dados de endereço tomando apenas o CEP com entrada.


## Objetivo

Demonstrar possuir a capacidade de interpretar requisitos do cliente e implementar utilizando Java com o framework Spring Boot.

Para isso. deveria criar uma API RESTfull com DTOs e Mappers para implementar um CRUD  para cadastramento, consulta, exclusão, lista, pesquisa e alteração de Cliente seguindo a modelagem abaixo:
 
<img align="center" alt="Arquitetura-Solucao" src="https://i.ibb.co/1nZ34dj/Opera-Instant-neo-2023-10-09-031650-D01-SPRINGBOOT-INTERMEDIARIO-V01-01012023.png">

Entretanto, tomei a liberdade de fazer uma alteração e considerei Endereco como sendo uma Tabela no Banco de Dados (com id) para implementação de métodos que se aproveitam de informações contidas nela.

## Tecnologias utilizadas

 - Java 17
 - Spring Boot 3.1.4
 - MySQL8
 - IDE STS Eclipse
 - Insomnia

## Instalação

Primeiramente, tenha certeza de ter o Java 17 instalado em seu computador. Para isso, abra seu Prompt de Comando ou Terminal e digite:

```cmd
java -version
````

Caso não esteja, faça o download do [Java 17
](https://www.oracle.com/br/java/technologies/downloads/#java17) e siga as instruções para a instalação do mesmo. Pesquise também sobre como configurar as variáveis de ambiente.

Após, faça o Clone desse repositório com o comando abaixo:
```bash
git clone https://github.com/Brian-Schneider/teste_muralis.git
```

## Dependências utilizadas

- Spring Boot DevTools
- Validation
- Spring Data JPA
- Spring Web
- MySQL Driver (mudar de acordo com o banco de dados utilizado)
- ModelMapper
- Gson
- Spring Doc

## application.properties

Configuração da application.properties
### Banco de Dados
```cmd
spring.jpa.hibernate.ddl-auto=update

spring.jpa.database=mysql

spring.datasource.url=jdbc:mysql://localhost/db_cadastroclientes?createDatabaseIfNotExist=true&serverTimezone=America/Sao_Paulo&useSSl=false

spring.datasource.username=root

spring.datasource.password=root

  

spring.jpa.show-sql=true

  

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect

  

spring.jackson.date-format=yyyy-MM-dd HH:mm:ss

spring.jackson.time-zone=Brazil/East
```

### Spring Doc
```cmd
springdoc.api-docs.path=/v3/api-docs

springdoc.swagger-ui.path=/swagger-ui.html

springdoc.swagger-ui.operationsSorter=method

springdoc.swagger-ui.disable-swagger-default-url=true

springdoc.packagesToScan=com.testemuralis.cadastroclientes.controller

springdoc.swagger-ui.use-root-path=true
```
## Métodos e Endpoints
A aplicação possui os seguintes métodos HTTP e endpoints:

### Cadastrar Cliente (POST): Endpoint "```/clientes```"
Recebe em seu corpo um objeto JSON com os dados a serem persistidos no Banco de Dados e retorna o mesmo com um HTTP Status 201: Created caso o cliente seja cadastrado com sucesso.

### Lista Clientes (GET): Endpoint "```/clientes```"
Retorna uma lista com todos os clientes e seus respectivos atributos existentes no Banco de Dados em formato JSON e um HTTP Status 200: Ok.

### Buscar Cliente por ID (GET): Endpoint "```/clientes/id```"
Busca no Banco de Dados o cliente cujo id seja igual ao passado pelo endpoint e retorna o mesmo em formato JSON com um HTTP Status 200: Ok. Caso não encontre essa correspondência, retorna um HTTP Status 404: Not Found.

### Atualizar Cliente (PUT): Endpoint "```/clientes```"
Recebe em seu corpo um objeto JSON com os dados, incluindo o id do cliente, a serem atualizados no Banco de Dados. Caso haja correspondência no Banco de Dados com o id passado, os novos dados são persistidos e retornados junto com um HTTP Status 200: Ok. Em caso de não encontrar esse id, retorna um HTTP Status 404: Not Found.

### Deletar Cliente (DELETE): Endpoint "```/clientes/id```"
Busca no Banco de Dados o cliente cujo id seja igual ao passado pelo endpoint e o deleta, com um HTTP Status 200: Ok em caso de bem sucedido e, caso não encontre essa correspondência, retorna um HTTP Status 404: Not Found.

## Swagger

Enquanto a aplicação estiver em execução, ao acessar o link [http://localhost:8080](http://localhost:8080) (caso a porta configurada seja outra, mude para a mesma), terá acesso a documentação do Swagger mostrando todos os Endpoints, Métodos, e formatos de Objetos a serem passados (em formato JSON) da aplicação.


## JSON

Como os atributos de endereço serão preenchidos automaticamente pela API Viacep, o objeto de entrada a ser utilizado no corpo da requisição deve ter o formato:
```json
{
	"nome": "Luana Maria de Souza",
	"endereco": {
		"cep": "04029000",
		"numero": "333"
	},
	"contato": [
		{
			"tipo": "Telefone",
			"texto": "1133228558"
		},
		{
			"tipo": "Celular",
			"texto": "11943129867"
		}
	],
	"dataCadastro": "09/10/2023"
}
```
O que será salvo no Banco de Dados e retornado ao usuário seria:
```json
{
        "id": 1,
	"nome": "Luana Maria de Souza",
	"endereco": {
		"cep": "04029-000",
		"logradouro": "Avenida Ibirapuera",
		"localidade": "São Paulo",
		"numero": "333",
		"complemento": "até 1731 - lado ímpar"
	},
	"contato": [
		{
			"tipo": "Telefone",
			"texto": "1133228558"
		},
		{
			"tipo": "Celular",
			"texto": "11943129867"
		}
	],
	"dataCadastro": "09/10/2023"
}
```

## Implementações futuras

 - Métodos para:
	 - Buscar Cliente pelo Nome
	 - Listar Endereços
	 - Buscar Endereço por Id
	 - Buscar Endereço por CEP
	 - Buscar Endereço por Cidade/Localidade
- Testes Unitários
