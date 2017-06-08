package brainscholar.brainscholar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                double gk = 1.1;
                double beta = 0.6;
                double gamma = -1.0;

                double v_stim = 2;
                double del_t = 0.001;

                double[] f = new double[100];
                double[] u = new double[100];
                double[] v = new double[100];


                u[0] = Double.parseDouble(u0.getText().toString());

                v[0] = Double.parseDouble(v0.getText().toString());

                for (int i = 0; i < 98; i++) {
                    /*int stinum = i/3000;
                    int stimt = 3000 + 3000 * (stinum - 1);*/
                    f[i] = v[i] * (1 - ((v[i] * v[i]) / 3));
                    v[i + 1] = 1 / c * (gna * f[i] - gk * u[i]) * del_t + v[i];
                    u[i + 1] = (v[i] + beta - gamma * u[i]) * del_t + u[i];


                    if (i % 6 == 0) {
                        v[i + 1] = v[i + 1] + v_stim;

                    }
                }
                Intent intent = new Intent(MainActivity.this, FullscreenActivity.class);
                intent.putExtra("v", v);
                startActivity(intent);

            }
        });
    }


}
