/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoimobiliario;

import static bancoimobiliario.Jogador.calculaNovaPosicao;
import exception.ComandoNaoExisteException;
import exception.SaldoInvalidoException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pedro
 * @author emanoel
 */
public class Jogo {

    public static List<Jogador> listaDeJogadores;

    public static void main(String[] args) {
        List<String> listaDeCores = new ArrayList<>();
        Jogador jogadorDaVez;
        preencherComCores(listaDeCores);
        Scanner leitor = new Scanner(System.in);

        boolean cadastrouJogadores = false;
        while (!cadastrouJogadores) {

            try {

                int numeroDeJogadores = Integer.parseInt(input("Digite o número de jogadores [2-6]: ", leitor));

                while (numeroDeJogadores < 2 || numeroDeJogadores > 6) {
                    System.out.println(colorirPalavra("vermelho", "✘ Número de jogadores inválido. Insira novamente!\n"));
                    numeroDeJogadores = Integer.parseInt(input("Digite o número de jogadores [2-6]: ", leitor));
                }

                listaDeJogadores = new ArrayList<>(numeroDeJogadores);

                limpaTela();
                for (int i = 0; i < numeroDeJogadores; i++) {
                    int numeroDaVez = i + 1;
                    String nome = input("\nDigite o nome do jogador " + numeroDaVez + ": ", leitor);

                    String corSelecionada = escolheCor(listaDeCores, numeroDaVez, leitor);

                    listaDeJogadores.add(new Jogador(nome, corSelecionada));
                    limpaTela();

                }
                cadastrouJogadores = true;

            } catch (NumberFormatException e) {
                System.out.println(colorirPalavra("vermelho", "✘ Insira somente números inteiros!\n"));

            }

        }
        System.out.println("O Banco Imobiliário vai começar. Aproveite!\n");

        Tabuleiro tabuleiro = new Tabuleiro();
        boolean gameOver = false;

        String comando = null;
        boolean jogadaFinalizada = false;
        boolean dadosDuplos = false;
        int novaPosicao = 0;
        int contaDadosDuplos = 0;

        while (!gameOver) {

            for (int i = 0; i < listaDeJogadores.size(); i++) {

                jogadorDaVez = listaDeJogadores.get(i);
                boolean comandoValido = false;
                System.out.println(design("⇋", 140));
                imprimeJogadorAtual(jogadorDaVez);

                String notificaDadoDuplo = "";  // será usada para notificar a ocorrência de dados duplos

                do {
                    
                    comando = verificaComando(jogadorDaVez, leitor);
                    limpaTela();

                    if (comando.equals("jogar")) {
                        int[] dadosObtidos = tabuleiro.rolaDado();
                        dadosDuplos = verificaDadosDuplos(dadosObtidos);

                        if (dadosDuplos) {
                            contaDadosDuplos++;
                            
                            if (contaDadosDuplos == 3) {
                                tabuleiro.prendeJogador(jogadorDaVez);
                                notificaDadoDuplo += design(colorirPalavra("vermelho","✸"), contaDadosDuplos) + " O jogador " + nomeECorDoJogador(jogadorDaVez)
                                        + " tirou um dado duplo " + contaDadosDuplos + "x, e será preso!\n";
                                jogadaFinalizada = true;

                            } else {
                                notificaDadoDuplo += design(colorirPalavra("vermelho","✸"), contaDadosDuplos) + " O jogador " + nomeECorDoJogador(jogadorDaVez)
                                        + " tirou um dado duplo " + contaDadosDuplos + "x, e terá direito a outra jogada!\n";

                                jogadaFinalizada = false;
                            }

                        } else {
                            contaDadosDuplos = 0;

                        }

                        if (contaDadosDuplos > 2) {
                            contaDadosDuplos = 0;
                            jogadaFinalizada = true;
                            tabuleiro.prendeJogador(jogadorDaVez);
                            System.out.println(notificaDadoDuplo);
                            notificaDadoDuplo = "";

                        } else {
                            
                            System.out.println(design("⇋", 140));
                            int antigoSaldo = jogadorDaVez.getConta().getSaldo();
                            novaPosicao = calculaNovaPosicao(jogadorDaVez, dadosObtidos, tabuleiro);
                            
                            if (novaPosicao > 39) {
                                System.out.println("✓ O jogador " + nomeECorDoJogador(jogadorDaVez) + "ganhou " + colorirPalavra("verde", "$200") + " por retornar ao começo do tabuleiro!\n");
                                System.out.print(colorirPalavra("vermelho", "✘ Antigo Saldo: $" + Integer.toString(antigoSaldo)
                                    + colorirPalavra("verde", "\n✓ Novo Saldo: $" + Integer.toString(jogadorDaVez.getConta().getSaldo())) + "\n"));
                                
                                System.out.println(design("⇋", 140));
                            }

                            imprimeJogadorAtual(jogadorDaVez);
                            System.out.println(notificaDadoDuplo);
                            notificaDadoDuplo = "";
                            System.out.println("➤ Saldo do Jogador " + nomeECorDoJogador(jogadorDaVez) + colorirPalavra("verde", "$" + Integer.toString(jogadorDaVez.getConta().getSaldo())));

                            System.out.printf("➤ O jogador " + nomeECorDoJogador(jogadorDaVez) + " tirou %d, %d e o peão avançou para " + jogadorDaVez.getPosicaoTabuleiro()
                                    + " - " + tabuleiro.getListaCartas()[jogadorDaVez.getPosicaoTabuleiro()].descricao() + "\n\n", dadosObtidos[0], dadosObtidos[1]);

                            if (tabuleiro.getListaCartas()[jogadorDaVez.getPosicaoTabuleiro()] instanceof Propriedade) {

                                try {
                                    // realização da compra do título de propriedade
                                    jogadorDaVez.compraTituloDePropriedade((Propriedade) tabuleiro.getListaCartas()[jogadorDaVez.getPosicaoTabuleiro()], leitor, listaDeJogadores, jogadorDaVez);
                                    
                                } catch (SaldoInvalidoException erro) {
                                    System.out.println(erro.getMessage());
                                }
                            }
                            dadosDuplos = verificaDadosDuplos(dadosObtidos);  // verifica se os dados do lançamento foram diferentes
                            if (!dadosDuplos) {
                                novaPosicao = 0;
                                jogadaFinalizada = true;
                            }

                        }

                    } else if (comando.equals("status")) {
                        System.out.println(design("⇋", 140));

                        String infoTitulos = "Títulos: \n" + jogadorDaVez.getCartas();
                        if (jogadorDaVez.getCartas().isEmpty()) {
                            infoTitulos = "Títulos: não possui";

                        }

                        System.out.println("STATUS DO JOGADOR: " + nomeECorDoJogador(jogadorDaVez) + "\n");

                        int posicaoAtualJogador = jogadorDaVez.getPosicaoTabuleiro();
                        System.out.println("➤ Situado na posição " + jogadorDaVez.getPosicaoTabuleiro()
                                + " - " + tabuleiro.getListaCartas()[posicaoAtualJogador].descricao()
                                + "\n➤ Saldo: " + colorirPalavra("verde", "$" + jogadorDaVez.getConta().getSaldo())
                                + "\n➤ " + infoTitulos);

                        System.out.println(design("⇋", 140));
                        System.out.println("Jogador " + nomeECorDoJogador(jogadorDaVez) + "insira um novo comando!");
                        jogadaFinalizada = false;

                    } else {

                        comandoValido = false;
                        while (!comandoValido) {
                            try {
                                comando = verificaEscolha(input(nomeECorDoJogador(jogadorDaVez) + "você deseja realmente sair (S/N): ", leitor)).toLowerCase();
                                comandoValido = true;
                                System.out.println("");

                            } catch (ComandoNaoExisteException erro) {
                                System.out.println(erro.getMessage());

                            }
                        }

                        if (comando.equals("s")) {
                            System.out.println("O jogador " + nomeECorDoJogador(jogadorDaVez) + "saiu!");
                            listaDeJogadores.remove(i); // remove o jogador no indice atual do for
                            jogadaFinalizada = true;

                            if (listaDeJogadores.size() == 1) {
                                System.out.println("FIM DE JOGO!");
                                System.exit(0); // saída do sistema
                            }

                        } else {
                            limpaTela();
                            System.out.println("Jogador " + nomeECorDoJogador(jogadorDaVez) + "insira um novo comando!");
                            jogadaFinalizada = false;

                        }

                    }

                } while (!jogadaFinalizada && contaDadosDuplos < 3);

            }

        }

    }

    
    /**
     * Método que pede realiza uma leitura juntamente com uma mensagem a mostrar
     *
     * @param mensagem - dica para o usuário
     * @param leitor - objeto Scanner
     * @return Scanner - irá ler a entrada
     */
    public static String input(String mensagem, Scanner leitor) {
        System.out.print(mensagem);
        return leitor.nextLine();
    }

