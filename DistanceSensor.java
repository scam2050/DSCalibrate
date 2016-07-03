
/**
 * Write a description of class DistanceSensor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import com.pi4j.wiringpi.*;
public class DistanceSensor
{
    // instance variables - replace the example below with your own
    int __trig;
    int __echo;
    long __counter;

    /**
     * Constructor for objects of class DistanceSensor
     */
    public DistanceSensor(int rpi_trig, int rpi_echo)
    {
        __trig = rpi_trig;
        __echo = rpi_echo;
       Gpio.pinMode(__trig, Gpio.OUTPUT);
       Gpio.pinMode(__echo, Gpio.INPUT);
        Gpio.digitalWrite(__trig, 0);
        Gpio.delay(100);
        Gpio.digitalWrite(__trig, 1);
        Gpio.delay(100);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public long getDistance()
    {
   //    Gpio.digitalWrite(__trig, 1);
    //   Gpio.delay(100);
       // wait for echo to go down
   //   System.out.println("***********************************************************************");
        __counter = 0;
        while(Gpio.digitalRead(__echo)==1){
   //       System.out.println("waiting for echo to go down");
        }
    //   System.out.println("***********************************************************************");
       while(Gpio.digitalRead(__echo)==0){
    //     System.out.println("waiting for echo to go up");
        }
  //    System.out.println("***********************************************************************");
       while(Gpio.digitalRead(__echo)==1){
           __counter++;
   //        System.out.println("sensing distance, counting up");
        }
        return __counter;
    }
}
