# 🚀 CRUD - Create, Read, Update, Delete (Java)
Este projeto é uma aplicação CRUD em Java, com integração ao MySQL, permitindo a manipulação de dados em uma tabela de funcionários/pessoas. A aplicação foi estruturada utilizando boas práticas de design de software, com separação de responsabilidades entre as camadas de DTO (Data Transfer Object), DAO (Data Access Object) e View. Essa organização garante um código mais limpo, manutenível e escalável.

## 🎯 Principais Funcionalidades
- **Cadastrar Funcionários:** Adiciona novos funcionários ao banco de dados.
- **Listar Funcionários:** Exibe todos os funcionários registrados no banco de dados.
- **Alterar Funcionários:** Atualiza informações de um funcionário específico.
- **Excluir Funcionários:** Remove um funcionário do banco de dados.
## 📂  Estrutura do projeto
O projeto está organizado em pacotes com as seguintes responsabilidades:

### DAO (Data Access Object)
Responsável pela interação com o banco de dados.
- **ConexaoDAO:** Classe responsável por estabelecer a conexão com o banco de dados.
- **FuncionarioDAO:** Classe que realiza as operações CRUD no banco de dados.

### DTO (Data Transfer Object)
Contém as classes que representam os dados transferidos entre as camadas.
- **FuncionarioDTO:** Representa um funcionário, com atributos como `id_funcionario`, `nome_funcionario` e `endereco_funcionario`.

### VIEW
Interface gráfica desenvolvida com Swing para interação do usuário com o sistema.
- **frmFuncionarioVIEW:** Janela principal para cadastro, listagem, atualização e exclusão de funcionários.
  
## 💾 Tecnologias Utilizadas
- ✅**Java:** Linguagem de programação principal.
- ✅**MySQL:** Banco de dados relacional para armazenamento dos dados.
- ✅**Swing:** Biblioteca para criação da interface gráfica.
- ✅**JDBC:** API de conexão com o banco de dados.
- 
## 🛠️ Configuração do Ambiente 
1. Certifique-se de ter o **Java JDK 8** ou superior instalado.
2. Instale o **MySQL Server** e crie um banco de dados chamado `bancoteste`.
3. Configure o arquivo `ConexaoDAO` com o usuário e senha do seu MySQL:
   ```java
   String url = "jdbc:mysql://localhost:3306/bancoteste?user=root&password=";
4. Importe o projeto em sua IDE preferida (Eclipse ou IntelliJ IDEA).
5. Execute o arquivo frmFuncionarioVIEW para iniciar a aplicação.

 ## 🏢 Script do Banco de Dados
```
 CREATE TABLE funcionario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_funcionario VARCHAR(100),
    endereco_funcionario VARCHAR(255)
);
```
 ## 🤝 Contribuições
 Sinta-se à vontade para contribuir! Basta fazer um fork do repositório, criar uma nova branch com sua funcionalidade ou correção e abrir um pull request. 🚀

 ---

Feito por **Elder Galvão** 🐈‍⬛
