package jlcd4pi;

/**
 * Utility methods
 * @author jCoder
 */
public class Utils {
    
    private Utils() { }

    /**
     * Sleep for the given amount of milliseconds
     * @param millisecs     milliseconds to sleep
     */
    public static void sleep(int millisecs) {
        if (millisecs < 1) {
            return;
        }
        try {
            Thread.sleep(millisecs);
        } catch (Exception ex) {
        }
    }
    
}
