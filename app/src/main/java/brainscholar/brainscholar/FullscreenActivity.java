package brainscholar.brainscholar;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class FullscreenActivity extends AppCompatActivity {

    private LineGraphSeries<DataPoint> series;

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
                double c = getIntent().getDoubleExtra("c", 0.025);
                double gna = getIntent().getDoubleExtra("gna", 0.9);
                double gk = getIntent().getDoubleExtra("gk", 1.1);
                double beta = getIntent().getDoubleExtra("beta", 0.6);
                double gamma = getIntent().getDoubleExtra("gamma", 1.0);
                double v_stim = getIntent().getDoubleExtra("v_stim", 0.9);
                double[] f = new double[20000];
                double[] u = new double[20000];
                final double[] v = new double[20000];

                double del_t = 0.001;
                int cl = 30;
                int T = cl * 4;
                Double num = T / del_t;
                u[0] = -1.1;
                v[0] = -1.2;


                for (int i = 0; i < 20000; ) {
                    double floor = i / 3000;
                    double stinum = Math.floor(floor);
                    Double stimt = 3000 + 3000 * (stinum - 1);
                    Integer intstim = stimt.intValue();
                    iteration++;

                    f[i%10000] = v[i%10000] * (1 - ((v[i%10000] * v[i%10000]) / 3));
                    v[(i + 1)%10000] = 1 / c * (gna * f[i%10000] - gk * u[i%10000]) * del_t + v[i%10000];
                    if (intstim.equals(i)) {
                        v[(i + 1)%10000] = v[(i + 1)%10000] + v_stim;
                    }
                    u[(i + 1)%10000] = (v[i%10000] + beta - gamma * u[i%10000]) * del_t + u[i%10000];
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            series.appendData(new DataPoint(iteration, v[iteration%10000]), true, 100000);
                            //System.out.println(v[iteration]);
                        }
                    });

                    i=(i+1)%10000;

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


