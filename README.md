# PontoEmDia

Esse projeto é a implementação de um sistema de ponto eletronico, onde os usuários acessam e realizam o registro de ponto na chegada a empresa, saída para almoço, volta do almoço e saída da empresa. 

O sistema é sub divido em dois niveis de usuários: Administradores e usuários comuns. 

O usuário comum tem opções limitadas de acesso dentro da aplicação. Já o usuário administrador tem acesso a todas as funções.

![Screenshot_8](https://user-images.githubusercontent.com/71987686/171059178-c3db0e4f-38f9-40d2-b67e-c75346259d67.png)

## Implementação

O projeto foi implementado utilizando Servlet, JSP, JSTL, Bootstrap, mariadb e JDBC. 

A construção da aplicação foi feita de tal forma onde temos apenas 1 servlet geral (/entrada), que recebe todas as requisições e redistrui para as classes que implementam as ações a serem tomadas.

Também é possível realizar o monitoramento do tempo de execução de cada ação dentro do sistema, através do console da aplicação.

## Instalação do projeto

1. Ide utilizada: [Eclipse EE](https://www.eclipse.org/downloads/packages/release/2022-03/r/eclipse-ide-enterprise-java-and-web-developers)

2. Banco de dados: [Maria db](https://mariadb.org/download/)

3. Clone o projeto com o seguinte comando:

```
git clone https://github.com/Guilherme2800/Ponto-em-dia.git
```

4. Crie um banco de dados com nome: pontoemdia

5. Trocar senha e usuário do banco em "usr/main/java/repository/ConnectionFactory"

![Screenshot_6](https://user-images.githubusercontent.com/71987686/171058735-e548ffee-f6a8-4566-8df5-92f792a556fa.png)

6. Importe a estrutura do banco com dados: [Base de dados](https://drive.google.com/file/d/1kUYXYHR0w8alnnSECpa-GaH_De1qBQB9/view?usp=sharing)

7. Instalar o tomCat 9: [Tomcat](https://tomcat.apache.org/download-90.cgi)

8. Adicionar o projeto ao TomCat

-> Window/show view/other e procurar por servers

![Screenshot_5](https://user-images.githubusercontent.com/71987686/171058494-01150623-5efa-440f-8b6f-314afa91db33.png)

-> Na nova aba de servers, adicionar um novo server como TomCat 9 e especificar o local onde o tomcat foi instalado

-> Clicar com botão direito no server inserido e apertar em "add and remove" e adicionar o projeto "PontoEmDia"

9. Iniciar o projeto clicando em "Start"

![Screenshot_4](https://user-images.githubusercontent.com/71987686/171058410-d18bea94-1a68-4046-ac06-6604dd0450f3.png)

10. End-point para acessar a aplicação: http://localhost:8080/PontoEmDia/entrada

Usuário para acesso: 

- (login) admin 
- (senha) admin
