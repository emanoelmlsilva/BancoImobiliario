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
public class ImpostoRenda implements Cartas{
    
    private final String informacao;
    private Jogador jogadorDaVez;
    public final int VALOR_PAGAR = 200;
    
    public ImpostoRenda(String informacao){
        this.informacao = informacao;
    }
    
    public void pague(Jogador jogadorDaVez){
        this.jogadorDaVez.getConta().creditar(200);
    }
    
    public String descricao(){
        return this.informacao;
    }
    
}
