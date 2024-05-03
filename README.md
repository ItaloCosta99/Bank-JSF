# EsigBank

Aplicação Web Java, usando a especificação JSF (JavaServer Faces) de simulando um banco fictício lidando com salários.

# Lista de Tarefas

## Pontos de Avaliação

1. [X] Criar uma aplicação Web Java, utilizando a especificação JSF (JavaServer Faces), com uma tela de Listagem de Pessoas, onde deve constar as informações consolidadas na tabela pessoa_salario_consolidado, após a realização do cálculo dos salários (item 2).
   
2. [X] Implementar o cálculo dos salários das pessoas, com uma opção na tela acima para calcular/recalcular salários.

## Diferenciais no Desafio (opcionais)

- [ ] Utilizar processamento assíncrono no cálculo dos salários.
  
- [ ] Criar um relatório, utilizando JasperReports, para exibição das pessoas e seus salários calculados e exportação em PDF.
  
- [ ] Criar um CRUD de Pessoa, para atualizar, excluir e incluir novas pessoas.
  
- [ ] Criar um CRUD de usuário e implementar autenticação via Login e Senha.
  
- [X] Criar testes de unidade.

## Tecnologias utilizadas

- [**Eclipse IDE for Enterprise Java and Web Developers Version: 2024-03 (4.31.0)**](https://www.eclipse.org/downloads/packages/)
- [**Java 11**](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)
- [**PostgreSQL 16.2**](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads) 
- [**Apache Maven 3.9.6**](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads)
- **JSF**
- **JPA com Hibernate**
- [**Apache Tomcat 9.0.88**](https://tomcat.apache.org/download-90.cgi)
- [**PrimeFaces 12**](https://www.primefaces.org/)


## Utilização

- Clone o repositório
- Crie um banco de dados no PostgreSQL com o nome "*banco*"
- Altere o *persistence.xml* inserindo em *value* o nome e senha do seu banco de dados
```xml
<property name="javax.persistence.jdbc.user" value="exemplo" />
<property name="javax.persistence.jdbc.password" value="exemplo" />
```
- Abra o projeto no Eclipse
- Crie um servidor Tomcat 9.0
- Sincronize o projeto com o Tomcat.
- Execute *Update Maven Project* (alt + F5).
- Execute *Run As Maven Install* para instalar as dependências.
- Inicie o Tomcat.

## Contribuindo

## Seja bem-vindo!

Esta seção busca auxiliar colaboradores interessados em contribuir para o desenvolvimento do EsigBank.

Como contribuir
Para contribuir, siga estes passos:

- Fork (Bifurque) o repositório: Clique em "Fork" no canto superior direito da página principal do repositório. Isso criará uma cópia do projeto na sua conta do GitHub.
- Clone (Clone) o seu fork para a sua máquina: Utilize o git para clonar o fork do repositório para a sua máquina local.
- Crie uma branch (ramificação) para a sua contribuição: Crie uma nova branch específica para sua alteração usando git checkout -b seguido de um nome descritivo para a branch.
- Implemente suas alterações: Faça as alterações desejadas no código.
- Adicione e confirme suas alterações: Utilize git add para adicionar os arquivos modificados e git commit para criar um commit com uma mensagem descritiva.
- Envie a sua pull request (solicitação de pull): Faça o push das alterações para o seu fork no GitHub e então crie uma pull request para o repositório principal.
- Responda aos reviews (avaliações): Os mantenedores do projeto irão avaliar sua pull request e podem solicitar alterações. Responda a esses comentários para garantir a integração da sua contribuição.

## License

[MIT](https://choosealicense.com/licenses/mit/)
