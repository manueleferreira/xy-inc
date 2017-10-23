# xy-inc
Aplicação que, dado um modelo de domínio com nome e 
atributos, realiza a criação e disponibilização de um
conjunto de serviços para um recurso.

## Arquitetura
Os detalhamentos sobre a arquitetura e decisões de projeto estão descritos 
no documento de [arquitetura do projeto](docs/architecture.md). 

Tecnologias:
* Java: Linguagem base de desenvolvimento
* Libraries:
  * Spring Boot: Framework Java para desenvolvimento Web (Spring MVC)
  * Maven: Gerenciador de dependências
  * Flyway: Gerenciamento de versionamento da base
  * H2: Database Embedded
  * JUnit: Testes unitários
  * MockMvc: Teste integração

## Usage
* Configurar projeto
 * [Instalar Maven](http://maven.apache.org/install.html) ou usar um [container docker](https://hub.docker.com/_/maven/)
 * Acessar raiz do diretório do projeto
 * Executar aplicação + testes: mvn install
 * Rodar instância local: mvn spring-boot:run
