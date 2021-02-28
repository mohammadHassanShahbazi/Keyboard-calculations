import java.util.Scanner;

public class Main {
    public static String[] alphabet = {"<", ">", "?", ":", "\""};
    public static String[] symbol = {")", "!", "@", "#", "$", "%", "^", "&", "*", "("};
    public static final String SHIFT_UP = "shift_up";
    public static final String SHIFT_DOWN = "shift_down";
    public static final String CAPSLOCK = "CAPSLOCK";
    public static String state = "five";
    public static boolean shift_down = false;
    public static boolean shift_up = false;
    public static boolean capslock = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] array = input.split(" ");

        int len = 0;
        while (len < array.length) {

            if ((array[len].equalsIgnoreCase(SHIFT_DOWN)) || (array[len].equalsIgnoreCase(SHIFT_UP)) || (array[len].equalsIgnoreCase(CAPSLOCK))) {
                if (array[len].equalsIgnoreCase(SHIFT_DOWN)) {
                    shift_down = true;
                }
                if (array[len].equalsIgnoreCase(SHIFT_UP)) {
                    shift_up = true;
                    shift_down = false;
                }
                if (array[len].equalsIgnoreCase(CAPSLOCK)) {
                    if (capslock == true) {
                        capslock = false;
                    } else capslock = true;
                }
                state();
            } else {
                switch (state) {
                    case "one":
                        System.out.print(" one ");
                        System.out.print(array[len] + " ");
                        break;
                    case "two":
                        if ((int) array[len].charAt(0) >= 97 && (int) array[len].charAt(0) <= 122) {
                            System.out.print((char) ((int) array[len].charAt(0) - 32) + " ");
                        } else System.out.print(array[len] + " ");
                        break;
                    case "three":
                        //for 0 to 9
                        if ((int) array[len].charAt(0) >= 48 && (int) array[len].charAt(0) <= 57) {
                            for (int i = 48, j = 0; i <= 57; i++, j++) {
                                if ((int) array[len].charAt(0) == i) {
                                    System.out.print(symbol[j] + " ");
                                }
                            }
                        }
                        //for a to z
                        if ((int) array[len].charAt(0) >= 97 && (int) array[len].charAt(0) <= 122) {
                            System.out.print((char) ((int) array[len].charAt(0) - 32) + " ");
                        }
                        //for ,./;'
                        if ((int) array[len].charAt(0) == 44) System.out.print(alphabet[0] + " ");
                        if ((int) array[len].charAt(0) == 46) System.out.print(alphabet[1] + " ");
                        if ((int) array[len].charAt(0) == 47) System.out.print(alphabet[2] + " ");
                        if ((int) array[len].charAt(0) == 59) System.out.print(alphabet[3] + " ");
                        if ((int) array[len].charAt(0) == 39) System.out.print(alphabet[4] + " ");
                        break;

                    case "four":
                        System.out.print(array[len] + " ");
                        break;
                }
            }
            len++;
        }
    }

    private static String state() {

        if (capslock == true && shift_down == true) state = "one";
        if (capslock == true && shift_down == false) state = "two";
        if (capslock == false && shift_down == true) state = "three";
        if (capslock == true && shift_up == true) state = "two";
        if (capslock == false && shift_up == true) state = "four";
        if (capslock == false && shift_down == false) state = "four";

        return state;
    }
}
