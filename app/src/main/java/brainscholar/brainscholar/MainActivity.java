package brainscholar.brainscholar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    //Declare speed here so that it is accessible to inner classes.
    private int speed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //***********DECLARE SEEKBARS***************//
        SeekBar C = (SeekBar) findViewById(R.id.c);
        SeekBar GNA = (SeekBar) findViewById(R.id.gna);
        SeekBar GK = (SeekBar) findViewById(R.id.gk);
        SeekBar BETA = (SeekBar) findViewById(R.id.beta);
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
                    TextView text_SeekBar = (TextView) findViewById(R.id.textGAMMAprogess);
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


        //*****DROPDOWN FOR GRAPH SPEED SELECTION*****//
        //Declare spinner and assign it to XML ID
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        /*Declare an ArrayAdapter to convert the dropdown options into an array.
        /*Then convert the string array in res/values/strings.xml to an AdapterArray for the dropdown*/
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.speed_arrays, android.R.layout.simple_spinner_item);
        //Set the dropdown view
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Assign the AdapterArray to it
        spinner.setAdapter(adapter);
        //Set the Item selected Listener
        spinner.setOnItemSelectedListener(MainActivity.this);
        //********************************************//


        //***************BUTTON ACTION****************//
        //Declare button and assign it to calcButton in activity_main.xml
        Button calcButton = (Button) findViewById(R.id.calcButton);
        //On Click do...
        calcButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View vw) {

                //*****DECLARE SEEKBARS*****//
                SeekBar C = (SeekBar) findViewById(R.id.c);
                SeekBar GNA = (SeekBar) findViewById(R.id.gna);
                SeekBar GK = (SeekBar) findViewById(R.id.gk);
                SeekBar BETA = (SeekBar)findViewById(R.id.beta);
                SeekBar GAMMA = (SeekBar) findViewById(R.id.gamma);
                SeekBar V_STIM = (SeekBar) findViewById(R.id.v_stim);
                SeekBar STIMRATE = (SeekBar) findViewById(R.id.stimRate);
                //**************************//

                //*****CONVERT SEEKBAR PROGRESS*****//

                //Get value from Seekbar (whole numbers 0 to [whatever max is determined in activity_main.xml])
                //Divide by what is needed to get the appropriate decimal

                double c = C.getProgress(); //Get progress from C seekbar declared and assigned above
                c = (c + 1)/1000; //Convert to decimal (ex. if Seekbar actual progress is 25, this makes it 0.025)

                double gna = GNA.getProgress();
                gna = gna/10;

                double gk = GK.getProgress();
                gk = gk/10;

                double beta = BETA.getProgress();
                beta = beta/10;

                double gamma = GAMMA.getProgress();
                gamma = gamma/10;

                double v_stim = V_STIM.getProgress();
                v_stim = v_stim/10;

                int stimRate = STIMRATE.getProgress();
                //********************//

                //*****PASS DATA TO NEXT ACTIVITY*****//
                //Declare an intent to direct where the data is coming from and where it is going
                Intent intent = new Intent(MainActivity.this, FullscreenActivity.class);
                //Move necessary variables to next activity with a string key to call on and their value
                intent.putExtra("speed", speed);
                intent.putExtra("c", c);
                intent.putExtra("gna", gna);
                intent.putExtra("gk", gk);
                intent.putExtra("beta", beta);
                intent.putExtra("gamma", gamma);
                intent.putExtra("v_stim", v_stim);
                intent.putExtra("stimRate", stimRate);


                //*****START NEXT ACTIVITY*****//
                startActivity(intent);
                //*****************************//


            }
        });
    }

    //From [[spinner.setOnItemSelectedListener(MainActivity.this);]]
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //A switch case based on AdapterArray position in the dropdown (top to bottom)
        switch (position) {
            case 0: //If "Very Fast" is selected...
                speed = 1;
                break;
            case 1: //If "Fast" is selected...
                speed = 2;
                break;
            case 2: //If "Moderate" is selected...
                speed = 3;
                break;
            case 3: //If "Slow" is selected...
                speed = 4;
                break;
            case 4: //If "Very Slow" is selected...
                speed = 5;
                break;

        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        speed = 2; //If nothing is selected...

    }


}