    /**
     * Método que verifica se os dados foram duplos
     *
     * @param dadosObtidos - contém dois valores com os dados obtidos
     * @return true caso sejam iguais, ou false caso seja diferentes
     */
    public static boolean verificaDadosDuplos(int[] dadosObtidos) {
        if (dadosObtidos[0] == dadosObtidos[1]) {
            return true;
        }
        return false;
    }
    
    /**
     * Método que verifica se o comando dado foi válido, e caso seja inválido,
     * realiza outra leitura até o comando ser do tipo válido
     *
     * @param jogadorDaVez - jogador que fez o comando
     * @param leitor - objeto Scanner
     * @return retorna o comando que foi verificado e ou reverificado
     */
    public static String verificaComando(Jogador jogadorDaVez, Scanner leitor) {
        String comando = input("Comandos disponíveis: [jogar][status][sair] \nDigite um comando: ", leitor).toLowerCase();

        if (comando.equalsIgnoreCase("jogar") || comando.equalsIgnoreCase("sair") || comando.equalsIgnoreCase("status")) {
            return comando;

        } else {
            limpaTela();
            System.out.print(colorirPalavra("vermelho", "✘ O comando ") + colorirPalavra("amarelo", "'" + comando + "'") + colorirPalavra("vermelho", " é inválido\n") 
                    + "Insira um novo comando para o jogador " + nomeECorDoJogador(jogadorDaVez) + "\n");
            return verificaComando(jogadorDaVez, leitor);
        }
    }

