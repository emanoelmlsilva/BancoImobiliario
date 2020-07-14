/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bancoimobiliario;

/**
 * Classe para objetos do tipo Propriedade, contendo informações e operações a serem realizadas
 * @author emanoel
 */
public class Propriedade implements Cartas{
    
    private final int preco;
    private final int aluguelSemCasa;
    private final int casa1;
    private final int casa2;
    private final int casa3;
    private final int casa4;
    private final int hotel;
    private final int hipoteca;
    private final int precoDaCasa;
    private final String informacao;
    private final String cor;
    private int casas;
    
    /**
     * Construtor de Propriedade
     * @param preco - valor da propriedade
     * @param aluguelSemCasa - valor do aluguel quando o jogador não possui nenhuma casa
     * @param casa1 - a quantidade de casas possuídas é igual a 1
     * @param casa2 - a quantidade de casas possuídas é igual a 2
     * @param casa3 - a quantidade de casas possuídas é igual a 3
     * @param casa4 - a quantidade de casas possuídas é igual a 4
     * @param hotel - o hotel é construído quando a propriedade possui 4 casas da mesma cor
     * @param hipoteca - lista as propriedades que podem ser hipotecadas
     * @param precoDaCasa - preço da casa
     * @param informacao - descrição da propriedade
     * @param cor - cor da propriedade
     */
    public Propriedade(int preco, int aluguelSemCasa, int casa1, int casa2, int casa3, int casa4, int hotel, int hipoteca, int precoDaCasa, String informacao, String cor) {
        this.preco = preco;
        this.aluguelSemCasa = aluguelSemCasa;
        this.casa1 = casa1;
        this.casa2 = casa2;
        this.casa3 = casa3;
        this.casa4 = casa4;
        this.hotel = hotel;
        this.hipoteca = hipoteca;
        this.precoDaCasa = precoDaCasa;
        this.informacao = informacao;
        this.cor = cor;
        this.casas = 0;
    }
     
    
    /**
     * Método que retorna a descrição da propriedade
     * @return String da descrição da propriedade
     */
    @Override
    public String descricao(){        
        return this.informacao;
    }
    
    /**
     * Método que retorna todas as informações da propriedade
     * @return concatenação das informações
     */
    @Override
    public String toString(){
        return "Preço: " + this.preco + " Aluguel do Terreno: " + this.aluguelSemCasa + "Terreno com "
                + "1 casa "+this.casa1 + " 2 casas: " + this.casa2 + " 3 casas: " + this.casa3 + " 4 casas: " 
                + this.casa4 + " Hotel: " + this.hotel + " Hipoteca: " + this.hipoteca + " Preço da Casa: " + this.precoDaCasa;
    }
    
    /**
     * Método que retorna a quantidade de casas da propriedade
     * @param compraCasa - caso a compra seja realizada, terá mais uma casa
     * @return total de casas adiquiridas
     */
    public int quantidadeDeCasas(boolean compraCasa) {
        
        if (compraCasa){
            this.casas++;
        }
        
        switch (this.casas) {
            
            case 0:
                return this.aluguelSemCasa;                
                
            case 1:
                return this.casa1;
                
            case 2:
                return this.casa3;
                
            case 3:
                return this.casa4;
                
            case 4:
                return this.hotel;
                
            default:
                return 0;
        }
    }
    
    /**
     * Método que informa a descrição da propriedade
     * @return informação da propriedade
     */
    public String getInformacao() {
        return this.informacao;
    }
    
    /**
     * Método que retorna a cor da propriedade
     * @return cor da propriedade
     */
    public String getCor(){
        return this.cor;
    }
    
    /**
     * Método que retorna o preço da propriedade
     * @return valor da propriedade
     */
    public int getPreco() {
        return preco;
    }
    
    /**
     * Método que retorna o valor do aluguel quando a propriedade não possui casas
     * @return valor do aluguel quando não possuir casas
     */
    public int getAluguelSemCasa() {
        return aluguelSemCasa;
    }
    
    /**
     * Método que retorna o valor do aluguel quando a propriede possui uma casa
     * @return valor do aluguel quando possuir uma casa
     */
   
    public int getCasa1() {
        return casa1;
    }

    /**
     * Método que retorna o valor do aluguel quando a propriede possui duas casas
     * @return valor do aluguel quando possuir duas casas
     */
    public int getCasa2() {
        return casa2;
    }

    /**
     * Método que retorna o valor do aluguel quando a propriede possui três casas
     * @return valor do aluguel quando possuir três casas
     */
    public int getCasa3() {
        return casa3;
    }

    /**
     * Método que retorna o valor do aluguel quando a propriedade possuir quatro casas
     * @return valor do aluguel quando possuir quatro casas
     */
    public int getCasa4() {
        return casa4;
    }

    /**
     * Método que retorna o valor a pagar quando a propriedade possuir um hotel (5 casas)
     * @return valor do aluguel quando possuir cinco casas
     */
    public int getHotel() {
        return hotel;
    }

    /**
     * Método que retorna o valor da hipoteca que receberá do banco após o jogador hipotecar suas propriedades
     * @return valor da hipoteca
     */
    public int getHipoteca() {
        return hipoteca;
    }

    /**
     * Método que retorna o valor da casa
     * @return valor da casa
     */
    public int getPrecoDaCasa() {
        return precoDaCasa;
    }
    
}

