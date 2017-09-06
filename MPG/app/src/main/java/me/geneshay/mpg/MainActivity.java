package me.geneshay.mpg;

import android.util.Log;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.view.View.OnClickListener;


import java.io.FileOutputStream;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView mpgTotal;
    TextView milesPerDollarTotal;
    TextView milesTotal;
    CarStatistics carStatistics = new CarStatistics();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            FileOutputStream fOut = openFileOutput("car_statistics", MODE_WORLD_READABLE);

        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        mpgTotal = (TextView) findViewById(R.id.mpgTotal);
        milesPerDollarTotal = (TextView) findViewById(R.id.milesPerDollarTotal);
        milesTotal = (TextView) findViewById(R.id.milesTotal);

        updateStatisticsPage();

        carStatistics.setStartingMilage(5);

        findViewById(R.id.cmdUpdateData).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.fillout_form);
            }
            }
        );
    }

    private void updateStatisticsPage(){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        mpgTotal.setText(decimalFormat.format(carStatistics.getAverageMPGallon()));
        milesPerDollarTotal.setText(decimalFormat.format(carStatistics.getAverageMPDollar()));
        milesTotal.setText(decimalFormat.format(carStatistics.getMilesTracked()));
    }

}
