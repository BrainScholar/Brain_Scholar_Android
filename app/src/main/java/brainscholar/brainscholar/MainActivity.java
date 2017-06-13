package brainscholar.brainscholar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calcButton = (Button) findViewById(R.id.calcButton);
        calcButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View vw) {


                SeekBar C = (SeekBar) findViewById(R.id.c);
                SeekBar GNA = (SeekBar) findViewById(R.id.gna);
                SeekBar GK = (SeekBar) findViewById(R.id.gk);
                SeekBar BETA = (SeekBar)findViewById(R.id.beta);
                SeekBar GAMMA = (SeekBar) findViewById(R.id.gamma);
                SeekBar V_STIM = (SeekBar) findViewById(R.id.v_stim);



                double c = C.getProgress();
                c = c/1000;

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




                Intent intent = new Intent(MainActivity.this, FullscreenActivity.class);
                intent.putExtra("c", c);
                intent.putExtra("gna", gna);
                intent.putExtra("gk", gk);
                intent.putExtra("beta", beta);
                intent.putExtra("gamma", gamma);
                intent.putExtra("v_stim", v_stim);
                startActivity(intent);


            }
        });
    }


}
