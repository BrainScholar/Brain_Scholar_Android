package brainscholar.brainscholar;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class FullscreenActivity extends AppCompatActivity {

    private LineGraphSeries<DataPoint> series;

    public int iteration = 0;
    public static double c;
    public static double gna;
    public static double gk;
    public static double beta;
    public static double gamma;
    public static double v_stim;

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
        graph.clearSecondScale();
        // customize viewport
        graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    // show custom x values
                    return super.formatLabel(value/100.0, isValueX);
                } else {
                    // show custom y values
                    return super.formatLabel(value, isValueX);
                }
            }
        });
        Viewport viewport = graph.getViewport();


        viewport.setMinY(-5);
        viewport.setMaxY(5);
        viewport.setMinX(0);
        viewport.setMaxX(6000);
        viewport.setXAxisBoundsManual(true);
        viewport.setYAxisBoundsManual(true);
        //viewport.setScrollable(true);
        viewport.setScalable(true);
        //viewport.scrollToEnd();

        SeekBar C = (SeekBar) findViewById(R.id.c);
        SeekBar GNA = (SeekBar) findViewById(R.id.gna);
        SeekBar GK = (SeekBar) findViewById(R.id.gk);
        SeekBar BETA = (SeekBar)findViewById(R.id.beta);
        SeekBar GAMMA = (SeekBar) findViewById(R.id.gamma);
        SeekBar V_STIM = (SeekBar) findViewById(R.id.v_stim);


        GNA.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    TextView text_SeekBar = (TextView) findViewById(R.id.textGNAprogress);
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        int val = (progress * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
                        text_SeekBar.setText("" + progress/10.0);
                        text_SeekBar.setX(seekBar.getX() + val + seekBar.getThumbOffset() / 2);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        text_SeekBar.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        text_SeekBar.setVisibility(View.GONE);
                    }
                }
        );

        GK.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    TextView text_SeekBar = (TextView) findViewById(R.id.textGKprogress);
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        int val = (progress * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
                        text_SeekBar.setText("" + progress/10.0);
                        text_SeekBar.setX(seekBar.getX() + val + seekBar.getThumbOffset() / 2);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        text_SeekBar.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        text_SeekBar.setVisibility(View.GONE);
                    }
                }
        );

        BETA.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    TextView text_SeekBar = (TextView) findViewById(R.id.textBETAprogress);
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        int val = (progress * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
                        text_SeekBar.setText("" + progress/10.0);
                        text_SeekBar.setX(seekBar.getX() + val + seekBar.getThumbOffset() / 2);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        text_SeekBar.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        text_SeekBar.setVisibility(View.GONE);
                    }
                }
        );

        GAMMA.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    TextView text_SeekBar = (TextView) findViewById(R.id.textGAMMAprogress);
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        int val = (progress * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
                        text_SeekBar.setText("" + progress/10.0);
                        text_SeekBar.setX(seekBar.getX() + val + seekBar.getThumbOffset() / 2);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        text_SeekBar.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        text_SeekBar.setVisibility(View.GONE);
                    }
                }
        );

        V_STIM.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    TextView text_SeekBar = (TextView) findViewById(R.id.textV_STIMprogress);
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        int val = (progress * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
                        text_SeekBar.setText("" + progress/10.0);
                        text_SeekBar.setX(seekBar.getX() + val + seekBar.getThumbOffset() / 2);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        text_SeekBar.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        text_SeekBar.setVisibility(View.GONE);
                    }
                }
        );

        C.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    TextView text_SeekBar = (TextView) findViewById(R.id.textCprogress);
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        int val = (progress * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
                        text_SeekBar.setText("" + progress/1000.0);
                        text_SeekBar.setX(seekBar.getX() + val + seekBar.getThumbOffset() / 2);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        text_SeekBar.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        text_SeekBar.setVisibility(View.GONE);
                    }
                }
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        // we're going to simulate real time with thread that append data to the graph
        new Thread(new Runnable() {

            @Override
            public void run() {
                // we add new entries
                c = getIntent().getDoubleExtra("c", 0.025);
                gna = getIntent().getDoubleExtra("gna", 0.9);
                gk = getIntent().getDoubleExtra("gk", 1.1);
                beta = getIntent().getDoubleExtra("beta", 0.6);
                gamma = getIntent().getDoubleExtra("gamma", 1.0);
                v_stim = getIntent().getDoubleExtra("v_stim", 0.9);
                Button calcButton2 = (Button) findViewById(R.id.calcButton2);
                calcButton2.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View vw) {


                        SeekBar C = (SeekBar) findViewById(R.id.c);
                        SeekBar GNA = (SeekBar) findViewById(R.id.gna);
                        SeekBar GK = (SeekBar) findViewById(R.id.gk);
                        SeekBar BETA = (SeekBar)findViewById(R.id.beta);
                        SeekBar GAMMA = (SeekBar) findViewById(R.id.gamma);
                        SeekBar V_STIM = (SeekBar) findViewById(R.id.v_stim);

                        c = C.getProgress();
                        c = c/1000;

                        gna = GNA.getProgress();
                        gna = gna/10;

                        gk = GK.getProgress();
                        gk = gk/10;

                        beta = BETA.getProgress();
                        beta = beta/10;

                        gamma = GAMMA.getProgress();
                        gamma = gamma/10;

                        v_stim = V_STIM.getProgress();
                        v_stim = v_stim/10;

                    }
                });
                double[] f = new double[10000];
                double[] u = new double[10000];
                final double[] v = new double[10000];
                double del_t = 0.001;
                int cl = 30;
                int T = cl * 4;
                Double num = T / del_t;
                u[0] = -1.1;
                v[0] = -1.2;


                for (int i = 0; i < 10000; i=(i+1)%6000) {
                    double floor = i / 3000;
                    double stinum = Math.floor(floor);
                    Double stimt = 3000 + 3000 * (stinum - 1);
                    Integer intstim = stimt.intValue();
                    iteration++;

                    f[i%6000] = v[i%6000] * (1 - ((v[i%6000] * v[i%6000]) / 3));
                    v[(i + 1)%6000] = 1 / c * (gna * f[i%6000] - gk * u[i%6000]) * del_t + v[i%6000];
                    if (intstim.equals(i)) {
                        v[(i + 1)%6000] = v[(i + 1)%6000] + v_stim;
                    }
                    u[(i + 1)%6000] = (v[i%6000] + beta - gamma * u[i%6000]) * del_t + u[i%6000];
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            series.appendData(new DataPoint(iteration, v[iteration%6000]), true, 10000);

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


