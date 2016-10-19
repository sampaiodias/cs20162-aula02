/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.kyriosdata.exemplo;

/**
 * Algoritmos matemáticos das listas 02 e 03 de Construção de Software.
 */
public final class Algoritmos {

    /**
     * Construtor.
     */
    private Algoritmos() {

    }
    /**
     * Limite máximo que podem ser analisado pelos algoritmos de propriedades.
     */
    private static final int LIMITE_MAX_PROPRIEDADES = 9999;
    /**
     * Número para divisões nas propriedades.
     */
    private static final int DIV_CENTENA = 100;
    /**
     * Número para divisões nas propriedades.
     */
    private static final int DIV_DEZENA = 10;
    /**
     * Número da potenciação ao cubo.
     */
    private static final int POTENCIA_CUBO = 3;

    /**
     * A soma dos primeiros naturais, N = { 0, 1, 2, ... } O valor do somatório
     * pode ser obtido por n (n + 1)/2.
     *
     * @param n número do somatório
     * @return valor da soma
     */
    public static int somaNaturais(final int n) {
        int i = 2;
        int s = 1;
        if (1 <= n) {
            while (i <= n) {
                s = s + i;
                i++;
            }
        } else {
            throw new IllegalArgumentException("Erro: n < 1");
        }
        return s;
    }

    /**
     * Produto de dois inteiros usando a menor quantidade de somas.
     *
     * @param a primeiro número da multiplicação
     * @param b segundo número da multiplicação
     * @return resultado do produto
     */
    public static int produto(final int a, final int b) {
        int i = 1;
        int s = 0;

        if (0 <= a && 0 <= b) {
            int totalParcelas = a;
            int parcela = b;
            if (b < a) {
                totalParcelas = b;
                parcela = a;
            }
            while (i <= totalParcelas) {
                s += parcela;
                i++;
            }
        } else {
            throw new IllegalArgumentException("Erro: a ou b < 0");
        }

        return s;
    }

    /**
     * Potência de dois inteiros usando apenas somas.
     *
     * @param x base
     * @param y potência
     * @return resultado da potência
     */
    public static int potencia(final int x, final int y) {
        int potencia = 1;
        int i = 1;
        if (0 <= x && 0 <= y) {
            while (i <= y) {
                potencia = produto(potencia, x);
                i++;
            }
        } else {
            throw new IllegalArgumentException("Erro: x ou y < 0");
        }
        return potencia;
    }

    /**
     * Propriedade onde os dois primeiros digitos + os dois últimos formam ele
     * mesmo. Exemplo: 3025 = "30 + 25".
     *
     * @param n número a ser testado pela propriedade
     * @return Verdadeiro -entra na propriedade 3025- ou falso
     */
    public static boolean propriedade3025(final int n) {
        int i = 0;
        int j = 0;
        if (0 <= n && n <= LIMITE_MAX_PROPRIEDADES) {
            i = n / DIV_CENTENA;
            j = n % DIV_CENTENA;
        } else {
            throw new IllegalArgumentException("Erro: n < 0 ou > 9999");
        }
        return Math.pow((i + j), 2) == n;
    }

    /**
     * A soma dos cubos dos dígitos do número 153 resulta em 153, 13 + 53 + 33 =
     * 153.
     *
     * @param n número a ser testado pela propriedade
     * @return Verdadeiro -entra na propriedade 153- ou falso
     */
    public static boolean propriedade153(final int n) {
        int i = 0;
        int j = 0;
        int k = 0;

        if (0 <= n && n <= LIMITE_MAX_PROPRIEDADES) {
            i = n / DIV_CENTENA;
            j = ((n - (DIV_CENTENA * i)) / DIV_DEZENA);
            k = n % DIV_DEZENA;
        } else {
            throw new IllegalArgumentException("Erro: n < 0 ou > 9999");
        }

        return (Math.pow(i, POTENCIA_CUBO) + Math.pow(j, POTENCIA_CUBO)
                + Math.pow(k, POTENCIA_CUBO)) == n;
    }

    /**
     * Testa se o valor informado é primo (divisível apenas por 1 e ele mesmo).
     *
     * @param n número a ser testado
     * @return Verdadeiro -se for primo- ou falso
     */
    public static boolean primo(final int n) {
        if (n > 1) {
            int i = 2;
            while (i <= n - 1) {
                if (n % i == 0) {
                    return false;
                }
                i++;
            }
        } else {
            throw new IllegalArgumentException("Erro: n < 1");
        }
        return true;
    }

    /**
     * Calcula o crivo de Eratostenes, que são os primos de 1 a n.
     *
     * @param a vetor de números que são primos
     * @param n limite dos números buscados
     */
    public static void crivoEratostenes(final int[] a, final int n) {
        int c = 0;
        if (n > 1) {
            boolean validacao = true;
            for (int i = 2; i <= n; i++) {
                if (a[i] != 0) {
                    validacao = false;
                }
            }
            if (validacao) {
                int i = 2;
                while (i <= n / 2) {
                    if (a[i] == 0) {
                        c = i + i;
                        while (c <= n) {
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
     * Encontra qual o maior divisor comum entre dois números inteiros.
     *
     * @param a maior número
     * @param b menor número
     * @return valor do mdc
     */
    public static int mdc(final int a, final int b) {
        int m;
        if (b <= a && 0 < b) {
            int maior = a;
            int menor = b;
            while (menor != 0) {
                m = maior % menor;
                maior = menor;
                menor = m;
            }
            return maior;
        } else {
            throw new IllegalArgumentException("Erro: n < 1");
        }
    }

    /**
     * O número harmônico de n é igual a 1/1 + 1/2 + ... + 1/n.
     *
     * @param n número de repetoições do somatório
     * @return valor do número harmônico buscado
     */
    public static float numeroHarmonico(final int n) {
        int i = 2;
        int s = 1;

        if (n < 2) {
            throw new IllegalArgumentException("Erro: n < 2");
        }

        while (i <= n) {
            s += (1 / i);
            i++;
        }

        return s;
    }
}
