package jlcd4pi.pi4j;

import com.pi4j.io.gpio.*;
import jlcd4pi.DigitalWritable;
import jlcd4pi.LCDDisplay;
import jlcd4pi.SerialLCDDisplay;

/**
 * Helper class for using Pi4J with the LCD Display classes
 * @author jCoder
 */
public class Pi4JHelper {
    
    private Pi4JHelper() { }
    
    /**
     * Creates a display, mapped to Raspberry Pi pins
     * @param pinRS pin RS
     * @param pinE  pin E
     * @param pinD4 pin D4
     * @param pinD5 pin D5
     * @param pinD6 pin D6
     * @param pinD7 pin D7
     * @return  display or null on error
     */
    public static LCDDisplay createDisplay(Pin pinRS, Pin pinE, Pin pinD4, Pin pinD5, Pin pinD6, Pin pinD7) {
        try {
            // get the controller instance
            final GpioController gpio = GpioFactory.getInstance();
            
            // create pins: RS, E
            final GpioPinDigitalOutput gpiopinRS = gpio.provisionDigitalOutputPin(pinRS, "PIN_RS", PinState.LOW);
            final GpioPinDigitalOutput gpiopinE = gpio.provisionDigitalOutputPin(pinE, "PIN_E", PinState.LOW);
            
            // create pins: D4, D5, D6, D7
            final GpioPinDigitalOutput gpiopinD4 = gpio.provisionDigitalOutputPin(pinD4, "PIN_D4", PinState.LOW);
            final GpioPinDigitalOutput gpiopinD5 = gpio.provisionDigitalOutputPin(pinD5, "PIN_D5", PinState.LOW);
            final GpioPinDigitalOutput gpiopinD6 = gpio.provisionDigitalOutputPin(pinD6, "PIN_D6", PinState.LOW);
            final GpioPinDigitalOutput gpiopinD7 = gpio.provisionDigitalOutputPin(pinD7, "PIN_D7", PinState.LOW);
            
            // wrap GPIO pins to display pins
            final DigitalWritable pRS = new Pi4JDigialWritable(gpiopinRS);
            final DigitalWritable pE = new Pi4JDigialWritable(gpiopinE);
            final DigitalWritable pD4 = new Pi4JDigialWritable(gpiopinD4);
            final DigitalWritable pD5 = new Pi4JDigialWritable(gpiopinD5);
            final DigitalWritable pD6 = new Pi4JDigialWritable(gpiopinD6);
            final DigitalWritable pD7 = new Pi4JDigialWritable(gpiopinD7);
            
            LCDDisplay display = new SerialLCDDisplay(pRS, pE, pD4, pD5, pD6, pD7);
            return display;
        } catch (Exception ex) {
            return null;
        }
    }
    
}
