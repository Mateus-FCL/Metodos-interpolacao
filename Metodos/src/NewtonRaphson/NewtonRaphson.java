package NewtonRaphson;
public class NewtonRaphson {
    static double funcao(double x) {
        return x * x + 2 * x - 3;
    }
    static double derivada(double x) {
        return 2 * x + 2;
    }

    static double newtonRaphson(double x0, double tolerancia, int maxIteracoes) {
        double x = x0;
        for (int i = 0; i < maxIteracoes; i++) {
            double fx = funcao(x);
            double derivadaFx = derivada(x);
            x = x - fx / derivadaFx;
            if (Math.abs(funcao(x)) < tolerancia) {
                System.out.println("Convergiu após " + (i + 1) + " iterações.");
                return x;
            }
        }
        System.out.println("O método de Newton-Raphson não convergiu após " + maxIteracoes + " iterações.");
        return Double.NaN;
    }

    public static void main(String[] args) {
        //Entrada de dados !!
        double raiz = newtonRaphson(1.0, 1e-6, 100);
        if (!Double.isNaN(raiz)) {
            System.out.println("A raiz aproximada é: " + raiz);
        }
    }
}


