package iterations;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by supi on 6/10/18.
 */
public class TestMenorInteiro {

    public static void main(String[] args) {

        Scanner tam = new Scanner(System.in);
        System.out.printf("Digite o tamanho do vetor: ", tam);
        int t = tam.nextInt();


        int v[] = new int[t];
        int i;

        Scanner ler = new Scanner(System.in);
        for (i=0; i<t; i++) {
            System.out.printf("Informe %2do. valor de %d: ", (i+1), t);
            v[i] = ler.nextInt();
        }

        Arrays.sort(v);
        Arrays.stream(v).forEach(e -> System.out.println(e));

        int resultadoTest1 = resultadoTest(v);
        System.out.println("O resultado é: " + resultadoTest1);
    }

    public static int resultadoTest(int[] v) {
        int resultado = 0;
        if (v[v.length - 1] < 0) {
            resultado = 1;
        } else {
            int j = 0;
            while ((j < v.length) && (resultado == 0)) {
                if (j == v.length - 1) {
                    resultado = v[j] + 1;
                } else if (v[j] >= 0) {
                    if (v[j + 1] - v[j] > 1) {
                        resultado = v[j] + 1;
                    }
                }
                j++;
            }
        }
        return resultado;
    }
}
