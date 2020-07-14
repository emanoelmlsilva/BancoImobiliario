/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userstory1234;

import bancoimobiliario.ContaCorrente;
import bancoimobiliario.Jogador;
import static bancoimobiliario.Jogador.calculaNovaPosicao;
import bancoimobiliario.Tabuleiro;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pedrock
 */
public class TestJogador2 {
    
    Jogador jogadorTeste2;
    ContaCorrente conta;
    Tabuleiro tabuleiro = new Tabuleiro();
    int resultadoNovaPosicao;
    int[] dadosTeste = {5, 5};
    int[] dadosAleatorios = tabuleiro.rolaDado();
    
    public TestJogador2() {
    }
    
    
    @Before
    public void setUp() {
        jogadorTeste2 = new Jogador("mariana", "verde");
        conta = new ContaCorrente();
        jogadorTeste2.setPosicaoTabuleiro(0);
        System.out.println("-----------------------------------"); 
    }
    
    
    /**
     * Teste para saber se o jogador ganhou $200 ao retornar para o início
     */
    @Test
    public void testCalculaNovaPosicao() {
        int saldoAntigo = jogadorTeste2.getConta().getSaldo();
        System.out.println("Saldo Antigo: $" + saldoAntigo);
        
        jogadorTeste2.setPosicaoTabuleiro(31);
        
        System.out.println("Posição Atual: " + jogadorTeste2.getPosicaoTabuleiro());
        resultadoNovaPosicao = calculaNovaPosicao(jogadorTeste2, dadosTeste, tabuleiro);
        
        assertTrue(saldoAntigo < jogadorTeste2.getConta().getSaldo());
        System.out.println("Novo Saldo: " + jogadorTeste2.getConta().getSaldo());
    }
    
    /**
     * Teste para afirmar que o jogador não retornou ao início
     */
    @Test
    public void testVoltouAoInicio() {
        jogadorTeste2.setPosicaoTabuleiro(10);
        System.out.println("Posição Atual: " + jogadorTeste2.getPosicaoTabuleiro());
        
        resultadoNovaPosicao = calculaNovaPosicao(jogadorTeste2, dadosAleatorios, tabuleiro);
        System.out.println("Nova Posição: " + jogadorTeste2.getPosicaoTabuleiro());
        
        assertFalse((jogadorTeste2.getPosicaoTabuleiro() >= 0) && (jogadorTeste2.getPosicaoTabuleiro()) <= 10);
        assertFalse(jogadorTeste2.getConta().getSaldo() > 1500);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
