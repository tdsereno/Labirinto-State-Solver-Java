/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labirinto;

/**
 *
 * @author Tiago
 */
public class LabirintoR {

    public LabirintoR() {
        try {

        } catch (Exception e) {
        }
    }

    public char[][] labirinto
            = {{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', '#', ' ', 'F', '#'},
            {'#', ' ', '#', ' ', '#', ' ', '#', ' ', '#', '#'},
            {'#', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', '#', '#', ' ', '#'},
            {'#', '#', '#', '#', '#', ' ', '#', ' ', ' ', '#'},
            {'#', ' ', '#', ' ', '#', ' ', '#', ' ', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', '#'},
            {'#', 'I', '#', '#', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},};

    public int[] obterInicio() {
        int[] retorno = {0, 0};
        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[0].length; j++) {
                if (labirinto[i][j] == 'I') {
                    retorno[0] = i;
                    retorno[1] = j;
                   //                                                                                                                                                                                                                       0 System.out.println("o retorno foi " + i + " e " + j);
                }
            }
        }

        return retorno;

    }

    public int[] obterFim() {
        int[] retorno = {0, 0};
        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[0].length; j++) {
                if (labirinto[i][j] == 'F') {
                    retorno[0] = i;
                    retorno[1] = j;
                    //System.out.println("o retorno foi " + i + " e " + j);
                }
            }
        }
        return retorno;
    }

    public void resolverlab(int a, int b) {

        if (estado(a, b)) {
            labirinto[a][b] = 'I';
        } else {
            labirinto[a][b] = 'I';
            tmsaida = false;
         //   System.out.println("nao ha saida para esta labirinto");
        }
    }
    static int contador;

    public int obterNComparacoes() {
        return contador;
    }
    boolean tmsaida = false;

    public boolean temsaida() {
        return tmsaida;
    }

    public boolean estado(int a, int b) {
        contador++;;

        System.out.println(this.toString()); // passo a passo
        try {
            Thread.sleep(100);                
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        //     System.out.println("entrei estado");
        if (eSolucao(a, b)) {
            //        System.out.println("entrei solucao");
            tmsaida = true;
            return true;

        }
        if (bateu(a, b)) {
            //      System.out.println("entrei bateu");
            return false;
        }
        marcarPassada(a, b);

        if (estado(a, b + 1)) { // direita
            return true;
        } else {

            if (estado(a - 1, b)) { //cima
                return true;
            } else {

                if (estado(a, b - 1)) { // esquerda
                    return true;
                } else {

                    // baixo
                    if (estado(a + 1, b)) {
                        return true;
                    }
                }
            }
        }
        labirinto[a][b] = ' ';

        return false;
    }

    public boolean eSolucao(int a, int b) {
        // System.out.println(a + " " + b);
        if (labirinto[a][b] == 'F') {
            return true;
        } else {
            return false;

        }
    }

    public boolean bateu(int a, int b) {
        if (labirinto[a][b] == '#' || labirinto[a][b] == '-') {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[0].length; j++) {
                s += labirinto[i][j] + " ";

            }
            s += "\n";
        }
        return s;
    }

    public void marcarPassada(int a, int b) {
        if (labirinto[a][b] != 'I') {
            labirinto[a][b] = '-';
        }
    }

}
