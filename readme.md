
# Projeto da Disciplina de Programação Orientada a Objetos
### Docente: Fábio Jorge Almeida Morais
###            Grupo
|Nome                |Matrícula                          |E-mail                        |
|----------------|-------------------------------|----------------------------- 
|Emanoel da Silva Medeiros|20170051574|emanoel.silva@dce.ufpb.br            |
|Pedro Carlos Alves de Oliveira   |20170122854|pedro.carlos@dce.ufpb.br     |

### [Link do Javadoc](https://pedrocarl0s.github.io/javadoc-poo-users1234/)

> Observações: O projeto contém coloração [ANSI](https://pt.wikipedia.org/wiki/C%C3%B3digo_escape_ANSI) e deve ser executado em IDE's ou terminais linux. Para a IDE [Eclipse](https://www.eclipse.org/), deve ser instalado um plugin na [Eclipse Market](https://marketplace.eclipse.org/content/ansi-escape-console).
---
# Primeira entrega - User Stories 1, 2, 3, 4
> Nota: O jogo é jogado em um terminal simples, onde os jogadores digitam comandos específicos para interagir com o sistema.

# Criação do Jogo

1 -  Ao executar o sistema, é exibida uma mensagem pedindo a quantidade de jogadores para prosseguir

```
  Digite o número de jogadores [2-8]:  
```
```
Digite o número de jogadores [2-6]: 7
✘ Número de jogadores inválido. Insira novamente!
```
> Nota: Caso a quantidade seja inválida, será impressa uma mensagem, e o sistema irá pedir outra entrada.<br/>

2 - Ao inserir uma quantidade válida, será pedido o nome e a cor do peão

```
Digite o nome do jogador 1: pedro
Escolha a cor do peão do jogador 1 entre as opções seguintes 
[preto][branco][vermelho][verde][azul][amarelo][laranja][rosa]: verd
```
> Nota: Caso o nome da cor seja inválida, será impressa uma mensagem, e o sistema irá pedir outra entrada:
> 
>Digite o nome do jogador 1: pedro
Escolha a cor do peão do jogador 1 entre as opções seguintes
[preto][branco][vermelho][verde][azul][amarelo][laranja][rosa]: verd<br/>
>✘ A cor 'verd' é inválida. Insira novamente!
---

3 - Ao inserir uma cor válida, o jogo irá iniciar com a seguinte mensagem

```
O Banco Imobiliário vai começar. Aproveite!
```
# Jogada
> Nota: Os testes mostrados a seguir, foram feitos com 2 jogadores para facilitar a exemplificação, e caso qualquer comando inválido seja digitado, o sistema irá mostrar o motivo do erro e pedirá outra entrada ao jogador.

> No terminal do linux, deve-se inserir o comando <b> java -cp BancoImobiliario.jar bancoimobiliario.Jogo</br>

1 - Após cadastrar os jogadores, será impresso na tela o jogador da vez e os comandos disponíveis.
```
⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋
JOGADOR DA VEZ: pedro (verde)
Comandos disponíveis: [jogar][status][sair] 
Digite um comando: jogar
⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋
```
## O Comando digitado foi: [jogar]
2 - Caso o comando seja [jogar], os dados serão jogados e jogador da vez terá uma nova posição no tabuleiro.
```
⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋
JOGADOR DA VEZ: pedro (verde)

➤ Saldo do Jogador pedro (verde)$1500
➤ O jogador pedro (verde) tirou 3, 2 e o peão avançou para 5 - Companhia Ferroviaria
⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋
```
## Título de Propriedade sem dono
2.1. - Se o jogador cair e uma propriedade com título disponível para compra, ele será notificado e perguntado se quer comprar a propriedade
```
⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋
JOGADOR DA VEZ: pedro (verde)

➤ Saldo do Jogador pedro (verde)$1500
➤ O jogador pedro (verde) tirou 6, 2 e o peão avançou para 8 - Av. Rebouças

O Título da Propriedade Av. Rebouças está disponível por $220.
pedro (verde), você possui $1500.
Você deseja comprar Av. Rebouças(S/N) ? s
⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋
```

2.1.2 - Caso a resposta seja sim, será impressa a confirmação de compra e o novo saldo
```
⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋
O Título da Propriedade Av. Rebouças está disponível por $220.
pedro (verde), você possui $1500.
Você deseja comprar Av. Rebouças(S/N) ? s

✓ Você comprou o título da propriedade Av. Rebouças por $220
✓ Novo Saldo: $1280
⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋
```
2.1.3 - Caso a resposta seja não, será a vez do outro jogador
```
⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋
O Título da Propriedade Av. Paulista está disponível por $140.
pedro (verde), você possui $1150.
Você deseja comprar Av. Paulista(S/N) ? n

⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋
JOGADOR DA VEZ: emanoel (vermelho)
Comandos disponíveis: [jogar][status][sair] 
Digite um comando: 
```
## O jogador da vez obteve uma dupla (2 e 2, 5 e 5)
2.2 - Quando um jogador obter uma dupla (Ex.: 1 e 1, 3 e 3) ele terá direito a outra jogada. Mas se a dupla ocorrer 3x vezes seguidas, ele irá para a prisão (como visitante)
```
⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋
JOGADOR DA VEZ: pedro (verde)
✸ O jogador pedro (verde) tirou um dado duplo 1x, e terá direito a outra jogada!

➤ Saldo do Jogador pedro (verde)$1500
➤ O jogador pedro (verde) tirou 1, 1 e o peão avançou para 2 - Sorte ou Reves

Comandos disponíveis: [jogar][status][sair] 
Digite um comando: jogar
⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋
```
> Nota: Ele terá direito a 2ª jogada
>
```
JOGADOR DA VEZ: pedro (verde)
✸✸ O jogador pedro (verde) tirou um dado duplo 2x, e terá direito a outra jogada!

➤ Saldo do Jogador pedro (verde)$1500
➤ O jogador pedro (verde) tirou 5, 5 e o peão avançou para 12 - Sorte ou Reves

Comandos disponíveis: [jogar][status][sair] 
Digite um comando: jogar
⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋
```
## Uma dupla pela 3ª vez seguida
> Nota: O jogador tirou uma dupla pela 3ª vez e será preso como visitante, e consequentemente será a vez do outro jogador
```
✸✸✸ O jogador pedro (verde) tirou um dado duplo 3x, e será preso!

⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋
JOGADOR DA VEZ: emanoel (vermelho)
Comandos disponíveis: [jogar][status][sair] 
Digite um comando: 
```
## Título de propriedade com dono
2.3 - Se o jogador da vez cair em um título de propriedade já com dono, ele deverá pagar o valor do aluguel correspondente
```
⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋
JOGADOR DA VEZ: emanoel (vermelho)

➤ Saldo do Jogador emanoel (vermelho) $1500
➤ O jogador emanoel (vermelho) tirou 2, 4 e o peão avançou para 8 - [Av. Rebouças]
 propriedade azul claro, aluguel $18

♛ pedro (verde) é dono dessa propriedade e você deve pagar $18 de aluguel.
✘ Seu saldo atual: $1500
✓ Seu novo saldo: $1482
⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋
```
##  O comando digitado foi: [sair]
3 - Se o comando digitado foi sair, o jogador deverá confirmar sua saída
```
⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋
Jogador pedro (verde) insira um novo comando!
Comandos disponíveis: [jogar][status][sair] 
Digite um comando: sair
pedro (verde) você deseja realmente sair (S/N): s
⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋

O jogador pedro (verde)saiu!
FIM DE JOGO!
```
> Nota: Quando o jogador sair, ele é removido da lista de jogadores e caso exista a quantidade mínima de jogadores (2) para continuar, o jogo continuará.

> Observação: No exemplo acima existiam apenas 2 jogadores, e como restou apenas 1, o jogo foi finalizado.
# Status do Jogador

3. Caso o comando seja [status], serão impressos 
-  O nome do jogador
-   A cor do peão;
-   O nome da posição atual no tabuleiro;
-   Quanto dinheiro o jogador possui;
-   Uma lista dos títulos que o jogador possui com as informações relativas a cada título (cor do grupo se for propriedade, aluguel das propriedades, valor das companhias, etc.).

>Nota: Após o jogador pedir o status, o sistema irá pedir um novo comando

### Exemplo de jogador sem propriedades
```
⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋
STATUS DO JOGADOR: emanoel (vermelho)

➤ Situado na posição 0 - Ponto de partida ✗
➤ Saldo: $1500
➤ Títulos: não possui
⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋
Jogador emanoel (vermelho)insira um novo comando!
Comandos disponíveis: [jogar][status][sair] 
Digite um comando: 
```
### Exemplo de jogador com propriedades
```
⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋
STATUS DO JOGADOR: pedro (verde)

➤ Situado na posição 10 - Prisão (visitante)
➤ Saldo: $1240
➤ Títulos: 
[Av. Nossa Senhora de Copacabana] - propriedade rosa, aluguel $2
[Av. Rebouças] - propriedade azul claro, aluguel $18

⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋⇋
Jogador pedro (verde)insira um novo comando!
Comandos disponíveis: [jogar][status][sair] 
Digite um comando: 
```

# Diagrama de Classes - User Stories 1,2,3,4
![](https://github.com/dcx-cursos/projeto-poo-projeto-poo/blob/master/BancoImobiliario/uml_banco_imobiliario.png)
