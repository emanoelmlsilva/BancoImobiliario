/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoimobiliario;

import java.util.List;
import java.util.Random;

/**
 * Classe que contém um Array de Cartas, onde existem todas as cartas do jogo
 * @author emanoel
 */
public class Tabuleiro {
    
    // Última posição do tabuleiro
    private static final int ULTIMA_POSICAO = 39;
    
    // Array com todas as cartas
    private final Cartas[] listaCartas;
    
    // USER - STORY 5
    private final Cartas[] listaSorteReves;  
    
    // A Constante marca o valor do índice da prisão
    private static final int PRISAO = 10;
    
    // Cria um objeto Randômico para jogar os dados
    private Random randomDados;
    
    /**
     * Construtor do Tabuleiro, onde cada índice do Array possui uma carta
     */
    public Tabuleiro(){      
        randomDados = new Random();
        listaCartas = new Cartas[40];
        listaSorteReves = new Cartas[31];
        
        //Preencher o array de cartas
        listaCartas[0] = new PontoInicial("Ponto de partida ✗");        
        listaCartas[1] = new Propriedade(100,6,30,90,270,400,500,50,50,"Leblon","\033[1;35mrosa\033[m");
        listaCartas[2] = new SorteReves("Sorte ou Reves",false,0);
        listaCartas[3] = new Propriedade(60,2,10,30,90,160,250,30,50,"Av. Presidente Vargas","\033[1;35mrosa\033[m");
        listaCartas[4] = new Propriedade(60,2,10,30,90,160,250,30,50,"Av. Nossa Senhora de Copacabana","\033[1;35mrosa\033[m");
        listaCartas[5] = new Titulos(200,100,50,"Companhia Ferroviaria");
        listaCartas[6] = new Propriedade(240,20,100,300,750,925,1100,120,150,"Av. Brigadeiro Faria Lima","\033[1;34mazul claro\033[m");
        listaCartas[7] = new Titulos(200,100,50,"Companhia de Viação");
        listaCartas[8] = new Propriedade(220,18,90,250,700,875,1050,110,150,"Av. Rebouças","\033[1;34mazul claro\033[m");
        listaCartas[9] = new Propriedade(220,18,90,250,700,875,1050,110,150,"Av. 9 de Julho","\033[1;34mazul claro\033[m");
        listaCartas[10] = new Prisao("Prisão (visitante)");
        listaCartas[11] = new Propriedade(200,16,80,220,600,800,1000,100,100,"Av. Europa","\033[0;35mroxo\033[m");
        listaCartas[12] = new SorteReves("Sorte ou Reves",false,0);
        listaCartas[13] = new Propriedade(180,14,70,200,550,750,950,90,100,"Rua Augusta","\033[0;35mroxo\033[m");
        listaCartas[14] = new Propriedade(180,14,70,200,550,750,950,90,100,"Rua Augusta","\033[0;35mroxo\033[m");
        listaCartas[15] = new Titulos(150,75,40,"Companhia de Táxi");
        listaCartas[16] = new SorteReves("Sorte ou Reves",false,0);
        listaCartas[17] = new Propriedade(350,35,175,500,1100,1400,1500,175,200,"Interlagos","\033[2;33mlaranja\033[m");
        listaCartas[18] = new LucrosDividendos("Lucro e Dividendos");
        listaCartas[19] = new Propriedade(400,50,200,600,1400,1700,2000,200,200,"Morumbi","\033[2;33mlaranja\033[m");
        listaCartas[20] = new ParadaLivre("Parada Livre");
        listaCartas[21] = new Propriedade(120,8,40,100,300,450,600,60,500,"Flamengo","\033[1;31mvermelho\033[m");
        listaCartas[22] = new SorteReves("Sorte ou Reves",false,0);
        listaCartas[23] = new Propriedade(100,6,30,90,270,400,400,500,50,"Botafogo","\033[1;31mvermelho\033[m");
        listaCartas[24] = new ImpostoRenda("Imposto de Renda");
        listaCartas[25] = new Titulos(150,75,40,"Companhia de Navegação");
        listaCartas[26] = new Propriedade(160,12,60,180,500,700,900,80,100,"Av. Brasil","\033[7;33mamarelo\033[m");
        listaCartas[27] = new SorteReves("Sorte ou Reves",false,0);
        listaCartas[28] = new Propriedade(140,10,50,150,450,625,750,70,100,"Av. Paulista","\033[7;33mamarelo\033[m");
        listaCartas[29] = new Propriedade(140,12,60,180,500,700,900,80,100,"Jardim Europa","\033[7;33mamarelo\033[m");
        listaCartas[30] = new VaParaPrisao("Vá para a prisão");
        listaCartas[31] = new Propriedade(260,22,110,330,800,975,1150,130,150,"Copacabana","\033[7;32mverde\033[m");
        listaCartas[32] = new Titulos(200,100,50,"Companhia de Aviação");
        listaCartas[33] = new Propriedade(320,28,150,450,1000,1200,1400,160,200,"Av. Vieira Souto","\033[7;32mverde\033[m");
        listaCartas[34] = new Propriedade(300,26,130,390,900,1100,1275,150,200,"Av. Atlântica","\033[7;32mverde\033[m");
        listaCartas[35] = new Titulos(200,100,50,"Companhia de Táxi Aéreo");
        listaCartas[36] = new Propriedade(300,26,130,390,900,1100,1275,150,200,"Ipanema","\033[7;32mverde\033[m");
        listaCartas[37] = new SorteReves("Sorte ou Reves",false,0);
        listaCartas[38] = new Propriedade(280,24,120,360,850,1025,1200,140,150,"Jardim Paulista","\033[7;34mazul escuro\033[m");
        listaCartas[39] = new Propriedade(260,22,110,300,800,975,1150,130,150,"Brooklin","\033[7;34mazul escuro\033[m"); 
        
        
        // Preencher o array de cartas Sorte ou Reves
        listaSorteReves[0] = new SorteReves("Sua empresa foi multada por poluir demais",false,200);
        listaSorteReves[1] = new SorteReves("O dia do seu casamento chegou, receba os presentes",true,50);
        listaSorteReves[2] = new SorteReves("Reformou sua casa",false,50);
        listaSorteReves[3] = new SorteReves("Seu livro será publicado por uma grande editoras",true,50);
        listaSorteReves[4] = new CartaoSairDaPrisao("Utilize este cartão para se livrar da prisão");
        listaSorteReves[5] = new VaParaPrisao("Vá para a prisão");
        listaSorteReves[6] = new SorteReves("Vá até o início ",true,200);
        listaSorteReves[7] = new SorteReves("Suas ações na bolsa de valores estão em alta",true,100);
        listaSorteReves[8] = new SorteReves("Você vai começar um curso de MBA e ganhou um bom desconto para pagamento a vista",false,20);
        listaSorteReves[9] = new SorteReves("Férias com a familia pague",false,20);
        listaSorteReves[10] = new SorteReves("Recebeu o prêmio de profissional do ano e ganhou um carro",true,10);
        listaSorteReves[11] = new JogarNovamente("Jogue os dados novamente");
        listaSorteReves[12] = new SorteReves("Sua empresa irá patrocinar uma expedição a Antártida ",false,50);
        listaSorteReves[13] = new SorteReves("Vendeu a parte de sua empresa para um investidor ",true,75);
        listaSorteReves[14] = new SorteReves("Apostou no cavalo azarão e ganhou",true,100);
        listaSorteReves[15] = new SorteReves("A falta de chuva prejudicou a colheita",false,45);
        listaSorteReves[16] = new SorteReves("Recebeu uma herança inesperada",true,75);
        listaSorteReves[17] = new SorteReves("Seu filho decidiu fazer intercâmbio",false,20);
        listaSorteReves[18] = new SorteReves("Sua casa será desapropriada para a construção de um metro e ganhará uma gorda indenização",true,60);
        listaSorteReves[19] = new SorteReves("Venceu licitação para grande obra",true,150);
        listaSorteReves[20] = new SorteReves("Seu iate afundou, mas você tinha seguro!",true,25);
        listaSorteReves[21] = new SorteReves("Seus funcionários entraram em greve",false,30);
        listaSorteReves[22] = new SorteReves("Comprou obra de arte falsificada",false,22);
        listaSorteReves[23] = new SorteNumParRevesNao("Sorte se tirou o número par da soma dos dados e revés caso contrário");
        listaSorteReves[24] = new SorteReves("Seu jatinho precisa de manutenção",false,9);
        listaSorteReves[25] = new SorteReves("Renovou a frota de carros da sua empresa",false,100);
        listaSorteReves[26] = new SorteReves("Ganhou sozinho na loteria",true,80);
        listaSorteReves[27] = new SorteReves("Atualizou os computadores da sua empresa",false,30);
        listaSorteReves[28] = new SorteReves("Um navio afundou com suas mercadorias (não tinha seguro)",false,40);
        listaSorteReves[29] = new SorteReves("Produção de leite de suas fazendas ficou abaixo da expectativa",false,60);
        listaSorteReves[30] = new SorteReves("Tirou primeiro lugar no torneio de golfe receba",true,100);
    }
   
    
    /**
     * Método que realiza a jogada dos dados com a Classe Random do Java
     * @return dois valores dos dados obtidos em um Array de inteiros
     */
    public int[] rolaDado(){
       return new int[]{1+randomDados.nextInt(6),1+randomDados.nextInt(6)};
    }
    
    /**
     * Método que retorna o Array de Cartas do tabuleiro
     * @return Array com todas as cartas do tabuleiro
     */
    public Cartas[] getListaCartas(){
        return this.listaCartas;
    }
    
    // Somente na USER - STORY 5
    public Cartas[] getlistaSorteReves(){
        return this.listaSorteReves;
    }
    
    /**
     * Método que prende o jogador na prisão (índice 10 do tabuleiro)
     * @param jogadorASerPreso - jogador que ficará na prisão
     */
    public void prendeJogador(Jogador jogadorASerPreso) {
        jogadorASerPreso.setPosicaoTabuleiro(PRISAO);
    }
    
    public int getUltimaPosicao() {
        return this.ULTIMA_POSICAO;
    }
    
}
