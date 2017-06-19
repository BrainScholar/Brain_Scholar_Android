package brainscholar.brainscholar;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class FullscreenActivity extends AppCompatActivity {

    private LineGraphSeries<DataPoint> series;
    /*public Intent intent = getIntent();
    public double c = intent.getDoubleExtra("c", 0.025);
    public double gna = intent.getDoubleExtra("gna", 0.9);
    public double gk = intent.getDoubleExtra("gk", 1.1);
    public double beta = intent.getDoubleExtra("beta", 0.6);
    public double gamma = intent.getDoubleExtra("gamma", 1.0);
    public double v_stim = intent.getDoubleExtra("v_stim", 0.9);*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        Intent intent = getIntent();
        // we get graph view instance
        GraphView graph = (GraphView) findViewById(R.id.graph);
        graph.setBackgroundColor(getResources().getColor(android.R.color.white));
        // data
        series = new LineGraphSeries<DataPoint>();
        graph.addSeries(series);
        // customize a little bit viewport
        Viewport viewport = graph.getViewport();


        viewport.setYAxisBoundsManual(true);
        viewport.setMinY(-5);
        viewport.setMaxY(5);
        viewport.setMinX(0);
        viewport.setMaxX(10000);
        viewport.setXAxisBoundsManual(true);
        viewport.setScrollable(true);
        viewport.scrollToEnd();
    }

    public int iteration = 0;

    @Override
    protected void onResume() {
        super.onResume();
        // we're going to simulate real time with thread that append data to the graph
        new Thread(new Runnable() {

            @Override
            public void run() {
                // we add new entries
                    /*double c = getIntent().getDoubleExtra("c", 0.025);
                    double gna = getIntent().getDoubleExtra("gna", 0.9);
                    double gk = getIntent().getDoubleExtra("gk", 1.1);
                    double beta = getIntent().getDoubleExtra("beta", 0.6);
                    double gamma = getIntent().getDoubleExtra("gamma", 1.0);
                    double v_stim = getIntent().getDoubleExtra("v_stim", 0.9);*/

                    /*SeekBar C = (SeekBar) findViewById(R.id.c);
                    SeekBar GNA = (SeekBar) findViewById(R.id.gna);
                    SeekBar GK = (SeekBar) findViewById(R.id.gk);
                    SeekBar BETA = (SeekBar)findViewById(R.id.beta);
                    SeekBar GAMMA = (SeekBar) findViewById(R.id.gamma);
                    SeekBar V_STIM = (SeekBar) findViewById(R.id.v_stim);*/

                Button calcButton2 = (Button) findViewById(R.id.calcButton2);
                calcButton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SeekBar C = (SeekBar) findViewById(R.id.c);
                        SeekBar GNA = (SeekBar) findViewById(R.id.gna);
                        SeekBar GK = (SeekBar) findViewById(R.id.gk);
                        SeekBar BETA = (SeekBar) findViewById(R.id.beta);
                        SeekBar GAMMA = (SeekBar) findViewById(R.id.gamma);
                        SeekBar V_STIM = (SeekBar) findViewById(R.id.v_stim);
                        double c = C.getProgress();
                        double gna = GNA.getProgress();
                        double gk = GK.getProgress();
                        double beta = BETA.getProgress();
                        double gamma = GAMMA.getProgress();
                        double v_stim = V_STIM.getProgress();

                        System.out.println(c);
                        System.out.println(gna);
                        System.out.println(gk);
                        System.out.println(beta);
                        System.out.println(gamma);
                        System.out.println(v_stim);

                        double[] f = new double[10000];
                        double[] u = new double[10000];
                        final double[] V = new double[10000];

                        double del_t = 0.001;
                        int cl = 30;
                        int T = cl * 4;
                        Double num = T / del_t;
                        u[0] = -1.1;
                        V[0] = -1.2;


                        for (int i = 0; i < 10000; i = (i + 1) % 6000) {

                            double floor = i / 3000;
                            double stinum = Math.floor(floor);
                            Double stimt = 3000 + 3000 * (stinum - 1);
                            Integer intstim = stimt.intValue();
                            iteration++;

                            f[i % 6000] = V[i % 6000] * (1 - ((V[i % 6000] * V[i % 6000]) / 3));
                            V[(i + 1) % 6000] = 1 / c * (gna * f[i % 6000] - gk * u[i % 6000]) * del_t + V[i % 6000];
                            if (intstim.equals(i)) {
                                V[(i + 1) % 6000] = V[(i + 1) % 6000] + v_stim;
                            }
                            u[(i + 1) % 6000] = (V[i % 6000] + beta - gamma * u[i % 6000]) * del_t + u[i % 6000];
                            runOnUiThread(new Runnable() {

                                @Override
                                public void run() {
                                    series.appendData(new DataPoint(iteration, V[iteration % 6000]), true, 10000);
                                    //System.out.println(v[iteration]);
                                }
                            });


                            // sleep to slow down the add of entries
                            try {
                                Thread.sleep(2);
                            } catch (InterruptedException e) {
                                // manage error ...
                            }
                        }
                    }
                });

                double c = getIntent().getDoubleExtra("c", 0.025);
                double gna = getIntent().getDoubleExtra("gna", 0.9);
                double gk = getIntent().getDoubleExtra("gk", 1.1);
                double beta = getIntent().getDoubleExtra("beta", 0.6);
                double gamma = getIntent().getDoubleExtra("gamma", 1.0);
                double v_stim = getIntent().getDoubleExtra("v_stim", 0.9);



                double[] f = new double[10000];
                double[] u = new double[10000];
                final double[] v = new double[10000];

                double del_t = 0.001;
                int cl = 30;
                int T = cl * 4;
                Double num = T / del_t;
                u[0] = -1.1;
                v[0] = -1.2;


                for (int i = 0; i < 10000; i = (i + 1) % 6000)

                {

                    double floor = i / 3000;
                    double stinum = Math.floor(floor);
                    Double stimt = 3000 + 3000 * (stinum - 1);
                    Integer intstim = stimt.intValue();
                    iteration++;

                    f[i % 6000] = v[i % 6000] * (1 - ((v[i % 6000] * v[i % 6000]) / 3));
                    v[(i + 1) % 6000] = 1 / c * (gna * f[i % 6000] - gk * u[i % 6000]) * del_t + v[i % 6000];
                    if (intstim.equals(i)) {
                        v[(i + 1) % 6000] = v[(i + 1) % 6000] + v_stim;
                    }
                    u[(i + 1) % 6000] = (v[i % 6000] + beta - gamma * u[i % 6000]) * del_t + u[i % 6000];
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            series.appendData(new DataPoint(iteration, v[iteration % 6000]), true, 10000);
                            //System.out.println(v[iteration]);
                        }
                    });


                    // sleep to slow down the add of entries
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        // manage error ...
                    }
                }


            }
        }).start();

    }
}


