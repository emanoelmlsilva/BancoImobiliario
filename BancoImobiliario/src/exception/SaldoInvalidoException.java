/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author pedrock
 */
public class SaldoInvalidoException extends Exception {
    
    public SaldoInvalidoException(String mensagem) {
        super(mensagem);
    }
    
    public SaldoInvalidoException(){
        super("Saldo insuficiente");
    }
    
    
}
 