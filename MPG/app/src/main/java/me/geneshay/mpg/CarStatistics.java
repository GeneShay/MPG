package me.geneshay.mpg;

/**
 * Created by geneshay on 8/28/17.
 */

public class CarStatistics {

    private double milesRecorded = 0.0;
    private double averageMPGallon = 0.0;
    private double averageMPDollar = 0.0;

    public void addMiles(double recordedMiles){
        milesRecorded += recordedMiles;
    }

    public void updateMPGallon(double recordedGallons, double recordedMiles){
        averageMPGallon += recordedMiles/recordedGallons;
        milesRecorded += recordedMiles;
    }

    public void updateMPDollar(double recordedPPGalon){
        averageMPDollar += recordedPPGalon;
    }

    public double getMilesRecorded(){
        return milesRecorded;
    }

    public double getAverageMPGallon(){
        return averageMPGallon;
    }

    public double getAverageMPDollar(){
        return averageMPDollar;
    }

}