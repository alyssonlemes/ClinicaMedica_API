# API CRUD para Médicos em Java com Spring Boot
<h4>O que é?</h4>

Esta API RESTful oferece funcionalidades CRUD (Criar, Ler, Atualizar e Excluir) para gerenciar dados de médicos em sua clínica, utilizando as seguintes tecnologias:

Spring Data JPA: Acesso simplificado ao banco de dados MySQL.
Flyway: Migrações de banco de dados seguras e confiáveis.
Lombok: Código mais conciso e legível.
Validação Bean: Entradas de dados precisas e confiáveis.
Funcionalidades:

Cadastro de Médicos: Adicione novos médicos à clínica, incluindo nome, especialidade, CRM, dados de contato e endereço.
Listagem de Médicos: Acesse uma lista paginada e ordenada de médicos ativos.
Atualização de Médicos: Edite as informações dos médicos cadastrados.
Exclusão de Médicos: Remova médicos da clínica (marcados como inativos).
Endpoints:

POST /medicos: Cadastra um novo médico.
GET /medicos: Lista médicos ativos (paginados).
PUT /medicos/{id}: Atualiza um médico pelo ID.
DELETE /medicos/{id}: Exclui um médico pelo ID.
Observações:

<h4>A API valida as entradas de dados para garantir a integridade das informações.
A API utiliza paginação para otimizar a listagem de dados em grandes conjuntos.
Começando:</h4>

Clone o repositório.
Instale as dependências.
Configure o banco de dados.
Execute a aplicação.
Para mais informações:

Consulte a documentação completa.
Contribua com o projeto.
Tecnologias:

Spring Boot
Spring Data JPA
Flyway
Lombok
Bean Validation
