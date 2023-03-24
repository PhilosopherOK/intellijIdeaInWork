package ua.example.SpringRest.util;

public class SensorNameError extends RuntimeException  {
    public SensorNameError(String mesError){
        super(mesError);
    }
}
