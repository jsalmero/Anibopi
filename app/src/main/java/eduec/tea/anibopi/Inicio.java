package eduec.tea.anibopi;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorEventListener2;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Inicio extends AppCompatActivity implements SensorEventListener {

    public Intent act1;
    public ImageView btninicio, btninfo, btnSalir;
    SensorManager sm;
    Sensor sensor;
    RelativeLayout rl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        rl = (RelativeLayout) findViewById(R.id.actividad1);

        btninicio = (ImageView) findViewById(R.id.btnInicio);
        btninfo = (ImageView) findViewById(R.id.btnInfo);
        btnSalir = (ImageView) findViewById(R.id.btnSalir);
        sm =(SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btninicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    act1 = new Intent(getApplicationContext(), Video.class);
                    startActivity(act1);
                }finally {
                    finish();
                }
            }
        });

        btninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    act1 = new Intent(getApplicationContext(), Creditos.class);
                    startActivity(act1);
                }finally {
                    finish();
                }
            }
        });


        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.exit(0);
            }
        });
    }

    void kill_activity(){finish();}

    @Override
    public void onSensorChanged(SensorEvent event) {
        String text = String.valueOf(event.values[0]);
        


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
