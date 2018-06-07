# MuxiTerminal

## Heroku Url

https://protected-depths-89552.herokuapp.com

## Componentes

#### MuxiEureka

Tem a intenção de nomear e controlar os microserviços que existem. [Eureka](https://github.com/FilipeSantiago/MuxiEureka)

#### MuxiZuul

É o proxy que define pra qual microserviço cada request será encaminhado. [Zuul](https://github.com/FilipeSantiago/MuxiZuul)

#### MuxiTerminalBeta

Versão inicial do projeto, ele propositalmente aceita POST em json, para simular uma descontinuação de serviço em relação a api pedida, utilizando para isto o número de versão.  [Beta](https://github.com/FilipeSantiago/MuxiTerminalBeta)

Em um cenário real provavelmente a api antiga teria seus serviços desligados aos poucos, e não teria um código diferente para diferentes versões, este serviço tem o intuito apenas de simular este cenário e como o Zuul seria útil para isto.

#### MuxiTerminal

Tarefa pedida onde temos o endpoint para criação, consulta e edição do terminal. [Terminal](https://github.com/FilipeSantiago/MuxiTerminal)


## Como executar

Estes serviços foram criados utilizando o framework Spring do Java, sua execução pode ser em qualquer apache, porém a maneira mais simples de se executar é usando o servidor que vem junto com o [Spring STS](https://spring.io/tools/sts/all).

Uma vez com o STS instalado basta abrir os serviços no workspace e executar na seguinte ordem:

* MuxiEureka
* MuxiZuul
* Outros Serviços
