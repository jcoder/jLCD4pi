package jlcd4pi;

/**
 * Interface for the LCD display
 * @author jCoder
 */
public interface LCDDisplay {

    /**
     * Clears the display
     */
    public void clear();

    /**
     * Sets the cursor to the home position
     */
    public void cursorHome();

    /**
     * Outputs the given at the current cursor position
     * @param s     string to output
     */
    public void print(String s);

    /**
     * Outputs a single character at the current cursor position
     * @param c     character to output
     */
    public void putc(char c);

    /**
     * Sets the cursor to a given position
     * @param row   row
     * @param col   column
     */
    public void setCursor(int row, int col);
    
    /**
     * Moves the cursor to the left by one position
     */
    public void moveCursorLeft();
    
    /**
     * Moves the cursor to the right by one position
     */
    public void moveCursorRight();
    
    /**
     * Shifts left by one position
     */
    public void moveShiftLeft();
    
    /**
     * Shifts right by one position
     */
    public void moveShiftRight();

    /**
     * Disables cursor blinking
     */
    public void cursorBlinkOff();

    /**
     * Enables cursor blinking
     */
    public void cursorBlinkOn();

    /**
     * Disables the visual cursor
     */
    public void cursorOff();

    /**
     * Enables the visual cursor
     */
    public void cursorOn();

    /**
     * Disables the display
     */
    public void displayOff();

    /**
     * Enables the display
     */
    public void displayOn();
    
}
