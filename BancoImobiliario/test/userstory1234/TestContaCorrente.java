/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userstory1234;

import bancoimobiliario.ContaCorrente;
import bancoimobiliario.Jogador;
import exception.SaldoInvalidoException;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author emanoel
 */
public class TestContaCorrente {
    
    ContaCorrente conta;
    Jogador jogador;
    public TestContaCorrente() {         
    }
    
    @Before
    public void setUp() {
        conta = new ContaCorrente(); 
        jogador = new Jogador("jose","cor");
    }
    
    @Test
    public void testDebitar() throws SaldoInvalidoException {            
        conta.debitar(500);                 
        assertEquals(1000,conta.getSaldo());                   
    }
        
    public void testCreditar(){           
        conta.creditar(500);                        
        assertEquals(1500,conta.getSaldo());
    }        
    
    
    @Test
    public void testTransferirParaUm() throws SaldoInvalidoException{
        conta.transferirParaUm(jogador, 1000);
        assertEquals(500,conta.getSaldo());
    }
    
    @Test(expected=SaldoInvalidoException.class)
    public void testTransferirParaUmException() throws SaldoInvalidoException{
        conta.transferirParaUm(jogador, 2000);
        assertEquals(100,conta.getSaldo());
    }
    
    @Test(expected=SaldoInvalidoException.class)
    public void testDebitarException() throws SaldoInvalidoException{
        conta.debitar(2000);
        assertEquals(1000,conta.getSaldo());
    }        
       
    @After
    public void tearDown() {
    }
}
