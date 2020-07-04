/** Class that determines whether or not a year is a leap year.
 *  @author Grace Li
 */
public class LeapYear {

    /** Calls isLeapYear to print correct statement.
     *  @param  year to be analyzed
     */
    private static void checkLeapYear(int year) {
        if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
            System.out.printf("%d is a leap year.\n", year);
        } else {
            System.out.printf("%d is not a leap year.\n", year);
        }
    }

    /** Must be provided an integer as a command line argument ARGS. */
    public static void main(String[] args) {

        int year = 2000;
        checkLeapYear(year);
    }
}

