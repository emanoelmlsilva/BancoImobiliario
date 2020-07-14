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
public class VaParaPrisao implements Cartas{
    
    private String informacao;
    private final int INDICE_PRISAO = 10;
    
    public VaParaPrisao(String informacao){
        this.informacao = informacao;
    }
    
    public void prisao(Jogador jogadorDaVez){
        jogadorDaVez.setPosicaoTabuleiro(INDICE_PRISAO);
    }
    
    @Override
    public String descricao(){
        return this.informacao;
    }
}
