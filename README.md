# Cadastro de Alunos

Este é um projeto de cadastro de alunos desenvolvido com o Spring Boot e Maven.

## Controller

O projeto possui duas classes de controller:

### AlunoController

Responsável por gerenciar operações relacionadas aos alunos.
Oferece endpoints para listar alunos, buscar aluno por ID, criar, atualizar e deletar alunos.
Lida com exceções, como IDs inválidos, dados inválidos e alunos não encontrados.

### AuthenticationController

Lida com autenticação e registro de usuários.
Fornece endpoints para login e registro de usuários.
Usa autenticação JWT para autenticar usuários e gerar tokens.

## Modelo de Dados

O modelo de dados inclui as seguintes entidades:

- Aluno: Representa informações de um aluno, incluindo nome e documento.
- User: Representa informações de usuário, incluindo login, senha (criptografada) e papel (role).

## Configuração

A aplicação usa o banco de dados H2 para armazenamento de dados.
A autenticação de usuários é baseada em tokens JWT.
As configurações podem ser encontradas no arquivo `application.yml` no diretório `resources`.

## Requisitos

- Java 17
- Spring Boot 3.1.3
- Maven

## Inicialização

1. Clone o repositório para sua máquina.
2. Certifique-se de que os requisitos estão instalados.
3. Configure as configurações do banco de dados no arquivo `application.yml`.
4. Execute o projeto com o comando `mvn spring-boot:run`.
5. A aplicação estará disponível em http://localhost:8088.



