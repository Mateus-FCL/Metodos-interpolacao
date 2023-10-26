package Bissecao;

import java.util.function.Function;

public class BissecaoFalse {
    public static void main(String[] args) {
        // Estimativas iniciais
        double a = -5.0;
        double b = 4.0;

        // Tolerância desejada
        double tolerancia = 1e-6;

        // Função que queremos encontrar a raiz
        Function<Double, Double> funcao = x -> x + 2 * (Math.cos(x));

        Resultado resultado = metodoSecante(a, b, tolerancia, funcao);

        double raiz = resultado.raiz;
        int iteracoes = resultado.iteracoes;

        System.out.println("A raiz da função é aproximadamente: " + raiz);
        System.out.println("Número de iterações: " + iteracoes);
    }

    public static Resultado metodoSecante(double a, double b, double tolerancia, Function<Double, Double> funcao) {
        double x;
        int iteracoes = 0;

        do {
            x = (a * funcao.apply(b) - b * funcao.apply(a)) / (funcao.apply(b) - funcao.apply(a));
            a = b;
            b = x;
            iteracoes++;
        } while (Math.abs(funcao.apply(x)) > tolerancia);

        return new Resultado(x, iteracoes);
    }

    public static class Resultado {
        public double raiz;
        public int iteracoes;

        public Resultado(double raiz, int iteracoes) {
            this.raiz = raiz;
            this.iteracoes = iteracoes;
        }
    }
}
