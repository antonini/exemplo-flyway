Exemplo Flyway
==============

### Objetivo
Esse projeto foi criado para servir de material complementar ao artigo de conclusão de pós graduação cujo tema é "". Com isso este visa demonstrar de forma prática como utilizar a ferramenta Flyway para efetuar o controle de aplicação de alterações em seu banco de dados.


### Pré requisitos
1. Java JDK 7 ou superior
1. Maven 3.2.1 ou superior
1. Git client 1.8 ou superior


### Efetuar o clone, compilar e executar o fonte...
Dentro de um console (Terminal, CMD) acesse um diretório onde deseja baixar os fontes do projeto em questão.
Efetue o clone do mesmo através do comando abaixo:

```shell
git clone https://github.com/antonini/exemplo-flyway.git
```

Tendo esse comando executado de forma correta, no diretório corrente deverá existir uma pasta chamada exemplo-flyway. Essa pasta contém todos os fontes necessários para compilar e executar a aplicação de exemplo.
Acesse o diretório e efetue a compilação da aplicação através das seguintes linhas de comando:

```shell
cd exemplo-flyway
mvn clean install
```

Pronto, agora o fonte esta preparado para ser executado. Para executar tal tarefa execute a linha de comando abaixo:

```shell
mvn package exec:java -Dexec.mainClass=br.com.endrigo.TesteFlyway
```

Isso irá executar a aplicação e será possível ver no log de saída as Pessoas que foram adicionadas no banco de dados temporário.


### Entendendo o que está acontecendo

O Flyway é formado por scripts tanto SQL quanto Java para efetuar as alterações ao banco de dados. Nesse projeto foram utilizados somente scripts SQL que estão disponíveis [aqui](https://github.com/antonini/exemplo-flyway/tree/master/src/main/resources/db/migration). A execução deles se dá através da numeração de versão que esses formam. Ou seja, para o arquivo "V2__Adicionar_Pessoa.sql" temos a versão "2". Já para o arquivo "V2_1__Corrige_nome_jose.sql" temos a versão "2.1" o que faz com que esse seja executado após o script anterior.
A classe [TesteFlyway.java](https://github.com/antonini/exemplo-flyway/blob/master/src/main/java/br/com/endrigo/TesteFlyway.java) está toda comentada contendo o processo que é utilizado para invocar a chamada do Flyway.


### Duvidas?

Em caso de dúvidas utilizar o [este link](https://github.com/antonini/exemplo-flyway/issues/new) para que as mesmas sejam esclarecidas e até mesmo esse documento melhorado.
