import java.util.Scanner;

public class Main {

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
                        System.out.println(" three ");
                        System.out.println(array[len] + " ");
                        break;
                    case "four":
                        System.out.println("four");
                        System.out.println(array[len] + " ");
                        break;
                    case "five":
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
        if (capslock == false && shift_up == true) state = "five";
        if (capslock == false && shift_down == false) state = "five";

        return state;
    }
}
