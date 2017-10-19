# xy-inc
Aplicação que, dado um modelo de domínio com nome e 
atributos, realiza a criação e disponibilização de um
conjunto de serviços REST.

## Arquitetura
Arquitetura baseada na linguagem Java.

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
 * [Instalar Maven](http://maven.apache.org/install.html)
 * Acessar raiz do diretório do projeto
 * Executar aplicação + testes: mvn install
 * Rodar instância local: mvn spring-boot:run
