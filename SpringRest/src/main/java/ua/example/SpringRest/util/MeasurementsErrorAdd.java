package ua.example.SpringRest.util;

public class MeasurementsErrorAdd extends RuntimeException  {
    public MeasurementsErrorAdd(String mesError){
        super(mesError);
    }
}
