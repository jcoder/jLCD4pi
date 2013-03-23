package jlcd4pi;

/**
 * Digital writable pin / output
 * @author jCoder
 */
public interface DigitalWritable {
    
    /**
     * Write state to on/off
     * @param stateOnOff    state on/off
     */
    public void writeState(boolean stateOnOff);
    
}
