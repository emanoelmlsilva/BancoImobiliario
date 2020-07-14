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
 * @author pedro
 */
public class TestJogador1 {
    
    Jogador jogadorTeste;
    ContaCorrente conta;
    Tabuleiro tabuleiro = new Tabuleiro();
    int resultadoNovaPosicao;
    int[] dadosTeste = {2, 3};
    int[] dadosAleatorios = tabuleiro.rolaDado();
    
    
    public TestJogador1() {
    }
    
    @Before
    public void setUp() {
        jogadorTeste = new Jogador("carlos", "verde");
        conta = new ContaCorrente();
        jogadorTeste.setPosicaoTabuleiro(0);
        System.out.println("------------------------------");
    }
    
    /**
     * Teste para saber se a posição do jogador é a mesma que foi pré-determinada com dados fixos
     */
    @Test
    public void testCalculaNovaPosicao() {
        jogadorTeste.setPosicaoTabuleiro(0);
        System.out.println("Posição Atual: " + jogadorTeste.getPosicaoTabuleiro());
        
        resultadoNovaPosicao = calculaNovaPosicao(jogadorTeste, dadosTeste, tabuleiro);
        
        System.out.println("Nova posição: " + jogadorTeste.getPosicaoTabuleiro());
        System.out.println("Você está na: " + tabuleiro.getListaCartas()[jogadorTeste.getPosicaoTabuleiro()].descricao());
        
        assertEquals(5, jogadorTeste.getPosicaoTabuleiro());
    }
    
  
    /**
     * Teste para saber se o jogador voltou ao início e se ganhou +$200
     */
    @Test
    public void testVoltouAoInicio() {
        jogadorTeste.setPosicaoTabuleiro(39);
        System.out.println("Posição Atual: " + jogadorTeste.getPosicaoTabuleiro());
        
        resultadoNovaPosicao = calculaNovaPosicao(jogadorTeste, dadosAleatorios, tabuleiro);
        System.out.println("Nova posição: " + jogadorTeste.getPosicaoTabuleiro());
        
        assertTrue((jogadorTeste.getPosicaoTabuleiro() >= 0) && (jogadorTeste.getPosicaoTabuleiro() <= 39));
        assertTrue(1700 == jogadorTeste.getConta().getSaldo());
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
