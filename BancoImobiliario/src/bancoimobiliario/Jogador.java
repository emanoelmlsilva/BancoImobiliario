/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoimobiliario;


/**
 * Importação dos métodos: 
 * input - realiza leitura dos dados
 * limpaTela - imprime espaços vazios na tela
 * nomeECorDoJogador - String formatada contendo nome e cor do jogador
 * verificaEscolha - verifica a escolha do jogador
 */
import static bancoimobiliario.Jogo.colorirPalavra;
import static bancoimobiliario.Jogo.input;
import static bancoimobiliario.Jogo.limpaTela;
import static bancoimobiliario.Jogo.nomeECorDoJogador;
import static bancoimobiliario.Jogo.verificaEscolha;
import exception.ComandoNaoExisteException;
import exception.SaldoInvalidoException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe para objetos do tipo Jogador, onde estão contidos valores e métodos
 * que serão utilizados durante a execução do jogo
 * 
 * @author pedro
 */
public class Jogador {
    
    private String nome;
    private String cor;
    private ContaCorrente conta;
    private int posicaoTabuleiro;
    private List<Cartas> cartasPossuidas; 
    private int quantidadeDeCasas;
    
    
    /**
     * Construtor do objeto Jogador, contendo a composição de ContaCorrente
     * 
     * @param nome - nome que será pedido no menu
     * @param cor - cor a ser selecionada no menu
     */
    public Jogador(String nome, String cor){
        this.nome = nome;
        this.cor = cor;
        this.posicaoTabuleiro = 0;
        this.cartasPossuidas = new ArrayList<Cartas>();
        this.conta = new ContaCorrente();
    }
    
    
    /**
     * Método para retorno do nome do jogador
     * @return nome - nome que foi cadastrado
     */
    public String getNome(){
        return this.nome;
    }
    
    /**
     * Método para retorno da cor selecionada
     * @return cor - cor que foi cadastrada no menu
     */    
    public String getCor(){
        return this.cor;
    }     
    
    /**
     * Método que retorna a posição do jogador no tabuleiro
     * @return posicaoTabuleiro - posição atual
     */    
    public int getPosicaoTabuleiro() {
        return this.posicaoTabuleiro;
    }
    
    
    /**
     * Método que modifica a posição do jogador no tabuleiro
     * @param novaPosicao - posição após jogar os dados
     */
    public void setPosicaoTabuleiro(int novaPosicao) {
        this.posicaoTabuleiro =  novaPosicao;
    }
    
    
    /**
     * Método que retorna a conta corrente do jogador
     * @return conta - conterá todos os métodos de ContaCorrente
     */
    public ContaCorrente getConta(){
        return this.conta;
    }
    
    
    /**
     * Método que retorna a quantidade de casas do jogador
     * @return quantidadeDeCasas - total de casas
     */
    public int getCasa(){
        return this.quantidadeDeCasas;
    }
    
    
    /**
     * Altera a quantidade de casas existentes
     * @param casa - total de casas
     */
    public void setCasa(int casa){
        this.quantidadeDeCasas = casa;
    }
    
    /**
     * Método que soma a posição atual do jogador com a soma dos dados, e
     * caso o resultado seja maior que 39 (última posição do tabuleiro), 
     * ele subtrai o novo valor com 39 Ex.: 42 - 39 = 3 (nova posição do jogador), e credita sua bonificação de $200
     * @param jogadorDaVez - jogador a calcular sua nova posição
     * @param dadosObtidos - array de dados com os valores obtidos
     * @param tabuleiro - tabuleiro do jogo
     * @return novaPosicao a ser verificada no main para imprimir se ele retornou ao início e ganhou $200
     */
    public static int calculaNovaPosicao(Jogador jogadorDaVez, int[] dadosObtidos, Tabuleiro tabuleiro) {
        int novaPosicao = jogadorDaVez.getPosicaoTabuleiro() + (dadosObtidos[0] + dadosObtidos[1]);
        
        if (novaPosicao > tabuleiro.getUltimaPosicao()) {
            jogadorDaVez.setPosicaoTabuleiro(novaPosicao - tabuleiro.getUltimaPosicao());
            jogadorDaVez.getConta().creditarBonificacao();
        
        } else {
            jogadorDaVez.setPosicaoTabuleiro(novaPosicao);
        }
        return novaPosicao;
    }
    
    /**
     * Método que retorna uma String concatenada com todas as propriedades do jogador Ex.: [Flamengo] ...
     * @return lista - contém todas a propriedades adquiridas
     */
    public String getCartas() {
        String lista = "";
        for (Cartas cartaAtual: this.cartasPossuidas) {
            if (cartaAtual instanceof Propriedade) {
                Propriedade p = (Propriedade) cartaAtual;
                lista += "[" + p.getInformacao() + "] - propriedade " + p.getCor() + ", aluguel " + colorirPalavra("verde", "$" + p.getAluguelSemCasa()) + "\n";
            }
        }
        
        return lista;
    }
    
