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

    //Declare these variables out here so that they are accessible within inner classes
    private LineGraphSeries<DataPoint> series;
    public int iteration = 0;
    public static double c;
    public static double gna;
    public static double gk;
    public static double beta;
    public static double gamma;
    public static double v_stim;
    public static int stimRate;
    //***********************************//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        //**********************GRAPHVIEW*********************//
        //Declare GraphView and assign it "graph" from activity_fullscreen.xml
        GraphView graph = (GraphView) findViewById(R.id.graph);
        graph.setBackgroundColor(getResources().getColor(android.R.color.white));
        //Assign the LineGraphSeries to the graph
        series = new LineGraphSeries<DataPoint>();
        graph.addSeries(series);
        //Clear old values
        graph.clearSecondScale();
        //Customize the viewport

        //*****LABEL FORMATTER*****//
        graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    //Show custom x values
                    return super.formatLabel(value/1000.0, isValueX);
                } else {
                    //Show custom y values
                    return super.formatLabel(value, isValueX);
                }
            }
        });
        //**************************//
        Viewport viewport = graph.getViewport();
        viewport.setMinY(-5); //Set minimum Y value
        viewport.setMaxY(5); //Set maximum Y value
        viewport.setMinX(0); //Set minimum X value
        viewport.setMaxX(6000); //Set maximum X values to be seen at one time
                                //(from actual x data points created NOT BASED ON VISIBLE X VALUES IN LABEL)
        viewport.setXAxisBoundsManual(true); //Set X viewport range static
        viewport.setYAxisBoundsManual(true); //Set Y viewport rang static
        viewport.setScalable(true);
        //*********************************************************//

        //***********DECLARE SEEKBARS***************//
        SeekBar C = (SeekBar) findViewById(R.id.c);
        SeekBar GNA = (SeekBar) findViewById(R.id.gna);
        SeekBar GK = (SeekBar) findViewById(R.id.gk);
        SeekBar BETA = (SeekBar)findViewById(R.id.beta);
        SeekBar GAMMA = (SeekBar) findViewById(R.id.gamma);
        SeekBar V_STIM = (SeekBar) findViewById(R.id.v_stim);
        SeekBar STIMRATE = (SeekBar) findViewById(R.id.stimRate);
        //******************************************//



        //*************SODIUM SEEKBAR ACTION***************//
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
        //********************************************//




        //*************POTASSIUM SEEKBAR ACTION**************//
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
        //********************************************//




        //***************BETA SEEKBAR ACTION*****************//
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
        //********************************************//




        //**************GAMMA SEEKBAR ACTION***************//
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
        //********************************************//




        //************V_STIM SEEKBAR ACTION*************//
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
        //********************************************//




        //*************C SEEKBAR ACTION***************//
        C.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    TextView text_SeekBar = (TextView) findViewById(R.id.textCprogress);
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        int val = (progress * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
                        text_SeekBar.setText("" + (progress + 1)/1000.0);
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
        //********************************************//



        //************STIM RATE SEEKBAR ACTION*************//
        STIMRATE.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    TextView text_SeekBar = (TextView) findViewById(R.id.textSTIMRATEprogress);
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
        //********************************************//


    }


    //**************************CALCULATE AND GRAPH***************************//
    @Override
    protected void onResume() {
        super.onResume();
        //We're going to simulate real time with thread that append data to the graph
        new Thread(new Runnable() {

            @Override
            public void run() {
                //***************DECLARE VARIABLES***************//
                //Get entries from Intent established in MainActivity
                //Assign them to variables declared above
                //----------------------------("String Key", Default Value [in case string key points to NULL])//
                c = getIntent().getDoubleExtra("c", 0.025);
                gna = getIntent().getDoubleExtra("gna", 0.9);
                gk = getIntent().getDoubleExtra("gk", 1.1);
                beta = getIntent().getDoubleExtra("beta", 0.6);
                gamma = getIntent().getDoubleExtra("gamma", 1.0);
                v_stim = getIntent().getDoubleExtra("v_stim", 0.9);
                stimRate = getIntent().getIntExtra("stimRate", 3000);


                //************CALC BUTTON ACTION******************//
                //Declare Button and assign it "calcButton2' from activity_fullscreen.xml
                Button calcButton2 = (Button) findViewById(R.id.calcButton2);
                //Listen for click
                calcButton2.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View vw) {
                        /*Changes the values of the constant variables as
                        /passed by intent from MainActivity to new values
                        /based on local seekbar progress on click of the
                        /"CALCULATE" button. Thus, allowing the user to
                        /use the seekbars to change the values and update
                        /the graph in real time on each press of the button*/

                        //***********DECLARE SEEKBARS***************//
                        SeekBar C = (SeekBar) findViewById(R.id.c);
                        SeekBar GNA = (SeekBar) findViewById(R.id.gna);
                        SeekBar GK = (SeekBar) findViewById(R.id.gk);
                        SeekBar BETA = (SeekBar)findViewById(R.id.beta);
                        SeekBar GAMMA = (SeekBar) findViewById(R.id.gamma);
                        SeekBar V_STIM = (SeekBar) findViewById(R.id.v_stim);
                        SeekBar STIMRATE = (SeekBar) findViewById(R.id.stimRate);
                        //******************************************//

                        //*****CONVERT SEEKBAR PROGRESS*****//

                        //Get value from Seekbar (whole numbers 0 to [whatever max is determined in activity_main.xml])
                        //Divide by what is needed to get the appropriate decimal

                        c = C.getProgress(); //Get progress from C seekbar declared and assigned above
                        c = (c + 1)/1000; //Convert to decimal (ex. if Seekbar actual progress is 25, this makes it 0.025)

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

                        stimRate = STIMRATE.getProgress();
                        //***********************************//

                    }
                });

                //Declare array sizes
                double[] f = new double[10000];
                double[] u = new double[10000];
                //"v" array is declared final to access within class that appends graph data
                //"v" array is all Y values for graph
                final double[] v = new double[10000];
                double del_t = 0.001;
                int cl = 30;
                int T = cl * 4;
                Double num = T / del_t;
                u[0] = -1.1;
                v[0] = -1.2;
                //************************************************//



                //********************CALCULATE*******************//
                for (int i = 0; i < 10000; i=(i+1)%6000) {
                    double floor = i / stimRate;
                    double stinum = Math.floor(floor);
                    Double stimt = stimRate + stimRate * (stinum - 1);
                    Integer intstim = stimt.intValue();
                    //increment constantly to reflect the onward march of time
                    iteration++;

                    f[i%6000] = v[i%6000] * (1 - ((v[i%6000] * v[i%6000]) / 3));
                    v[(i + 1)%6000] = 1 / c * (gna * f[i%6000] - gk * u[i%6000]) * del_t + v[i%6000];
                    if (i == intstim) {
                        v[(i + 1)%6000] = v[(i + 1)%6000] + v_stim;
                    }
                    u[(i + 1)%6000] = (v[i%6000] + beta - gamma * u[i%6000]) * del_t + u[i%6000];
                //************************************************//


                    //*****APPEND DATA*****//
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //Add a new data point (x, y)
                            //Mod used to overwrite data in "v" array and continue forever
                            series.appendData(new DataPoint(iteration, v[iteration%6000]), true, 10000);
                        }
                    });
                    //*********************//


                    //**********GRAPH SPEED**********//

                    //Control speed of graphing by controling how long the thread sleeps in between
                    try {
                        //Since we already let the user determine the speed in MainActivity
                        //and passed it to this activity via intent, let's call it up and
                        //speed up or slow down the graph accordingly
                        int speed = getIntent().getIntExtra("speed", 2);
                        Thread.sleep(speed);
                    } catch (InterruptedException e) {
                        //Manage error ...
                    }
                    //********************************//
                }
            }
        })/*Start Graphing*/.start();

    }
    //**************************************************************************//

}


