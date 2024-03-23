# Hackathon Time Tracking Microservice

## Problema
A Hackaton Company SA, uma empresa de grande porte com mais de 100.000 colaboradores e que atende diversas áreas, inclusive tecnologia, está em um ponto de transição crucial. Atualmente, está utilizando um sistema de ponto eletrônico terceirizado, mas devido a questões de qualidade e custos mensais significativos por usuário, a diretoria decidiu por construir o próprio sistema de ponto eletrônico interno. E, para que atenda as diversas filiais e pontos de trabalho dos colaboradores, este novo sistema será baseado em nuvem.

A decisão de migrar para um sistema interno e em nuvem é motivada por várias razões. A primeira é relacionada à qualidade do serviço fornecido pelo sistema terceirizado, que tem sido insatisfatória, com problemas frequentes de desempenho e disponibilidade. Somando-se a isso, os custos mensais por usuário estão se tornando proibitivos, especialmente considerando a quantidade de colaboradores. E outro ponto importante é a possibilidade de controlar a evolução do software implementando as melhorias necessárias sempre que desejado.

Ao construir o próprio sistema em nuvem, espera-se não apenas economizar custos no longo prazo, mas também melhorar a qualidade e a confiabilidade do registro de ponto para os colaboradores. A nuvem oferece benefícios significativos em termos de escalabilidade, disponibilidade e segurança, tornando-a a escolha ideal para o novo sistema.

Este projeto envolverá a criação de um sistema de ponto eletrônico robusto, escalável e seguro que possa suportar a carga de nossa grande força de trabalho. O novo sistema irá implementar as funcionalidades do sistema atual, e terá uma série de recursos adaptados à realidade da nossa empresa, incluindo a autenticação de usuário, registro de ponto, visualização e edição de registros, geração de relatórios, notificações e integração com outros sistemas.

A transição para a nuvem é um passo importante para o início de grandes modernizações dentro da organização.

## Solução

Foi elaborado um conjunto de serviços para viabilizar a operação de registro de ponto.

![Visão Geral da Solução](doc/c1_hackathon.png)

Nesse repositório, temos a implementação do serviço de registro de ponto (Hackathon Time Tracking Microservice).  

![Time Tracking Microservice](doc/time-tracking-c2_hackathon.png)

## Repositórios de IaC

### Repositórios Infra AWS Cloud

Nossa infraestrutura de Cloud está dividida da seguinte forma:

1) [hackathon-infra-foundation](https://github.com/fiap-postech/hackathon-infra-foundation): Repositório com a infra-estrutura responsável por toda a fundação, que inclui camada de rede (VPC), Security Groups, Subnets, Internet Gateway, API Gateway e etc.
2) [hackathon-iac-microservice-foundation](https://github.com/fiap-postech/hackathon-iac-microservice-foundation): Repositório com a infra-estrutura base para micro serviços: AWS ECS Cluster, API Gateway, VPC Link.

### Repositório Infra Time Tracking Microservice

1) [hackathon-iac-timetracking-microservice](https://github.com/fiap-postech/hackathon-iac-time-tracking-microservice): Repositório que contem o código de aprovisionamento dos recursos para o workload do Time Tracking microservice.

## Estrutura Geral do Projeto
```
./hackathon-time-tracking-microservice
├── README.md
├── adapter
│   └── src
│       └── main
│           └── java
│               └── br
│                   └── com
│                       └── fiap
│                           └── hackathon
│                               └── time
│                                   └── tracking
│                                       └── adapter
│                                           ├── controller
│                                           ├── dto
│                                           ├── event
│                                           ├── gateway
│                                           ├── mapping
│                                           ├── presenter
│                                           └── repository
├── application
│   └── src
│       └── main
│           └── java
│               └── br
│                   └── com
│                       └── fiap
│                           └── hackathon
│                               └── time
│                                   └── tracking
│                                       └── application
│                                           ├── gateway
│                                           └── usecase
├── doc
├── drivers
│   ├── mongodb
│   │   └── src
│   │       └── main
│   │           └── java
│   │               └── br
│   │                   └── com
│   │                       └── fiap
│   │                           └── hackathon
│   │                               └── time
│   │                                   └── tracking
│   │                                       └── driven
│   │                                           └── mongo
│   │                                               ├── config
│   │                                               ├── mapping
│   │                                               ├── model
│   │                                               ├── repository
│   │                                               └── service
│   ├── rest
│   │   └── src
│   │       └── main
│   │           └── java
│   │               └── br
│   │                   └── com
│   │                       └── fiap
│   │                           └── hackathon
│   │                               └── time
│   │                                   └── tracking
│   │                                       └── driver
│   │                                           └── rest
│   │                                               ├── config
│   │                                               ├── mapping
│   │                                               └── resource
│   │                                                   ├── doc
│   │                                                   ├── request
│   │                                                   └── response
│   └── time-tracking-event-producer
│       └── src
│           └── main
│               └── java
│                   └── br
│                       └── com
│                           └── fiap
│                               └── hackathon
│                                   └── time
│                                       └── tracking
│                                           └── driven
│                                               └── event
│                                                   └── producer
├── enterprise
│   └── src
│       └── main
│           └── java
│               └── br
│                   └── com
│                       └── fiap
│                           └── hackathon
│                               └── time
│                                   └── tracking
│                                       └── enterprise
│                                           ├── entity
│                                           ├── error
│                                           └── valueobject
└── launcher
    └── src
        ├── main
        │   ├── java
        │   │   └── br
        │   │       └── com
        │   │           └── fiap
        │   │               └── hackathon
        │   │                   └── time
        │   │                       └── tracking
        │   │                           └── launcher
        │   │                               └── configuration
        │   └── resources
        └── test
            ├── java
            │   └── br
            │       └── com
            │           └── fiap
            │               └── hackathon
            │                   └── time
            │                       └── tracking
            │                           └── launcher
            │                               ├── config
            │                               ├── containers
            │                               ├── fixture
            │                               ├── messaging
            │                               ├── rest
            │                               ├── service
            │                               └── util
            └── resources
                └── schemas
```

## Como executar o projeto?

### Pré-Requisitos ⚙️

<br>![Static Badge](https://img.shields.io/badge/java-v17.0.0-blue)
<br>![Static Badge](https://img.shields.io/badge/docker-latest-blue)


### Preparação 💻

Independente da forma que escolha para executar o projeto, temos o seguinte procedimento a ser executado:

1. Clone o projeto desse repositório do Github
```sh
git clone https://github.com/fiap-postech/hackathon-time-tracking-microservice.git
```
2. Acesse a pasta do projeto pelo terminal/cmd
```sh
cd hackathon-time-tracking-microservice
```
3. Execute o comando de build do projeto
```sh
./gradlew build
```

### Execução 🏃

1. Execute o docker-compose.yml para iniciar o provisionamento da infra local
```sh
docker-compose -f infra/docker-compose-local.yml up -d
```
2. Com isso, você já pode executar o projeto pela IDE de sua preferência ou, se preferir, pode executar o projeto pela
   linha de comando com:
```sh
./gradlew bootRun
```
Ao executar o serviço, o servidor responderá no endereço: `http://localhost:8691`. Ao acessar essa url você será redirecionado ao swagger do projeto.
