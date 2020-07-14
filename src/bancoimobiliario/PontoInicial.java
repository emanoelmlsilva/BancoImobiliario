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
public class PontoInicial implements Cartas{
    
    private String informacao;
    
    public PontoInicial(String informacao){
        this.informacao = informacao;
    }
    
    public String descricao(){
        return this.informacao;
    }

    public String getInformacao() {
        return informacao;
    }
        
}
