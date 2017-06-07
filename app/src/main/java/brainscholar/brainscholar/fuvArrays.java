package brainscholar.brainscholar;

import java.util.Scanner;

/**
 * Created by derekroberts on 6/7/17.
 */

public class fuvArrays {

    public static void main(String[] args) {

        double c = 0.025;
        double gna = 0.9;
        double gk = 1.1;
        double beta = 0.6;
        double gamma = -1.0;

        double v_stim = 2;
        double del_t = 0.001;

        double[] f = new double[30];
        double[] u = new double[30];
        double[] v = new double[30];
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter 0 value for U array: ");
        u[0] = sc.nextDouble();

        System.out.println("Enter 0 value for V array: ");
        v[0] = sc.nextDouble();


        for (int i = 0; i < 29; i++) {
        /*int stinum = i/3000;
        int stimt = 3000 + 3000 * (stinum - 1);*/
            v[i + 1] = 1 / c * (gna * f[i] - gk * u[i]) * del_t + v[i];
            u[i + 1] = (v[i] + beta - gamma * u[i]) * del_t + u[i];
            f[i] = v[i] * (1 - ((v[i] * v[i]) / 3));

            if (i % 6 == 0) {
                v[i + 1] = v[i + 1] + v_stim;

            }
        }

        System.out.println("F array");
        for (int i = 0; i < 30; i++) {
            System.out.println(f[i]);
        }

        System.out.println("U array");
        for (int i = 0; i < 30; i++) {
            System.out.println(u[i]);
        }

        System.out.println("V array");
        for (int i = 0; i < 30; i++) {
            System.out.println(v[i]);
        }
    }
}
