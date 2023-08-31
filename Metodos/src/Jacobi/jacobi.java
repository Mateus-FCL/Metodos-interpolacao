package Jacobi;
public class jacobi {
    public static void main(String[] args) {
        int n = 3; // Tamanho da matriz e vetores
        double[][] a = {{10, 3, -2}, {2, 8, -1}, {1, 1, 5}}; // Matriz dos coeficientes
        double[] b = {57, 20, -4}; // Vetor de termos independentes
        int interMax = 9; // Número máximo de iterações
        double toler = 1e-5; // Tolerância

        double[] x = new double[n]; // Vetor solução
        int inter = 0; // Número de iterações realizadas
        int info = -1; // Informação sobre a convergência

        jacobiSolucao(n, a, b, interMax, toler, x, inter, info);

        // Exibir resultados
        if (info == 0) {
            System.out.println("Solução encontrada após " + inter + " iterações:");
            for (int i = 0; i < n; i++) {
                System.out.println("x[" + i + "] = " + x[i]);
            }
        } else {
            System.out.println("O algoritmo não convergiu após " + interMax + " iterações.");
        }
    }

    public static void jacobiSolucao(int n, double[][] a, double[] b, int interMax, double toler,
                                    double[] x, int inter, int info) {
        double[] tempX = new double[n];

        while (inter < interMax) {
            for (int i = 0; i < n; i++) {
                double sum = b[i];
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum -= a[i][j] * x[j];
                    }
                }
                tempX[i] = sum / a[i][i];
            }

            double error = 0.0;
            for (int i = 0; i < n; i++) {
                error += Math.abs(tempX[i] - x[i]);
            }

            if (error < toler) {
                info = 0;
                break;
            }

            for (int i = 0; i < n; i++) {
                x[i] = tempX[i];
            }

            inter++;
        }

        if (inter == interMax) {
            info = 1;
        }
    }
}
