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
public class SorteNumParRevesNao implements Cartas{
    
    private final String informacao;
    private final int PAR = 100;
    private final int IMPAR = 100;
    
    public SorteNumParRevesNao(String informacao){
        this.informacao = informacao;
    }
    
    public void numParSorteRevesNao(int[] dados,Jogador jogadorDaVez){
        if((dados[0] == dados[1]) && dados[0] % 2 == 0){
            jogadorDaVez.getConta().creditar(PAR);
        }else{
            jogadorDaVez.getConta().creditar(IMPAR);
        }
    }
    
    @Override
    public String descricao(){
        return this.informacao;
    }
}
