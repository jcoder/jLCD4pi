package jlcd4pi;

/**
 * LCD Display implementation for HD44870
 * @author jCoder
 */
public class SerialLCDDisplay implements LCDDisplay {

    protected static final byte CMD_DISPLAY_ON = 0xC;
    protected static final byte CMD_DISPLAY_CLEAR = 0x1;
    protected static final byte CMD_CURSOR_HOME = 0x2;
    protected static final byte MASK_SET_CURSOR = (byte) 0x80;
    protected DigitalWritable pinRS;
    protected DigitalWritable pinE;
    protected DigitalWritable pinD4;
    protected DigitalWritable pinD5;
    protected DigitalWritable pinD6;
    protected DigitalWritable pinD7;

    public SerialLCDDisplay(DigitalWritable rs,
            DigitalWritable e,
            DigitalWritable d4,
            DigitalWritable d5,
            DigitalWritable d6,
            DigitalWritable d7) 
    {
        this.pinRS = rs;
        this.pinE = e;
        this.pinD4 = d4;
        this.pinD5 = d5;
        this.pinD6 = d6;
        this.pinD7 = d7;
        
        this.initDisplay();
    }

    /**
     * Clears the display
     */
    @Override
    public void clear() {
        this.sendCmd(CMD_DISPLAY_CLEAR);
    }

    /**
     * Sets the cursor to the home position
     */
    @Override
    public void cursorHome() {
        this.sendCmd(CMD_CURSOR_HOME);
    }

    /**
     * Outputs the given at the current cursor position
     * @param s     string to output
     */
    @Override
    public void print(String s) {
        if ((s == null) || (s.length() == 0)) {
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            this.putc(s.charAt(i));
        }
    }

    /**
     * Outputs a single character at the current cursor position
     * @param c     character to output
     */
    @Override
    public void putc(char c) {
        pinD7.writeState((c & 0x80) != 0);
        pinD6.writeState((c & 0x40) != 0);
        pinD5.writeState((c & 0x20) != 0);
        pinD4.writeState((c & 0x10) != 0);
        pinE.writeState(true);
        pinE.writeState(false);

        pinD7.writeState((c & 0x08) != 0);
        pinD6.writeState((c & 0x04) != 0);
        pinD5.writeState((c & 0x02) != 0);
        pinD4.writeState((c & 0x01) != 0);
        pinE.writeState(true);
        pinE.writeState(false);
    }

    /**
     * Sets the cursor to a given position
     * @param row   row
     * @param col   column
     */
    @Override
    public void setCursor(int row, int col) {
        this.sendCmd((byte) (MASK_SET_CURSOR | row << 6 | col));
    }
    
    /**
     * Sends a command to the LCD
     * @param cmd   command to send
     */
    protected void sendCmd(byte cmd) {
        pinRS.writeState(false);

        pinD7.writeState((cmd & 0x80) != 0);
        pinD6.writeState((cmd & 0x40) != 0);
        pinD5.writeState((cmd & 0x20) != 0);
        pinD4.writeState((cmd & 0x10) != 0);
        pinE.writeState(true);
        pinE.writeState(false);

        pinD7.writeState((cmd & 0x08) != 0);
        pinD6.writeState((cmd & 0x04) != 0);
        pinD5.writeState((cmd & 0x02) != 0);
        pinD4.writeState((cmd & 0x01) != 0);
        pinE.writeState(true);
        pinE.writeState(false);

        Utils.sleep(1);
        pinRS.writeState(true);
    }
    
    /**
     * Initializes the display
     */
    protected void initDisplay() {
        pinRS.writeState(false);

        Utils.sleep(50);

        pinD7.writeState(false);
        pinD6.writeState(false);
        pinD5.writeState(true);
        pinD4.writeState(true);

        pinE.writeState(true);
        pinE.writeState(false);

        Utils.sleep(50);

        pinD7.writeState(false);
        pinD6.writeState(false);
        pinD5.writeState(true);
        pinD4.writeState(true);

        pinE.writeState(true);
        pinE.writeState(false);

        Utils.sleep(50);

        pinD7.writeState(false);
        pinD6.writeState(false);
        pinD5.writeState(true);
        pinD4.writeState(true);

        pinE.writeState(true);
        pinE.writeState(false);

        Utils.sleep(50);

        pinD7.writeState(false);
        pinD6.writeState(false);
        pinD5.writeState(true);
        pinD4.writeState(false);

        pinE.writeState(true);
        pinE.writeState(false);

        this.sendCmd(CMD_DISPLAY_ON);
        this.sendCmd(CMD_DISPLAY_CLEAR);
    }

}
