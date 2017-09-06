package me.geneshay.mpg;
/**
 * simple CarStatistics class to store data on a per car basis
 * the class contains update and get methods
 */

import android.util.Log;

public class CarStatistics {
    private double startingMileage = 0.0;
    private double lastRecordedMileage = 0.0;
    private double milesTracked = 0.0;
    private double totalMoneySpent = 0.0;
    private double totalGallonsFilled = 0.0;
    private double averageMPGallon = 0.0;
    private double averageMPDollar = 0.0;
    private double averageGallonCost = 0.0;

    private static final String TAG = "CarStatistics";
    //method to record the original milage
    public void setStartingMilage(double startingMilageReading){
        startingMileage = startingMilageReading;
        lastRecordedMileage = startingMilageReading;
    }

    //-------------start update methods-------------
    public void updateMetrics(double newCarMilage, double amountSpent, double gallonsFilled){
        if(startingMileage > 0.0){
            addMiles(newCarMilage);
            addMoneySpent(amountSpent);
            addGalonsFilled(gallonsFilled);
            updateMPGallon();
            updateMPDollar();
            Log.i(TAG, "Updated car metrics");
        }
        else{
            setStartingMilage(newCarMilage);
            Log.i(TAG, "No previous mileage records, only set starting mileage.");
        }
    }

    //---------------start private add methods---------
    private void addMiles(double newCarMilage){
        milesTracked += newCarMilage - lastRecordedMileage;
        Log.i(TAG, "" +milesTracked);
    }

    private void addMoneySpent(double amountSpent){
        totalMoneySpent += amountSpent;
        Log.i(TAG, "" + totalMoneySpent);
    }

    private void addGalonsFilled(double galonsFilled){
        totalGallonsFilled += galonsFilled;
        Log.i(TAG, "" + totalGallonsFilled);
    }

    //----------------start public update methods------
    public void updateMPGallon(){
        if(milesTracked > 0.0 && totalGallonsFilled > 0.0){
            averageMPGallon = milesTracked/totalGallonsFilled;
        }
    }

    public void updateMPDollar(){
        if(milesTracked > 0.0 && totalMoneySpent > 0.0){
            averageMPDollar = milesTracked/totalMoneySpent;
        }
    }

    public void updateAverageGalonCost(){
        if(milesTracked > 0.0 && totalMoneySpent > 0.0){
            averageGallonCost = totalMoneySpent/totalGallonsFilled;
        }
    }

    //-------------start get methods-------------------

    public double getMilesTracked(){
        return milesTracked;
    }

    public double getLastRecordedMilage(){
        return lastRecordedMileage;
    }

    public double getTotalMoneySpent(){
        return totalMoneySpent;
    }

    public double getTotalGalonsFilled(){
        return totalGallonsFilled;
    }

    public double getAverageMPGallon(){
        return averageMPGallon;
    }

    public double getAverageMPDollar(){
        return averageMPDollar;
    }

}