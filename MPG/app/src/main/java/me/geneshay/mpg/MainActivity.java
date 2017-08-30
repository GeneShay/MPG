package me.geneshay.mpg;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import me.geneshay.mpg.CarStatistics;
import android.view.View.OnClickListener;


import org.w3c.dom.Text;

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

        mpgTotal = (TextView) findViewById(R.id.mpgTotal);
        milesPerDollarTotal = (TextView) findViewById(R.id.milesPerDollarTotal);
        milesTotal = (TextView) findViewById(R.id.milesTotal);

        updateStatisticsPage();

        findViewById(R.id.cmdUpdateData).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                carStatistics.updateMPGallon(5.3,21.6);
                carStatistics.updateMPDollar(20);
                updateStatisticsPage();
            }
            }
        );
    }

    private void updateStatisticsPage(){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        mpgTotal.setText(decimalFormat.format(carStatistics.getAverageMPGallon()));
        milesPerDollarTotal.setText(decimalFormat.format(carStatistics.getAverageMPDollar()));
        milesTotal.setText(decimalFormat.format(carStatistics.getMilesRecorded()));
    }
}
