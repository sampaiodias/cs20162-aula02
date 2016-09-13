/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package somanumeros;

import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class SomaNumeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Insira um número: ");
        int num = Integer.parseInt(leitor.nextLine());
        System.out.println("A soma dos primeiros números é: " 
                + somaNaturais(num));
    }
    
    public static int somaNaturais(int n){  
        int i = 2;
        int s = 1;        
        if (1 <= n){
           while (i <= n){
               s = s + i;
               i++;
           }
        }
        return s;
    }
    
}