    /**
     * Método que verifica se o comando de saída [s / n] foi válido, e caso seja falso lançará uma exceção
     * @param confirmaSair - valor digitado pelo usuário
     * @return coamando em letra minúscula
     * @throws ComandoNaoExisteException - pode ser que o comando não exista
     */
    public static String verificaEscolha(String confirmaSair) throws ComandoNaoExisteException {
        if (confirmaSair.equalsIgnoreCase("s") || confirmaSair.equalsIgnoreCase("n")) {
            return confirmaSair.toLowerCase();
        }
        throw new ComandoNaoExisteException(colorirPalavra("vermelho", "✘ O comando de saída ") + colorirPalavra("amarelo", "'" + confirmaSair + "'") 
                + colorirPalavra("vermelho", " é inválido!\n"));
    }

    
    /**
     * Método que imprime formatadamente o nome do jogador da vez e sua cor Ex.:
     * JOGADOR DA VEZ: pedro (azul)
     *
     * @param jogadorDaVez - jogador da vez
     */
    public static void imprimeJogadorAtual(Jogador jogadorDaVez) {
        System.out.println("JOGADOR DA VEZ: " + nomeECorDoJogador(jogadorDaVez));
    }

    /**
     * Método que retorna o nome e cor do jogador Ex.: pedro (azul)
     *
     * @param jogadorDaVez - jogador da vez
     * @return String formatada com nome e cor
     */
    public static String nomeECorDoJogador(Jogador jogadorDaVez) {
        return jogadorDaVez.getNome() + " (" + jogadorDaVez.getCor() + ")";
    }

    /**
     * Método que preenche a lista de cores juntamente com o seu respectivo
     * código ANSI
     *
     * @param listaDeCores - lista que será preenchida com as cores
     */
    public static void preencherComCores(List<String> listaDeCores) {   // cores com código ANSI
        listaDeCores.add("\033[1;37mpreto\033[m");
        listaDeCores.add("\033[1;30mbranco\033[m");
        listaDeCores.add("\033[1;31mvermelho\033[m");
        listaDeCores.add("\033[7;32mverde\033[m");
        listaDeCores.add("\033[7;34mazul\033[m");
        listaDeCores.add("\033[7;33mamarelo\033[m");
        listaDeCores.add("\033[2;33mlaranja\033[m");
        listaDeCores.add("\033[7;35mrosa\033[m");
    }

