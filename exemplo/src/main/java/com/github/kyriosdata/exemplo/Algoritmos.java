/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.kyriosdata.exemplo;

/**
 *Algoritmos matemáticos das listas 02 e 03 de Construção de Software
 * @author Lucas Sampaio Dias
 */
public class Algoritmos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
    /**
     * A soma dos primeiros naturais, N = { 0, 1, 2, ... }
     * O valor do somatório pode ser obtido por n (n + 1)/2
     * @param n número do somatório
     */
    public static int somaNaturais(int n){  
        int i = 2;
        int s = 1;        
        if (1 <= n){
           while (i <= n){
               s = s + i;
               i++;
           }
        }
        else{
            throw new IllegalArgumentException("Erro: n < 1");
        }
        return s;
    }
    
    /**
     * Produto de dois inteiros usando a menor quantidade de somas
     * @param a primeiro número da multiplicação
     * @param b segundo número da multiplicação
     */
    public static int produto(int a, int b){
        int i = 1;
        int s = 0;
        
        if (0 <= a && 0 <= b){
            int totalParcelas = a;
            int parcela = b;
            if (b < a){
                totalParcelas = b;
                parcela = a;
            }
            while(i <= totalParcelas){
                s += parcela;
                i++;
            }
        }
        else{
            throw new IllegalArgumentException("Erro: a ou b < 0");
        }
        
        return s;
    }
    
    /**
     * Potência de dois inteiros usando apenas somas
     * @param x base
     * @param y potência
     */
    public static int potencia(int x, int y){
        int potencia = 1;
        int i = 1;
        if (0 <= x && 0 <= y){
            while (i <= y){
                potencia = produto(potencia, x);
                i++;
            }
        }
        else{
            throw new IllegalArgumentException("Erro: x ou y < 0");
        }
        return potencia;
    }
    
    /**
     * Propriedade onde os dois primeiros digitos + os dois últimos
     * formam ele mesmo. Exemplo: 3025 = "30 + 25"
     * @param n número a ser testado pela propriedade
     */
    public static boolean propriedade3025(int n){
        int i = 0;
        int j = 0;
        if (0 <= n && n <= 9999){
            i = n / 100;
            j = n % 100;
        }
        else{
            throw new IllegalArgumentException("Erro: n < 0 ou > 9999");
        }
        return Math.pow((i + j), 2) == n;
    }
    
    /**
     * A soma dos cubos dos dígitos do número 153 resulta em 
     * 153, 13 + 53 + 33 = 153.
     * @param n número a ser testado pela propriedade
     */
    public static boolean propriedade153(int n){
        int i = 0;
        int j = 0;
        int k = 0;
        
        if (0 <= n && n <= 9999){
            i = n/100;
            j = ((n - (100 * i))/10);
            k = n % 10;
        }
        else{
            throw new IllegalArgumentException("Erro: n < 0 ou > 9999");
        }
        
        return (Math.pow(i, 3) + Math.pow(j, 3) + Math.pow(k, 3)) == n;
    }
    
    /**
     * Testa se o valor informado é primo (divisível apenas por 1 e ele mesmo)
     * @param n número a ser testado
     */
    public static boolean primo(int n){
        if (n > 1){
            int i = 2;
            while (i <= n - 1){
                if (n % i == 0){
                    return false;
                }
                i++;
            }
        }
        else{
            throw new IllegalArgumentException("Erro: n < 1");
        }
        return true;
    }
    
    /**
     * Calcula o crivo de Eratostenes, que são os primos de 1 a n
     * @param a[] vetor de números que são primos
     * @param n limite dos números buscados
     */
    public static void crivoEratostenes(int[] a, int n){
        int c = 0;
        if (n > 1){
            boolean validacao = true;
            for (int i = 2; i <= n; i++){
                if (a[i] != 0){
                    validacao = false;
                }
            }
            if (validacao){
                int i = 2;
                while (i <= n/2){
                    if (a[i] == 0){
                        c = i + i;
                        while(c <= n){
                            a[c] = 1;
                            c = c + i;
                        }
                    }
                    i++;
                }
            }
        }
    }
    
    /**
     * Encontra qual o maior divisor comum entre dois números inteiros
     * @param a maior número
     * @param b menor número
     */
    public static int mdc(int a, int b){
        int m;
        if (b <= a && 0 < b){
            while (b != 0){
                m = a % b;
                a = b;
                b = m;
            }
        }
        else{
            throw new IllegalArgumentException("Erro: n < 1");
        }
        return a;
    }
    /**
     * O número harmônico de n é igual a 1/1 + 1/2 + ... + 1/n
     * @param n número a ser testado pela propriedade
     */
    public static float numeroHarmonico(int n){
        int i = 2;
        int s = 1;
        
        if (n < 2){
            throw new IllegalArgumentException("Erro: n < 2");
        }
        
        while (i <= n){
            s += (1 / i);
            i++;
        }
        
        return s;
    }
}
