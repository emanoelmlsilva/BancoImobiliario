/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoimobiliario;

/**
 *
 * @author emanoel
 */
public class CartaoSairDaPrisao implements Cartas{
    
    private final String informacao;
    
    public CartaoSairDaPrisao(String informacao){
        this.informacao = informacao;
    }
    
    @Override
    public String descricao(){
        return this.informacao;
    }
}