    /**
     * Método que faz a seleção da cor do jogador, e caso seja inválida, pede
     * novamente
     *
     * @param listaDeCores - lista que contém as cores disponíveis
     * @param numeroDaVez - número da vez do jogador atual
     * @param leitor - objeto Scanner
     * @return String da cor selecionada
     */
    public static String escolheCor(List<String> listaDeCores, int numeroDaVez, Scanner leitor) {
        String numeroCor, none = "1";

        String corSelecionada = input("Escolha a cor do peão do jogador " + numeroDaVez
                + " entre as opções seguintes\n" + coresDisponiveis(listaDeCores) + ": ", leitor).toLowerCase();

        switch (corSelecionada) {

            case "preto":
                numeroCor = "37";
                break;

            case "branco":
                numeroCor = "30";
                break;

            case "vermelho":
                numeroCor = "31";
                break;

            case "verde":
                numeroCor = "32";
                none = "7";
                break;

            case "azul":
                numeroCor = "34";
                none = "7";
                break;

            case "amarelo":
                numeroCor = "33";
                none = "7";
                break;

            case "laranja":
                numeroCor = "33";
                none = "2";
                break;

            case "rosa":
                numeroCor = "35";
                none = "7";
                break;

            default:
                numeroCor = "0";
                break;

        }

        if (listaDeCores.indexOf("\033[" + none + ";" + numeroCor + "m" + corSelecionada + "\033[m") != -1) {
            removeCor(listaDeCores, corSelecionada, none, numeroCor);
            return "\033[" + none + ";" + numeroCor + "m" + corSelecionada + "\033[m";
        } else {
            System.out.print(colorirPalavra("vermelho", "✘ A cor ") + colorirPalavra("amarelo", "'" +  corSelecionada + "' ") + colorirPalavra("vermelho", "é inválida. Insira novamente!\n\n"));
            return escolheCor(listaDeCores, numeroDaVez, leitor);
        }

    }

    /**
     * Método que remove uma cor da lista de cores disponíveis
     *
     * @param listaDeCores - contém as cores disponíveis
     * @param corARemover - cor que será removida da lista
     * @param none - código ANSI
     * @param numeroCor - código ANSI
     */
    public static void removeCor(List<String> listaDeCores, String corARemover, String none, String numeroCor) {
        if (listaDeCores.indexOf("\033[" + none + ";" + numeroCor + "m" + corARemover + "\033[m") != -1) {
            listaDeCores.remove("\033[" + none + ";" + numeroCor + "m" + corARemover + "\033[m");
        }
    }

    /**
     * Método que retorna uma String formatada com todas as cores disponíveis
     * Ex.: [preto][azul][verde][rosa]
     *
     * @param listaDeCores - lista contendo as cores disponíveis
     * @return String formatada com as cores
     */
    public static String coresDisponiveis(List<String> listaDeCores) {
        String lista = "";
        for (String cor : listaDeCores) {
            lista += "[";
            lista += cor;
            lista += "]";
        }

        return lista;
    }
    
    /**
     * Método que colore uma palavra com o padrão ANSI
     * @param cor - cor selecionada
     * @param palavra será pintada e retornada com o padrão ANSI
     * @return retornará a palavra pintada com a cor selecionada
     */
    public static String colorirPalavra(String cor, String palavra) {
        
        switch (cor) {
            
            case "preto":
                return "\033[1;37m" + palavra + "\033[m";
            
            case "amarelo":
                return "\033[7;33m" + palavra + "\033[m";
                
            case "verde":
                return "\033[7;32m" + palavra + "\033[m";
        
            case "vermelho":
                return "\033[1;31m" + palavra + "\033[m";
                
            default:
                return "";
        }
    }
    
    /**
     * Método que imprime quebras de linha para deixar o que foi feito para trás
     *
     */
    public static void limpaTela() {
        for (int i = 0; i < 40; i++) {
            System.out.println("\n\n");
        }
    }

    /**
     * Método que retorna um caractere a ser concatenado uma certa quantidade de
     * vezes Ex.: design("*", 3) resulta em ***
     *
     * @param caractere - caractere a ser concantenado consigo mesmo
     * @param numeroDeVezes - total de vezes a repetir a concatenação
     * @return String já concatenada
     */
    public static String design(String caractere, int numeroDeVezes) {
        String design = "";
        for (int i = 0; i < numeroDeVezes; i++) {
            design += caractere + "";
        }
        return design;
    }

}
