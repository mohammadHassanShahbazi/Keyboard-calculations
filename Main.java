import java.util.Scanner;

public class Main {

    public static final String SHIFT_UP = "shift_up";
    public static final String SHIFT_DOWN = "shift_down";
    public static final String CAPSLOCK = "CAPSLOCK";
    public static String state = "";
    public static boolean shift_down = false;
    public static boolean shift_up = false;
    public static boolean capslock = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] array = input.split(" ");

        int len = 0;
        while (len < array.length) {

            if ((array[len] == SHIFT_DOWN) || (array[len] == SHIFT_UP) || (array[len] == CAPSLOCK)) {
                if (array[len] == SHIFT_DOWN) shift_down = true;
                if (array[len] == SHIFT_UP) shift_up = true;
                if (array[len] == CAPSLOCK) capslock = true;
                state();
            } else {
                switch (state) {
                    case "one":
                        System.out.print(" one ");
                        System.out.print(array[len] + " ");
                        break;
                    case "two":
                        System.out.print(" two ");
                        System.out.println(array[len] + " ");
                        break;
                    case "three":
                        System.out.println(" three ");
                        System.out.println(array[len] + " ");
                        break;
                    default:
                        break;
                }
            }
            len++;
        }
    }

    private static String state() {
        state = "";
        if (capslock == true && shift_down == true) state = "one";
        if (capslock == true && shift_down == false) state = "two";
        if (capslock == false && shift_down == true) state = "three";
        return state;
    }
}
