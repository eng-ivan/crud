# Microservice Client



. Chamadas aos endpoints:

- [POST] http://localhost:8080/api/cliente/save [Salva um cliente, mas antes, faz um request na api do via cep]

- [PUT] http://localhost:8080/api/cliente/update/{id} [Atualiza cliente por id]

- [GET] http://localhost:8080/api/cliente/list [Lista todos os clientes cadastrados]

- [GET] http://localhost:8080/api/cliente/list-ativo [Lista todos os clientes ativos cadastrados]

- [GET] http://localhost:8080/api/test [Testa conexao retornando host user, timestamp e token de conexao]

- [GET] http://localhost:8080/api/cliente/find/{id} [Busca cliente por id]

- [DELETE] http://localhost:8080/api/cliente/delete/{id} [Deleta cliente por id]

