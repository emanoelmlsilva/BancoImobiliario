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
public class LucrosDividendos implements Cartas{
    
    private String informacao;
    public final int VALOR200 = 200;
    
    public LucrosDividendos(String informacao){
        this.informacao = informacao;
    }
    
    public void receber(Jogador jogador){
        jogador.getConta().creditar(VALOR200);
    }
    
    @Override
    public String descricao(){
        return this.informacao;
    }
       
}
