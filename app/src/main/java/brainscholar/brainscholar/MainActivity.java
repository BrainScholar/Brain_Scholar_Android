package brainscholar.brainscholar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText u0 = (EditText)findViewById(R.id.u0);
        EditText v0 = (EditText)findViewById(R.id.v0);
        Button calcButton = (Button) findViewById(R.id.calcButton);

        calcButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View vw) {

                EditText u0 = (EditText)findViewById(R.id.u0);
                EditText v0 = (EditText)findViewById(R.id.v0);

                double c = 0.025;
                double gna = 0.9;
                double gk = 7;
                double beta = 0.6;
                double gamma = -1.0;

                double v_stim = 0.9;
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
                }

                int tsize = 10000;
                Bundle vArray = new Bundle();
                vArray.putDoubleArray("v", v);
                Intent intent = new Intent(MainActivity.this, FullscreenActivity.class);
                intent.putExtras(vArray);
                intent.putExtra("tsize", tsize);
                startActivity(intent);

            }
        });
    }


}
