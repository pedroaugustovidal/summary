# Sales Summary

Desafio proposto para ler arquivos em lotes dentro de um diretório, processar, e gerar um arquivo na pasta de saída com
a síntese dos dados.

## Funcionalidades

- Processa multiplos arquivos na pasta de entrada ao mesmo tempo
- Retorna um sumário das vendas, clientes e vendedores
- Assíncrono

## Ferramentas

- Java 11+
- Maven 3.8.1
- Spring Framework 2.7.1
- Reactor core 3.4.19
- Lombok 1.18.24
- H2 Database 2.1.214

## Variáveis de Ambiente

Para rodar esse projeto, você vai precisar adicionar a seguinte variável de ambiente no seu .env

`%HOMEPATH%`

Dentro do diretório nessa variável, será necessário criar as seguintes pastas:

`%HOMEPATH%/data/in`

`%HOMEPATH%/data/out`

## Rodando localmente

Clone o projeto

```bash
  git clone https://github.com/pedroaugustovidal/summary
```

Entre no diretório do projeto

```bash
  cd summary
```

Gere o pacote

```bash
  mvn clean package
```

Inicie o servidor

```bash
  java -jar target/summary-0.0.1-SNAPSHOT.jar
```

## Rodando os testes

Para rodar os testes, rode o seguinte comando

```bash
  mvn test
```

## FAQ

#### Por que não foi usado Spring Batch?

Para processamentos de arquivos em lotes, o Spring Batch seria mais simples e perfeito para um auto processamento
escalável dos arquivos.

Entretanto, para apresentar o conhecimento técnico com webflux, foi utilizado um scheduler, inicialmente com threds, que
depois foi adaptado para ser controlado pelas entidades do Reactor (Mono e Flux).

## Autores

- [@Pedro Augusto Nodary Vidal](https://github.com/pedroaugustovidal)

