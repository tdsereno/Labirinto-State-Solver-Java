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
public class Labirinto {

    public static void main(String[] args) {
        LabirintoR l = new LabirintoR();
        int[] ini = l.obterInicio();

        l.resolverlab(ini[0], ini[1]);
        if (l.tmsaida) {
            System.out.println("Foi encontrado saida para esta labirinto");
            System.out.println(l.toString());
        } else {
            System.out.println("Não foi encontrado ha saida para esta labirinto");
            System.out.println(l.toString());
        }

        System.out.println("Foram feitas " + l.obterNComparacoes() + " comparaçoes");

    }

}
