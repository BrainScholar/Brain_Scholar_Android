package brainscholar.brainscholar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText C = (EditText)findViewById(R.id.c);
        EditText GNA = (EditText)findViewById(R.id.gna);
        EditText GK = (EditText)findViewById(R.id.gk);
        EditText BETA = (EditText)findViewById(R.id.beta);
        EditText GAMMA = (EditText)findViewById(R.id.gamma);
        Button calcButton = (Button) findViewById(R.id.calcButton);

        calcButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View vw) {

                EditText C = (EditText)findViewById(R.id.c);
                EditText GNA = (EditText)findViewById(R.id.gna);
                EditText GK = (EditText)findViewById(R.id.gk);
                EditText BETA = (EditText)findViewById(R.id.beta);
                EditText GAMMA = (EditText)findViewById(R.id.gamma);


                double c;
                String cCheck = C.getText().toString();
                if (cCheck.isEmpty()) {
                    c = 0.025;
                }
                else {
                    c = Double.parseDouble(C.getText().toString());
                }


                double gna;
                String gnaCheck = GNA.getText().toString();
                if (gnaCheck.isEmpty()) {
                    gna = 0.9;
                }
                else {
                    gna = Double.parseDouble(GNA.getText().toString());
                }

                double gk;
                String gkCheck = GK.getText().toString();
                if (gkCheck.isEmpty()) {
                    gk = 1.1;
                }
                else {
                    gk = Double.parseDouble(GK.getText().toString());
                }

                double beta;
                String betaCheck = BETA.getText().toString();
                if (betaCheck.isEmpty()) {
                    beta = 0.6;
                }
                else {
                    beta = Double.parseDouble(BETA.getText().toString());
                }

                double gamma;
                String gammaCheck = GAMMA.getText().toString();
                if (gammaCheck.isEmpty()) {
                    gamma = 1.0;
                }
                else {
                    gamma = Double.parseDouble(GAMMA.getText().toString());
                }

                /*double v_stim = 0.9;
                double del_t = 0.001;
                int cl = 30;
                int T = cl * 4;
                Double num = T/del_t;


                double[] f = new double[10000];
                double[] u = new double[10000];
                double[] v = new double[10000];



                u[0] = -1.1;
                v[0] = -1.2;

                for (int i = 0; i < 9998; i++) {
                    double floor = i/3000;
                    double stinum = Math.floor(floor);
                    Double stimt = 3000 + 3000 * (stinum - 1);
                    Integer intstim = stimt.intValue();

                    f[i] = v[i] * (1 - ((v[i] * v[i]) / 3));
                    v[i + 1] = 1 / c * (gna * f[i] - gk * u[i]) * del_t + v[i];
                    if (intstim.equals(i)) {
                        v[i + 1] = v[i + 1] + v_stim;
                    }
                    u[i + 1] = (v[i] + beta - gamma * u[i]) * del_t + u[i];
                }*/

                int tsize = 10000;
                /*Bundle vArray = new Bundle();
                vArray.putDoubleArray("v", v);*/
                Intent intent = new Intent(MainActivity.this, FullscreenActivity.class);
                /*intent.putExtras(vArray);*/
                intent.putExtra("c", c);
                intent.putExtra("gna", gna);
                intent.putExtra("gk", gk);
                intent.putExtra("beta", beta);
                intent.putExtra("gamma", gamma);
                intent.putExtra("tsize", tsize);
                startActivity(intent);

            }
        });
    }


}
