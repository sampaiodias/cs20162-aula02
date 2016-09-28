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
     * @return valor da soma
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
     * @return resultado do produto
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
     * @return resultado da potência
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
     * @return Verdadeiro -entra na propriedade 3025- ou falso
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
     * @return Verdadeiro -entra na propriedade 153- ou falso
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
     * @return Verdadeiro -se for primo- ou falso
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
     * @return valor do mdc
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
     * @param n número de repetoições do somatório
     * @return valor do número harmônico buscado
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
    /**
     * Um somatório envolvendo os primeiros números naturais
     * @param n número de repetições do somatório
     * @return resultado do somatório
     */
    public static int somatorioElementar(int n){
        int i = 1;
        int s = 0;
        
        if (1 <= n){
            while(i <= n){
                int d = 1 + potencia(i, 2);
                s = s + (1 / d);
                i++;
            }
        }
        else{
            throw new IllegalArgumentException("Erro: n < 1");
        }
        
        return s;
    }
    /**
     * Calcula o valor de PI através de um somatório.
     * @param n número de repetições do somatório
     * @return valor de PI
     */
    public static float pi(int n){
        int i = 1;
        int s = -1;
        int d = -1;
        int p = 0;
        
        if (1 <= n){
            while (i <= n){
                d = d + 2;
                s *= -1;
                p = p + 4 * s / d;
                i++;
            }
        }else{
            throw new IllegalArgumentException("Erro: n < 1");
        }
        return p;
    }
    /**
     * Calcula o fatorial de um número natural n
     * @param n valor base
     * @return fatorial de n
     */
    public static int fatorial(int n){
        int i = 2;
        int f = 1;
        
        if (1 <= n){
            while(i <= n){
                f *= i;
                i++;
            }
        }
        else{
            throw new IllegalArgumentException("Erro: n < 1");
        }
        
        return f;
    }
    /**
     * Calcula o logaritmo natural de um número natural positivo n
     * @param n Número base, sendo n maior ou igual a 1
     * @param k Repetições, sendo k maior ou igual a 2
     * @return valor do logaritmo natural de n
     */
    public static float logaritmoNatural(int n, int k){
        int i = 2;
        float e = n + 1;
        
        if (1 <= n && 2 <= k){
            while (i  <= k){
                int p = potencia(n, i);
                int f = fatorial(i);
                e += p / f;
                i++;
            }
        }
        else{
            throw new IllegalArgumentException("Erro: Parâmetro(s) inválido!");
        }
        
        return e;
    }
    /**
     * Calcula a razão áurea com dois inteitos positivos em k repetições
     * @param x x maior ou igual a 0
     * @param y y maior que x
     * @param k k maior que 0
     * @return Valor da razão áurea
     */
    public static float razaoAurea(int x, int y, int k){
        int c = y;
        int a = x;
        int i = 1;
        
        if (0 <= x && x < y && 0 < k){
            while (i <= k){
                int t = c;
                c += a;
                a = t;
                i++;
            }
        }
        else{
            throw new IllegalArgumentException("Erro: Parâmetro(s) inválido!");
        }
        
        return c / a;
    }
    /**
     * Verifica se o número fornecido é um quadrado perfeito
     * @param k número que será verificado
     * @return verdadeiro (é quadrado perfeito) ou falso
     */
    public static boolean quadradoPerfeito(int k){
        int i = 1;
        int q = 1;
        if (1 <= k){
            while (q < k){
                i += 2;
                q += i;
            }
        }
        else{
            throw new IllegalArgumentException("Erro: k < 1");
        }

        return q == k;
    }
    /**
     * Calcula o resto da divisão de dois inteiros
     * @param x dividendo
     * @param y divisor
     * @return resto da divisão
     */
    public static int mod(int x, int y){
        int s = x;
        
        if (0 <= y && 0 < x){
            while (y <= s){
                s -= y;
            }
        }
        else{
            throw new IllegalArgumentException("Erro: Parâmetro(s) inválido!");
        }
        
        return s;
    }
    /**
     * Calcula a raiz pelo método babilônico de um número n
     * @param n Número desejado
     * @param i Quanto maior i, maior a aproximação da raiz desejada
     * @return Raiz
     */
    public static float raiz(int n, int i){
        float r = 1;
        
        if (0 > n){
            while (0 <= i){
                r = (r + n / r) / 2;
                i--;
            }
        }
        else{
            throw new IllegalArgumentException("Erro: n <= 0");
        }
        
        return r;
    }
    /**
     * Calcula o n-ésimo valor da sequência Fibonacci
     * @param n posição na sequência
     * @return valor buscado
     */
    public static int fibonacci(int n){
        int a = 0;
        int c = 1;
        
        if (0 <= n){
            if (n == 0 || n == 1){
                return n;
            }
            int i = 2;
            while (i <= n){
                int t = c;
                c += a;
                a = t;
                i++;
            }
        }
        else{
            throw new IllegalArgumentException("Erro: n < 0");
        }
        
        return c;
    }
}
