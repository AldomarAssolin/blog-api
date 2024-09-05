
<div align="center">
    <img src="https://github.com/AldomarAssolin/blog/blob/main/src/assets/images/SeminarioInterdisciplinar.png?raw=true" width="920"/>
</div>

# Esta API está sendo desenvolvida como parte do trabalho (PAPER) do 5° semestre da Faculdade de Análise e Desenvolvimento de Sistemas. 
 O objetivo é criar uma plataforma de blog que permita aos usuários publicar, gerenciar e interagir com postagens de forma eficiente.

## **Sumário**
1. [Integrantes do Grupo](#integrantes)  
2. [Tecnologias Utilizadas](#tecnologias)
3. [Tecnologias EnvolvidasFuncionalidades Principais](#principais)  
4. [Funcionalidades Detalhadas do Blog](#funcionalidades)
5. [Definição dos Endpoints Principais](#endpoints)
   
   5.1 [Autenticação de Usuários](#usuarios)
   
   5.2 [Gestão de Artigos](#artigos)
   
   5.3 [Gestão de Categorias e Tags](#categorias)
   
   5.4 [Sistema de Comentários](#comentarios)
   
   5.5 [Favoritos](#favoritos)
   
6. [Padrões e Boas Práticas](#padroes)
   
   6.1 [Autenticação e Autorização](#autenticacao)
   
   6.2 [Validação de Dados](#validacao)
   
   6.3 [Documentação da API](#documantacao)

## 1. Integrantes do grupo <a name="integrantes"></a>

- [@aldomarassolin](https://www.github.com/AldomarAssolin)
- [@pedroleite](https://github.com/PedroLeite009)
- [@jeanbiotto](https://www.github.com/jeanbiotto)
- [@robertovitorvilela](https://www.github.com/#)
- [@viniciustria](https://www.github.com/jeanbiotto)

## 2. Tecnologias Utilizadas <a name="tecnologias"></a>
- **Java:** Linguagem de programação principal para o desenvolvimento da API.
- **Spring Boot:** Framework utilizado para criar a aplicação de forma rápida e eficiente.
- **JPA (Java Persistence API):** Utilizado para gerenciar a persistência de dados e interações com o banco de dados.
- **Postman:** Ferramenta para testar e validar os endpoints da API.
- **Swagger:** Utilizado para documentação e visualização dos endpoints da API.

## 3. Funcionalidades Principais <a name="principais"></a>
- **Gerenciamento de Postagens:** CRUD completo (Criar, Ler, Atualizar, Deletar) para postagens.
- **Gerenciamento de Categorias e Tags:** Adicionar e organizar postagens em categorias e tags.
- **Comentários:** Permite que os usuários comentem nas postagens.
- **Usuários e Autenticação:** Registro, login e gerenciamento de perfis de usuários.
- **Curtidas:** Sistema para curtir postagens.
Endpoints
A API fornece uma série de endpoints para interagir com o blog. 

A documentação completa dos endpoints pode ser visualizada através do Swagger, *link em breve*.

## 4. Funcionalidades Detalhadas do Blog <a name="funcionalidades"></a>

- *Sistema de Login e Cadastro de Usuários*
- *Interface de Administração para Publicação de Artigos*
- *Publicação e Formatação de Artigos*
- *Busca e Filtragem de Artigos*
- *Sistema de Comentários*
- *Favoritos e Interação do Usuário*

## 5. Definição dos Endpoints Principais <a name="endpoints"></a>
Alguns endpoints definidos com base nas funcionalidades descritas:

### 5.1 Autenticação de Usuários: <a name="usuarios"></a>
````http
POST /api/auth/signup  //Cadastro de novos usuários
POST /api/auth/login //Login de usuários
POST /api/auth/forgot-password //Recuperação de senha
````


### 5.2 Gestão de Artigos: <a name="artigos"></a>
````http
GET /api/articles //Listar todos os artigos
GET /api/articles/{id} //Obter detalhes de um artigo específico
POST /api/articles //Criar um novo artigo
PUT /api/articles/{id} //Atualizar um artigo existente
DELETE /api/articles/{id} //Deletar um artigo
````

### 5.3 Gestão de Categorias e Tags: <a name="categorias"></a>
````http
GET /api/categories //Listar todas as categorias
POST /api/categories //Criar uma nova categoria
GET /api/tags //Listar todas as tags
POST /api/tags //Criar uma nova tag
````

### 5.4 Sistema de Comentários: <a name="comentarios"></a>
````http
GET /api/articles/{id}/comments //Listar todos os comentários de um artigo
POST /api/articles/{id}/comments //Adicionar um comentário a um artigo
DELETE /api/comments/{id} //Deletar um comentário
````


### 5.5 Favoritos: <a name="favoritos"></a>
````http
POST /api/users/{id}/favorites //Adicionar um artigo aos favoritos do usuário
GET /api/users/{id}/favorites //Listar todos os artigos favoritados pelo usuário
DELETE /api/users/{id}/favorites/{articleId} //Remover um artigo dos favoritos
````


## 6. Padrões e Boas Práticas <a name="padroes"></a>
### 6.1 Autenticação e Autorização: <a name="autenticacao"></a>

Utiliza `JWT`(JSON Web Tokens) para autenticação de usuários.
Implementação de controle de acesso baseado em permissões para diferenciar usuários comuns de administradores.

### 6.2 Validação de Dados: <a name="validacao"></a>

Valida todas as entradas de usuários para evitar injeções SQL e outras vulnerabilidades.
Utiliza anotações como `@Valid` e `@NotNull` em Spring Boot para garantir que os dados recebidos estejam corretos.

### 6.3 Documentação da API: <a name="documentacao"></a>

Utilizado Swagger para documentar automaticamente os endpoints da API,
Facilitando a integração com a equipe de frontend e outros desenvolvedores.

<div align="center">
    <img src="https://github.com/AldomarAssolin/blog/blob/main/src/assets/images/logo_black-recort.png?raw=true" width="220"/>
</div>
