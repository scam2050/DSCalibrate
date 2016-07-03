
/**
 * Write a description of class Calibrate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import com.pi4j.wiringpi.*;
public class Calibrate
{
    public static void main(String[] args){
        Gpio.wiringPiSetup();
        DistanceSensor ds = new DistanceSensor(15, 16);
        long distance;
        while(true){
            distance = 0;
            for(int i=0;i<3;i++){
                distance = ds.getDistance() + distance;
                Gpio.delay(15);
            }
            distance = distance/3;
            System.out.println("Distance is " + distance);
            Gpio.delay(1000);
        }
    }
    
}
