package jlcd4pi.example;

import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.RaspiPin;
import jlcd4pi.LCDDisplay;
import jlcd4pi.Utils;
import jlcd4pi.pi4j.Pi4JHelper;

/**
 * A simple "Hello World" program
 * @author jCoder
 */
public class HelloWorld {
    
    public static void main(String[] args) {
        
        try {
            LCDDisplay display = Pi4JHelper.createDisplay(RaspiPin.GPIO_02, RaspiPin.GPIO_03, RaspiPin.GPIO_01, RaspiPin.GPIO_04, RaspiPin.GPIO_05, RaspiPin.GPIO_06);
            if (display == null) {
                System.out.println("Could not create display.");
                GpioFactory.getInstance().shutdown();
                return;
            }
            
            display.cursorHome();
            display.print("Hello World!");
            Utils.sleep(2000);
            display.clear();
            Utils.sleep(500);
            display.print("Test from Java!");
            Utils.sleep(5000);
            display.clear();
            
            GpioFactory.getInstance().shutdown();
        } catch (Exception ex) {
            System.out.println("An exception occured: " + ex);
            ex.printStackTrace();
        }
        
    }
    
}