    /**
     * Método que retorna a lista de cartas do jogador
     * @return cartasPossuidas - lista com todas as cartas do jogador
     */
    public List<Cartas> listaCartas(){        
        return cartasPossuidas;
    }
    
    /**
     * Método que adiciona a nova carta adquirida na lista de cartas do jogador
     * @param cartaAdquirida - nova carta adquirida
     */
    public void addCarta(Cartas cartaAdquirida) {
        this.cartasPossuidas.add(cartaAdquirida);
    }
    
    /**
     * Método que remove uma determinada carta que foi vendida ou hipotecada
     * @param cartaARemover - carta que será removida da lista de cartas
     */
    public void removeCarta(Cartas cartaARemover) {
        this.cartasPossuidas.remove(cartaARemover);
        
    }
    
    /**
     * Método que retorna se a propriedade já tem dono
     * @param propriedade - propriedade a ser verificada
     * @param listaDeJogadores - contém todos os jogadores cadastrados
     * @return Jogador - retorna null se não existir dono ou retorna o objeto Jogador dono da propriedade
     */
    public Jogador equalsPropriedade(Propriedade propriedade, List<Jogador> listaDeJogadores){        
        for(Jogador jogadorIndiceAtual: listaDeJogadores){           
            if(jogadorIndiceAtual.listaCartas().indexOf(propriedade) != -1){
                return jogadorIndiceAtual;            
            }           
        }
        return null;
    }
    
    
    /**
     * Método que realiza a compra de uma propriedade
     * @param propriedadeAComprar - propriedade que se deseja comprar
     * @param input - um objeto Scanner que será criado no menu
     * @param listaDeJogadores - lista conténdo todos os jogadores cadastrados
     * @param jogadorComprador - o jogadr que deseja comprar a propriedade
     * @throws SaldoInvalidoException - pode lançar exceção de saldo menor que valor a pagar
     */
    public void compraTituloDePropriedade(Propriedade propriedadeAComprar, Scanner input, List<Jogador> listaDeJogadores,Jogador jogadorComprador) throws SaldoInvalidoException {
        Jogador dono = equalsPropriedade(propriedadeAComprar, listaDeJogadores);
       
        
        String comprar = "";
        if (dono == null) {
            
            boolean comandoValido = false;
            Scanner leitor = new Scanner(System.in);
            while (!comandoValido) {
                try {

                    comprar = verificaEscolha(input("O Título da Propriedade " + propriedadeAComprar.descricao() + " está disponível por "+ colorirPalavra("vermelho" , "$" + Integer.toString(propriedadeAComprar.getPreco())) 
                            + ".\n" + nomeECorDoJogador(jogadorComprador) + ", você possui " + colorirPalavra("verde", "$" + Integer.toString(jogadorComprador.getConta().getSaldo())) + "." 
                            + "\nVocê deseja comprar " 
                            + propriedadeAComprar.descricao() + "(S/N) ? ", leitor));
                    comandoValido = true;
                    System.out.println("");


                } catch (ComandoNaoExisteException erro) {
                    System.out.println(colorirPalavra("vermelho", "✘ O comando de compra ") + colorirPalavra("amarelo", "'" + comprar + "'") + colorirPalavra("vermelho", " é inválido!\n"));
                }
                
            }
            if (comprar.equals("s")) {
                jogadorComprador.addCarta(propriedadeAComprar);
                jogadorComprador.getConta().debitar(propriedadeAComprar.getPreco());
                System.out.printf(colorirPalavra("verde", "✓ Você comprou o título da propriedade %s por " + colorirPalavra("vermelho", "$%d"))
                        + "\n" + colorirPalavra("vermelho", "✓ Novo Saldo: $%d\n\n"), propriedadeAComprar.descricao(), propriedadeAComprar.getPreco(),jogadorComprador.getConta().getSaldo());
                
            } else {
                // o jogo continua
            }
            
            
        }
        else if (jogadorComprador.getNome().equals(dono.getNome())) {
            System.out.println("[COMING SOON IN STORY 8 ] - Você é o dono desta Propriedade, deseja comprar casa [S/N] ?");
            //comprar = input.nextLine().toLowerCase();
            
        } else {
            System.out.printf("♛ %s (%s) é dono dessa propriedade e você deve pagar " + colorirPalavra("vermelho", "$%d de aluguel.")
                    + "\n" + colorirPalavra("verde", "✘ Seu saldo atual: $%d"), dono.getNome(), dono.getCor(), 
                    propriedadeAComprar.quantidadeDeCasas(false), jogadorComprador.getConta().getSaldo());
            
            jogadorComprador.getConta().transferirParaUm(dono, propriedadeAComprar.quantidadeDeCasas(false));
            
        }   
    }
    
}
