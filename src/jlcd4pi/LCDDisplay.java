package jlcd4pi;

/**
 * Interface for the LCD display
 * @author jCoder
 */
public interface LCDDisplay {

    /**
     * Clears the display
     */
    void clear();

    /**
     * Sets the cursor to the home position
     */
    void cursorHome();

    /**
     * Outputs the given at the current cursor position
     * @param s     string to output
     */
    void print(String s);

    /**
     * Outputs a single character at the current cursor position
     * @param c     character to output
     */
    void putc(char c);

    /**
     * Sets the cursor to a given position
     * @param row   row
     * @param col   column
     */
    void setCursor(int row, int col);
    
}
