package brainscholar.brainscholar;


import android.content.Intent;

import com.jjoe64.graphview.series.DataPoint;

/**
 * Created by derekroberts on 6/7/17.
 */

public class Calculations {

    public static void main(String[] args) {

    }

    public static double[] fhn(double c, double gna, double gk, double beta, double gamma, double v_stim) {
        double del_t = 0.001;
        int cl = 30;
        int T = cl * 4;
        Double num = T / del_t;


        double[] f = new double[10000];
        double[] u = new double[10000];
        double[] v = new double[10000];


        u[0] = -1.1;
        v[0] = -1.2;

        for (int i = 0; i < 9998; i++) {
            double floor = i / 3000;
            double stinum = Math.floor(floor);
            Double stimt = 3000 + 3000 * (stinum - 1);
            Integer intstim = stimt.intValue();

            f[i] = v[i] * (1 - ((v[i] * v[i]) / 3));
            v[i + 1] = 1 / c * (gna * f[i] - gk * u[i]) * del_t + v[i];
            if (intstim.equals(i)) {
                v[i + 1] = v[i + 1] + v_stim;
            }
            u[i + 1] = (v[i] + beta - gamma * u[i]) * del_t + u[i];
        }
        return v;
    }

    public static double fhnVi(double lastU, double lastV, double c, double gna, double gk, double beta, double gamma, double v_stim) {

        double del_t = 0.001;
        int cl = 30;
        int T = cl * 4;
        Double num = T / del_t;


        double[] f = new double[10000];
        double[] u = new double[10000];
        double[] v = new double[10000];


        u[0] = lastU;
        v[0] = lastV;

        int i = 0;
        double floor = i / 3000;
        double stinum = Math.floor(floor);
        Double stimt = 3000 + 3000 * (stinum - 1);
        Integer intstim = stimt.intValue();

        f[i] = v[i] * (1 - ((v[i] * v[i]) / 3));
        v[i + 1] = 1 / c * (gna * f[i] - gk * u[i]) * del_t + v[i];
        if (intstim.equals(i)) {
            v[i + 1] = v[i + 1] + v_stim;
        }
        u[i + 1] = (v[i] + beta - gamma * u[i]) * del_t + u[i];
        return v[i+1];
    }

    public static double fhnUi(double lastU, double lastV, double c, double gna, double gk, double beta, double gamma, double v_stim) {

        double del_t = 0.001;
        int cl = 30;
        int T = cl * 4;
        Double num = T / del_t;


        double[] f = new double[10000];
        double[] u = new double[10000];
        double[] v = new double[10000];


        u[0] = lastU;
        v[0] = lastV;

        int i = 0;
        double floor = i / 3000;
        double stinum = Math.floor(floor);
        Double stimt = 3000 + 3000 * (stinum - 1);
        Integer intstim = stimt.intValue();

        f[i] = v[i] * (1 - ((v[i] * v[i]) / 3));
        v[i + 1] = 1 / c * (gna * f[i] - gk * u[i]) * del_t + v[i];
        if (intstim.equals(i)) {
            v[i + 1] = v[i + 1] + v_stim;
        }
        u[i + 1] = (v[i] + beta - gamma * u[i]) * del_t + u[i];
        return u[i+1];
    }
}