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
public class SorteReves implements Cartas{
        
    private final String informacao;
    private final boolean sorte_reves;
    private final int valor;
    
    public SorteReves(String informacao,boolean sorte_reves,int valor){
        this.informacao = informacao;
        this.sorte_reves = sorte_reves;
        this.valor = valor;
    }
    
    @Override
    public String descricao(){
        return this.informacao;
    }        
        
   
}
