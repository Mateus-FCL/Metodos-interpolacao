package Lagrange;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class lagrange {

    public static double interpolate(double[] xValues, double[] yValues, double x) {
        if (xValues.length != yValues.length) {
            throw new IllegalArgumentException("OS arrays devem ter o mesmo tamanho");  
        }

        double result = 0;

        for (int i = 0; i < xValues.length; i++) {
            double term = yValues[i];
            for (int j = 0; j < xValues.length; j++) {
                if (j != i) {
                    term *= (x - xValues[j]) / (xValues[i] - xValues[j]);
                }
            }
            result += term;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Double> valuexList = new ArrayList<>();
        List<Double> valueyList = new ArrayList<>();
        
        //Para informar o valor de z
        System.out.println("Informe o valor de Z: ");
        double z = in.nextDouble();

        //Para informar os valores de x
        System.out.println("Informe quantos números vai ter em X: ");
        int sizeX = in.nextInt();
        for(int i = 0; i < sizeX; i++){
            System.out.println("Valor de X: ");
            double xValues = in.nextDouble();
            valuexList.add(xValues);
        }

        //Para informar os valores de y
        System.out.println("Informer quantos números vai ter em Y: ");
        int sizeY = in.nextInt();
        for(int i = 0; i < sizeY; i++){
            System.out.println("Valor de Y: ");
            double yValues = in.nextDouble();
            valueyList.add(yValues);
        }

        double[] xValues = valuexList.stream().mapToDouble(Double::doubleValue).toArray();
        double[] yValues = valueyList.stream().mapToDouble(Double::doubleValue).toArray();
        double interpo = interpolate(xValues, yValues, z);
        System.out.println("Valor interpolado de z = " + z + " é = " + interpo);
        in.close();
    }
}
