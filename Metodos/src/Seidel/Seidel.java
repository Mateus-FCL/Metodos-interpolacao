package Seidel;

class Result {
    int inter;
    int info;
}

public class Seidel {
    public static void main(String[] args) {
        int n = 10; // Tamanho da matriz e vetores
        double[][] a = {
                { 4, -1, 0, -1, 0, 0, 0, 0, 0, 0 },
                { -1, 4, -1, 0, -1, 0, 0, 0, 0, 0 },
                { 0, -1, 4, 0, 0, -1, 0, 0, 0, 0 },
                { -1, 0, 0, 4, -1, 0, 0, 0, 0, 0 },
                { 0, -1, 0, -1, 4, -1, -1, 0, 0, 0 },
                { 0, 0, -1, 0, -1, 4, 0, -1, 0, 0 },
                { 0, 0, 0, 0, -1, 0, 4, -1, 0, 0 },
                { 0, 0, 0, 0, 0, -1, -1, 4, -1, 0 },
                { 0, 0, 0, 0, 0, 0, 0, -1, 4, -1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, -1, 4 } }; // Matriz dos coeficientes
        double[] b = { -110, -30, -40, -110, 0, -15, -90, -25, -55, -65 }; // Vetor de termos independentes
        int interMax = 100; // Número máximo de iterações
        double toler = 1e-7; // Tolerância

        double[] x = new double[n]; 
        Result result = new Result();
        result.inter = 0;
        result.info = 0;

        gaussSeidelSolucao(n, a, b, interMax, toler, x, result);

        // Exibir resultados
        if (result.info == 0) {
            System.out.println("Solução encontrada após " + result.inter + " iterações:");
            for (int i = 0; i < n; i++) {
                System.out.println("x[" + i + "] = " + x[i]);
            }
        } else {
            System.out.println("O algoritmo não convergiu após " + interMax + " iterações.");
        }
    }

    public static void gaussSeidelSolucao(int n, double[][] a, double[] b, int interMax, double toler,
            double[] x, Result result) {
        while (result.inter < interMax) {
            double maxError = 0.0;

            for (int i = 0; i < n; i++) {
                double sum = b[i];
                double diag = a[i][i];

                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum -= a[i][j] * x[j];
                    }
                }

                double newX = sum / diag;
                double error = Math.abs(newX - x[i]);
                x[i] = newX;

                if (error > maxError) {
                    maxError = error;
                }
            }

            if (maxError < toler) {
                result.info = 0;
                break;
            }

            result.inter++;
        }

        if (result.inter == interMax) {
            result.info = 1;
        }
    }
}
