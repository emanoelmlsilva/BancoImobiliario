/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoimobiliario;


/**
 * Importação da exceção de operações que envolvem transferências e método de imprimir palavra colorida
 */
import static bancoimobiliario.Jogo.colorirPalavra;
import exception.SaldoInvalidoException;

/**
 * Classe para objetos do tipo Jogador, contendo informações e operações a serem realizadas com a conta do jogador
 * @author pedro
 */
public class ContaCorrente {
    
    private int saldo;
    private static final int BONIFICACAO_HONORARIO = 200;
    private static final int SALDO_INICIAL = 1500;
    
    /**
     * Construtor da conta corrente, onde o saldo inicial é a constante SALDO_INICIAL
     */
    public ContaCorrente() {
        this.saldo = SALDO_INICIAL;
    }
    
    
    /**
     * Método que realiza débito na conta do jogador
     * @param valorDebito - valor a ser debitado na conta
     * @throws SaldoInvalidoException - exceções que envolvem valores inválidos
     */
    public void debitar(int valorDebito) throws SaldoInvalidoException {
        
        if (this.saldo >= valorDebito) {
            this.saldo -= valorDebito;
        
        } else {
            throw new SaldoInvalidoException(colorirPalavra("vermelho","\n✘ O valor do saldo é menor que o valor do débito!"));
        }
    }
    
    /**
     * Método que adiciona uma quantia na conta do jogador
     * @param valorCredito - valor a ser creditado na conta
     */
    public void creditar(int valorCredito) {
        this.saldo += valorCredito;
    }
    
    /**
     * Método que credita um valor fixo quando o jogador retorna ao início do tabuleiro
     */
    public void creditarBonificacao() {
        this.creditar(BONIFICACAO_HONORARIO);
    }
    
    /**
     * Método que realiza uma transferência de valor para outro jogador
     * @param jogadorAReceber - será creditado com um valor
     * @param valorTransferencia - valor a ser creditado
     * @throws SaldoInvalidoException - exceções que envolvem valores inválidos
     */
    public void transferirParaUm(Jogador jogadorAReceber, int valorTransferencia) throws SaldoInvalidoException {
        debitar(valorTransferencia);
        jogadorAReceber.getConta().creditar(valorTransferencia);
        System.out.printf("\n" + colorirPalavra("vermelho", "✓ Seu novo saldo: $%d\n\n"), this.getSaldo());
    }
   
    /**
     * Método que retorna o valor atual da conta
     * @return saldo - valor atual na conta do jogador
     */
    public int getSaldo() {
        return this.saldo;
    }
    
    /**
     * Método que altera o valor do saldo do jogador
     * @param novoSaldo - valor a alterar o antigo saldo
     */
    public void setSaldo(int novoSaldo) {
        this.saldo = novoSaldo;
    }
    
}
