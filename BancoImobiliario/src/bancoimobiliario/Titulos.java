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
public class Titulos implements Cartas{
    
    private final int preco;
    private final int hipoteca;
    private final int multiplicador;
    private final String informacao;
    
    public Titulos(int preco,int hipoteca,int multiplicador,String informacao){
        this.preco = preco;
        this.hipoteca = hipoteca;
        this.multiplicador = multiplicador;
        this.informacao = informacao;
    }
    
    @Override
    public String descricao(){
        return this.informacao;
    }
    
    public String toString(){
        return "Preço: "+this.preco+" Hipoteca: "+this.hipoteca+" Multiplicador: "+this.multiplicador;
    }
    
    public int getPreco() {
        return preco;
    }

    public int getMultiplicador() {
        return multiplicador;
    }

    public int getHipoteca() {
        return hipoteca;
    }
        
}
