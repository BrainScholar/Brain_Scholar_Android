package brainscholar.brainscholar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView arrayOutput;
    EditText u0;
    EditText v0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        arrayOutput = (TextView) findViewById(R.id.arrayOutput);
        u0 = (EditText) findViewById(R.id.u0);
        v0 = (EditText) findViewById(R.id.v0);
        Button calcButton = (Button) findViewById(R.id.calcButton);

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double c = 0.025;
                double gna = 0.9;
                double gk = 1.1;
                double beta = 0.6;
                double gamma = -1.0;

                double v_stim = 2;
                double del_t = 0.001;

                double[] f = new double[30];
                double[] u = new double[30];
                double[] v = new double[30];

                u[0] = Double.parseDouble(u0.getText().toString());

                v[0] = Double.parseDouble(u0.getText().toString());


                for (int i = 0; i < 29; i++) {
                    /*int stinum = i/3000;
                    int stimt = 3000 + 3000 * (stinum - 1);*/
                    v[i + 1] = 1 / c * (gna * f[i] - gk * u[i]) * del_t + v[i];
                    u[i + 1] = (v[i] + beta - gamma * u[i]) * del_t + u[i];
                    f[i] = v[i] * (1 - ((v[i] * v[i]) / 3));

                    if (i % 6 == 0) {
                        v[i + 1] = v[i + 1] + v_stim;

                    }
                }
                arrayOutput.setText(f.toString());

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
