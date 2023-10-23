package Bissecao;
import java.util.function.Function;
public class Bissecao {
    public static void main(String[] args) {
        // Intervalo inicial
        double a = -5.0;
        double b = 4.0;

        // Tolerância 
        double tolerancia = 1e-6;

        // Função que queremos encontrar a raiz
        Function<Double, Double> funcao = x -> x + Math.cos(x);

        Resultado resultado = metodoBissecao(a, b, tolerancia, funcao);

        double raiz = resultado.raiz;
        int iteracoes = resultado.iteracoes;

        System.out.println("A raiz da função é aproximadamente: " + raiz);
        System.out.println("Número de iterações: " + iteracoes);
    }

    public static Resultado metodoBissecao(double a, double b, double tolerancia, Function<Double, Double> funcao) {
        if (funcao.apply(a) * funcao.apply(b) >= 0) {
            throw new IllegalArgumentException("A função não satisfaz os critérios.");
        }

        double x = (a + b) / 2;
        int iteracoes = 0;

        while (Math.abs(funcao.apply(x)) > tolerancia) {
            iteracoes++;

            if (funcao.apply(a) * funcao.apply(x) < 0) {
                b = x;
            } else {
                a = x;
            }
            x = (a + b) / 2;
        }

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


