package jlcd4pi.pi4j;

import com.pi4j.io.gpio.GpioPinDigitalOutput;
import jlcd4pi.DigitalWritable;

/**
 * DigitalWritable implementation using pi4j GPIO pin
 * @author jCoder
 */
public class Pi4JDigialWritable implements DigitalWritable {
    
    protected GpioPinDigitalOutput outputPin;
    
    public Pi4JDigialWritable(GpioPinDigitalOutput pin) {
        this.outputPin = pin;
    }

    @Override
    public void writeState(boolean stateOnOff) {
        if (this.outputPin != null) {
            this.outputPin.setState(stateOnOff);
        }
    }
    
}
